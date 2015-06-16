package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.StudentController;
import domein.Docent;
import domein.Student;

@SuppressWarnings("serial")
public class StudentcodeServlet extends HttpServlet {
	private StudentController sc = new StudentController();
	private Student s = new Student();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int aantal = Integer.parseInt(req.getParameter("aantal"));
		Docent d = (Docent) req.getSession().getAttribute("docent");
		System.out.println("session na login" + req.getSession().getAttribute("docent"));
		String msgs = "";
		//genereert code tussen 111.111 en 999.999
		for (int i = 0; i < aantal; i++) {
			int getal = (int) (888888 * Math.random() + 111111);
//			if (!sc.checkCode(getal, done)) {
				s.setCode(getal);
				sc.setStudentCode(s, d.getEmail());
				msgs += getal + "<br />";
//			} else {
//				System.out.println("deze code staat WEL in de database "
//						+ getal);
//				aantal++;
//			}
		}
		RequestDispatcher rd = null;
		req.setAttribute("msgs", msgs);
		rd = req.getRequestDispatcher("/studentcode-aanmaken.jsp");
		rd.forward(req, resp);
	}
}
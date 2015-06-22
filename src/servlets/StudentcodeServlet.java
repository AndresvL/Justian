package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.StudentDAO;
import domein.Docent;
import domein.Student;

@SuppressWarnings("serial")
public class StudentcodeServlet extends HttpServlet {
	private Student s = new Student();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		int aantal = Integer.parseInt(req.getParameter("aantal"));
		if (aantal <= 40) {
			Docent d = (Docent) req.getSession().getAttribute("docent");
			String msgs = "";
			String[] codes= new String[aantal+1];
			// genereert code tussen 111.111 en 999.999
			for (int i = 0; i < aantal; i++) {
				int getal = (int) (888888 * Math.random() + 111111);
				if(StudentDAO.checkCode(getal)){
					s.setCode(getal);
					StudentDAO.createStudent(s, d.getEmail());
					codes[i] = getal + "";
					msgs += getal + "<br />";
				}else{
					aantal++;
				}
				
			}
			req.setAttribute("msgs", msgs);
			req.getSession().setAttribute("codeExport", codes);
		} else {
			String melding = "Vul een getal kleiner dan 40 in!";
			req.setAttribute("melding", melding);
		}
		rd = req.getRequestDispatcher("studentcode-aanmaken.jsp");
		rd.forward(req, resp);
	}
}

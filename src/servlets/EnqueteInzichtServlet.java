package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.StudentDAO;
import domein.Student;

@SuppressWarnings("serial")
public class EnqueteInzichtServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Student stud = new Student();
		stud = (Student) req.getSession().getAttribute("huidigeStudent");
		
		stud.setWatIsRekensom(req.getParameter("watIsRekensom"));
		stud.setHoogteEiffeltoren(req.getParameter("hoogteEiffeltoren"));
		stud.setAantMobieleTelefoons(req.getParameter("aantMobieleTelefoons"));
		
		StudentDAO.fillStudent(stud);
		RequestDispatcher rd = null;
		rd = req.getRequestDispatcher("toets-vraag.jsp");
		rd.forward(req, resp);
	}

}

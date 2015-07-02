package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.StudentDAO;
import domein.Student;

public class EnqueteInzichtServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2941548112770177902L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		Student stud = (Student) req.getSession().getAttribute("student");	
		stud.setWatIsRekensom(req.getParameter("watIsRekensom"));
		stud.setHoogteEiffeltoren(req.getParameter("hoogteEiffeltoren"));
		stud.setAantMobieleTelefoons(req.getParameter("aantMobieleTelefoons"));
		req.getSession().setAttribute("student", stud);
		System.out.println("studentnr inzicht" + stud.getCode());
		StudentDAO.fillStudent(stud);		
		rd = req.getRequestDispatcher("toets-begin.jsp");
		rd.forward(req, resp);
	}
}

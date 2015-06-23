package servlets;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domein.Student;

public class EnqueteServlet extends HttpServlet implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4596112393549239366L;
	private Student s = new Student();

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Student stud = (Student) req.getSession().getAttribute("student");
		s.setCode(Integer.parseInt(req.getParameter("msgs").toString()));
		s.setSchool(req.getParameter("school"));
		s.setJaar(req.getParameter("lesjaar"));
		s.setProfiel(req.getParameter("profiel"));
		s.setNiveau(req.getParameter("niveau"));
		s.setGeslacht(req.getParameter("geslacht"));
		s.setGemCijfer(req.getParameter("gemWisCijfer"));
		String datum = req.getParameter("blijvenZitten");
		s.setIsBlijvenZitten(datum);
		req.getSession().setAttribute("huidigeStudent", s);
		RequestDispatcher rd = null;
		rd = req.getRequestDispatcher("enquete-inzicht.jsp");
		rd.forward(req, resp);
	}
}

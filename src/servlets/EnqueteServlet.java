package servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.StudentController;
import domein.Docent;
import domein.Student;

public class EnqueteServlet extends HttpServlet {
	private Student s = new Student();
	private StudentController sc = new StudentController();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Student stud = (Student) req.getSession().getAttribute("student");
		s.setCode(stud.getCode());
		s.setSchool(req.getParameter("school"));
		s.setJaar(req.getParameter("lesjaar"));
		s.setProfiel(req.getParameter("profiel"));
		s.setNiveau(req.getParameter("niveau"));
		s.setGeslacht(req.getParameter("geslacht"));
		s.setGemCijfer(req.getParameter("gemWisCijfer"));
		String datum = req.getParameter("blijvenZitten");
		s.setIsBlijvenZitten(datum);
		if (sc.createStudent(s)) {
			RequestDispatcher rd = null;
			rd = req.getRequestDispatcher("/toets-vraag.jsp");
			rd.forward(req, resp);
		}else{
			System.out.println("Er is wat fout gegaan bij het sturen "
					+ "van de enquete gegevens naar de datbase");
		}
	}

}

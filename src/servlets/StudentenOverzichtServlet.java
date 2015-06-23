package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.StudentDAO;
import domein.Student;

public class StudentenOverzichtServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6055975407706991951L;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
	int code = Integer.parseInt(req.getParameter("studentnummer"));
	
	Student x = new Student();
	x = StudentDAO.getStudentByCode(code);

	req.getSession().setAttribute("studentnummer", x.getCode());
	req.getSession().setAttribute("gemWiskundeCijfer", x.getGemCijfer());
	req.getSession().setAttribute("wannBlijvenZitten", x.getIsBlijvenZitten());
	
	RequestDispatcher rd = null;
	rd = req.getRequestDispatcher("/student-details.jsp");
	rd.forward(req, resp);
	}
}

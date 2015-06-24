package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutStudentServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		HttpSession session = req.getSession(false);
		if (session != null) {
		    session.invalidate();
		}
		
		req.setAttribute("msgs", "U bent succesvol uitgelogd");
		
		RequestDispatcher rd = null;
		rd = req.getRequestDispatcher("/login-student.jsp");
		rd.forward(req, resp);
	}
}

package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DocentDAO;
import DAO.ToetsDAO;
import domein.Docent;
import domein.Vraag;

public class DocentenOverzichtServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8578648337310405243L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
	String email = req.getParameter("email");
	
	Docent x = new Docent();
	x = DocentDAO.getDocentByEmail(email);

	req.getSession().setAttribute("voornaam", x.getVoornaam());
	req.getSession().setAttribute("achternaam", x.getAchternaam());
	req.getSession().setAttribute("email", x.getEmail());
	req.getSession().setAttribute("schoolnaam", x.getSchoolnaam());
	req.getSession().setAttribute("schoolplaats", x.getSchoolplaats());
	
	RequestDispatcher rd = null;
	rd = req.getRequestDispatcher("/docent-bewerken.jsp");
	rd.forward(req, resp);
	}
}

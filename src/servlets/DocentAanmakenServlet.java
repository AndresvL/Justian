package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domein.Docent;
import DAO.DocentDAO;
import DAO.StudentDAO;

@SuppressWarnings("serial")
public class DocentAanmakenServlet extends HttpServlet{

	private Docent d = new Docent();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String w1 = req.getParameter("wachtwoord");
		String w2 = req.getParameter("wwbevestiging");
		String msgs = "";
		RequestDispatcher rd = null;
		
		if (w1.equals(w2)){
			
			d.setVoornaam(req.getParameter("voornaam"));
			d.setAchternaam(req.getParameter("achternaam"));
			d.setEmail(req.getParameter("email"));
			d.setSchoolnaam(req.getParameter("schoolnaam"));
			d.setSchoolplaats(req.getParameter("schoolplaats"));
			d.setWachtwoord(req.getParameter("wachtwoord"));
			DocentDAO.createDocent(d);
			msgs = "Docent is aangemaakt";
			req.setAttribute("msgs", msgs);
		}
		else{
			msgs = "Mislukt, controleer invoer";
			req.setAttribute("msgs", msgs);
		}
		rd = req.getRequestDispatcher("/docent-overzicht.jsp");
		rd.forward(req, resp);
	}
}

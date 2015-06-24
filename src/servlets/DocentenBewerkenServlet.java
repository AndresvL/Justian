package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Text;

import domein.Docent;
import domein.Vraag;
import DAO.DocentDAO;
import DAO.VraagDAO;

@SuppressWarnings("serial")
public class DocentenBewerkenServlet extends HttpServlet{
	
	private Docent d = new Docent();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String blob = "";
		String msgs = "";
		RequestDispatcher rd = null;
		
		d = (Docent) req.getSession().getAttribute("docentbewerk");

		d.setVoornaam(req.getParameter("voornaam"));
		d.setAchternaam(req.getParameter("achternaam"));
		d.setEmail(req.getParameter("email"));
		d.setSchoolnaam(req.getParameter("schoolnaam"));
		d.setSchoolplaats(req.getParameter("schoolplaats"));

		Docent dd = (Docent) req.getSession().getAttribute("docentbewerk");
		String ww = dd.getWachtwoord();
		String wb = req.getParameter("wwbevestiging");
		
		if(wb.equals(ww)){
			DocentDAO.updateDocent(d);
			
			msgs = "Vraag is aangepast";
			req.setAttribute("msgs", msgs);
			rd = req.getRequestDispatcher("/docent-overzicht.jsp");
			
			rd.forward(req, resp);
		}else{
			msgs = "Wachtwoord komt niet overeen";
			req.setAttribute("msgs", msgs);
			rd = req.getRequestDispatcher("/docent-bewerken.jsp");
			
			rd.forward(req, resp);
		}
		
	}
}

package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ToetsDAO;

import com.google.appengine.api.datastore.Text;

import controller.TijdController;
import domein.Vraag;
import domein.Antwoord;


@SuppressWarnings("serial")
public class ToetsServlet extends HttpServlet{
	private TijdController tijd = new TijdController();
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		RequestDispatcher rd = null;
		if(req.getParameter("button").equals("volgende")&&req.getSession().getAttribute("vraagnummer") != null){
			int vraagnr = (Integer)req.getSession().getAttribute("vraagnummer");
			String antwoord  = req.getParameter("antwoord");			
			int toetsnr = (Integer)req.getSession().getAttribute("toetsnummer");
			int uur = (Integer)req.getSession().getAttribute("uren");
			int min = (Integer)req.getSession().getAttribute("minuten");
			int sec = (Integer)req.getSession().getAttribute("seconden");

			int t = tijd.getVraagTijd(sec, min, uur, (System.currentTimeMillis()));
			Vraag huidig = ToetsDAO.getVraagByNr(vraagnr);
			boolean goedAntwoord = false;
			if(huidig.getAntwoord().equals(antwoord)){
				goedAntwoord = true;
			}
			Antwoord a = new Antwoord(vraagnr, antwoord, t, false, toetsnr, vraagnr, goedAntwoord);
			ToetsDAO.addAntwoord(a);
			
			
			if(ToetsDAO.getVraagByNr(vraagnr + 1) != null){				
				Vraag v = ToetsDAO.getVraagByNr(vraagnr + 1);
				if (v.getAfbeelding().equals("NULL")) {
					Text blob = new Text("iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAAYdEVYdFNvZnR3YXJlAHBhaW50Lm5ldCA0LjAuNWWFMmUAAAANSURBVBhXY/j//z8DAAj8Av6IXwbgAAAAAElFTkSuQmCC");
					v.setAfbeelding(blob);
				}
				req.getSession().setAttribute("vraagnummer", v.getNummer());
				req.getSession().setAttribute("context", v.getContext());
				req.getSession().setAttribute("antwoord", "");
				req.getSession().setAttribute("vraag", v.getVraagstelling());
				req.getSession().setAttribute("plaatje", v.getAfbeelding());
				req.getSession().setAttribute("rekenmachine", v.isRekenmachine());
				req.getSession().setAttribute("uren", tijd.getUur(System.currentTimeMillis()));
				req.getSession().setAttribute("minuten", tijd.getMinuut(System.currentTimeMillis()));
				req.getSession().setAttribute("seconden", tijd.getSeconde(System.currentTimeMillis()));				
				rd = req.getRequestDispatcher("/toets-vraag.jsp");
				
			}else rd = req.getRequestDispatcher("/toets-eind.jsp");
		}else{
			rd = req.getRequestDispatcher("/");
		}
		rd.forward(req,resp);
	}	
}

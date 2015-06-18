package servlets;

import java.io.IOException;
import java.util.ArrayList;

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
	
	
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		RequestDispatcher rd = null;
		ArrayList<Vraag> vragen = new ArrayList<Vraag>();
		if(req.getParameter("button").equals("volgende")){	
			int aantal = (Integer)req.getSession().getAttribute("aantal");
			int vraagnr = (Integer)req.getSession().getAttribute("vraagnummer");
			String antwoord  = req.getParameter("antwoord");			
			int toetsnr = (Integer)req.getSession().getAttribute("toetsnummer");
			int uur = (Integer)req.getSession().getAttribute("uren");
			int min = (Integer)req.getSession().getAttribute("minuten");
			int sec = (Integer)req.getSession().getAttribute("seconden");
			int t = tijd.getVraagTijd(sec, min, uur, (System.currentTimeMillis()));
			
			vragen = (ArrayList<Vraag>) req.getSession().getAttribute("set1");
			System.out.println("arraylist set1.getNummer line 41 " + vragen.get(aantal+1).getNummer());
			System.out.println("arraylist set1.size " + vragen.size());
			
			Vraag huidig = vragen.get(aantal-1);
			boolean goedAntwoord = false;
			if(huidig.getAntwoord().equals(antwoord)){
				goedAntwoord = true;
			}
			aantal++;
			Antwoord a = new Antwoord(aantal, antwoord, t, false, toetsnr, vraagnr, goedAntwoord);
			ToetsDAO.addAntwoord(a);		
			
			if(aantal <= vragen.size()){				
				Vraag volgende = vragen.get(aantal);
				if (volgende.getAfbeelding().equals("NULL")) {
					Text blob = new Text("iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAAYdEVYdFNvZnR3YXJlAHBhaW50Lm5ldCA0LjAuNWWFMmUAAAANSURBVBhXY/j//z8DAAj8Av6IXwbgAAAAAElFTkSuQmCC");
					volgende.setAfbeelding(blob);
				}
				req.getSession().setAttribute("aantal", aantal);
				req.getSession().setAttribute("vraagnummer", volgende.getNummer());
				req.getSession().setAttribute("context", volgende.getContext());
				req.getSession().setAttribute("antwoord", "");
				req.getSession().setAttribute("vraag", volgende.getVraagstelling());
				req.getSession().setAttribute("plaatje", volgende.getAfbeelding());
				req.getSession().setAttribute("rekenmachine", volgende.isRekenmachine());
				req.getSession().setAttribute("uren", tijd.getUur(System.currentTimeMillis()));
				req.getSession().setAttribute("minuten", tijd.getMinuut(System.currentTimeMillis()));
				req.getSession().setAttribute("seconden", tijd.getSeconde(System.currentTimeMillis()));				
				rd = req.getRequestDispatcher("/toets-vraag.jsp");
				
			}else rd = req.getRequestDispatcher("/toets-eind.jsp");
		}
		rd.forward(req,resp);		
	}	
}

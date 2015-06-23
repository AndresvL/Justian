package servlets;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ToetsDAO;
import DAO.VraagDAO;

import com.google.appengine.api.datastore.Text;

import controller.TijdController;
import domein.Student;
import domein.Vraag;
import domein.Antwoord;
public class ToetsServlet extends HttpServlet implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1777304050993338567L;
	private TijdController tijd = new TijdController();
	private ArrayList<Antwoord> ant = null;
	
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		ArrayList<Vraag> set1 = (ArrayList<Vraag>) req.getSession().getAttribute("set1");
		if (req.getParameter("button").equals("volgende")) {
			String antwoord = req.getParameter("antwoord");			
			if(!antwoord.equals("")){
				//getSession
				Student s = (Student) req.getSession().getAttribute("student");
				int aantal = (Integer) req.getSession().getAttribute("aantal");
				int vraagnr = (Integer) req.getSession().getAttribute("vraagnummer");
				boolean rekenmachine = Boolean.parseBoolean(req.getParameter("rekenmachine"));
				int toetsnr = (Integer) req.getSession().getAttribute("toetsnummer");
				int uur = (Integer) req.getSession().getAttribute("uren");
				int min = (Integer) req.getSession().getAttribute("minuten");
				int sec = (Integer) req.getSession().getAttribute("seconden");
				int t = tijd.getVraagTijd(sec, min, uur,(System.currentTimeMillis()));
				
				Vraag huidig = set1.get(aantal-1);
				boolean goedAntwoord = false;
				if (huidig.getAntwoord().equals(antwoord)) {
					goedAntwoord = true;
				}
				Antwoord a = new Antwoord(aantal, antwoord, t, rekenmachine, toetsnr, vraagnr, goedAntwoord);
				ToetsDAO.addAntwoord(a);
				if(req.getSession().getAttribute("antwoorden")!=null){
					 ant = (ArrayList<Antwoord>)req.getSession().getAttribute("antwoorden");
					 ant.add(a);
				}else{
					 ant = new ArrayList<Antwoord>();
					 ant.add(a);
				}
				
				if (aantal <= set1.size()) {
					if(aantal == 20){	
						ArrayList<Vraag> set2 = Adaptief.set2(ant, set1);
						for(Vraag vr : set2){
							set1.add(vr);		
						}				
						VraagDAO.addVraagSet(set2, s.getCode(), aantal);
						rd = req.getRequestDispatcher("/toets-vraag.jsp");
					}
					if(aantal == 40){	
						ArrayList<Vraag> set3 = Adaptief.set3(ant, set1);
						for(Vraag vr : set3){
							set1.add(vr);		
						}				
						VraagDAO.addVraagSet(set3, s.getCode(), aantal);
						rd = req.getRequestDispatcher("/toets-vraag.jsp");
					}if(aantal < 60){
						Vraag volgende = set1.get(aantal);
						if (volgende.getAfbeelding().equals("NULL")) {
							Text blob = new Text(
									"iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAAYdEVYdFNvZnR3YXJlAHBhaW50Lm5ldCA0LjAuNWWFMmUAAAANSURBVBhXY/j//z8DAAj8Av6IXwbgAAAAAElFTkSuQmCC");
							volgende.setAfbeelding(blob);
						}
						req.getSession().setAttribute("aantal", aantal+1);
						req.getSession().setAttribute("vraagnummer",volgende.getNummer());
						if(!volgende.getContext().equals("NULL")){
							req.getSession().setAttribute("context", volgende.getContext());
						}else{
							req.getSession().setAttribute("context", "");
						}
						req.getSession().setAttribute("antwoord", "");
						req.getSession().setAttribute("antwoorden", ant);
						req.getSession().setAttribute("vraag", volgende.getVraagstelling());
						req.getSession().setAttribute("plaatje", volgende.getAfbeelding());
						req.getSession().setAttribute("rekenmachine", volgende.isRekenmachine());
						req.getSession().setAttribute("uren", tijd.getUur(System.currentTimeMillis()));
						req.getSession().setAttribute("minuten", tijd.getMinuut(System.currentTimeMillis()));
						req.getSession().setAttribute("seconden", tijd.getSeconde(System.currentTimeMillis()));	
						req.getSession().setAttribute("msgs", null);
						rd = req.getRequestDispatcher("/toets-vraag.jsp");

					} else {
						VraagDAO.removeSet(s.getCode());
						req.getSession().removeAttribute("aantal");
						req.getSession().removeAttribute("vraagNummer");
						req.getSession().removeAttribute("context");
						req.getSession().removeAttribute("vraag");
						req.getSession().removeAttribute("plaatje");
						req.getSession().removeAttribute("rekenmachine");
						req.getSession().removeAttribute("uren");
						req.getSession().removeAttribute("minuten");
						req.getSession().removeAttribute("seconden");
						rd = req.getRequestDispatcher("/toets-eind.jsp");
						
						
					}
				}
			} else {
				req.getSession().setAttribute("msgs", "Vul je antwoord in");
				rd = req.getRequestDispatcher("/toets-vraag.jsp");
			}
			rd.forward(req, resp);
		}
	}
}

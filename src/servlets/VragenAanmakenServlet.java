package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Text;

import domein.Vraag;
import DAO.VraagDAO;

@SuppressWarnings("serial")
public class VragenAanmakenServlet extends HttpServlet{
	
	private Vraag v = new Vraag();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String blob = "";
		String msgs = "";
		RequestDispatcher rd = null;
		v.setRekenmachine(false);
		
		String y = "";
		y = y + req.getParameter("rekenmachine");
	
		if (y.equals("true")){
			v.setRekenmachine(true);
		}
		
		ArrayList<Vraag >arr = new ArrayList<Vraag>();
		arr = VraagDAO.alleVragen();		
		int n = arr.size();
		n = n +1;
		v.setNummer(n);
		
		v.setType(req.getParameter("categorie"));
		v.setContext(req.getParameter("context"));
		v.setVraagstelling(req.getParameter("opgave"));
		v.setAntwoord(req.getParameter("antwoord"));
		
		v.setBlobAfbeelding("");
		Text t = null;
		v.setAfbeelding(t);
		
		//blob = iets parse van de afbeelding??? TODO
		//v.setBlobAfbeelding(blob);
		
		VraagDAO.addVraag(v);
		
		msgs = "Vraag is aangemaakt";
		req.setAttribute("msgs", msgs);
		rd = req.getRequestDispatcher("/vraag-overzicht.jsp");
		
		rd.forward(req, resp);
		
	}
}

package servlets;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DocentDAO;
import DAO.StudentDAO;
import DAO.ToetsDAO;
import DAO.VraagDAO;

import com.google.appengine.api.datastore.Text;

import controller.TijdController;
import domein.Antwoord;
import domein.Student;
import domein.Vraag;

public class LoginStudentServlet extends HttpServlet implements Serializable{

	private static final long serialVersionUID = 194503685680L;
	private TijdController tijd = new TijdController();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Student s = new Student();
		int code;
		if(req.getParameter("code")==null){
			code = Integer.parseInt(req.getSession().getAttribute("student").toString());
		}
		else{
			code = Integer.parseInt(req.getParameter("code"));
		}
		
//		VraagDAO.removeAlleSets();
//		VraagDAO.removeAntwoord();
//		DocentDAO.createBeheerder();
		
		ArrayList<Vraag> vragen = VraagDAO.alleVragen();
		getServletContext().setAttribute("alleVragen", vragen);
		RequestDispatcher rd = null;
		req.getSession().setAttribute("aantal", 1);
		if (StudentDAO.checkStudent(code)) {
			s = StudentDAO.getStudentByCode(code);
			ArrayList<Antwoord> antwoorden = ToetsDAO.getAlleAntwoorden(code);
			Vraag v = null;
			ArrayList<Integer> vraag = null;
			if(ToetsDAO.getToetsNummer(code) == 0||VraagDAO.getLaatsteAntwoordNummer(code)==60){
				req.getSession().setAttribute("aantal", 1);
				ToetsDAO.addToets(code);
				vraag = Adaptief.set1(vragen);	
				VraagDAO.addVraagSet(vraag, code, 0);
				v = vragen.get(vraag.get(0));
			}else{
				vraag = VraagDAO.getVraagSet(code);
				int vraagNummer = VraagDAO.getLaatsteAntwoordNummer(code);
				v = ToetsDAO.getVraagByNr(vraagNummer);	
				req.getSession().setAttribute("aantal", VraagDAO.getLaatsteAntwoordNummer(code)+1);
				
			}
			if (v.getAfbeelding().equals("NULL")) {
				Text blob = new Text("iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAAYdEVYdFNvZnR3YXJlAHBhaW50Lm5ldCA0LjAuNWWFMmUAAAANSURBVBhXY/j//z8DAAj8Av6IXwbgAAAAAElFTkSuQmCC");
				v.setAfbeelding(blob);
			}

			req.getSession().setAttribute("student", s);	
			req.getSession().setAttribute("arrayLeeg", true);
			req.getSession().setAttribute("vraagnrs", vraag);
			req.getSession().setAttribute("antwoorden", antwoorden);
			int toetsnummer;
			if(ToetsDAO.getToetsNummer(s.getCode()) == 0){
				toetsnummer = 1;
			}else{
				toetsnummer = ToetsDAO.getToetsNummer(s.getCode());
			}
			req.getSession().setAttribute("toetsnummer", toetsnummer);
			req.getSession().setAttribute("vraag", v.getVraagstelling());
			req.getSession().setAttribute("vraagnummer", v.getNummer());
			if(!v.getContext().equals("NULL")){
				req.getSession().setAttribute("context", v.getContext());
			}else{
				req.getSession().setAttribute("context", "");
			}
			req.getSession().setAttribute("type", v.getType());
			req.getSession().setAttribute("plaatje", v.getAfbeelding());
			req.getSession().setAttribute("rekenmachine", v.isRekenmachine());
			req.getSession().setAttribute("uren", tijd.getUur(System.currentTimeMillis()));
			req.getSession().setAttribute("minuten", tijd.getMinuut(System.currentTimeMillis()));
			req.getSession().setAttribute("seconden", tijd.getSeconde(System.currentTimeMillis()));
			
			if (s.isFirstTime()) {
				rd = req.getRequestDispatcher("enquete.jsp");
			} else {
				rd = req.getRequestDispatcher("toets-begin.jsp");
			}
		} else {
			req.setAttribute("msgs", "code bestaat niet");
			rd = req.getRequestDispatcher("/login-student.jsp");
		}

		rd.forward(req, resp);

	}
}

package servlets;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mortbay.log.Log;

import DAO.StudentDAO;
import DAO.ToetsDAO;
import DAO.VraagDAO;

import com.google.appengine.api.datastore.Text;

import controller.TijdController;
import domein.Antwoord;
import domein.Student;
import domein.Vraag;

import java.util.logging.*;
public class LoginStudentServlet extends HttpServlet implements Serializable{

	private static final long serialVersionUID = 194503685680L;
	private TijdController tijd = new TijdController();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Student s = new Student();
		int code = Integer.parseInt(req.getParameter("code"));
//		VraagDAO.removeAlleSets();
//		VraagDAO.removeAntwoord();
//		DocentDAO.createBeheerder();
		RequestDispatcher rd = null;
		Logger log = Logger.getLogger("loginCode");
			
		log.info("test");
		if (StudentDAO.checkStudent(code)) {
			log.info("checkstudent is k");
			s = StudentDAO.getStudentByCode(code);
			log.info(code + "is studentcode");
			log.info(s.getCode() +" is studentobjectcode");
			ArrayList<Antwoord> antwoorden = ToetsDAO.getAlleAntwoorden(code);
			req.getSession().setAttribute("antwoorden", antwoorden);
			Vraag v = null;
			ArrayList<Vraag> vraag = VraagDAO.getVraagSet(code);
			if(ToetsDAO.getToetsNummer(code) == 0 || VraagDAO.getLaatsteAntwoordNummer(code)==60){
				ToetsDAO.addToets(code);
				vraag = Adaptief.set1();	
				VraagDAO.addVraagSet(vraag, code, 0);
				v = vraag.get(0);
			}else{
				if(VraagDAO.getLaatsteAntwoordNummer(code)==60){
					v = vraag.get(0);
				}else{
					v = vraag.get(VraagDAO.getLaatsteAntwoordNummer(code));
				}
			}
			if (v.getAfbeelding().equals("NULL")) {
				Text blob = new Text("iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAAYdEVYdFNvZnR3YXJlAHBhaW50Lm5ldCA0LjAuNWWFMmUAAAANSURBVBhXY/j//z8DAAj8Av6IXwbgAAAAAElFTkSuQmCC");
				v.setAfbeelding(blob);
			}
			
			req.getSession().setAttribute("set1", vraag);			
			req.getSession().setAttribute("aantal", (VraagDAO.getLaatsteAntwoordNummer(code)+1));
			req.getSession().setAttribute("student", s);
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
			req.getSession().setAttribute("uren",
					tijd.getUur(System.currentTimeMillis()));
			req.getSession().setAttribute("minuten",
					tijd.getMinuut(System.currentTimeMillis()));
			req.getSession().setAttribute("seconden",
					tijd.getSeconde(System.currentTimeMillis()));
			req.getSession().setAttribute("toetsnummer",
					ToetsDAO.getToetsNummer(s.getCode()));
			if (s.isFirstTime()) {
				req.getSession().setAttribute("msgs", s.getCode());
				
				rd = req.getRequestDispatcher("enquete.jsp");
			} else {
				rd = req.getRequestDispatcher("toets-vraag.jsp");
			}
		} else {
			req.setAttribute("msgs", "code bestaat niet");
			rd = req.getRequestDispatcher("/login-student.jsp");
		}

		rd.forward(req, resp);

	}
}

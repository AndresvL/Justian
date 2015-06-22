package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.StudentDAO;
import DAO.ToetsDAO;
import DAO.VraagDAO;

import com.google.appengine.api.datastore.Text;

import controller.TijdController;
import domein.Antwoord;
import domein.Student;
import domein.Vraag;

public class LoginStudentServlet extends HttpServlet {

	private static final long serialVersionUID = 194503685680L;
	private TijdController tijd = new TijdController();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Student s = new Student();
		int code = Integer.parseInt(req.getParameter("code"));
//		VraagDAO.removeSet();
//		VraagDAO.removeAntwoord();
		RequestDispatcher rd = null;
		if (StudentDAO.checkStudent(code)) {
			s = StudentDAO.getStudentByCode(code);
			ArrayList<Vraag> vraag = VraagDAO.getVraagSet(code);
			Vraag v = null;
			if(VraagDAO.getLaatsteAntwoordNummer(code) == 0){
				vraag = Adaptief.set1();	
				VraagDAO.addVraagSet(vraag, code, 0);
				v = vraag.get(0);
			}else{
				v = vraag.get(VraagDAO.getLaatsteAntwoordNummer(code));
			}
			if (v.getAfbeelding().equals("NULL")) {
				Text blob = new Text("iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAAYdEVYdFNvZnR3YXJlAHBhaW50Lm5ldCA0LjAuNWWFMmUAAAANSURBVBhXY/j//z8DAAj8Av6IXwbgAAAAAElFTkSuQmCC");
				v.setAfbeelding(blob);
			}
			ArrayList<Antwoord> antwoorden = ToetsDAO.getAlleAntwoorden(code);
			req.getSession().setAttribute("antwoorden", antwoorden);
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
					ToetsDAO.getVolgendToetsNummer(s.getCode()));
			if (s.isFirstTime()) {
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

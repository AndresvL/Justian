package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import controller.DocentController;
import domein.Docent;
import controller.DocentController;
public class LoginDocentBeheerderServlet extends HttpServlet {
	private DocentController dc = new DocentController();
	private Docent d = new Docent();
	RequestDispatcher rd = null;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{		
		String email = req.getParameter("email");
		String wachtwoord = req.getParameter("wachtwoord");	
		d = dc.getDocent(email, wachtwoord);
		if(d!= null){	
			req.getSession().setAttribute("docent", d);		
			rd = req.getRequestDispatcher("/studentcode-aanmaken.jsp");			
		}else{
			rd = req.getRequestDispatcher("/login-docent.jsp");
			req.setAttribute("msgs", "Email of wachtwoord bestaat niet");
		}
		rd.forward(req, resp);
	}

}

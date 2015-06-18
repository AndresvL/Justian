package servlets;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

public class InlogFilterStudentServlet implements Filter{
	public void init(FilterConfig arg0) throws ServletException {
	}

	public void doFilter(ServletRequest req, ServletResponse resp,FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req2 = (HttpServletRequest) req;	
		if (req2.getSession().getAttribute("student") != null) {
			chain.doFilter(req, resp);
		} else {
			RequestDispatcher rd = null;
			req.setAttribute("msgs","Log A.U.B. in");
			rd = req.getRequestDispatcher("login-student.jsp");
			rd.forward(req, resp);
		}
		
	}

	public void destroy() {
	}
}

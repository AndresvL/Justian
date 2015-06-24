package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.VraagDAO;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;


public class Serve extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1260291234438393419L;
	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
        throws IOException, ServletException {
            BlobKey blobKey = new BlobKey(req.getParameter("blob-key"));            
            VraagDAO.setVragen(blobKey);
            blobstoreService.delete(blobKey);
            req.removeAttribute("blob-key");
            RequestDispatcher rd = null;
            req.setAttribute("msgs", "bestand is succesvol geupload");
            rd = req.getRequestDispatcher("/vraag-uploaden.jsp");
            rd.forward(req, res);
        }
}
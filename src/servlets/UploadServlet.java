package servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

@SuppressWarnings("serial")
public class UploadServlet extends HttpServlet {
	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(req);
        List<BlobKey> blobKeys = blobs.get("data");
        
        if (blobKeys == null || blobKeys.isEmpty()) {
            resp.sendRedirect("/");
        } else {
            resp.sendRedirect("/serve?blob-key=" + blobKeys.get(0).getKeyString());
        }
		
        
//		if (ServletFileUpload.isMultipartContent(req)) {
//		FileItemFactory factory = new DiskFileItemFactory();
//		ServletFileUpload upload = new ServletFileUpload(factory);
//			resp.setContentType("text/html");
//			try {
//				// Parse the request to get file items.
//				List<FileItem> fileItems = upload.parseRequest(req);
//				// Process the uploaded file items
//				Iterator<FileItem> i = fileItems.iterator();
//				while (i.hasNext()) {
//					FileItem fi = (FileItem) i.next();
//					if(!fi.isFormField()) {
//						BufferedReader br = new BufferedReader(new InputStreamReader(fi.getInputStream(), "UTF-8"));
//						Vraag vr = new Vraag();
//						System.out.println(br.readLine());
//						while ((line = br.readLine()) != null) {							
//							String[] inhoud = line.split(";");
//							vr.setNummer(Integer.parseInt(inhoud[0]));
//							vr.setType(inhoud[1]);
//							vr.setVraagstelling(inhoud[2]);
//							vr.setRekenmachine(Boolean.parseBoolean(inhoud[3]));
//							vr.setContext(inhoud[4]);
//							vr.setAfbeelding(inhoud[5]);
//							vr.setMultiplechoice(Boolean.parseBoolean(inhoud[6]));
//							vr.setAntwoord(inhoud[7]);
//							controller.addVraag(vr);
//						}
//					}
//				}
//			} catch (Exception ex) {
//				System.out.println(ex);
//			}
//		}
	}

}

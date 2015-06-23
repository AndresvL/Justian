package servlets;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csvreader.CsvWriter;


public class ExporteerCodesServlet extends HttpServlet{
	private static final long serialVersionUID = -995038670924153515L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String[] codes = (String[])req.getSession().getAttribute("codes");
		
		resp.setContentType("application/zip");
		   resp.setStatus(HttpServletResponse.SC_OK);
		    ZipOutputStream zipOut = new ZipOutputStream(resp.getOutputStream());
		    try {
		    		
		            zipOut.putNextEntry(new ZipEntry("codes.csv"));
		            CsvWriter mySerializer = new CsvWriter(new OutputStreamWriter(zipOut), ';');
		            for(String s : codes){
		            		mySerializer.flush();
		            		mySerializer.write(s);
		            	}
		            
		            zipOut.closeEntry();

		    } finally { 
		        zipOut.close();
		    }
		}
		
	
}

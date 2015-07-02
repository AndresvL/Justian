package servlets;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csvreader.CsvWriter;

import DAO.ToetsDAO;
public class ExporteerAllServlet extends HttpServlet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2523321741541730788L;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("application/zip");
		resp.setStatus(HttpServletResponse.SC_OK);
		ZipOutputStream zipOut = new ZipOutputStream(resp.getOutputStream());
		int index = 1;
		try{
			for(int i[] : ToetsDAO.getCorrecteCategorien()){
				zipOut.putNextEntry(new ZipEntry("antwoorden-toets-" + index + ".csv"));
				CsvWriter w = new CsvWriter(new OutputStreamWriter(zipOut),';');
				for(int i2 : i){
					w.write(i2 + "");w.flush();
					
				}
				zipOut.closeEntry();
				index++;
			}
		}finally{
			zipOut.close();
		}
		

	}
	
}

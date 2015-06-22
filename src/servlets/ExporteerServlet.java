package servlets;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csvreader.CsvWriter;

import domein.Antwoord;
import domein.Student;
import DAO.ToetsDAO;
public class ExporteerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -995038670924153514L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		ArrayList<Antwoord> antwoorden = ToetsDAO.getAntwoordenByToetsNr(Integer.parseInt(req.getParameter("toetsNr")));
		/*StringBuilder sb = new StringBuilder();
		for(Antwoord a : antwoorden){
			if(sb.length() != 0){
				sb.append(";");
			}
			sb.append(a.getNummer());sb.append(";");
			sb.append(a.getToetsNummer());sb.append(";");
			sb.append(a.getVraagNummer());sb.append(";");
			sb.append(a.getHeeftRekenmachineGebruikt());sb.append(";");
			sb.append(a.checkAntwoord());sb.append(";");
		}*/
		 resp.setContentType("application/zip");
		    resp.setStatus(HttpServletResponse.SC_OK);
		    Student s = (Student)req.getSession().getAttribute("student");
		    // note : intentionally no content-length set, automatic chunked transfer if stream is larger than the internal buffer of the response
		    ZipOutputStream zipOut = new ZipOutputStream(resp.getOutputStream());

		    try {
		            // case 2: write directly to output stream, i.e. you have your raw data but need to create csv representation
		    		
		            zipOut.putNextEntry(new ZipEntry("test.csv"));

		            // example setup, key is to use the below outputstream 'zipOut' write methods
		            CsvWriter mySerializer = new CsvWriter(new OutputStreamWriter(zipOut), ';'); // i.e. csv-writer
		            String myData = getMyData(antwoorden); // the data to be processed by the serializer in order to make a csv file


		            // write whatever you have to the zipOut
		            mySerializer.write(myData);

		            zipOut.closeEntry();

		            // repeat for the next file.. or make for-loop

		        
		    } finally { 
		        zipOut.close();
		    }
	
	}
	String getMyData(ArrayList<Antwoord> antwoorden){
		String s = "";
		for(Antwoord a : antwoorden){
			s+=a.getNummer();s+=";";
			s+=a.getToetsNummer();s+=";";
			s+=a.getVraagNummer();s+=";";
			s+=a.getHeeftRekenmachineGebruikt();s+=";";
			s+=a.getAntwoord();s+=";";
			s+="\n";
		}
		
		
		return s;
	}
}

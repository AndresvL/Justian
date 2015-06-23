package servlets;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csvreader.CsvWriter;

import domein.Antwoord;
import DAO.ToetsDAO;
public class ExporteerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -995038670924153514L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		ArrayList<Antwoord> antwoorden = ToetsDAO.getAntwoordenByToetsNr(Integer.parseInt(req.getParameter("toetsNr")));
		resp.setContentType("application/zip");
		resp.setStatus(HttpServletResponse.SC_OK);
		ZipOutputStream zipOut = new ZipOutputStream(resp.getOutputStream());
		try {
			zipOut.putNextEntry(new ZipEntry("antwoorden-toets-" + Integer.parseInt(req.getParameter("toetsNr")) + ".csv"));

			CsvWriter mySerializer = new CsvWriter(new OutputStreamWriter(zipOut), ';');
			List<String[]> myData = getMyData(antwoorden);
			for(String s[] : myData){	
				for(String s2 : s){
					mySerializer.flush();
					mySerializer.write(s2);
				}
				mySerializer.write("\n");
			}
			zipOut.closeEntry();

		} finally { 
			zipOut.close();
		}

	}
	public List<String[]> getMyData(ArrayList<Antwoord> antwoorden){
		List<String[]> stringAntw = new ArrayList<String[]>();
		for(Antwoord a : antwoorden){
			stringAntw.add(new String[] {a.getNummer() + "",a.getToetsNummer() + "",
					a.getVraagNummer() + "",a.getHeeftRekenmachineGebruikt() + "",
					a.getAntwoord()});
		}

		return stringAntw;
	}
}

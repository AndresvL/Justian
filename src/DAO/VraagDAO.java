
package DAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreInputStream;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.*;
import com.google.appengine.api.datastore.Text;

import domein.Vraag;
/**
 * deze klasse beheert alle vraag-gerelateerde database acties
 * @author Direct-Act
 *
 */

public final class VraagDAO {
	static DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
/**
 * deze methode voegt een vraag toe aan de database
 * @param vr het vraag object dat toegevoegd dient te worden
 */
	public static void addVraag(Vraag vr) {
		Entity vraag = new Entity("Vraag", vr.getNummer());
		Text af = new Text(vr.getBlobAfbeelding());
		vraag.setProperty("categorie", vr.getType());
		vraag.setProperty("opgave", vr.getVraagstelling());
		vraag.setProperty("rekenmachine", vr.isRekenmachine());
		vraag.setProperty("context", vr.getContext());
		vraag.setProperty("afbeelding", af);
		vraag.setProperty("isMultiplechoice", vr.isMultiplechoice());
		vraag.setProperty("antwoord", vr.getAntwoord());
		ds.put(vraag);
	}
/**
 * deze methode haalt een vraag uit een blob file
 * @param blobkey de blobkey
 * @return de vraag die opgevraagd wordt
 */
	
	public static Vraag getVraag(BlobKey blobkey) {
		Vraag vr = null;
		try {
			InputStream is = new BlobstoreInputStream(blobkey);
			BufferedReader br = new BufferedReader(new InputStreamReader(is,
					"UTF-8"));
			String line = br.readLine();
			while (line != null) {
				String[] inhoud = line.split(";");
				vr = new Vraag();
				vr.setNummer(Integer.parseInt(inhoud[0]));
				vr.setType(inhoud[1]);
				vr.setVraagstelling(inhoud[2]);
				vr.setRekenmachine(Boolean.parseBoolean(inhoud[3]));
				vr.setContext(inhoud[4]);
				String afbeelding = inhoud[5].replaceAll("\r\n", "");
				vr.setBlobAfbeelding(afbeelding);
				vr.setMultiplechoice(Boolean.parseBoolean(inhoud[6]));
				vr.setAntwoord(inhoud[7]);
				addVraag(vr);
				line = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return vr;
	}
/**
 * deze methode haalt het laatste vraagnummer op als de toets vroegtijdig is afgesloten.
 * <p>eerst zoekt de methode het toetsnummer met als filter studentnr<br>vervolgens wordt het hoogste toetsnummer meegegeven<br>
 * daarna wordt in die toets het hoogste vraagnummer geselecteerd om terug te geven.
 * @param studentNr het studentnummer van de student die de toets hervat.
 * @return het vraagnummer
 */
	public static int getLaatsteVraagNummer(int studentNr) {
		Filter filter = new FilterPredicate("studentNummer", FilterOperator.EQUAL, studentNr);
		Query q = new Query("Toets").setFilter(filter);
		PreparedQuery pq = ds.prepare(q);
		int toetsNummer = 0;
		for (Entity toets : pq.asIterable()) {
			toetsNummer = Integer.parseInt(toets.getProperty("toetsNummer").toString());
		}
		int vraagNummer = 0;
		if (toetsNummer > 0) {
			Filter filter1 = new FilterPredicate("toetsNummer",
					FilterOperator.EQUAL, toetsNummer);
			Query q1 = new Query("Antwoord").setFilter(filter1);
			PreparedQuery pq1 = ds.prepare(q1);
			for (Entity antwoord : pq1.asIterable()) {
				if(vraagNummer < Integer.parseInt(antwoord.getProperty(
						"vraagNummer").toString())){
					vraagNummer = Integer.parseInt(antwoord.getProperty(
							"vraagNummer").toString());
				}
			}
		}
		return vraagNummer+1;
	}
}

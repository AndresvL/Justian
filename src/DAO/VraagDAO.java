<<<<<<< Updated upstream
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


public class VraagDAO {
	DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
	public void addVraag(Vraag vr) {		
		Entity vraag = new Entity("Vraag", vr.getNummer());
		Text af = new Text(vr.getAfbeelding());
		vraag.setProperty("categorie", vr.getType());
		vraag.setProperty("opgave", vr.getVraagstelling());
		vraag.setProperty("rekenmachine", vr.isRekenmachine());
		vraag.setProperty("context", vr.getContext());
		vraag.setUnindexedProperty("afbeelding", af);
		vraag.setProperty("isMultiplechoice", vr.isMultiplechoice());
		vraag.setProperty("antwoord", vr.getAntwoord());
		ds.put(vraag);
	}
	public Vraag getVraag(BlobKey blobkey){		
		Vraag vr = null;
		try {
			InputStream is = new BlobstoreInputStream(blobkey);
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
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
				System.out.println("afbeelding " + afbeelding);
				vr.setAfbeelding(afbeelding);
				vr.setMultiplechoice(Boolean.parseBoolean(inhoud[6]));
				vr.setAntwoord(inhoud[7]);
				addVraag(vr);
				line = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vr;
	}
	
	public int getLaatsteVraagNummer(int studentNr){
		//zoekt het toetsNummer in Entity Toets
		//met als filter het studentNr
		Filter filter = new FilterPredicate("studentNummer", FilterOperator.EQUAL, studentNr);
		Query q = new Query("Toets").setFilter(filter);
		PreparedQuery pq = ds.prepare(q);
		//het laatste toetsnummer wordt meegegeven aan toetsNummer;
		int toetsNummer = 1;
		for(Entity toets:pq.asIterable()){
//			Key temp = toets.getKey();			
//			toetsNummer = Integer.parseInt(KeyFactory.keyToString(temp));
			toetsNummer = Integer.parseInt(toets.getProperty("toetsNummer").toString());
			System.out.println("toetsNummer "+ toetsNummer);
		}
		//zoek in Entity Antwoord naar het laatste vraagNummer van het meegegeven toetsNr
		Filter filter1 = new FilterPredicate("toetsNummer", FilterOperator.EQUAL, toetsNummer);
		Query q1 = new Query("Antwoord").setFilter(filter1);	
		PreparedQuery pq1 = ds.prepare(q1);
		int vraagNummer = 1;
		for(Entity antwoord:pq1.asIterable()){
			vraagNummer = Integer.parseInt(antwoord.getProperty("vraagNummer").toString());
			System.out.println("VraagNummer " + vraagNummer);
		}
		return vraagNummer;
		
	}
	
}
=======
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

public class VraagDAO {
	DatastoreService ds = DatastoreServiceFactory.getDatastoreService();

	public void addVraag(Vraag vr) {
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

	// getVraag uit blob file
	public Vraag getVraag(BlobKey blobkey) {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vr;
	}

	public int getLaatsteVraagNummer(int studentNr) {
		// zoekt het toetsNummer in Entity Toets
		// met als filter het studentNr
		Filter filter = new FilterPredicate("studentNummer",
				FilterOperator.EQUAL, studentNr);
		Query q = new Query("Toets").setFilter(filter);
		PreparedQuery pq = ds.prepare(q);
		// het laatste toetsnummer wordt meegegeven aan toetsNummer;
		int toetsNummer = 1;
		for (Entity toets : pq.asIterable()) {
			toetsNummer = Integer.parseInt(toets.getProperty("toetsNummer")
					.toString());
		}
		// zoek in Entity Antwoord naar het laatste vraagNummer van het
		// meegegeven toetsNr
		int vraagNummer = 1;
		if (toetsNummer > 1) {
			Filter filter1 = new FilterPredicate("toetsNummer",
					FilterOperator.EQUAL, toetsNummer);
			Query q1 = new Query("Antwoord").setFilter(filter1);
			PreparedQuery pq1 = ds.prepare(q1);

			
			for (Entity antwoord : pq1.asIterable()) {
				vraagNummer = Integer.parseInt(antwoord.getProperty(
						"vraagNummer").toString());
			}
		}
		return vraagNummer;

	}

}
>>>>>>> Stashed changes

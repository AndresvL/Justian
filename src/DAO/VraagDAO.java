package DAO;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.mortbay.io.ByteArrayBuffer;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreInputStream;
import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Text;

import domein.Vraag;


public class VraagDAO {
	DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
	public void addVraag(Vraag vr) {		
		Entity vraag = new Entity("Vraag", vr.getNummer());
		Text tx = new Text(vr.getAfbeelding());
		vraag.setProperty("categorie", vr.getType());
		vraag.setProperty("opgave", vr.getVraagstelling());
		vraag.setProperty("rekenmachine", vr.isRekenmachine());
		vraag.setProperty("context", vr.getContext());
		vraag.setProperty("afbeelding", tx);
		vraag.setProperty("isMultiplechoice", vr.isMultiplechoice());
		vraag.setProperty("antwoord", vr.getAntwoord());
		ds.put(vraag);
	}
	public Vraag getVraag(BlobKey blobkey){
		String line = "";
		try {
			InputStream is = new BlobstoreInputStream(blobkey);
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			Vraag vr = new Vraag();
			while ((line = br.readLine()) != null) {
				String[] inhoud = line.split(";");
				vr.setNummer(Integer.parseInt(inhoud[0]));
				vr.setType(inhoud[1]);
				vr.setVraagstelling(inhoud[2]);
				vr.setRekenmachine(Boolean.parseBoolean(inhoud[3]));
				vr.setContext(inhoud[4]);
				vr.setAfbeelding(inhoud[5]);
				vr.setMultiplechoice(Boolean.parseBoolean(inhoud[6]));
				vr.setAntwoord(inhoud[7]);
				addVraag(vr);
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
}

package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;

import dSUtil.SQLCon;
import domein.Antwoord;
import domein.Vraag;

public class ToetsDAO {
	DatastoreService ds = DatastoreServiceFactory.getDatastoreService();

	public Vraag getVraagByNr(int nr) {
		Vraag v = null;
		try {
			Entity vraag = ds.get(KeyFactory.createKey("Vraag", nr));
			v = new Vraag(Boolean.parseBoolean(vraag
					.getProperty("rekenmachine").toString()), nr, vraag
					.getProperty("context").toString(), vraag.getProperty(
					"afbeelding").toString(), vraag.getProperty("categorie")
					.toString(), vraag.getProperty("opgave").toString(), vraag
					.getProperty("antwoord").toString());
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return v;
	}

	public void addAntwoord(Antwoord a) {
		Entity antwoord = new Entity("Antwoord");
		antwoord.setProperty("antwoord", a.getAntwoord());
		antwoord.setProperty("tijd", a.getTijd());
		antwoord.setProperty("heeftRekenmachineGebruikt",
				a.getHeeftRekenmachineGebruikt());
		antwoord.setProperty("toetsNummer", a.getToetsNummer());
		antwoord.setProperty("vraagNummer", a.getVraagNummer());
		ds.put(antwoord);

	}
	//Moet nog aangepast worden
	public int getHuidigToetsNummer() {
		Connection conn = null;
		int toetsNummer = 0;
		try {
			conn = SQLCon.getConnection();
			PreparedStatement pStmt = conn
					.prepareStatement("select MAX from toets");
			ResultSet rSet = pStmt.executeQuery();
			toetsNummer = rSet.getInt("toetsNummer");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLCon.closeConnection(conn);
		}
		if (toetsNummer == 0)
			return 1;
		else
			return toetsNummer;
	}

	public int getVolgendToetsNummer(boolean newToets, int studentNr) {
		int toetsNummer = 1;
		Query q = new Query("Toets");
		PreparedQuery pq = ds.prepare(q);
		for (@SuppressWarnings("unused")
		Entity e : pq.asIterable()) {
			toetsNummer++;
		}
		//!!Opgelet, als er wat uit de datastore "Toets" wordt verwijderd klopt de nummering niet meer
		Entity toets = new Entity("Toets", toetsNummer);
		toets.setProperty("studentNummer", studentNr);
		ds.put(toets);

		return toetsNummer;
	}
}

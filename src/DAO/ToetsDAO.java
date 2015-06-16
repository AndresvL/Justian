package DAO;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.api.datastore.Text;

import domein.Antwoord;
import domein.Vraag;

public class ToetsDAO {
	DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
	public int toetsNummer = 1;

	// set volgende vraag
	public Vraag getVraagByNr(int nr) {
		Vraag v = null;
		try {
			Entity vraag = ds.get(KeyFactory.createKey("Vraag", nr));
			v = new Vraag(Boolean.parseBoolean(vraag
					.getProperty("rekenmachine").toString()), nr, vraag
					.getProperty("context").toString(),
					(Text) vraag.getProperty("afbeelding"), vraag.getProperty(
							"categorie").toString(), vraag
							.getProperty("opgave").toString(), vraag
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

	// Moet nog aangepast worden
	// public int getHuidigToetsNummer() {
	// Connection conn = null;
	// int toetsNummer = 0;
	// try {
	// conn = SQLCon.getConnection();
	// PreparedStatement pStmt = conn
	// .prepareStatement("select MAX from toets");
	// ResultSet rSet = pStmt.executeQuery();
	// toetsNummer = rSet.getInt("toetsNummer");
	// } catch (SQLException e) {
	// e.printStackTrace();
	// } finally {
	// SQLCon.closeConnection(conn);
	// }
	// if (toetsNummer == 0)
	// return 1;
	// else
	// return toetsNummer;
	// }

	public int getVolgendToetsNummer(boolean newToets, int studentNr) {
		boolean b = true;
		Filter filter = new FilterPredicate("studentNummer",
				FilterOperator.EQUAL, studentNr);
		Query q = new Query("Toets").setFilter(filter);
		PreparedQuery pq = ds.prepare(q);
		for (Entity e : pq.asIterable()) {
			if (toetsNummer < Integer.parseInt(e.getProperty("toetsNummer").toString())) {
				toetsNummer = Integer.parseInt(e.getProperty("toetsNummer").toString());
			}
			b = false;
		}
		if (b) {
			Query q1 = new Query("Toets");
			PreparedQuery pq1 = ds.prepare(q1);
			for (Entity e1 : pq1.asIterable()) {
			int nr = Integer.parseInt(e1.getProperty("toetsNummer").toString());
				if (toetsNummer <= nr) {
					toetsNummer = nr+1;
				}
			}
			Entity toets = new Entity("Toets", toetsNummer);
			toets.setProperty("toetsNummer", toetsNummer);
			toets.setProperty("studentNummer", studentNr);
			ds.put(toets);
			
		}		
		return toetsNummer;
	}
}

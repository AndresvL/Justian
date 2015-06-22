package DAO;

import java.util.ArrayList;

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

/**
 * deze klasse beheert alle toets-gerelateerde database acties
 * 
 * @author Direct-Act
 * 
 */
public final class ToetsDAO {
	/**
	 * dit is een vereist attribuut om de verbinding met de google data
	 */
	static DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
	/**
	 * dit attribuut houdt het toetsnummer bij met default value -1
	 */
	public static int toetsNummer = 1;

	/**
	 * deze methode haalt de volgende vraag voor de toets op gebaseerd op een
	 * vraagnummer
	 * <P>
	 * eerst wordt er een lege vraag gemaakt. vervolgens wordt er een key
	 * gegenereerd op basis <br>
	 * van het vraagnummer. ten slotte wordt de vraag ingevuld met gegevens uit
	 * de database<br>
	 * 
	 * @param nr
	 *            het gewenste vraagnummer voor de volgende vraag.
	 * @return de volgende vraag in de toets deze kan null zijn of ingevuld.
	 */
	public static Vraag getVraagByNr(int nr) {
		Vraag v = null;
		try {
			Entity vraag = ds.get(KeyFactory.createKey("Vraag", nr));
			v = new Vraag(Boolean.parseBoolean(
					vraag.getProperty("rekenmachine").toString()),
					nr, 
					vraag.getProperty("context").toString(),
					(Text) vraag.getProperty("afbeelding"),
					vraag.getProperty("categorie").toString(),
					vraag.getProperty("opgave").toString(),
					vraag.getProperty("antwoord").toString());
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
		}
		return v;
	}

	/**
	 * deze methode voegt een antwoord toe aan de database.
	 * <p>
	 * er wordt eerst een entity aangemaakt en vervolgens wordt die ingevuld.
	 * 
	 * @param a
	 *            het antwoord object dat toegevoegd moet worden aan de database
	 */
	public static void addAntwoord(Antwoord a) {
		Entity antwoord = new Entity("Antwoord");
		antwoord.setProperty("antwoordNummer", a.getNummer());
		antwoord.setProperty("antwoord", a.getAntwoord());
		antwoord.setProperty("tijd", a.getTijd());
		antwoord.setProperty("heeftRekenmachineGebruikt",a.getHeeftRekenmachineGebruikt());
		antwoord.setProperty("checkAntwoord", a.checkAntwoord());
		antwoord.setProperty("toetsNummer", a.getToetsNummer());
		antwoord.setProperty("vraagNummer", a.getVraagNummer());
		ds.put(antwoord);

	}

	public static ArrayList<Antwoord> getAlleAntwoorden(int code) {
		ArrayList<Antwoord> set = null;
		Antwoord antw = null;
		
		Filter filter = new FilterPredicate("studentNummer",FilterOperator.EQUAL, code);
		Query q = new Query("Toets").setFilter(filter);
		PreparedQuery pq = ds.prepare(q);
		int toetsNummer = 0;
		for (Entity toets : pq.asIterable()) {
			toetsNummer = Integer.parseInt(toets.getProperty("toetsNummer").toString());
		}
		if (toetsNummer > 0) {
			set = new ArrayList<Antwoord>();
			Filter filter1 = new FilterPredicate("toetsNummer",	FilterOperator.EQUAL, toetsNummer);
			Query q1 = new Query("Antwoord").setFilter(filter1);
			PreparedQuery pq1 = ds.prepare(q1);
			for (Entity e : pq1.asIterable()) {
				int nummer = Integer.parseInt(e.getProperty("antwoordNummer").toString());
			    int vraagnummer = Integer.parseInt(e.getProperty("vraagNummer").toString());
			    int tijd = Integer.parseInt(e.getProperty("tijd").toString());
			    boolean rekenmachine  = Boolean.parseBoolean(e.getProperty("heeftRekenmachineGebruikt").toString());
			    boolean correct = Boolean.parseBoolean(e.getProperty("checkAntwoord").toString());
			    String antwoord = e.getProperty("antwoord").toString();
			    antw = new Antwoord(nummer, antwoord, tijd, rekenmachine, toetsNummer, vraagnummer, correct);
			    set.add(antw);				
			}
		}
		return set;
	}
	public static ArrayList<Antwoord> getAntwoordenByToetsNr(int nr){
		ArrayList<Antwoord> antwoorden = new ArrayList<Antwoord>();
		Query q = new Query("Antwoord");
		PreparedQuery pq = ds.prepare(q);
		for (Entity e : pq.asIterable()) {
			Antwoord a = null;
			if(e.getProperty("toetsNummer").toString().equals(nr + "")){
				int antwoordnummer = antwoorden.size() +1;
				int vraagnummer = Integer.parseInt(e.getProperty("vraagNummer").toString());
				int tijd = Integer.parseInt(e.getProperty("tijd").toString());
				boolean rekenmachine  = Boolean.parseBoolean(e.getProperty("heeftRekenmachineGebruikt").toString());
				boolean correct = Boolean.parseBoolean(e.getProperty("checkAntwoord").toString());
				String antwoord = e.getProperty("antwoord").toString();
				a = new Antwoord( antwoordnummer,antwoord, tijd, rekenmachine, nr,vraagnummer, correct);
				antwoorden.add(a);
			
			}
			
		}
		return antwoorden;
	}
	//TODO maken!
	public static Antwoord getAntwoordByVraagNr(int nr){
		return null;
	}


	/**
	 * deze methode haalt het volgende toetsnummer op.
	 * <p>
	 * 
	 * de methode haalt het volgende toetsnummer uit de database, vergelijkt
	 * deze met de huidige<br>
	 * als het volgende toetsnummer hoger is dan het huidige, dan wordt het
	 * huidige nummer overschreven/
	 * 
	 * @param studentNr
	 *            het student nummer van de student die de toets aan het maken
	 *            is.
	 * @return het toetsnummer van de volgende toets.
	 */
	public static int getVolgendToetsNummer(int studentNr) {
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
		//maak nieuwe toets aan als student geen toets heeft
		if (b) {
			Query q1 = new Query("Toets");
			PreparedQuery pq1 = ds.prepare(q1);
			for (Entity e1 : pq1.asIterable()) {
				int nr = Integer.parseInt(e1.getProperty("toetsNummer")
						.toString());
				if (toetsNummer <= nr) {
					toetsNummer = nr + 1;
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

package DAO;


import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.api.datastore.Query.CompositeFilterOperator;

import domein.Docent;
import domein.Student;
/**
 * deze klasse beheert alle docent-gerelateerde database acties.
 * @author Direct-Act
 *
 */
public final class DocentDAO {
	/**
	 * vereiste variabele om met de google datastore te verbinden
	 */
	static DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
	/**
	 * haalt een docent op uit de database<p>
	 * uit een loginpoging worden een email en wachtwoord gehaald. dit zijn de twee <br>
	 * gegevens waarmee we in de database kunnen kijken en exact de goede docent kunnen selecteren.<p>
	 * als eerste wordt een lege docent aangemaakt. vervolgens wordt er gekeken of er een docent<br>
	 * in de database staat die het ingevulde email en wachtwoord heeft. <br>
	 * als deze bestaat wordt de docent ingevuld met de gegevens uit de database.
	 * @param em het emailadres van de docent, gehaald uit een loginpoging
	 * @param ww het wachtwoord van de docent, gehaald uit een loginpoging
	 * @return de docent wordt teruggegeven. deze kan null of volledig zijn.
	 */
	public static Docent getDocent(String em, String ww) {	
		Docent d = null;
		// filter voor ingevoerde email en wachtwoord
		Filter email = new FilterPredicate("email", FilterOperator.EQUAL, em);
		Filter wachtwoord = new FilterPredicate("wachtwoord",
				FilterOperator.EQUAL, ww);
		Filter inlogCheck = CompositeFilterOperator.and(email, wachtwoord);
		Query q = new Query("Docent").setFilter(inlogCheck);
		PreparedQuery pq = ds.prepare(q);
		for (Entity e : pq.asIterable()) {
			d = new Docent();
			d.setEmail(e.getProperty("email").toString());
			d.setWachtwoord(e.getProperty("wachtwoord").toString());
			d.setVoornaam(e.getProperty("voornaam").toString());
			d.setAchternaam(e.getProperty("achternaam").toString());
			d.setSchoolnaam(e.getProperty("schoolNaam").toString());
			d.setSchoolplaats(e.getProperty("schoolPlaats").toString());
		}

		return d;
	}
	
	public static void createDocent(Docent d) {
		Entity docent = new Entity("Docent");
		docent.setProperty("email", d.getEmail());
		docent.setProperty("voornaam", d.getVoornaam());
		docent.setProperty("achternaam", d.getAchternaam());
		docent.setProperty("wachtwoord", d.getWachtwoord());
		docent.setProperty("schoolNaam", d.getSchoolnaam());
		docent.setProperty("schoolPlaats", d.getSchoolplaats());
		ds.put(docent);
	}
	
}

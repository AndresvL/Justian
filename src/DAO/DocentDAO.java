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

import dSUtil.SQLCon;
import domein.Docent;

public class DocentDAO {
	DatastoreService ds = DatastoreServiceFactory.getDatastoreService();

	public Docent getDocent(String em, String ww) {
		Entity docent = new Entity("Docent");
		docent.setProperty("email", "Andresvanlummel@gmail.com");
		docent.setProperty("wachtwoord", "andres");
		docent.setProperty("voornaam", "Andres");
		docent.setProperty("achternaam", "van Lummel");
		docent.setProperty("schoolNaam", "Corderius");
		docent.setProperty("schoolPlaats", "Bunschoten");
		ds.put(docent);

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
}

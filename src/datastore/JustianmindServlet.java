package datastore;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Transaction;
@SuppressWarnings("serial")
public class JustianmindServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world!");
		
		//roept datastoreservice aan
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		
		//maakt transaction
		Transaction tx = ds.beginTransaction();
		//maakt een Entity ZONDER identifier
		int id=10;
		try{
		Entity gebruiker = new Entity("Gebruiker",id);
		gebruiker.setProperty("Id", id);
		gebruiker.setProperty("Voornaam", "Niek");
		gebruiker.setProperty("Achternaam", "van Doorn");
		gebruiker.setProperty("Leeftijd", "24");
		ds.put(gebruiker);
		tx.commit();
		}finally{
			if(tx.isActive()){
				tx.rollback();
			}
		}
		
		
		//maakt een Entity MET identifier
		Entity toets = new Entity("Toets", 418);
		toets.setProperty("Toetsid", 418);
		toets.setProperty("Voornaam", "Broer");
		toets.setProperty("Achternaam", "Bril");
		//Create of update
		ds.put(toets);
		
		//Batch Entity
		Entity stud1 = new Entity("Student1");
		Entity stud2 = new Entity("Student2");
		Entity stud3 = new Entity("Student3");
		
		List<Entity> stud4 = Arrays.asList(stud1, stud2, stud3);
		ds.put(stud4);
		
		//maakt een Key
		Key key=KeyFactory.createKey("Toets", 415);
//		System.out.println("The key is " + key);
		
	
		//set Query
		//Filters
//		Query q = new Query("Gebruiker").addFilter("Leeftijd",FilterOperator.GREATER_THAN, "20");
		Query q = new Query("Gebruiker").addSort("Voornaam", Query.SortDirection.ASCENDING);
		PreparedQuery pq= ds.prepare(q);
		for(Entity g1:pq.asIterable()) {
			String voornaam = g1.getProperty("Voornaam").toString();
			String achternaam = g1.getProperty("Achternaam").toString();
			System.out.println("Voornaam "+voornaam+ " achternaam "+achternaam);
		}
		
	
		
//		//ophalen van een Entity
//		try {
//			Entity getKey = ds.get(key);
//			System.out.println("opgehaalde Entity "+ getKey);
//		} catch (EntityNotFoundException e) {
//			e.printStackTrace();
//		}
//		//delete een Entity
//			ds.delete(key);
//		
//		//maakt een ancestor key
//		Key key1 = new KeyFactory.Builder("Gebruiker", "Overgrootvader")
//		.addChild("Gebruiker", "Grootvader")
//		.addChild("Gebruiker", "Vader").getKey();
//		System.out.println("The ancestor key is " + key1);
//		
//		//maakt een Entity groep
//		Entity groep = new Entity("Docent",gebruiker.getKey());
//		ds.put(groep);
		
		
	}
}
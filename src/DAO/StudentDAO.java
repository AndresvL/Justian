package DAO;

import java.util.ArrayList;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

import domein.Docent;
import domein.Student;
/**
 * Deze klasse beheert alle student-gerelateerde database acties
 * @author Direct-Act
 *
 */
public final class StudentDAO {
	/**
	 * vereiste variabele om verbinding te maken met de google datastore
	 */
	static DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
	/**
	 * deze methode wordt aangeroepen als de student wordt gegenereerd door de docent
	 * @param s de gegenereerde student
	 * @param email het emailadres van de docent die de student genereert.
	 */
	public static void createStudent(Student s, String email) {
		Entity student = new Entity("Student", s.getCode());
		student.setProperty("studentNummer", s.getCode());
		student.setProperty("docent_email", email);
		ds.put(student);
	}
	/**
	 * deze methode vult de student met de gegevens uit de enquette<p>
	 * eerst zal de student een unieke key worden toegewezen, vervolgens<br>
	 * zal de methode de student in de database invullen.
	 * @param s de student die de enquette invult.
	 */
	public static void fillStudent(Student s) {
		Key key=KeyFactory.createKey("Student", s.getCode());
		String email = "";
		int code = 0;
		try{
			Entity getKey = ds.get(key);		
			email = getKey.getProperty("docent_email").toString();
			code = Integer.parseInt(getKey.getProperty("studentNummer").toString());
		}catch(EntityNotFoundException e){
			e.printStackTrace();
		}
		Entity student = new Entity("Student",s.getCode());
		student.setProperty("studentNummer", code);
		student.setProperty("docent_email", email);
		student.setProperty("schoolNaam", s.getSchool());
		student.setProperty("schoolJaar", s.getJaar());
		student.setProperty("profiel", s.getProfiel());
		student.setProperty("niveau", s.getNiveau());
		student.setProperty("geslacht", s.getGeslacht());
		student.setProperty("gemWiskundeCijfer", s.getGemCijfer());
		student.setProperty("wannBlijvenZitten", s.getIsBlijvenZitten());
		student.setProperty("watIsRekensom", s.getWatIsRekensom());
		student.setProperty("hoogteEiffeltoren", s.getHoogteEiffeltoren());
		student.setProperty("aantMobieleTelefoons", s.getAantMobieleTelefoons());
		ds.put(student);
	}
	/**
	 * deze methode checkt of de meegegeven studentcode bestaat.
	 * 
	 * @param code de studentcode
	 * @return een boolean die bepaalt of de student bestaat of niet.
	 */
	public static boolean checkCode(int code){
		boolean b = false;

		Key key=KeyFactory.createKey("Student", code);
		try{
			@SuppressWarnings("unused")
			Entity getKey = ds.get(key);	
			b = false;
			
		}catch (EntityNotFoundException e) {			
			b = true;
		}
		return b;
		
	}
	/**
	 * deze methode checkt of de meegegeven studentcode bestaat.
	 * 
	 * @param code de studentcode
	 * @return een boolean die bepaalt of de student bestaat of niet.
	 */
	public static boolean checkStudent(int code){
		boolean b = false;
		Key key=KeyFactory.createKey("Student", code);
		try{
			Entity getKey = ds.get(key);	
			if(getKey!=null){
				b = true;
			}
			
		}catch (EntityNotFoundException e) {			
			b = false;
		}
		return b;		
	}
	/**
	 * deze methode haalt een studen uit de database gebaseerd op een studentcode.<p>
	 * eerst wordt er een key gegenereerd gebaseerd op de studentcode<br>
	 * vervolgens wordt de database doorzocht naar die student<br>
	 * ten slotte wordt de student ingevuld met de 
	 * @param code de code van de student die je wilt ophalen.
	 * @return de student van de bijbehorende code.
	 */
	public static Student getStudentByCode(int code) {
		Key key=KeyFactory.createKey("Student", code);
		Student s = new Student();
		s.setCode(code);
		try {
			Entity getKey = ds.get(key);			
			if(getKey.hasProperty("schoolNaam")){
				s.setCode(Integer.parseInt(getKey.getProperty("studentNummer").toString()));
				s.setDocentEmail(getKey.getProperty("docent_email").toString());
				s.setSchool(getKey.getProperty("schoolNaam").toString());
				s.setJaar(getKey.getProperty("schoolJaar").toString());
				s.setProfiel(getKey.getProperty("profiel").toString());
				s.setNiveau(getKey.getProperty("niveau").toString());
				s.setGeslacht(getKey.getProperty("geslacht").toString());
				s.setIsBlijvenZitten(getKey.getProperty("wannBlijvenZitten").toString());
				s.setGemCijfer(getKey.getProperty("gemWiskundeCijfer").toString());
				s.setWatIsRekensom(getKey.getProperty("watIsRekensom").toString());
				s.setHoogteEiffeltoren(getKey.getProperty("hoogteEiffeltoren").toString());
				s.setAantMobieleTelefoons(getKey.getProperty("aantMobieleTelefoons").toString());
			}
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;		
	}
	
	public static ArrayList<Student> alleStudenten() {
		ArrayList<Student> studenten = new ArrayList<Student>();
		Student dc = null;
		Query q = new Query("Student");
		PreparedQuery pq = ds.prepare(q);
		for (Entity e : pq.asIterable()) {
			if(e.hasProperty("schoolNaam")){
				int code = Integer.parseInt(e.getProperty("studentNummer").toString());
				String email = e.getProperty("docent_email").toString();
				String schoolNaam = e.getProperty("schoolNaam").toString();
				String schoolJaar = e.getProperty("schoolJaar").toString();
				String profiel = e.getProperty("profiel").toString();
				String niveau = e.getProperty("niveau").toString();
				String geslacht = e.getProperty("geslacht").toString();
				String wanBlijvenZitten = e.getProperty("wannBlijvenZitten").toString();
				String watIsRekensom = e.getProperty("watIsRekensom").toString();
				String hoogteEiffeltoren = e.getProperty("hoogteEiffeltoren").toString();
				String aantMobieleTelefoons = e.getProperty("aantMobieleTelefoons").toString();
	
				dc = new Student();
				dc.setCode(code);
				dc.setDocentEmail(email);
				dc.setSchool(schoolNaam);
				dc.setJaar(schoolJaar);
				dc.setProfiel(profiel);
				dc.setNiveau(niveau);
				dc.setGeslacht(geslacht);
				dc.setIsBlijvenZitten(wanBlijvenZitten);
				dc.setWatIsRekensom(watIsRekensom);
				dc.setHoogteEiffeltoren(hoogteEiffeltoren);
				dc.setAantMobieleTelefoons(aantMobieleTelefoons);
				studenten.add(dc);
			}
		}
		return studenten;
	}
}

package DAO;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
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
		try{
			Entity getKey = ds.get(key);		
			email = getKey.getProperty("docent_email").toString();
		}catch(EntityNotFoundException e){
			e.printStackTrace();
		}
		Entity student = new Entity("Student",s.getCode());
		student.setProperty("schoolNaam", s.getSchool());
		student.setProperty("schoolJaar", s.getJaar());
		student.setProperty("profiel", s.getProfiel());
		student.setProperty("niveau", s.getNiveau());
		student.setProperty("geslacht", s.getGeslacht());
		student.setProperty("gemWiskundeCijfer", s.getGemCijfer());
		student.setProperty("wannBlijvenZitten", s.getIsBlijvenZitten());
		student.setProperty("docent_email", email);
		ds.put(student);
	}

//	public ArrayList<Student> getStudenten() {
//		Connection conn = null;
//		ArrayList<Student> Studenten = new ArrayList<Student>();
//		try {
//			conn = SQLCon.getConnection();
//			PreparedStatement pStmt = conn
//					.prepareStatement("select * from student");
//			ResultSet rSet = pStmt.executeQuery();
//			while (rSet.next()) {
//				Student s = new Student();
//				s.setCode(rSet.getInt("studencode"));
//				s.setSchool(rSet.getString("school"));
//				s.setJaar(rSet.getInt("lesjaar"));
//				s.setProfiel(rSet.getString("profiel"));
//				s.setNiveau(rSet.getString("niveau"));
//				s.setGeslacht(rSet.getString("geslacht"));
//				s.setGemCijfer(rSet.getDouble("gemCijfer"));
//				s.setIsBlijvenZitten(rSet.getString("isBlijvenZitten"));
//				Studenten.add(s);
//			}
//			pStmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			SQLCon.closeConnection(conn);
//		}
//		return Studenten;
//
//	}

//	public ArrayList<Student> getStudentByGeslacht(String ges) {
//		Connection conn = null;
//		ArrayList<Student> Studenten = new ArrayList<Student>();
//		try {
//			conn = SQLCon.getConnection();
//			PreparedStatement pStmt = conn
//					.prepareStatement("select * from student where geslacht = '?'");
//			pStmt.setString(1, ges);
//			ResultSet rSet = pStmt.executeQuery();
//			while (rSet.next()) {
//				Student s = new Student();
//				s.setCode(rSet.getInt("studentcode"));
//				s.setSchool(rSet.getString("school"));
//				s.setJaar(rSet.getInt("lesjaar"));
//				s.setNiveau(rSet.getString("niveau"));
//				s.setGeslacht(rSet.getString("geslacht"));
//				s.setGemCijfer(rSet.getDouble("gemCijfer"));
//				s.setIsBlijvenZitten(rSet.getString("isBlijvenZitten"));
//				Studenten.add(s);
//			}
//			pStmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			SQLCon.closeConnection(conn);
//		}
//		return Studenten;
//
//	}

//	public ArrayList<Student> getStudentByniveau(String niv) {
//		Connection conn = null;
//		ArrayList<Student> Studenten = new ArrayList<Student>();
//		try {
//			conn = SQLCon.getConnection();
//			PreparedStatement pStmt = conn
//					.prepareStatement("select * from student where niveau = '?'");
//			pStmt.setString(1, niv);
//			ResultSet rSet = pStmt.executeQuery();
//			while (rSet.next()) {
//				Student s = new Student();
//				s.setCode(rSet.getInt("studentcode"));
//				s.setSchool(rSet.getString("school"));
//				s.setJaar(rSet.getInt("lesjaar"));
//				s.setNiveau(rSet.getString("niveau"));
//				s.setGeslacht(rSet.getString("geslacht"));
//				s.setGemCijfer(rSet.getDouble("gemCijfer"));
//				s.setIsBlijvenZitten(rSet.getString("isBlijvenZitten"));
//				Studenten.add(s);
//			}
//			pStmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			SQLCon.closeConnection(conn);
//		}
//		return Studenten;
//
//	}

//	public ArrayList<Student> getStudentByLesjaar(String jaar) {
//		Connection conn = null;
//		ArrayList<Student> Studenten = new ArrayList<Student>();
//		try {
//			conn = SQLCon.getConnection();
//			PreparedStatement pStmt = conn
//					.prepareStatement("select * from student where lesjaar = '?'");
//			pStmt.setString(1, jaar);
//			ResultSet rSet = pStmt.executeQuery();
//			while (rSet.next()) {
//				Student s = new Student();
//				s.setCode(rSet.getInt("studentcode"));
//				s.setSchool(rSet.getString("school"));
//				s.setJaar(rSet.getInt("lesjaar"));
//				s.setNiveau(rSet.getString("niveau"));
//				s.setGeslacht(rSet.getString("geslacht"));
//				s.setGemCijfer(rSet.getDouble("gemCijfer"));
//				s.setIsBlijvenZitten(rSet.getString("isBlijvenZitten"));
//				Studenten.add(s);
//			}
//			pStmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			SQLCon.closeConnection(conn);
//		}
//		return Studenten;
//
//	}
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
			if(getKey != null){
				b = true;
			}
			
		}catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
				s.setSchool(getKey.getProperty("schoolNaam").toString());
				s.setJaar(getKey.getProperty("schoolJaar").toString());
				s.setProfiel(getKey.getProperty("profiel").toString());
				s.setNiveau(getKey.getProperty("niveau").toString());
				s.setGeslacht(getKey.getProperty("geslacht").toString());
				s.setIsBlijvenZitten(getKey.getProperty("wannBlijvenZitten").toString());
				s.setGemCijfer(getKey.getProperty("gemWiskundeCijfer").toString());
			}
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;		
	}
}

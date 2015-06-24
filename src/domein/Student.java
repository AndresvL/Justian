package domein;

import java.io.Serializable;


public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6084012180678435361L;
	private boolean firstTime;
	private String docentEmail;
	private int code;
	private String school;
	private int jaar;
	private String niveau;
	private String geslacht;
	private double cijfer;
	private String isBlijvenZitten;
	private String profiel;
	private String watIsRekensom;
	private String hoogteEiffeltoren;
	private String aantMobieleTelefoons;

	public boolean isFirstTime() {
		if(this.school == null)firstTime = true;
		else firstTime = false;
		return firstTime;
	}

	public void setFirstTime(boolean firstTime) {
		this.firstTime = firstTime;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public int getJaar() {
		return jaar;
	}

	public void setJaar(String jaar) {
		System.out.println(jaar);
		this.jaar = Integer.parseInt(jaar);
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public String getGeslacht() {
		return geslacht;
	}

	public void setGeslacht(String geslacht) {
		this.geslacht = geslacht;
	}

	public double getGemCijfer() {
		return cijfer;
	}

	public void setGemCijfer(String cijfer) {
		this.cijfer = Double.parseDouble(cijfer);
	}

	public String getIsBlijvenZitten() {
		return isBlijvenZitten;
	}

	public void setIsBlijvenZitten(String blijvenZitten) {
		this.isBlijvenZitten = blijvenZitten;
	}

	public String getProfiel() {
		return profiel;
	}
	public void setProfiel(String prof) {
		this.profiel = prof;
	}

	public String getWatIsRekensom() {
		return watIsRekensom;
	}

	public void setWatIsRekensom(String watIsRekensom) {
		this.watIsRekensom = watIsRekensom;
	}

	public String getHoogteEiffeltoren() {
		return hoogteEiffeltoren;
	}

	public void setHoogteEiffeltoren(String hoogteEiffeltoren) {
		this.hoogteEiffeltoren = hoogteEiffeltoren;
	}

	public String getAantMobieleTelefoons() {
		return aantMobieleTelefoons;
	}

	public void setAantMobieleTelefoons(String aantMobieleTelefoons) {
		this.aantMobieleTelefoons = aantMobieleTelefoons;
	}

	public String getDocentEmail() {
		return docentEmail;
	}

	public void setDocentEmail(String docentEmail) {
		this.docentEmail = docentEmail;
	}
	
}

package domein;

import java.io.Serializable;


public class Student implements Serializable{

	private boolean firstTime;
	private int code;
	private String school;
	private int jaar;
	private String niveau;
	private String geslacht;
	private double cijfer;
	private String isBlijvenZitten;
	private String profiel;

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
}

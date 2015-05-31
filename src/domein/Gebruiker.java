package domein;

import java.io.Serializable;

public abstract class Gebruiker implements Serializable{
	protected String email, wachtwoord, voornaam, achternaam;
	
	public Gebruiker(String eM, String ww, String vN, String aN){
		email = eM;
		wachtwoord = ww;
		voornaam = vN;
		achternaam = aN;
	}
	public Gebruiker() {
		// TODO Auto-generated constructor stub
	}
	public Gebruiker(String email2, String vN, String aN) {
		email = email2;
		voornaam = vN;
		achternaam = aN;
	}
	protected void setEmail(String em){
		email = em;
	}
	protected void setWachtwoord(String ww){
		wachtwoord = ww;
	}
	protected void setVoornaam(String vn){
		voornaam = vn;
	}
	protected void setAchternaam(String an){
		achternaam = an;
	}
	
}

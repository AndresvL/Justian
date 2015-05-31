package domein;

public class Docent extends Gebruiker  {
	private String schoolnaam;
	private String schoolplaats;

	public Docent(){
		super();
	}
	public Docent(String email, String ww, String vN, String aN, String sN, String sP){
		super(email,ww,vN,aN);
		this.schoolnaam = aN;
		this.schoolplaats = sP;
	}
	public Docent(String email, String vN, String aN, String sN, String sP){
		super(email,vN,aN);
		this.schoolnaam = sN;
		this.schoolplaats = sP;
	}

	public String getSchoolnaam() {
		return schoolnaam;
	}

	public void setSchoolnaam(String schoolnaam) {
		this.schoolnaam = schoolnaam;
	}

	public String getSchoolplaats() {
		return schoolplaats;
	}

	public void setSchoolplaats(String schoolplaats) {
		this.schoolplaats = schoolplaats;
	}
	public void setEmail(String em){
		email = em;
	}
	public void setWachtwoord(String ww){
		wachtwoord = ww;
	}
	public void setVoornaam(String vn){
		voornaam = vn;
	}
	public void setAchternaam(String an){
		achternaam = an;
	}
	public String getEmail(){
		return email;
	}
	public String getVoornaam(){
		return voornaam;
	}
	public String getWachtwoord(){
		return wachtwoord;
	}
	public String getAchternaam(){
		return achternaam;
	}
	
	
}

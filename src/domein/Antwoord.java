package domein;

import java.io.Serializable;

public class Antwoord implements Serializable{
	private int nummer;
	private String antw;
	private int toetsNummer;
	private int tijd;
	private int vraagNummer;
	private boolean heeftRekenmachineGebruikt;
	private enum categorie{getal,meet,verhouding,verband}
	categorie cat;
	public Antwoord(){
	}
	public Antwoord(int nr,String antw,String cat, int t, int tN, boolean hRG, int vN){
		setNummer(nr);
		setAntwoord(antw);
		setCategorie(cat);
		setTijd(t);
		setToetsNummer(tN);
		setHeeftRekenmachineGebruikt(hRG);
		setVraagNummer(vN);
		setToetsNummer(tN);
	}
	
	public void setNummer(int nr) {
		this.nummer = nr;
		
	}
	public int getNummer(){
		return nummer;
	}
	public String getAntwoord(){
		return antw;
	}
	public void setAntwoord(String antw){
		this.antw = antw;
	}
	public void setCategorie(String t){
		for(categorie tt : categorie.values()){
			if(tt.name().equals(t)){
				this.cat = tt;
			}
		}
	}
	
	public String getCategorie(){
		return cat.toString();
	}
	public void setTijd(int seconden) {
		this.tijd = seconden;		
	}
	public int getTijd(){
		return tijd;
	}
	public int getToetsNummer() {
		return toetsNummer;
	}
	public void setToetsNummer(int toetsNummer) {
		this.toetsNummer = toetsNummer;
	}	
	public boolean getHeeftRekenmachineGebruikt(){
		return heeftRekenmachineGebruikt;
	}
	public void setHeeftRekenmachineGebruikt(boolean heeftRekenmachineGebruikt){
		this.heeftRekenmachineGebruikt = heeftRekenmachineGebruikt;
	}
	public int getVraagNummer(){
		return vraagNummer;
	}
	public void setVraagNummer(int vraagNummer){
		this.vraagNummer = vraagNummer;
	}
}

package domein;

import java.io.Serializable;

public class Antwoord implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int nummer;
	private String antw;
	private int toetsNummer;
	private int tijd;
	private int vraagNummer;
	private boolean heeftRekenmachineGebruikt;
	private boolean goedAntwoord;

	private enum categorie {
		getal, meet, verhouding, verband
	}

	categorie cat;

	public Antwoord() {
	}

	public Antwoord(int nr, String antw, int t, boolean hRG, int tN, int vN,
			boolean gA) {
		this.setNummer(nr);
		this.setAntwoord(antw);
		this.setTijd(t);
		this.setHeeftRekenmachineGebruikt(hRG);
		this.setToetsNummer(tN);
		this.setVraagNummer(vN);
		this.setcheckAntwoord(gA);
	}

	public void setNummer(int nr) {
		this.nummer = nr;

	}

	public int getNummer() {
		return nummer;
	}

	public String getAntwoord() {
		return antw;
	}

	public void setAntwoord(String antw) {
		this.antw = antw;
	}

	public void setTijd(int seconden) {
		this.tijd = seconden;
	}

	public int getTijd() {
		return tijd;
	}

	public int getToetsNummer() {
		return toetsNummer;
	}

	public void setToetsNummer(int toetsNummer) {
		this.toetsNummer = toetsNummer;
	}

	public boolean getHeeftRekenmachineGebruikt() {
		return heeftRekenmachineGebruikt;
	}

	public void setHeeftRekenmachineGebruikt(boolean heeftRekenmachineGebruikt) {
		this.heeftRekenmachineGebruikt = heeftRekenmachineGebruikt;
	}

	public int getVraagNummer() {
		return vraagNummer;
	}

	public void setVraagNummer(int vraagNummer) {
		this.vraagNummer = vraagNummer;
	}

	public void setcheckAntwoord(boolean gA) {
		this.goedAntwoord = gA;
	}

	public boolean checkAntwoord() {
		return goedAntwoord;
	}
}

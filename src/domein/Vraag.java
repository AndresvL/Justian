package domein;

import java.io.Serializable;

import com.google.appengine.api.datastore.Text;

public class Vraag implements Serializable{
	private String antwoord;
	private boolean rekenmachine;
	private boolean isMultiplechoice;
	private int nummer;
	private String context;
	private Text afbeelding;
	private String blobAfbeelding;
	private String vraagstelling;
	private enum type{getal,verhouding, verband, meet}
	type cat;
	private String antwoord2;
	private String antwoord3;
	private String antwoord4;
	
	public Vraag(boolean rek, int nr, String con, Text af, String t, String vS, String a){
		this.setRekenmachine(rek);
		this.setNummer(nr);
		this.setContext(con);
		this.setAfbeelding(af);
		this.setType(t);
		this.setVraagstelling(vS);
		this.setAntwoord(a);
	}

	public Vraag() {
		// TODO Auto-generated constructor stub
	}
	
	public Vraag(int nr, String cat){
		this.setNummer(nr);
		this.setType(cat);
	}
	
	public void setAntwoord2(String a){
		antwoord2 = a;
	}
	
	public String getAntwoord2(){
		return antwoord2;
	}
	
	public void setAntwoord3(String a){
		antwoord3 = a;
	}
	
	public String getAntwoord3(){
		return antwoord3;
	}
	
	public void setAntwoord4(String a){
		antwoord4 = a;
	}
	
	public String getAntwoord4(){
		return antwoord4;
	}
	
	public void setType(String t){
		for(type tt : type.values()){
			if(tt.name().equals(t)){
				this.cat = tt;
			}
		}
	}
	
	public String getType(){
		return cat.name();
	}
	
	public boolean isRekenmachine() {
		return rekenmachine;
	}

	public void setRekenmachine(boolean rekenmachine) {
		this.rekenmachine = rekenmachine;
	}

	public int getNummer() {
		return nummer;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getAfbeelding() {
		return afbeelding.getValue();
		
	}

	public void setAfbeelding(Text afbeelding) {
		this.afbeelding = afbeelding;		
	}

	public String getVraagstelling() {
		return vraagstelling;
	}

	public void setVraagstelling(String vraagstelling) {
		this.vraagstelling = vraagstelling;
	}

	public String getAntwoord() {
		return antwoord;
	}

	public void setAntwoord(String antwoord) {
		this.antwoord = antwoord;
	}

	public boolean isMultiplechoice() {
		return isMultiplechoice;
	}

	public void setMultiplechoice(boolean isMultiplechoice) {
		this.isMultiplechoice = isMultiplechoice;
	}

	public void setBlobAfbeelding(String blobAfbeelding) {
		this.blobAfbeelding = blobAfbeelding;
	}
	public String getBlobAfbeelding(){
		return blobAfbeelding;
	}

	public boolean heeftAfbeelding() {
		boolean b = true;
		if (afbeelding == null
				|| afbeelding.equals("")
				|| afbeelding.equals("NULL")
				|| afbeelding
						.equals("iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAAYdEVYdFNvZnR3YXJlAHBhaW50Lm5ldCA0LjAuNWWFMmUAAAANSURBVBhXY")) {
			b = false;
		}
		return b;
	}

	public boolean heeftContext() {
		boolean b = true;
		if (context == null || context.equals("") || context.equals("NULL")) {
			b = false;
		}
		return b;
	}
}

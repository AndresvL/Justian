 package domein;

import java.io.Serializable;

import com.google.appengine.api.datastore.Text;

public class Vraag implements Serializable{
	private String antwoord;
	private boolean rekenmachine;
	private int nummer;
	private String context;
	private Text afbeelding;
	private String blobAfbeelding;
	private String vraagstelling;
	private enum type{getal,verhouding, verband, meet}
	type cat;
	
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
	
	public void setBlobRekenmachine(int rekenmachine) {
		if(rekenmachine == 0){
			this.rekenmachine = false;
		}else{
			this.rekenmachine = true;
		}
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
		if(context.equals("NULL")){
			this.context = context;
		}else{
			this.context = "";
		}
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

	public void setBlobAfbeelding(String blobAfbeelding) {
		this.blobAfbeelding = blobAfbeelding;
	}
	public String getBlobAfbeelding(){
		return blobAfbeelding;
	}

	public boolean heeftAfbeelding() {
		boolean b = true;
		if (getAfbeelding() == null
				|| getAfbeelding().equals("")
				|| getAfbeelding().equals("NULL")
				|| getAfbeelding().equals("iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAAYdEVYdFNvZnR3YXJlAHBhaW50Lm5ldCA0LjAuNWWFMmUAAAANSURBVBhXY")) {
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

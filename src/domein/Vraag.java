package domein;

import com.google.appengine.api.datastore.Text;

public class Vraag {
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
	
	public Vraag(int nr){
		this.setNummer(nr);
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
		if(context.equals("NULL")){
			context = "";
		}
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
}

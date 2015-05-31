package controller;

import com.google.appengine.api.blobstore.BlobKey;

import domein.Vraag;
import DAO.ToetsDAO;
import DAO.VraagDAO;

public class VraagController {
	
	VraagDAO vraagDAO = new VraagDAO();
	public void addVraag(Vraag vr){
		vraagDAO.addVraag(vr);
	}
	public Vraag getVraag(BlobKey blobkey){
		return vraagDAO.getVraag(blobkey);
	}
	ToetsDAO dao = new ToetsDAO();
	public Vraag eersteVraag() {
		Vraag v = dao.getVraagByNr(1);
		
		return v;
	}

	public boolean isVolgendeVraag(int nr) {
		if(dao.getVraagByNr(nr) == null)return false;
		else return true;
	}

	public Vraag volgendeVraag(int nr) {
		Vraag v = dao.getVraagByNr(nr);
		return v;
	}

	public int getHuidigToetsNummer(){
		return dao.getHuidigToetsNummer();
	}
	public int getVolgendToetsNummer(boolean newToets, int stNr){
		return dao.getVolgendToetsNummer(newToets, stNr);
	}
	
}

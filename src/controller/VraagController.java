package controller;

import com.google.appengine.api.blobstore.BlobKey;

import domein.Vraag;
import DAO.ToetsDAO;
import DAO.VraagDAO;

public class VraagController {
	private ToetsDAO dao = new ToetsDAO();
	private VraagDAO vraagDAO = new VraagDAO();
	
	public void addVraag(Vraag vr){
		vraagDAO.addVraag(vr);
	}
	public Vraag getVraag(BlobKey blobkey){
		return vraagDAO.getVraag(blobkey);
	}
	
	public Vraag eersteVraag(int nr) {
		Vraag v = dao.getVraagByNr(nr);		
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
	
	public int getLaatsteVraag(int studentNr){
		return vraagDAO.getLaatsteVraagNummer(studentNr);
	}
	
	public int getVolgendToetsNummer(boolean newToets, int stNr){
		return dao.getVolgendToetsNummer(newToets, stNr);
	}
	
}

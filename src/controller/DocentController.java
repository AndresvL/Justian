package controller;

import domein.Docent;
import DAO.DocentDAO;

public class DocentController {
	private DocentDAO dao = new DocentDAO();
	public Docent getDocent(String em, String ww) {		
		return dao.getDocent(em, ww);		
	}
}

package controller;


import domein.Antwoord;
import DAO.ToetsDAO;

public class AntwoordController {

	ToetsDAO dao = new  ToetsDAO();
	public void verwerk(Antwoord a) {
		dao.addAntwoord(a);
		
	}
//	public Map<String, Object> getAlleAntwoorden(int nr) {
//		return dao.getAlleAntwoorden(nr);
//	}

}

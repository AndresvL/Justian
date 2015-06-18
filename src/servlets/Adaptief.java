package servlets;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import domein.Antwoord;
import domein.Vraag;
import DAO.VraagDAO;

public class Adaptief{
	private static ArrayList<Vraag> vr = VraagDAO.alleVragen();
	

	public static ArrayList<Vraag> set1() {	
		ArrayList<Vraag> set = new ArrayList<Vraag>();
		int meet = 0;
		int verband = 0;
		int verhouding = 0;
		int getal = 0;
		Collections.shuffle(vr);
		
		for (Vraag v : vr) {
			if (v.getType().equals("meet")) {
				if (meet < 5) {
					meet++;
					set.add(v);
				}
			}
			if (v.getType().equals("verband")) {
				if (verband < 5) {
					verband++;
					set.add(v);
				}
			}
			if (v.getType().equals("getal")) {
				if (getal < 5) {
					getal++;
					set.add(v);
				}
			}
			if (v.getType().equals("verhouding")) {
				if (verhouding < 5) {
					verhouding++;
					set.add(v);
				}
			} 
		}
//		for(Vraag vraag : set){
//			vr.remove(vraag);
//		}
		return set;
	}
	
	public static ArrayList<Vraag> set2(Antwoord a, int meet, int verband, int verhouding, int getal) {
		ArrayList<Vraag> set = new ArrayList<Vraag>();
		return set;
		
	}
}

package servlets;

import java.util.ArrayList;
import java.util.Collections;

import domein.Antwoord;
import domein.Vraag;
import DAO.VraagDAO;

public class Adaptief {
	private static ArrayList<Vraag> vr = VraagDAO.alleVragen();
	private static ArrayList<Vraag> set;

	public static ArrayList<Vraag> set1() {
		set = new ArrayList<Vraag>();
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
//		for (Vraag vraag : set) {
//			vr.remove(vraag);
//		}
		if(set.size() == 20){
			set2(meet, verband, verhouding, getal);
		}
		return set;
	}

	public static ArrayList<Vraag> set2(int meetN, int verbandN,
			int verhoudingN, int getalN) {
		ArrayList<Vraag> set = new ArrayList<Vraag>();

		int meet = 0;
		int verband = 0;
		int verhouding = 0;
		int getal = 0;

		for (Vraag v : vr) {
			if (v.getType().equals("meet")) {
				if (meet < meetN) {
					meet++;
					set.add(v);
				}
			}
			if (v.getType().equals("verband")) {
				if (verband < verbandN) {
					verband++;
					set.add(v);
				}
			}
			if (v.getType().equals("getal")) {
				if (getal < getalN) {
					getal++;
					set.add(v);
				}
			}
			if (v.getType().equals("verhouding")) {
				if (verhouding < verhoudingN) {
					verhouding++;
					set.add(v);
				}
			}
		}
		for (Vraag vraag : set) {
			vr.remove(vraag);
		}
		return set;

	}

	public static ArrayList<Vraag> set3(Antwoord a, int meetN, int verbandN,
			int verhoudingN, int getalN) {
		ArrayList<Vraag> set = new ArrayList<Vraag>();

		int meet = 0;
		int verband = 0;
		int verhouding = 0;
		int getal = 0;

		for (Vraag v : vr) {
			if (v.getType().equals("meet")) {
				if (meet < meetN) {
					meet++;
					set.add(v);
				}
			}
			if (v.getType().equals("verband")) {
				if (verband < verbandN) {
					verband++;
					set.add(v);
				}
			}
			if (v.getType().equals("getal")) {
				if (getal < getalN) {
					getal++;
					set.add(v);
				}
			}
			if (v.getType().equals("verhouding")) {
				if (verhouding < verhoudingN) {
					verhouding++;
					set.add(v);
				}
			}
		}
		for (Vraag vraag : set) {
			vr.remove(vraag);
		}
		return set;

	}
}

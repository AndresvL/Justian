package controller;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TijdController {
	public int getVraagTijd(int sec, int min, int ur, long millisecs) {
		Date resultdate = new Date(millisecs);
//		haalt uren, minuten en seconden uit het systeem
		SimpleDateFormat uur = new SimpleDateFormat("HH");
		SimpleDateFormat minuut = new SimpleDateFormat("mm");
		SimpleDateFormat seconde = new SimpleDateFormat("ss");	
//		parsed de tijd in int en maakt secondes van de tijd van de huidige vraag
	    int uurSeconden = Integer.parseInt(uur.format(resultdate))*3600;
	    int minuutSeconden = Integer.parseInt(minuut.format(resultdate))*60;
	    int seconden = Integer.parseInt(seconde.format(resultdate));
	    int totaal = uurSeconden + minuutSeconden + seconden;
//	    maakt secondes van de tijd van de vorige vraag
	    int uSeconden = ur*3600;
	    int mSeconden = min*60;
	    int totaal2 = uSeconden+mSeconden+sec;
	    return totaal-totaal2;
	}
	public int getUur(long millisecs) {
		SimpleDateFormat uur = new SimpleDateFormat("HH");
		Date resultdate = new Date(millisecs);
		int HH = Integer.parseInt(uur.format(resultdate));
		return HH;
	}

	public int getMinuut(long millisecs) {
		SimpleDateFormat minuut = new SimpleDateFormat("mm");
		Date resultdate = new Date(millisecs);
		int mm = Integer.parseInt(minuut.format(resultdate));
		return mm;
	}

	public int getSeconde(long millisecs) {
		SimpleDateFormat seconde = new SimpleDateFormat("ss");
		Date resultdate = new Date(millisecs);
		int ss = Integer.parseInt(seconde.format(resultdate));
		return ss;
	}
}

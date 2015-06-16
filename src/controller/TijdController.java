package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * deze klasse beheert alle tijd-gerelateerde acties.
 * @author Direct-Act
 *
 */
public class TijdController {
	/**
	 * in deze methode worden eerst het aantal uren, minuten en seconden uit het systeem gehaald<br>
	 * vervolgens worden het aantal uren en minuten naar seconden omgerekend<br>
	 * daarna wordt de tijd van de vorige vraag omgezet in seconden<br>
	 * ten slotte wordt de totale tijd van de vraag berekend.
	 * @param sec het aantal seconden waar de vorige vraag is beëindigd.
	 * @param min het aantal minuten waar  de vorige vraag is beëindigd.
	 * @param ur  het aantal uren waar  de vorige vraag is beëindigd.
	 * @param millisecs de huidige tijd in milliseconden.
	 * @return het totale aantal seconden waar een vraag over gedaan is.
	 */
	public int getVraagTijd(int sec, int min, int ur, long millisecs) {
		Date resultdate = new Date(millisecs);
		SimpleDateFormat uur = new SimpleDateFormat("HH");
		SimpleDateFormat minuut = new SimpleDateFormat("mm");
		SimpleDateFormat seconde = new SimpleDateFormat("ss");	
	    int uurSeconden = Integer.parseInt(uur.format(resultdate))*3600;
	    int minuutSeconden = Integer.parseInt(minuut.format(resultdate))*60;
	    int seconden = Integer.parseInt(seconde.format(resultdate));
	    int totaal = uurSeconden + minuutSeconden + seconden;
	    int uSeconden = ur*3600;
	    int mSeconden = min*60;
	    int totaal2 = uSeconden+mSeconden+sec;
	    return totaal-totaal2;
	}
	/**
	 * getUur haalt het huidige uur van de systeemklok op
	 * @param millisecs de huidige tijd in milliseconden
	 * @return het huidige uur van de systeemklok
	 */
	public int getUur(long millisecs) {
		SimpleDateFormat uur = new SimpleDateFormat("HH");
		Date resultdate = new Date(millisecs);
		int HH = Integer.parseInt(uur.format(resultdate));
		return HH;
	}
/**
 *  haalt het huidige aantal minuten van de systeemklok
 * @param millisecs de huidige tijd in milliseconden
 * @return het huidige aantal minuten van de systeemklok
 */
	public int getMinuut(long millisecs) {
		SimpleDateFormat minuut = new SimpleDateFormat("mm");
		Date resultdate = new Date(millisecs);
		int mm = Integer.parseInt(minuut.format(resultdate));
		return mm;
	}
/**
 * haalt het huidige aantal seconden van de systeemklok
 * @param millisecs de huidige tijd in milliseconden
 * @return het huidige aantal seconden van de systeemklok
 */
	public int getSeconde(long millisecs) {
		SimpleDateFormat seconde = new SimpleDateFormat("ss");
		Date resultdate = new Date(millisecs);
		int ss = Integer.parseInt(seconde.format(resultdate));
		return ss;
	}
}

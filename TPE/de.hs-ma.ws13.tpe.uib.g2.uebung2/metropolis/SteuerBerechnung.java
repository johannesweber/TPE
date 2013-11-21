package metropolis;

/**
 * Extra Klasse fuer die Berechnung der Einkommensteuer und der Kapitalsteuer.
 * 
 * @author Johannes Weber
 * @author Amanpreet Singh Chahota
 * @author Constantin Schneider
 */
public class SteuerBerechnung {
	
	/**
	 * Statische Attribute zur Berechnung der Einkommenssteuer
	 */

	private static final int BASIS20K = (20000 / 100) * 10;
	private static final int BASIS40K = ((20000 / 100) * 25) + BASIS20K;
	private static final int BASIS60k = ((20000 / 100) * 25) + BASIS40K;
	private static final int BASIS120k = ((60000 / 100) * 35) + BASIS60k;
	
	/**
	 * Statische Methode die die Einkommenssteuer berechnet.
	 * @param metroDollar Grundlage zur Berechung der Einkommenssteuer
	 * @return gibt die Hoehe der Einkommenssteuer zurueck
	 */
	
	public static final int berechneEinkommenSt(int grundlage){
		int berechnungsgrundlage = grundlage;
		int steuerNeu = 0;

		if (berechnungsgrundlage <= 0) {
			steuerNeu = 0;
		} else if (grundlage <= 20000) {
			steuerNeu = (grundlage / 100) * 10;
		} else if (grundlage <= 60000) {
			steuerNeu = ((grundlage - 40000) / 100) * 25 + SteuerBerechnung.BASIS40K;
		} else if (grundlage <= 120000) {
			steuerNeu = ((grundlage - 60000) / 100) * 35 + SteuerBerechnung.BASIS60k;
		} else {
			steuerNeu = ((grundlage - 120000) / 100) * 50
					+ SteuerBerechnung.BASIS120k;
		}
		return steuerNeu;	
	}
	public static final int berechneKapitalSt(int grundlage){
		return (grundlage / 100) * 25;
	}
	
	public static final int berechneGewerbeSt(int grundlage){
		return (grundlage / 100) * 10;
	}

}

package tpe_uib_g2_ue1_h0506_1314;

/**
 * @author Johannes Weber
 * @author Amanpreet Singh Chahota
 * @author Constantin Schneider
 * 
 * @version 1.2
 * 
 *          Klasse repraesentiert einen Bruch. Neben den Konstruktoren fuer die
 *          Erstellung von unechten und echten Bruechen, enthaelt die Klasse die
 *          wichtigsten arithmetischen Operation, in Form von Methoden, um mit
 *          Bruechen rechnen zu koennen.
 * 
 * 
 */
public class Bruch {

	/**
	 *
	 */

	private long ganze, zaehler, nenner;

	/**
	 * Konstruktor um einen unechten Bruch zu erstellen.
	 * 
	 * @param zaehler
	 *            Erste uebergebene Zahl wird der Zaehler des Bruches.
	 * @param nenner
	 *            Zweite uebergebene Zahl wird der Nenner des Bruches.Wenn als
	 *            Nenner eine 0 eingegeben wird, wird sie durch eine 1 ersetzt.
	 */

	Bruch(long zaehler, long nenner) {
		if (nenner != 0) {
			this.zaehler = zaehler;
			this.nenner = nenner;
			kuerzen();
		} else {
			this.nenner = 1;
		}
	}

	/**
	 * 
	 * Konstruktor um einen echten Bruch zu erstellen. In diesem Konstruktor
	 * wird auf den Konstruktor fuer den unechten Bruch zugegriffen.
	 * 
	 * @param ganze
	 *            Erste uebergebene Zahl wird der ganze Anteil des Bruches.
	 * @param zaehler
	 *            Zweite uebergebene Zahl wird der Zaehler des Bruches.
	 * @param nenner
	 *            Dritte uebergebene Zahl wird der Nenner des Bruches.Wenn als
	 *            Nenner eine 0 eingegeben wird, wird sie durch eine 1 ersetzt.
	 */

	Bruch(long ganze, long zaehler, long nenner) {
		this(zaehler, nenner);
		this.ganze = ganze;
	}

	/**
	 * interne Methode die durch einen rekursiven Aufruf den GgT, der beiden
	 * uebergebenen Zahlen, berechnet.
	 * 
	 * @param zaehler
	 *            Zaehler des Bruches.
	 * @param nenner
	 *            Nenner des Bruches.
	 * @return gibt den berechneten GgT als Datentyp "long" zurueck.
	 */

	private long getGgt(long zaehler, long nenner) {
		if (nenner == 0) {
			return zaehler;

		} else {
			return getGgt(nenner, zaehler % nenner);
		}
	}

	/**
	 * interne Methode zum kuerzen eines Bruches. Diese Methode wird direkt beim
	 * erstellen eines Bruches ausgefuehrt.
	 */

	private void kuerzen() {
		long ggt = getGgt(zaehler, nenner);
		zaehler = zaehler / ggt;
		nenner = nenner / ggt;
	}

	/**
	 * Methode die den Nenner des Bruches zurueck gibt
	 * 
	 * @return Gibt den Nenner des Bruches zurueck
	 */

	public long getNenner() {
		return nenner;

	}

	/**
	 * Methode die den Zaehler des Bruches zurueck gibt
	 * 
	 * @return gibt den Zaehler des Bruches zurueck.
	 */

	public long getZaehler() {
		return zaehler;
	}

	/**
	 * Methode die den ganzen Anteil des Bruches zurueck gibt
	 * 
	 * @return gibt den ganzen Anteil des Bruches zurueck
	 */

	public long getGanze() {
		return ganze;
	}

	/**
	 * Methode die testet, ob der Bruch echt oder unecht ist
	 * 
	 * @return gibt true oder false zurueck
	 */

	public boolean isEcht() {
		boolean test = false;

		if (ganze != 0)
			test = true;

		return test;
	}

	/**
	 * Methode die einen echten Bruch in einem unechten Bruch umwandelt.
	 * Innerhalb der Methode wird ein komplett neues Bruchobjekt erstellt und
	 * umgewandelt.
	 * 
	 * @return gibt den unechten Bruch zurueck
	 */

	public Bruch unechterBruch() {
		if (isEcht()) {

			long zaehler = (this.nenner * this.ganze) + this.zaehler;
			long nenner = this.nenner;

			Bruch unechterBruch = new Bruch(zaehler, nenner);

			return unechterBruch;
		} else {
			return new Bruch(ganze, zaehler, nenner);
		}
	}

	/**
	 * Methode die einen unechten Bruch in einem echten Bruch umwandelt.
	 * Innerhalb der Methode wird ein komplett neues Bruchobjekt erstellt und
	 * umgewandelt.
	 * 
	 * @return gibt den echten Bruch zurueck
	 */

	public Bruch echterBruch() {
		if (!isEcht()) {

			long ganze = getZaehler() / getNenner();
			long zaehler = getZaehler() % getNenner();
			long nenner = getNenner();

			Bruch echterBruch = new Bruch(ganze, zaehler, nenner);

			return echterBruch;
		} else {
			return new Bruch(zaehler, nenner);
		}
	}

	/**
	 * Methode um einen Bruch in eine Dezimalzahlzahl umzuwandeln. Wobei der
	 * uebergebene Bruch erst in einen unechten Bruch umgewandelt wird.
	 * 
	 * @return gibt den Bruch als eine Dezimalzahl zurueck.
	 */

	public double getDezimalzahl() {

		Bruch bruch = unechterBruch();

		double ergebnis = (double) bruch.getZaehler()
				/ (double) bruch.getNenner();

		return ergebnis;
	}

	/**
	 * Methode die den Kehrwert ausgibt
	 * 
	 * @return gibt den Kehrwert zurueck
	 */

	public Bruch kehrwert() {
		Bruch bruch = unechterBruch();

		long zaehler = bruch.getNenner();
		long nenner = bruch.getZaehler();

		Bruch kehrbruch = new Bruch(zaehler, nenner);

		return kehrbruch;
	}

	/**
	 * Methode die zwei Brueche auf den gleichen Dezimalwert vergleicht.
	 * 
	 * @param bruch2
	 *            der zweite Bruch mit dem das Bruchobjekt verglichen wird.
	 * @return gibt true oder false zurueck
	 */

	public boolean equals(Bruch bruch2) {

		if (this.getDezimalzahl() == bruch2.getDezimalzahl()) {
			return true;
		}

		return false;
	}

	/**
	 * Diese Methode fŸhrt die einzelnen Rechenoperationen auf Brueche aus. Um
	 * Codeduplikation zu vermeiden wurden alle Rechenoperationen in einer
	 * Methode zusammengefasst. Da diese Methode nur innerhalb der Klasse Bruch
	 * benutzt wird wurde ihre Sichtbarkeit auf "private" gesetzt um den Zugriff
	 * von au§en zu unterbinden.
	 * 
	 * @param bruch2
	 *            Zweiter Bruch mit dem gerechnet werden soll wird uebergeben
	 * @param zeichen
	 *            Je nach dem welche Rechenoperation von dem Benutzer gewaehlt
	 *            wird, wird ein anderer Rechenoperator uebergeben.
	 * @return Das Ergebnis, in Form eines neuen Bruches, wird zurueckgegeben
	 */

	private Bruch rechnen(Bruch bruch2, char zeichen) {
		long zaehlerNeu = 0;
		long nennerNeu = 0;
		Bruch unechterBruch1 = unechterBruch();

		if (zeichen == '/') {
			Bruch kehrwert = bruch2.kehrwert().unechterBruch();
			Bruch ergebnis = unechterBruch1.multipliziere(kehrwert);

			if (isEcht() || bruch2.isEcht()) {
				ergebnis = ergebnis.echterBruch();
				return ergebnis;
			} else {
				return ergebnis;
			}
		} else {
			Bruch unechterBruch2 = bruch2.unechterBruch();

			switch (zeichen) {
			case '+':
				zaehlerNeu = (unechterBruch2.getNenner() * unechterBruch1
						.getZaehler())
						+ (unechterBruch1.getNenner() * unechterBruch2
								.getZaehler());
				nennerNeu = unechterBruch1.getNenner()
						* unechterBruch2.getNenner();
				break;
			case '-':
				zaehlerNeu = (unechterBruch1.getZaehler() * unechterBruch2
						.getNenner())
						- (unechterBruch2.getZaehler() * unechterBruch1
								.getNenner());
				nennerNeu = unechterBruch1.getNenner()
						* unechterBruch2.getNenner();
				break;
			case '*':
				zaehlerNeu = unechterBruch1.getZaehler()
						* unechterBruch2.getZaehler();
				nennerNeu = unechterBruch1.getNenner()
						* unechterBruch2.getNenner();
				break;
			}

			Bruch ergebnis = new Bruch(zaehlerNeu, nennerNeu);

			if (isEcht() || bruch2.isEcht()) {
				ergebnis = ergebnis.echterBruch();
				return ergebnis;
			} else {
				return ergebnis;
			}
		}
	}

	/**
	 * Diese Methode ist von au§en sichtbar und fuehrt die Addition der Brueche
	 * durch, wobei nicht direkt das addieren der Brueche in dieser Methode
	 * durchgefuehrt, sondern diese Methode ist dafŸr da um die private
	 * rechnen() auszufuehren.
	 * 
	 * @param bruch2
	 *            Der zweite Bruch mit welchem gerechnet wird.
	 * @return Das Ergebnis der Methode rechen() wird zurueck gegeben.
	 */

	public Bruch addiere(Bruch bruch2) {
		return rechnen(bruch2, '+');
	}

	/**
	 * Diese Methode ruft die interne Methode rechnen() auf um das Bruchobjekt
	 * wird der ganzen Zahl zu multiplizieren.
	 * 
	 * @param bruch2
	 *            Der zweite Bruch mit welchem gerechnet wird.
	 * @return Das Ergebnis der Methode rechen() wird zurueck gegeben.
	 */

	public Bruch subtrahiere(Bruch bruch2) {
		return rechnen(bruch2, '-');
	}

	/**
	 * Diese Methode ruft die interne Methode rechnen() auf um die uebergebenen
	 * Brueche zu multiplizieren.
	 * 
	 * @param bruch2
	 *            Der zweite Bruch mit welchem gerechnet wird.
	 * @return Das Ergebnis der Methode rechen() wird zurueck gegeben.
	 */

	public Bruch multipliziere(Bruch bruch2) {
		return rechnen(bruch2, '*');
	}

	/**
	 * Diese Methode ruft die interne Methode rechnen() auf um die uebergebenen
	 * Brueche zu multiplizieren.
	 * 
	 * @param ganzeZahl
	 *            Die ganze Zahl mit welcher Bruch Bruch multipliziert wird.
	 * @return Das Ergebnis der Methode rechen() wird zurueck gegeben.
	 */

	public Bruch multipliziere(long ganzeZahl) {
		Bruch unechterBruch1 = unechterBruch();
		Bruch bruch2 = new Bruch(ganzeZahl, 1);

		return unechterBruch1.multipliziere(bruch2);
	}

	/**
	 * Diese Methode ruft die interne Methode rechnen() auf und fuehrt die
	 * Division der Brueche durch.
	 * 
	 * @param bruch2
	 *            Der zweite Bruch mit welchem gerechnet wird.
	 * @return Das Ergebnis der Methode rechen() wird zurueck gegeben.
	 */

	public Bruch dividiere(Bruch bruch2) {
		return rechnen(bruch2, '/');
	}

	/**
	 * Diese Methode ruft die interne Methode rechnen() auf das Bruchobjekt
	 * durch die ganzzahlige Zahl zu dividieren.
	 * 
	 * @param ganzeZahl
	 *            Die ganze Zahl durch die der Bruch geteilt wird.
	 * @return Das Ergebnis der Methode rechen() wird zurueck gegeben.
	 */

	public Bruch dividiere(long ganzeZahl) {
		Bruch unechterBruch1 = unechterBruch();
		Bruch bruch2 = new Bruch(ganzeZahl, 1);

		return unechterBruch1.dividiere(bruch2);
	}

	/**
	 * 
	 * Diese Methode potenziert das Bruchobjekt mit der uebergebenen Potenz.
	 * Falls die uebergebene Zahl positiv ist wird ganz normal potenziert. Falls
	 * nicht wird der potenzierte Bruch durch 1 geteilt. Zum potenzieren wird
	 * die interne Methode potenziereRek() aufgerufen.
	 * 
	 * @param potenz
	 *            Die Zahl mit welcher potenziert wird.
	 * @return Der Ergebnis-Bruch  wird zurueckgegeben
	 */

	public Bruch potenziere(long potenz) {

		if (potenz >= 0) {
			long zaehler = potenzierenRek(getZaehler(), potenz);
			long nenner = potenzierenRek(getNenner(), potenz);

			return new Bruch(zaehler, nenner);
		} else {
			Bruch bruch1 = new Bruch(1, 1);
			Bruch bruch2 = new Bruch(zaehler, nenner);
			Bruch zwischen = bruch2.potenziere(2);
			Bruch ergebnis = bruch1.dividiere(zwischen);

			return ergebnis;
		}
	}

	/**
	 * 
	 * Diese Methode potenziert das Bruchobjekt mit einem Bruch.
	 * 
	 * @param bruch2
	 *            Die Bruch, mit welchem potenziert wird.
	 * @return Das Ergebnis wird als neuen Bruch zurueckgegeben.
	 */

	public double potenziere(Bruch bruch2) {
		
		Bruch zwischen = bruch2.unechterBruch();
		
		double zaehler1 = zwischen.getZaehler();
		double nenner1 = zwischen.getNenner();
		
		double zaehler2 = Math.pow(zaehler, zaehler1 / nenner1);
		double nenner2 = Math.pow(nenner, zaehler1 / nenner1);

		double ergebnis = zaehler2 /  nenner2;

		return ergebnis;

	}

	/**
	 * In dieser Methode findet das eigentliche potentieren statt. Sie
	 * Sichtbarkeit dieser Methode wurde auf "private" gesetzt, da die Methode
	 * nur innerhalb der Klasse Bruch benutzt wird.
	 * 
	 * @param zahl
	 *            Die Basis, welche potenziert werden soll.
	 * @param potenz
	 *            Der Quotient
	 * @return Das Ergebnis der Potenzfunktion
	 */

	private long potenzierenRek(long zahl, long potenz) {
		long ergebnis = 0;
		if (potenz == 0) {
			ergebnis = 1;
		} else {
			ergebnis = zahl * potenzierenRek(zahl, potenz - 1);
		}
		return ergebnis;
	}

	/**
	 * Diese Methode ueberschreibt die vorhandene toString() Methode um das
	 * Bruchobjekt korrekt darzustellen.
	 * 
	 */

	@Override
	public String toString() {
		if (ganze != 0 && zaehler == 0) {
			return ganze + "";
		} else if (zaehler == 0) {
			return "0";
		} else if (ganze != 0) {
			return ganze + " " + Math.abs(zaehler) + "/" + Math.abs(nenner);
		} else if (zaehler % nenner == 0) {
			long ergebnis = zaehler / nenner;
			String ergebnis1 = String.valueOf(ergebnis);
			return ergebnis1;
		} else {
			return zaehler + "/" + nenner;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (ganze ^ (ganze >>> 32));
		result = prime * result + (int) (nenner ^ (nenner >>> 32));
		result = prime * result + (int) (zaehler ^ (zaehler >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bruch other = (Bruch) obj;
		if (ganze != other.ganze)
			return false;
		if (nenner != other.nenner)
			return false;
		if (zaehler != other.zaehler)
			return false;
		return true;
	}

}

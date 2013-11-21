package menschen;

import metropolis.*;

/**
 * Die Klasse Mensch ist eine konkrete Klasse und repraesentiert einen normalen
 * Buerger von Metropolis. Zusaetzlich zu den 3 Attributen, welcher der Buerger
 * von der abstrakten Klasse Mensch geerbet hat, besitzt der normale Buerger
 * noch die Methoden berechneSteuer() und arbeiten().
 * 
 * @author Johannes Weber
 * @author Amanpreet Singh Chahota
 * @author Constantin Schneider
 */
public class Buerger extends Menschen implements Steuerpflichtig {

	/**
	 * Zusaetzlich zu den drei Attributen, welche im Menschen-Konstruktor
	 * festgelegt werden wird jeder Buerger sofort auf in die Liste der
	 * steuerzahlenden Personen eingetragen und bekommt 40000 Metro-Dollar.
	 * 
	 * @param name
	 *            der Name des Buergers
	 */
	public Buerger(String name) {
		super(name);
		this.metroDollar = 40000;
		Finanzamt.beitreten(this);
	}

	/**
	 * Methode um die Einkommensteuer der Buerger zu ermitteln.
	 */
	@Override
	public int berechneSteuer() {
		return SteuerBerechnung.berechneEinkommenSt(this.metroDollar);
	}

	/**
	 * Methode arbeiten, welche dem Buerger 1500 Metro-Dollar ueberweisst.
	 */

	public void arbeiten() {
		this.metroDollar += 1500;
	}

	/**
	 * Mit dieser Methode kann der Buerger Lotto spielen und gewinnt sogar beim
	 * ersten mal 160000 metro Dollar.
	 */
	public void lottoSpielen() {
		this.metroDollar += 160000;
	}
}

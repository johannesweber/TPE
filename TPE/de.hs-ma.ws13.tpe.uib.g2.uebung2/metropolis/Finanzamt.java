package metropolis;

import java.util.LinkedList;

/**
 * Diese Klasse erzeigt ein Objekt vom Typ Finanzamt. Pro Finanzamt wird eine
 * Liste aller steuerzahlenden Buergern angelegt. Anhand dieser Liste kann man
 * sofort auf alle steuerpflichtigen Buergern zugreifen und alle Steuern von
 * Metropolis berechnen.
 * 
 * @author Johannes Weber
 * @author Amanpreet Singh Chahota
 * @author Constantin Schneider
 */
public class Finanzamt {

	private static LinkedList<Steuerpflichtig> steuerzahler;

	private String name;
	private static long steuerGesamt;

	/**
	 * Der Konstruktor eines Objekts vom Typ Finanzamt. Da ein Finanzamt immer
	 * die selben Eigenschaften besitzt, besitzt auch der Konstruktor keinen
	 * Uebergabewert. Sobald ein Finanzamt angelegt wird, wird einen Liste mit
	 * allen steuerpflichtigen Buergern angelegt.
	 */
	public Finanzamt() {
		this.name = this.getClass().getSimpleName();
		Finanzamt.steuerzahler = new LinkedList<Steuerpflichtig>();
	}

	/**
	 * In dieser Methode wird die Steuer aller Bewohner berechnet.
	 */
	private void steuerEintreiben() {
		long steuer = 0;
		for (Steuerpflichtig it : steuerzahler) {
			steuer += it.berechneSteuer();
		}
		Finanzamt.steuerGesamt = steuer;
	}

	/**
	 * Methode damit ein Steuerpflichtiger der steuerzahler Liste hinzugefuegt
	 * werden kann
	 * 
	 * @param mensch
	 *            Der Steuerpflichtige der in die Liste aller steuerpflichtigen
	 *            eingetragen wird
	 */

	public static void beitreten(Steuerpflichtig mensch) {
		Finanzamt.steuerzahler.add(mensch);
	}

	/**
	 * @param dollar
	 *            Die Hoehe der Veraenderung
	 */
	public static void SteuerVeraendern(long dollar) {
		Finanzamt.steuerGesamt += dollar;
	}

	/**
	 * @return die Anzahl der steuerpflichtigen Buerger in Metropolis.
	 */
	public int getAnzahlSteuerBuerger() {
		return Finanzamt.steuerzahler.size();
	}

	/**
	 * @return Die gesamten Steuern in Metropolis.
	 */
	public long getSteuerGesamt() {
		steuerEintreiben();
		return Finanzamt.steuerGesamt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Finanzamt other = (Finanzamt) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
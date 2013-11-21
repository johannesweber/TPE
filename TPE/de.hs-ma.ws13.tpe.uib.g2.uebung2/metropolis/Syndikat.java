package metropolis;

import java.util.LinkedList;
import mutanten.Schurke;

/**
 * Klasse um ein Syndikat Objekt zu definieren. Eine Syndikat enthaelt eine
 * Liste aller Mitglieder, ein bestimmtes Kapital und natuerlich einen Namen.
 * 
 * @author Johannes Weber
 * @author Amanpreet Singh Chahota
 * @author Constantin Schneider
 */
public class Syndikat implements Steuerpflichtig {

	private LinkedList<Schurke> syndikat;
	private int anzahlSchurken;
	private int kapital;
	private String name;

	/**
	 * Konstruktor fuer ein Objekt des Typs Syndikat. Beim erstellen eines
	 * Syndikats wird ein Name und ein Startkapital festgelegt. Zusaetzlich wird
	 * noch jedes erstellte Syndikat zu der Liste der Steuerpflichtigen hinzugefuegt.
	 * 
	 * @param name
	 *            Der Name des Syndikats
	 * @param startkapital
	 *            Das Startkapital
	 */

	public Syndikat(String name, int startkapital) {
		this.name = name;
		this.kapital = startkapital;
		this.syndikat = new LinkedList<Schurke>();
		Finanzamt.beitreten(this);
	}

	/**
	 * @return Anzahl der Mitglieder
	 */
	public int getAnzahlMitglieder() {
		return this.syndikat.size();
	}

	/**
	 * @return Liste aller Mirglieder
	 */
	public LinkedList<Schurke> getMitglieder() {
		return this.syndikat;
	}

	/**
	 * Methode welche das Vermoegen aller Mitglieder berechnet
	 */
	public int getMetroDollarGesamt() {
		int dollarGesamt = this.kapital;
		for (Schurke it : syndikat) {
			dollarGesamt += it.getMetroDollar();
		}
		return dollarGesamt;
	}

	/**
	 * Mit dieser Methode entwickelt das Syndikat einen genialen Plan, um die
	 * Weltherschaft an sich zu reissen. Der Plan funktioniert und spendiert dem
	 * Syndikat 70000 Metro-Dollar.
	 */
	public void derBrainPlan() {
		this.kapital += 70000;
	}

	/**
	 * Durch diese Methode wird ein neues Mitglied im Syndikat aufgenommen.
	 * 
	 * @param schurke
	 *            Das neue Mitglied
	 */
	public void neuesMitglied(Schurke schurke) {
		this.syndikat.add(schurke);
	}

	/**
	 * Diese Methode ueberschreibt die Methode berechneSteuer() der
	 * Schnittstelle Steuerpflichtig und berechnet die Kapitalsteuer des
	 * Syndikats.
	 */
	@Override
	public int berechneSteuer() {
		return SteuerBerechnung.berechneKapitalSt(this.getMetroDollarGesamt());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anzahlSchurken;
		result = prime * result + (int) (kapital ^ (kapital >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((syndikat == null) ? 0 : syndikat.hashCode());
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
		Syndikat other = (Syndikat) obj;
		if (anzahlSchurken != other.anzahlSchurken)
			return false;
		if (kapital != other.kapital)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (syndikat == null) {
			if (other.syndikat != null)
				return false;
		} else if (!syndikat.equals(other.syndikat))
			return false;
		return true;
	}
}

package metropolis;

import menschen.Buerger;

/**
 * Eine Klasse fuer eine Abstraktion eines Unternehmens.Jedes Unternehmen hat
 * einen Namen sowie einen Gewinn.
 * 
 * @author Johannes Weber
 * @author Amanpreet Singh Chahota
 * @author Constantin Schneider
 */
public abstract class Unternehmen implements Steuerpflichtig {

	protected int gewinn;
	protected String name;

	/**
	 * Konstruktor fuer alle Arten eines Unternehmens. Sobald eine Art des
	 * Unternehmens angelegt wird, wird es zur Liste der steuerzahlenden Buerger
	 * hinzugefuegt.Zusaetzlich bekommt jedes Unternehmen noch ein Startkapital.
	 * 
	 * @param name
	 *            Der Name des Unternehmens
	 */
	protected Unternehmen(String name, int startkapital) {
		this.name = name;
		this.gewinn = startkapital;
		Finanzamt.beitreten(this);
	}

	/**
	 * @return Liefert den Gewinn des Unternehmens
	 */
	public int getGewinn() {
		return this.gewinn;
	}

	/**
	 * Methode setzt den Gewinn neu. Dient vorrangig zum testen der Unternehmen
	 * in der JUnit Klasse.
	 * 
	 * @param neuerGewinn
	 *            Der neue Gewinn
	 */

	public void setGewinn(int neuerGewinn) {
		this.gewinn = neuerGewinn;
	}

	/**
	 * abstrakte Methode welche ein neues Mitglied zum Unternehmen hinzufuegt.
	 * 
	 * @param buerger
	 *            Das neue Mitglied
	 */
	public abstract void neuerMitarbeiter(Buerger buerger);

	/**
	 * abstrakte Methode welche die GewerbeSteuer ausgibt.
	 * 
	 * @return Die Hoehe der Gewerbesteuer
	 */

	public abstract int getGewerbeSt();

	/**
	 * @return Liefert die Anzahl der Gesellschafter
	 */
	public abstract int getAnzahlGesellschafter();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (gewinn ^ (gewinn >>> 32));
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
		Unternehmen other = (Unternehmen) obj;
		if (gewinn != other.gewinn)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}

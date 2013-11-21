package menschen;

import metropolis.Einwohner;

/**
 * diese abstrakte Klasse Menschen repraesentiert einen Menschen in Metropolis.
 * Jeder Mensch besitzt vier Attribute: Alter, Name, MetroDollar und Leben.
 * 
 * @author Johannes Weber
 * @author Amanpreet Singh Chahota
 * @author Constantin Schneider
 */
public abstract class Menschen extends Einwohner {

	protected int alter;

	/**
	 * Zusaetzlich zu den zwei Attributen, welche im Konstruktor der Einwohner
	 * festgelegt werden, bekommt jeder Buerger 10000 Metro-Dollar zur
	 * Einbuergerung und es wird ein Alter per Zufallsprinzip berechnet.
	 * 
	 * @param name
	 *            Name des Menschen
	 */
	Menschen(String name) {
		super(name);
		this.metroDollar = 10000;
		alterBerechnen();
	}

	/**
	 * Diese Methode berechnet per Zufall das Alter des Menschen (zwischen 18
	 * und 80 Jahren)
	 */
	protected void alterBerechnen() {
		this.alter = (int) Math.random() * (80 - 16) + 16;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + alter;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menschen other = (Menschen) obj;
		if (alter != other.alter)
			return false;
		return true;
	}
}

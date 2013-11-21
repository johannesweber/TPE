package metropolis;

/**
 * Abstrakte Klasse, welche alle Einwohner der Stadt repraesentieren. Jeder
 * Einwohner in der Stadt hat einen Namen, ein Vermoegen(in Metro Dollar) und
 * 100 Lebenspunkte.
 * 
 * @author Johannes Weber
 * @author Amanpreet Singh Chahota
 * @author Constantin Schneider
 */
public abstract class Einwohner {

	protected int leben;
	protected String name;
	protected int metroDollar;

	/**
	 * Konstruktor fuer einen Einwohner. Jeder Einwohner von Metropolis besitzt
	 * einen Namen und 100 Lebenspunkte
	 * 
	 * @param name
	 *            Der Name des Einwohners
	 */
	public Einwohner(String name) {
		this.name = name;
		this.leben = 100;
	}

	/**
	 * Gibt die Anzahl der verbleibenden Lebenspunkte des Einwohners zurueck.
	 * @return Liefert die Anzahl der Lebenspunkte
	 */
	public int getLeben() {
		return this.leben;
	}

	/**
	 * Methode, welche die Lebenspunkte um den Uebergabeparameter veraendert.
	 * 
	 * @param leben
	 *            Die Anzahl um welche die Leben des Einwohners veraendert
	 *            werden.
	 */
	public void LebenVerringern(int leben) {
		this.leben = this.leben - leben;
	}

	/**
	 * @return Liefert das Vermoegen des Einwohners
	 */
	public int getMetroDollar() {
		return this.metroDollar;
	}

	/**
	 * Methode, welche das Vermoegen um den Uebergabeparameter aendert.
	 * 
	 * @param dollar
	 *            Die Hoehe um die die Metro-Dollar des Einwohners veraendert
	 *            werden.
	 */
	public void MetroDollarVeraendern(int dollar) {
		this.metroDollar += dollar;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + leben;
		result = prime * result + (int) (metroDollar ^ (metroDollar >>> 32));
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
		Einwohner other = (Einwohner) obj;
		if (leben != other.leben)
			return false;
		if (metroDollar != other.metroDollar)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}

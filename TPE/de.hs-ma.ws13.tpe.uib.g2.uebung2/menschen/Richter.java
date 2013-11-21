package menschen;

import java.util.Random;

import mutanten.Schurke;

/**
 * Die Klasse Richter ist eine konkrete Klasse und repraesentiert einen Richter
 * von Metropolis. Zusaetzlich zu den 3 Attributen, welcher der Richter von der
 * abstrakten Klasse Mensch geerbet hat, kann ein Richter korrupt sein oder
 * nicht. Zusätzlich besitzt der Richter noch die Methode verurteilen().
 * 
 * @author Johannes Weber
 * @author Amanpreet Singh Chahota
 * @author Constantin Schneider
 */
public class Richter extends Menschen {

	private Random k = new Random();
	private boolean korrupt;

	/**
	 * Der Konstruktor fuer einen Richter enthaelt alle Attribute eines
	 * Konstruktors fuer einen Menschen. Zusaetzlich bekommt jeder Richter 40000
	 * metro-dollar als Willkommensgeschenk.
	 * 
	 * @param name
	 *            Der Name des Richters
	 */
	public Richter(String name) {
		super(name);
		this.metroDollar = 40000;
		this.korrupt = k.nextBoolean();
	}

	/**
	 * In dieser Methode verurteilt der Richter einen Schurken. Wenn der Richter
	 * korrupt ist, laesst er den Schurken laufen. Wenn nicht, bekommt der Schurke
	 * eine Strafe in Hoehe von 1000 Metro-dollar. In beiden Faellen wird der
	 * Richter mit 60000 Metro-Dollar fuer seine Muehen entlohnt.
	 * 
	 * @param schurke
	 *            Der zu verurteilende Schurke
	 */
	public void verurteilen(Schurke schurke) {
		if (!this.korrupt) {
			schurke.MetroDollarVeraendern(-1000);
		}
		this.metroDollar += 60000;
	}

	/**
	 * Methode ist primaer fuer den JUnit test gedacht
	 * 
	 * @return Gibt aus ob der Richter korrupt ist oder nicht. 
	 * 			true = Richter  ist korrupt.
	 *         	false = Richter ist nicht korrupt.
	 */
	public boolean istKorrupt() {
		if (this.korrupt) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((k == null) ? 0 : k.hashCode());
		result = prime * result + (korrupt ? 1231 : 1237);
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
		Richter other = (Richter) obj;
		if (k == null) {
			if (other.k != null)
				return false;
		} else if (!k.equals(other.k))
			return false;
		if (korrupt != other.korrupt)
			return false;
		return true;
	}
}

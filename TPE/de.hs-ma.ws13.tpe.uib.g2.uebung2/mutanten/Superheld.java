package mutanten;

import java.util.Arrays;

import metropolis.Finanzamt;

/**
 * Diese konkrete Methode repraesentiert einen Superhelden und enthaelt neben
 * dem Kontsruktor und den geerbte Methode, die Methode weltRetten().
 * 
 */

public class Superheld extends Mutanten {

	private String[] superkraefte;

	/**
	 * Konstruktor fuer einen Superhelden. Sobald der Superheld angelegt wird
	 * erhaelt er einen Bonus von 20000 metro-dollar,
	 * 
	 * @param name
	 *            Der Name des Superhelden
	 */
	public Superheld(String name) {
		super(name);
		this.metroDollar = 30000;
		kraefteErmitteln();
	}

	/**
	 * Methode welche per Zufallsprinzip zuerst die Anzahl der Superkraefte des
	 * Superhelden auswaehlt und dann diese auf Basis der geerbten Methode
	 * superkraftFestelgen() ermittelt.
	 */
	private void kraefteErmitteln() {
		double anzahlkraefte = (double) ((Math.random() * 5) + 1);
		Math.round(anzahlkraefte);
		superkraefte = new String[(int) anzahlkraefte];
		for (int i = 0; i < superkraefte.length; i++) {
			superkraefte[i] = this.superkraftFestlegen();
		}
	}

	/**
	 * Methode kaempfen, in welcher der Superheld gegen einen Schurken kaempft.
	 * Anhand der Superkraft entscheidet es sich ob der Schurke gewinnt oder
	 * verliert. Der Gewinner erhaelt einen Teil des Vermoegens des Siegers.
	 * 
	 * @return boolean true = Kampf gewonnen. false = Kampf verloren.
	 * @param gegner
	 *            Der Gegner
	 */
	public boolean kaempfe(Schurke gegner) {
		int zaehler = 0;
		boolean gewonnen = false;
		for (String gutekraft : superkraefte) {
			if (gutekraft.equals(gegner.getSuperkraft())) {
				zaehler++;
			}
		}
		if (zaehler != 0) {
			gewonnen = true;
			gegner.LebenVerringern(100);
			int provision = (gegner.getMetroDollar() / 100) * 80;
			int steuerAnteil = (gegner.getMetroDollar() / 100) * 20;
			this.metroDollar += provision;
			Finanzamt.SteuerVeraendern(steuerAnteil);
			gegner.MetroDollarVeraendern(-(provision + steuerAnteil));
		} else {
			this.LebenVerringern(100);
			int beute = this.metroDollar / 2;
			gegner.MetroDollarVeraendern(beute);
			this.metroDollar -= beute;
		}
		return gewonnen;
	}

	/**
	 * Mit dieser Methode rettet der Superheld die Welt und erhaelt fuer seine
	 * glorreichen Taten satte 170000 Metro-Dollar.
	 */
	public void weltRetten() {
		this.metroDollar += 170000;
	}

	/**
	 * 
	 * @return Liefert das String Array der Superkraefte zurueck.
	 */
	public String[] getSuperkraefte() {
		return this.superkraefte;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Arrays.hashCode(superkraefte);
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
		Superheld other = (Superheld) obj;
		if (!Arrays.equals(superkraefte, other.superkraefte))
			return false;
		return true;
	}
}

package mutanten;

import metropolis.*;

/**
 * Diese konkrete Methode repraesentiert einen Schurken und enthaelt neben dem
 * Kontsruktor und den geerbten Methoden, noch 4 individuelle Methoden.
 * 
 * Um sein Vermoegen aufzubessern bsitzte der Schurke zwei Moeglichkeiten:
 * entwerder plant er einen auftragsmord() oder er kann ein
 * finanzamtAusrauben(). Des weiteren kann ein Schurke noch mit einem
 * Superhelden kaempfen und einem Syndikat beitreten.
 * 
 * @author Johannes Weber
 * @author Amanpreet Singh Chahota
 * @author Constantin Schneider
 */
public class Schurke extends Mutanten implements Steuerpflichtig {

	private String superkraft;

	/**
	 * Konstruktor um einen Schurken zu erstellen. Sobald ein Schurke erstellt
	 * wird, wird er in die Liste der Steuerpflichtigen eingetragen. Die
	 * Superkraft des Schurken wird danach per Zufallsprinzip ermittelt.
	 * 
	 * @param name
	 *            Der Name des Schurken
	 */
	public Schurke(String name) {
		super(name);
		Finanzamt.beitreten(this);
		this.superkraft = superkraftFestlegen();
	}

	/**
	 * @return gibt die Hoehe der Einkommensteuer zurueck
	 */
	@Override
	public int berechneSteuer() {
		return SteuerBerechnung.berechneEinkommenSt(this.metroDollar);
	}

	/**
	 * Methode um ein Raub im Finanzamt zu begehen. Bei einem erfolgreichen Raub
	 * wird der Schurke mit 40 Prozent der Steuern von Metropolis belohnt. Wenn
	 * der Raub nicht erfolgreich war, bekommt der Schurke ein Bussgeld von 1000
	 * metro-dollar.
	 * 
	 * @param amt
	 *            Das auszuraubende Finanzamt
	 */
	public void finanzamtAusrauben(Finanzamt amt) {
		long beute = 0;
		if (amt.getSteuerGesamt() > 0) {
			beute = (amt.getSteuerGesamt() / 100) * 40;
		} else {
			beute = -1000;
		}
		this.metroDollar += beute;
		Finanzamt.SteuerVeraendern(beute);
	}

	/**
	 * Methode kaempfen, in welcher der Schurke gegen einen Superheld kaempft.
	 * Anhand der Superkraft entscheidet es sich ob der Schurke gewinnt oder
	 * verliert. Der Gewinner erhaelt ein Teil des Vermoegens des Siegers.
	 * 
	 * @return boolean true = Kampf gewonnen. false = Kampf verloren.
	 * @param gegner
	 *            Der Gegner
	 */
	public boolean kaempfe(Superheld gegner) {
		int zaehler = 0;
		boolean gewonnen = false;
		for (String gutekraft : gegner.getSuperkraefte()) {
			if (gutekraft.equals(this.getSuperkraft())) {
				zaehler++;
			}
		}
		if (zaehler != 0) {
			this.LebenVerringern(100);
			int provision = (this.getMetroDollar() / 100) * 80;
			int steuerAnteil = (this.getMetroDollar() / 100) * 20;
			gegner.MetroDollarVeraendern(provision);
			Finanzamt.SteuerVeraendern(steuerAnteil);
			this.MetroDollarVeraendern(-(provision + steuerAnteil));
		} else {
			gewonnen = true;
			gegner.LebenVerringern(100);
			int beute = gegner.getMetroDollar() / 2;
			this.MetroDollarVeraendern(beute);
			gegner.MetroDollarVeraendern(-beute);
		}
		return gewonnen;
	}

	/**
	 * Mit dieser Methode begeht der Schurke ein Auftragsmord und verdient damit
	 * 20000 metro-dollar,
	 */
	public void auftragsmord() {
		this.metroDollar += 20000;
	}

	/**
	 * Methode beitreten, mit welcher der Schurke einem Syndikat beitreten kann.
	 */
	public void beitreten(Syndikat syndikat) {
		syndikat.neuesMitglied(this);
	}

	/**
	 * @return liefert die Superkraft des Schurken
	 */
	public String getSuperkraft() {
		return this.superkraft.toString();
	}
}

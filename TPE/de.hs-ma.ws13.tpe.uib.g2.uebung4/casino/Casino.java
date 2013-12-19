package casino;

import tisch.Spieler;
import java.util.LinkedList;

/**
 * Die Klasse fuer ein Casino. Ein Casino hat einen Namen, einen Gewinn, einem
 * Kartenmischer und besteht aus beliebig vielen Tischen.
 * 
 * @author Johannes Weber
 * @author Amanpreet Singh Chahota
 * @author Yannick Appolain Fowa
 */
public class Casino {

	private String name;
	private int gewinn;
	private LinkedList<Tisch> tische;
	private KartenMischer kartenmischer;

	public Casino(String name) {
		this.kartenmischer = new KartenMischer();
		this.name = name;
		this.tische = new LinkedList<Tisch>();
		this.tische.add(new Tisch());
	}

	/**
	 * @return liefert den Gewinn des Casinos zurueck
	 */
	public int getGewinn() {
		return this.gewinn;
	}

	/**
	 * 
	 * @return liefert den zentralen kartenmischer zurueck.
	 */
	public KartenMischer getKartenmischer() {
		return this.kartenmischer;
	}

	/**
	 * Methode, welche den Gewinn des Casinos um einen beliebigen betrag
	 * erhoeht.
	 * 
	 * @param gewinn
	 *            der Gewinn (falls der Dealer gewonnen hat)
	 */
	public void gewonnen(int gewinn) {
		this.gewinn += gewinn;
	}

	/**
	 * @return liefert die Anzahl der Tische zurueck.
	 */
	public int getAnzahlTische() {
		return this.tische.size();
	}

	/**
	 * @return liefert alle Tische des Casinos zurueck.
	 */
	public LinkedList<Tisch> getTische() {
		return this.tische;
	}

	public void tischAufstellen(Tisch tisch) {
		this.tische.add(tisch);
	}

	/**
	 * Methode um einen Besucher einem freien Tisch zuzuordnen
	 * 
	 * @param besucher
	 *            der Besucher
	 */
	public void besucherZuordnen(Spieler besucher) {
		boolean hinsetzen = false;
		while (!hinsetzen) {
			for (Tisch it : this.tische) {
				if (it.AnzahlTeilnehmer() < 8) {
					it.hinsetzen(besucher);
					besucher.setTischNr(this.tische.indexOf(it));
					besucher.setCasino(this);
					it.getDealer().setCasino(this);
					hinsetzen = true;
				}
			}
			if (!hinsetzen) {
				tischAufstellen(new Tisch());
			}
		}
	}

	@Override
	public String toString() {
		return "Casino{" + "name='" + name + '\'' + '}';
	}
}

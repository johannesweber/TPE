package tisch;

import casino.Casino;
import kartendeck.Karte;
import java.util.LinkedList;

/**
 * 
 * Eine Klasse fuer einen Spieler an einem Tisch. Jeder Spieler hat eine
 * eindeutige ID (Namensersatz). Zusaetzlich besitzt jeder Spieler ein vermoegen
 * und eine "Hand" in der alle seine Karten, welche er an einem Tisch bekommt,
 * gespeichert sind. Auserdem weiss jeder Spieler an welchem Tisch er sitzt.
 * 
 * @author Johannes Weber
 * @author Amanpreet Singh Chahota
 * @author Yannick Appolain Fowa
 */
public class Spieler {

	protected Casino casino;
	private int tischNr;
	protected String id;
	protected int vermoegen;
	protected LinkedList<Karte> hand;

	public Spieler(int vermoegen) {
		this.id = "" + System.identityHashCode(this);
		this.vermoegen = vermoegen;
		this.hand = new LinkedList<Karte>();
	}

	/**
	 * Methode, mit welcher der Spieler ein Betrag setzen kann. Das Vermoegen
	 * wird verringert.
	 *
	 * @param betrag
	 *            der zu setzende Betrag
	 */
	public void setzen(int betrag) {
		this.casino.getTische().get(this.tischNr).getPot()
				.put(this.id, betrag);
		this.vermoegen -= betrag;
	}

	/**
	 * @return liefert die Hand des Spielers zurueck.
	 */
	public LinkedList<Karte> getHand() {
		return this.hand;
	}

	/**
	 * Methode die eingesetzt wird wenn der Spieler gewinnt.Das Vermoegen wird
	 * erhoeht.
	 * 
	 * @param betrag
	 *            Der Betrag um welchen das Vermoegen erhoeht wird.
	 */
	public void gewonnen(int betrag) {
		this.vermoegen += betrag;
	}

	public void setCasino(Casino casino) {
		this.casino = casino;
	}

	/**
	 * Methode welche dem Spieler eine TischNr zuweisst.
	 */
	public void setTischNr(int tischNr) {
		this.tischNr = tischNr;
	}

	/**
	 * @return die ID des Spielers
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * @return das Vermoegen des Spielers
	 */
	public int getVermoegen() {
		return this.vermoegen;
	}

	/**
	 * Mit dieser methode wird die Punktzahl des Spielers berechnet.
	 * 
	 * @return die Punktzahl
	 */
	public int berechnePunkte() {
		int punktzahl = 0;
		for (Karte i : this.hand) {
			punktzahl += i.getWert();
		}
		return punktzahl;
	}

	/**
	 * Methode um ein bestimmtes Casino zu besuchen.
	 * 
	 * @param casino
	 *            Das Casino, welches besucht werden soll.
	 */
	public void betreten(Casino casino) {
		casino.besucherZuordnen(this);
	}

	@Override
	public String toString() {
		return "Spieler{" + "id='" + id + '\'' + ", tischNr=" + tischNr
				+ ", vermoegen=" + vermoegen + ", punkte=" + berechnePunkte()
				+ '}';
	}
}

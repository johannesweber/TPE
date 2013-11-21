package unternehmen;

import java.util.LinkedList;

import menschen.Buerger;
import metropolis.SteuerBerechnung;
import metropolis.Unternehmen;

/**
 * Klasse Kapitalgesellschaften. Jedes Objekt des Typs Kapitalgesellschaften
 * wird mit einer Liste ausgestattet, welche die Anzahl aller Gesellschafter
 * enthaelt. Neben dieser Liste erhaelt jedes Objekt noch einen Namen und ein
 * frei waehlbares Startkapital
 * 
 * @author Johannes Weber
 * @author Amanpreet Singh Chahota
 * @author Constantin Schneider
 */
public class Kapitalgesellschaft extends Unternehmen {

	private LinkedList<Buerger> kapitalgesellschaft;

	/**
	 * Zusaetzlich zu dem Konstruktur in der Oberklasse Unternehmen, hat eine
	 * Kapitalgesellschaft noch einen Geschaeftsfuehrer. Dieser wird beim
	 * anlegen in die die Liste "Personengesellschaft" hinzugefuegt.
	 * 
	 * @param name
	 *            Name der Kapitalgesellschaft
	 * @param geschaeftsleitung
	 *            Objekt des Typs Buergers, welcher als Geschaeftsfuehrer
	 *            eingetragen wird
	 * @param startkapital
	 *            Startkapital des Unternehmens
	 */
	public Kapitalgesellschaft(String name, Buerger geschaeftsleitung,
			int startkapital) {
		super(name, startkapital);
		this.kapitalgesellschaft = new LinkedList<Buerger>();
		this.kapitalgesellschaft.add(geschaeftsleitung);
	}

	/**
	 * Mit dieser Methode wird ein neues Mitglied zur Kapitalgesellschaft
	 * hinzugefuegt.
	 * 
	 * @param buerger
	 *            Der Buerger der hinzugefuegt werden soll.
	 */
	public void neuerMitarbeiter(Buerger buerger) {
		this.kapitalgesellschaft.add(buerger);
	}

	/**
	 * Mit dieser Methode wird die Koerperschaftssteuer und die Gewerbesteuer
	 * berechnet.
	 */
	@Override
	public int berechneSteuer() {
		int steuerGesamt = getKoerperschaftSt() + getGewerbeSt();
		if (steuerGesamt <= 0) {
			steuerGesamt = 0;
		}
		return steuerGesamt;
	}

	/**
	 * @return Hoehe der Gewerbesteuer.
	 */
	@Override
	public int getGewerbeSt() {
		return SteuerBerechnung.berechneGewerbeSt(this.gewinn);
	}

	/**
	 * @return der long wert in hoehe der koerperschaftssteuer
	 */
	public int getKoerperschaftSt() {
		return SteuerBerechnung.berechneKapitalSt(this.gewinn);
	}

	/**
	 * @return Liefert die Anzahl der Gesellschafter
	 */
	@Override
	public int getAnzahlGesellschafter() {
		return this.kapitalgesellschaft.size();
	}
}

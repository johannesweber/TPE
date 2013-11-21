package unternehmen;

import java.util.LinkedList;

import menschen.Buerger;
import metropolis.SteuerBerechnung;
import metropolis.Unternehmen;

/**
 * Klasse Personengesellschaft. Jedes Objekt des Typs Personengesellschaft wird
 * mit einer Liste ausgestattet, welche die Anzahl aller Mitarbeiter enthaelt.
 * Neben dieser Liste erhaelt jedes Objekt noch einen Namen und ein frei
 * waehlbares Startkapital
 * 
 * @author Johannes Weber
 * @author Amanpreet Singh Chahota
 * @author Constantin Schneider
 */
public class Personengesellschaft extends Unternehmen {

	private LinkedList<Buerger> personengesellschaft;

	/**
	 * Zusaetzlich zu dem Konstruktur in der Oberklasse Unternehmen, hat eine
	 * Personengesellschaft noch einen Geschaeftsfuehrer. Dieser wird beim
	 * anlegen in die die Liste "Personengesellschaft" hinzugefuegt.
	 * 
	 * @param name
	 *            Name der Personengesellschaft
	 * @param geschaeftsleitung
	 *            Objekt des Typs Buergers, welcher als Geschaeftsfuehrer
	 *            eingetragen wird
	 * @param startkapital
	 *            Startkapital des Unternehmens
	 */
	public Personengesellschaft(String name, Buerger geschaeftsleitung,
			int startkapital) {
		super(name, startkapital);
		this.personengesellschaft = new LinkedList<Buerger>();
		this.personengesellschaft.add(geschaeftsleitung);
	}

	/**
	 * Mit dieser Methode wird ein neues Mitglied zur Personengesellschaft
	 * hinzugefuegt. Unter der Annahme, dass jedes neue Mitglied auch eine
	 * fuehrende Position in dem Unternehmen hat wird das Vermoegen des neuen
	 * Mitglieds sofort auf den Gewinn der Personengesellschaft dazuaddiert.
	 * 
	 * @param buerger
	 *            Der Buerger der hinzugefuegt werden soll.
	 */
	@Override
	public void neuerMitarbeiter(Buerger buerger) {
		this.personengesellschaft.add(buerger);
		this.gewinn += buerger.getMetroDollar();
	}

	/**
	 * @return Gibt die Hoehe der Gewerbesteuer an
	 */
	@Override
	public int getGewerbeSt() {
		return this.gewerbeSt();
	}

	/**
	 * @return Gibt die Hoehe der Einkommensteuer an
	 */
	public int getEinkommenSt() {
		return this.einkommenSt();
	}

	/**
	 * Methode, welche die Einkommensteuer, auf Basis des Gewinns, berechnet.
	 */
	private int einkommenSt() {
		return SteuerBerechnung.berechneEinkommenSt(this.gewinn);
	}

	/**
	 * Methode, welche die Gewerbesteuer auf Basis des Gewinns berechnet und den
	 * Steuernachlass von 1000 metro Dollar beruecksichtigt.
	 */
	private int gewerbeSt() {
		int gewerbeSt = SteuerBerechnung.berechneGewerbeSt(this.gewinn);

		if (gewerbeSt >= 1000) {
			gewerbeSt = gewerbeSt - 1000;
		} else {
			gewerbeSt = 0;
		}
		return gewerbeSt;
	}

	/**
	 * Ueberschriebene Methode die die gesamten Steuer berechnet
	 * 
	 * @return gibt die Hoehe der gesamten Steuer zurueck
	 */
	@Override
	public int berechneSteuer() {
		return getGewerbeSt() + getEinkommenSt();
	}

	/**
	 * @return Die Anzahl der Gesellschafter
	 */
	@Override
	public int getAnzahlGesellschafter() {
		return this.personengesellschaft.size();
	}
}

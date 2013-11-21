package kontrolleinheit;

import menschen.*;
import metropolis.*;
import mutanten.*;
import unternehmen.*;

/**
 * Klasse um die Stadt Metropolis zu simulieren.
 * 
 * @author Johannes Weber
 * @author Amanpreet Singh Chahota
 * @author Constantin Schneider
 */
public class MetroSim {

	private static Finanzamt amt;
	private static Personengesellschaft heinoekfm;
	private static Kapitalgesellschaft heinogmbh;
	private static Syndikat evilheinos;
	private static Schurke boeserheino;
	private static Superheld superheino;
	private static Buerger heino;
	private static Buerger nina;
	private static Buerger dieter;
	private static Richter richterheino;

	public static void main(String[] args) {

		metropolisAufbauen();
		tagesablaufNachgehen();
		unternehmenBeitreten();
		syndikatBeitreten();
		kaempfen();
		schurkenVerurteilen();
		steuernEintreiben();
	}

	private static void metropolisAufbauen() {
		amt = new Finanzamt();
		heinoekfm = new Personengesellschaft("Heino eKfm.", heino, 120000);
		heinogmbh = new Kapitalgesellschaft("Heino GmbH", dieter, 100000);
		evilheinos = new Syndikat("The Evil Heinos", 100000);
		boeserheino = new Schurke("Heino (Boese)");
		superheino = new Superheld("SuperHeino");
		heino = new Buerger("Heino");
		nina = new Buerger("Nina");
		dieter = new Buerger("Dieter");
		richterheino = new Richter("RichterHeino");
	}

	private static void steuernEintreiben() {
		System.out
				.println("Die Steuern in Metropolis wurden eingetrieben...Insgesamt gibt es "
						+ amt.getAnzahlSteuerBuerger()
						+ " steuerpflichtige Buerger in Metropolis."
						+ "\nDie Steuereinnahmen in Metropolis belaufen sich auf "
						+ amt.getSteuerGesamt() + ".- Metro-Dollar");
	}

	private static void schurkenVerurteilen() {
		richterheino.verurteilen(boeserheino);

		if (richterheino.istKorrupt()) {
			System.out.println("Boeser Heino ist dem Gesetz entkommen.");
		} else {
			System.out
					.println("Richter Heino verurteile Boeser Heino zu einer Strafe in Hoehe von 1000 Metro-Dollar");
		}
		System.out
				.println("Nach diesem schweren Urteil besitzt Richter Heino nun "
						+ richterheino.getMetroDollar() + ".- Metro Dollar");

	}

	private static void syndikatBeitreten() {
		evilheinos.neuesMitglied(boeserheino);
		System.out.println("Die Evil Heinos haben jetzt "
				+ evilheinos.getAnzahlMitglieder() + ". Mitglied(er).");
	}

	private static void unternehmenBeitreten() {
		System.out.println("Die Einzelhandelskaufmann Heino hat jetzt "
				+ heinoekfm.getAnzahlGesellschafter() + ". Mitarbeiter.");

		heinogmbh.neuerMitarbeiter(nina);
		System.out.println("Die Heino GmbH  hat jetzt "
				+ heinogmbh.getAnzahlGesellschafter() + ". Gesellschafter.");
	}

	private static void tagesablaufNachgehen() {
		nina.lottoSpielen();
		System.out
				.println("Heute ist Ninas Glueckstag sie hat im Lotto 160000,- Metro-Dollar gewonnen.\nSie besitzt jetzt insgesamt "
						+ nina.getMetroDollar() + ",- Metro-Dollar.");

		heino.arbeiten();
		System.out.println("Nach einem harten Arbeitstag besitzt Heino nun "
				+ heino.getMetroDollar() + ".- Metro-Dollar");
	}

	private static void kaempfen() {
		boolean kampf = superheino.kaempfe(boeserheino);
		if (kampf) {
			System.out
					.println("Der Gewinner des Kampfes: Superheino vs. BoeserHeino ist...Superheino.");
		} else {
			System.out
					.println("Der Gewinner des Kampfes: Superheino vs. BoeserHeino ist...BoeserHeino.");
		}
	}
}

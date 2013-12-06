package kontrolleinheit;

import menschen.Buerger;
import menschen.Richter;
import metropolis.Finanzamt;
import metropolis.Syndikat;
import mutanten.Schurke;
import mutanten.Superheld;
import org.junit.Test;
import unternehmen.Kapitalgesellschaft;
import unternehmen.Personengesellschaft;

import static org.junit.Assert.*;

/**
 * @author Johannes Weber
 * @author Amanpreet Singh Chahota
 * @author Constantin Schneider
 */
public class MetropolisTestCase {

	Finanzamt amt = new Finanzamt();
	Buerger heinoscheff = new Buerger("Scheff");
	Personengesellschaft heinoekfm = new Personengesellschaft("Heino eKfm.",
			heinoscheff, 120000);
	Buerger heinoscheffe = new Buerger("Scheff");
	Kapitalgesellschaft heinogmbh = new Kapitalgesellschaft("Heino GmbH",
			heinoscheffe, 100000);
	Syndikat evilheinos = new Syndikat("The Evil Heinos", 80000);
	Schurke boeserheino = new Schurke("Heino (Boese)");
	Superheld superheino = new Superheld("SuperHeino");
	Buerger heino = new Buerger("Heino");
	Richter richterheino = new Richter("RichterHeino");

	Superheld supernina = new Superheld("Nina");
	Schurke boeserotto = new Schurke("Otto");

	/**
	 * In diesem Junit Test wird die Berechnung der Einkommensteuer auf korrekte
	 * Ausgabe geprueft.
	 */

	@Test
	public void testEinkommenSt() {

		assertEquals(0, boeserheino.berechneSteuer());

		boeserheino.auftragsmord();
		assertEquals(2000, boeserheino.berechneSteuer());

		assertEquals(7000, heino.berechneSteuer());
		heino.lottoSpielen();
		assertEquals(73000, heino.berechneSteuer());

		assertEquals(33000, heinoekfm.getEinkommenSt());
	}

	/**
	 * Test auf die korrekte Berechnung der Gewerbesteuer
	 */
	@Test
	public void testGewerbeSt() {
		assertEquals(11000, heinoekfm.getGewerbeSt());
		assertEquals(10000, heinogmbh.getGewerbeSt());
	}

	@Test
	public void testKoerperschaftSt() {
		assertEquals(25000, heinogmbh.getKoerperschaftSt());
		assertEquals(20000, evilheinos.berechneSteuer());
	}

	/**
	 * Bevor und nach dem ein Mitglied in einem Syndikat ein auftragsmord
	 * begangen hat wird das kapital des syndikats getestet.
	 */

	@Test
	public void testSyndikat() {
		assertEquals(80000, evilheinos.getMetroDollarGesamt());
		boeserheino.auftragsmord();
		boeserheino.beitreten(evilheinos);
		assertEquals(100000, evilheinos.getMetroDollarGesamt());
	}

	/**
	 * Das Finanzamt wird auf korrekte ausgabe aller steuerpflichtigen Buerger
	 * und aller Steuereinnahmen getestet.
	 */

	@Test
	public void testFinanzamt() {

		assertEquals(8, amt.getAnzahlSteuerBuerger());
		assertEquals(120000, amt.getSteuerGesamt());
	}

	/**
	 * Methode kaempfen wird getestet
	 */
	@Test
	public void testKaempfe() {

		if (superheino.kaempfe(boeserheino)) {
			assertEquals(0, boeserheino.getLeben());
			assertEquals(100, superheino.getLeben());

		} else {
			assertEquals(0, superheino.getLeben());
			assertEquals(100, boeserheino.getLeben());
		}

		if (boeserotto.kaempfe(supernina)) {
			assertEquals(100, boeserotto.getLeben());
			assertEquals(0, supernina.getLeben());
		} else {
			assertEquals(100, supernina.getLeben());
			assertEquals(0, boeserotto.getLeben());
		}
	}

	/**
	 * Methode Richter wird auf korrekte verurteilung der Schurken getestet
	 */
	@Test
	public void testRichter() {
		richterheino.verurteilen(boeserheino);
		if (richterheino.istKorrupt()) {
			assertEquals(0, boeserheino.getMetroDollar());
		} else {
			assertEquals(-1000, boeserheino.getMetroDollar());
		}
		assertEquals(100000, richterheino.getMetroDollar());
	}

	/**
	 * Testet die beitreten Methode auf Korrektheit
	 */
	@Test
	public void testUnternehmen() {
		heinogmbh.neuerMitarbeiter(heino);
		assertEquals(2, heinogmbh.getAnzahlGesellschafter());
		assertEquals(100000, heinogmbh.getGewinn());
		heinogmbh.setGewinn(0);
		assertEquals(0, heinogmbh.berechneSteuer());
	}
}
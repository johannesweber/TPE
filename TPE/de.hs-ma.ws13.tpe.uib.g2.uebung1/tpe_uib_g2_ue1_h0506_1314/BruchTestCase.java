package tpe_uib_g2_ue1_h0506_1314;

import static org.junit.Assert.*;

/**
 * Zusätzlich zu den vorgegebenen Testfällen, testeten wir folgenden Rechenoperation:
 * Rechnen mit negativen Brüchen
 * Rechnen mit 2 echten Brüchen
 * Potenzieren mit einem Bruch
 * Zusatzlich wird die 'equals','kehrwert' und 'isEcht' Methode getestet
 * 
 */

import org.junit.Test;


public class BruchTestCase {

	/**
	 * Diese Methode testet, ob der Bruch richtig in eine Dezimalzahl
	 * umgewandelt wird.
	 */

	@Test
	public void testDezimalzahl() {
		Bruch bruch1 = new Bruch(19, 2);
		assertEquals(9.5, bruch1.getDezimalzahl(), 10);

		Bruch bruch2 = new Bruch(16, 2);
		assertEquals(8.0, bruch2.getDezimalzahl(), 9);

		Bruch bruch3 = new Bruch(5, 10);
		assertEquals(0.5, bruch3.getDezimalzahl(), 1);

		Bruch bruch4 = new Bruch(9, 5, 10);
		assertEquals(9.5, bruch4.getDezimalzahl(), 10);

		Bruch bruch5 = new Bruch(19, 12);
		assertEquals(1.5833333333333333333333333333333333333333333333333333,
				bruch5.getDezimalzahl(), 2);
	}

	/**
	 * Diese Methode testet, ob der Bruch richtig in einen unechten Bruch bzw.
	 * in einen echten Bruch umgewandelt wird.
	 */
	@Test
	public void testUmwandlung() {
		Bruch unechterBruch1 = new Bruch(24, 5);
		assertEquals(new Bruch(4, 4, 5), unechterBruch1.echterBruch());

		Bruch unechterBruch2 = new Bruch(47, 5);
		assertEquals(new Bruch(9, 2, 5), unechterBruch2.echterBruch());

		Bruch echterBruch1 = new Bruch(4, 4, 5);
		assertEquals(new Bruch(24, 5), echterBruch1.unechterBruch());

		Bruch echterBruch2 = new Bruch(9, 2, 5);
		assertEquals(new Bruch(47, 5), echterBruch2.unechterBruch());
	}

	/**
	 * Diese Methode testet, ob Brüche richtig miteinander addiert werden.
	 */

	@Test
	public void testAddieren() {
		Bruch bruch1 = new Bruch(1, 6);
		Bruch bruch2 = new Bruch(2, 15);
		assertEquals(new Bruch(3, 10), bruch1.addiere(bruch2));

		Bruch bruch3 = new Bruch(1, 5);
		Bruch bruch4 = new Bruch(1, 5);
		assertEquals(new Bruch(2, 5), bruch3.addiere(bruch4));

		Bruch bruch5 = new Bruch(2, 10);
		Bruch bruch6 = new Bruch(3, 5);
		assertEquals(new Bruch(4, 5), bruch5.addiere(bruch6));

		Bruch bruch7 = new Bruch(2, 3, 7);
		Bruch bruch8 = new Bruch(-5, 7);
		assertEquals(new Bruch(1, 5, 7), bruch7.addiere(bruch8));

		Bruch bruch9 = new Bruch(2, 3, 7);
		Bruch bruch10 = new Bruch(5, 5, 7);
		assertEquals(new Bruch(8, 1, 7), bruch9.addiere(bruch10));

		Bruch bruch11 = new Bruch(273, 587);
		Bruch bruch12 = new Bruch(372, 161);
		assertEquals(new Bruch(262317, 94507), bruch11.addiere(bruch12));
	}

	/**
	 * Diese Methode testet, ob Brüche richtig voneinander subtrahiert werden.
	 */
	@Test
	public void testSubtrahieren() {
		Bruch bruch1 = new Bruch(3, 10);
		Bruch bruch2 = new Bruch(1, 6);
		assertEquals(new Bruch(2, 15), bruch1.subtrahiere(bruch2));

		Bruch bruch3 = new Bruch(2, 5);
		Bruch bruch4 = new Bruch(1, 5);
		assertEquals(new Bruch(1, 5), bruch3.subtrahiere(bruch4));

		Bruch bruch5 = new Bruch(8, 10);
		Bruch bruch6 = new Bruch(2, 10);
		assertEquals(new Bruch(3, 5), bruch5.subtrahiere(bruch6));

		Bruch bruch7 = new Bruch(2, 3, 7);
		Bruch bruch8 = new Bruch(2, 7);
		assertEquals(new Bruch(2, 1, 7), bruch7.subtrahiere(bruch8));

		Bruch bruch9 = new Bruch(2, 3, 7);
		Bruch bruch10 = new Bruch(5, 5, 7);
		assertEquals(new Bruch(-3, -2, 7), bruch9.subtrahiere(bruch10));

		Bruch bruch11 = new Bruch(6, 4, 8);
		Bruch bruch12 = new Bruch(2, 3, 4);
		assertEquals(new Bruch(3, 3, 4), bruch11.subtrahiere(bruch12));
	}

	/**
	 * Diese Methode testet, ob Brüche richtig miteinander multipliziert werden.
	 */
	@Test
	public void testMultiplikation() {
		Bruch bruch1 = new Bruch(3, 10);
		Bruch bruch2 = new Bruch(1, 6);
		assertEquals(new Bruch(1, 20), bruch1.multipliziere(bruch2));

		Bruch bruch3 = new Bruch(3, 6);
		assertEquals(new Bruch(15, 6), bruch3.multipliziere(5));

		Bruch bruch4 = new Bruch(3, 3, 10);
		Bruch bruch5 = new Bruch(1, 6);
		assertEquals(new Bruch(11, 20), bruch4.multipliziere(bruch5));

		Bruch bruch6 = new Bruch(0, 3);
		Bruch bruch7 = new Bruch(1, 5);
		assertEquals(new Bruch(0, 15), bruch6.multipliziere(bruch7));

		Bruch bruch8 = new Bruch(2, 4, 3);
		Bruch bruch9 = new Bruch(4, 7, 2);
		assertEquals(new Bruch(25, 0, 1), bruch8.multipliziere(bruch9));
	}

	/**
	 * Diese Methode testet, ob Brüche richtig dividiert werden.
	 */

	@Test
	public void testDivision() {
		Bruch bruch1 = new Bruch(3, 60);
		Bruch bruch2 = new Bruch(1, 6);
		assertEquals(new Bruch(3, 10), bruch1.dividiere(bruch2));

		Bruch bruch3 = new Bruch(3, 60);
		assertEquals(new Bruch(1, 200), bruch3.dividiere(10));

		Bruch bruch4 = new Bruch(3, 3, 10);
		Bruch bruch5 = new Bruch(1, 6);
		assertEquals(new Bruch(19, 4, 5), bruch4.dividiere(bruch5));

		Bruch bruch6 = new Bruch(3, 3, 10);
		Bruch bruch7 = new Bruch(-5, 6);
		assertEquals(new Bruch(-3, -24, 25), bruch6.dividiere(bruch7));
	}

	/**
	 * Diese Methode testet, ob Brüche richtig potenziert werden.
	 */

	@Test
	public void testPotenzieren() {
		Bruch bruch1 = new Bruch(2, 3);
		Bruch bruch2 = new Bruch(2, 5);

		assertEquals(new Bruch(1, 1), bruch1.potenziere(0));
		assertEquals(new Bruch(2, 3), bruch1.potenziere(1));
		assertEquals(new Bruch(4, 9), bruch1.potenziere(2));
		assertEquals(new Bruch(8, 27), bruch1.potenziere(3));
		assertEquals(new Bruch(9, 4), bruch1.potenziere(-2));
		assertEquals(0.8502830004171938885776985667953328488632667224613215,
				bruch1.potenziere(bruch2), 0.1);

	}

	/**
	 * Diese Methode testet, ob die Inhalte zweier Brüche identisch sind.
	 */

	@Test
	public void testEquals() {
		Bruch bruch1 = new Bruch(5, 10);
		Bruch bruch2 = new Bruch(10, 20);

		assertTrue(bruch1.equals(bruch2));

		Bruch bruch3 = new Bruch(10, 5);
		Bruch bruch4 = new Bruch(20, 10);

		assertTrue(bruch3.equals(bruch4));

		Bruch bruch5 = new Bruch(2, 4, 10);
		Bruch bruch6 = new Bruch(24, 10);

		assertTrue(bruch5.equals(bruch6));

		Bruch bruch7 = new Bruch(-2, -4, 10);
		Bruch bruch8 = new Bruch(-24, 10);
		assertTrue(bruch7.equals(bruch8));

		assertFalse(bruch1.equals(bruch3));
		assertFalse(bruch2.equals(bruch4));
		assertFalse(bruch6.equals(bruch1));
	}

	/**
	 * Diese Methode testet Kehrwert eines Bruches auf Richtigkeit.
	 */
	@Test
	public void testKehrwert() {
		Bruch bruch1 = new Bruch(1, 3);
		assertEquals(new Bruch(3, 1), bruch1.kehrwert());

		Bruch bruch2 = new Bruch(1, 2, 3);
		assertEquals(new Bruch(3, 5), bruch2.kehrwert());

		Bruch bruch3 = new Bruch(-2, 3);
		assertEquals(new Bruch(3, -2), bruch3.kehrwert());

		Bruch bruch4 = new Bruch(-1, 2, -3);
		assertEquals(new Bruch(3, -5), bruch4.kehrwert());
	}

	/**
	 * Diese Methode testet, ob es ein echter Bruch ist, oder nicht.
	 */

	@Test
	public void testIsEcht() {
		Bruch bruch1 = new Bruch(4, 1, 3);
		assertTrue(bruch1.isEcht());

		Bruch bruch2 = new Bruch(4, 3);
		assertFalse(bruch2.isEcht());
	}
}
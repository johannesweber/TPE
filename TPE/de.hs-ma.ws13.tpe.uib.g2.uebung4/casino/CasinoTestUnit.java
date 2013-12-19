package casino;

import org.junit.Test;
import tisch.*;
import static org.junit.Assert.*;

public class CasinoTestUnit {

    Casino casino = new Casino("casino");
    Spieler heinz = new Spieler(100);
    Spieler s3 = new Spieler(9000000);
    Tisch tischZwei = new Tisch();

    @Test
    public void testCasino() {

        assertEquals(0, casino.getGewinn());
        assertEquals(1, casino.getAnzahlTische());
        casino.gewonnen(50);
        assertEquals(50, casino.getGewinn());
        heinz.betreten(casino);
        assertEquals(1, casino.getAnzahlTische());

    }

    @Test
    public void testTisch() {
        assertEquals(0, tischZwei.AnzahlTeilnehmer());
    }

    @Test
    public void testVermoegen() {

        Spieler s1 = new Spieler(593075184);
        Spieler s2 = new Spieler(-314124332);

        assertEquals(593075184, s1.getVermoegen());
        assertEquals(-314124332, s2.getVermoegen());
    }

    @Test
    public void testDeck() {

        Kartendeck deck = new Kartendeck();

        assertEquals(52, deck.getDeck().size());

        deck.getDeck().pop();
        assertEquals(51, deck.getDeck().size());
        deck.getDeck().clear();
        assertEquals(0, deck.getDeck().size());
    }

    @Test
    public void testEinSpieler() {

        Spieler s1 = new Spieler(5092);

        s1.betreten(casino);
        s1.setzen(5000);

        casino.getTische().getFirst().getDealer().kartenAusteilen();

        assertEquals(3, s1.getHand().size());
        assertEquals(92, s1.getVermoegen());
        casino.getTische().getFirst().getDealer().kartenEinsammeln();
        assertEquals(0, s1.getHand().size());
    }

    @Test
    public void testDealerGetEinsatz() {

        Spieler s1 = new Spieler(150);
        Spieler s2 = new Spieler(200);

        s1.betreten(casino);
        s2.betreten(casino);
        s3.betreten(casino);

        s1.setzen(1005423);
        s2.setzen(2002058);
        s3.setzen(8000000);

        assertEquals(1005423, casino.getTische().getFirst().getDealer()
                .getEinsatz(s1));
        assertEquals(2002058, casino.getTische().getFirst().getDealer()
                .getEinsatz(s2));
        assertEquals(8000000, casino.getTische().getFirst().getDealer()
                .getEinsatz(s3));
    }

    @Test
    public void testGetId() {

        String ID = heinz.getId();

        assertEquals(ID, heinz.getId());
    }

    @Test
    public void testDealerKartenMischen() {
        heinz.betreten(casino);
        // Kartendeck in der Klasse Tisch ist Basis
        // neues nicht gemischtes Array
        Kartendeck deck = new Kartendeck();
        Kartendeck deck2 = new Kartendeck();

        // Test ob 2 Kartendeck zuerst identisch (beim erstellen)
        assertTrue(deck.equals(deck2));
        // Testen ob nach dem mischen die Decks nicht mehr gleich sind

        casino.getTische().get(0).getDealer().kartenMischen();
        assertFalse(deck.equals(casino.getTische().get(0).getKartendeck().getDeck()));
    }

    @Test
    // Testet ob die Karten austeilen Methode funktioniert und ob das Deck
    // richtig funktioniert
    public void testDealerKartenAusteilen() {

        // Spieler am ersten Tisch

        Spieler s1 = new Spieler(12345);
        s1.betreten(casino);
        s1.setzen(1234);
        Spieler s2 = new Spieler(54321);
        s2.betreten(casino);
        s2.setzen(5432);
        Spieler s3 = new Spieler(23456);
        s3.betreten(casino);
        s3.setzen(2345);
        Spieler s4 = new Spieler(65432);
        s4.betreten(casino);
        s4.setzen(6543);
        Spieler s5 = new Spieler(34567);
        s5.betreten(casino);
        s5.setzen(3456);
        Spieler s6 = new Spieler(76543);
        s6.betreten(casino);
        s6.setzen(7654);
        Spieler s7 = new Spieler(45678);
        s7.betreten(casino);
        s7.setzen(4567);
        Spieler s8 = new Spieler(87654);
        s8.betreten(casino);
        s8.setzen(8765);

        // Spieler am 2. Tisch

        Spieler s9 = new Spieler(56789);
        s9.betreten(casino);
        s9.setzen(5678);
        Spieler s10 = new Spieler(98765);
        s10.betreten(casino);
        s10.setzen(9876);
        // Austeilen erster Tisch
        casino.getTische().get(0).getDealer().kartenAusteilen();

        assertEquals(3, s1.getHand().size());
        assertEquals(3, s2.getHand().size());
        assertEquals(3, s3.getHand().size());
        assertEquals(3, s4.getHand().size());
        assertEquals(3, s5.getHand().size());
        assertEquals(3, s6.getHand().size());
        assertEquals(3, s7.getHand().size());
        assertEquals(3, s8.getHand().size());

        System.out.println(casino.getTische().get(0).getDealer().getHand()
                .size());

        // Testen ob das Deck sich verringert
        assertEquals((52 - (casino.getTische().get(0).getDealer().getHand()
                .size()) - (casino.getTische().get(0).AnzahlTeilnehmer()) * 3),
                casino.getTische().get(0).getKartendeck().getDeck().size());

        // Austeilen 2. Tisch

        casino.getTische().get(1).getDealer().kartenAusteilen();

        assertEquals(3, s9.getHand().size());
        assertEquals(3, s10.getHand().size());

        // Testen ob das Deck sich am 2. Tisch verringert

        assertEquals((52 - (casino.getTische().get(1).getDealer().getHand()
                .size()) - (casino.getTische().get(1).AnzahlTeilnehmer()) * 3),
                casino.getTische().get(1).getKartendeck().getDeck().size());
    }

    @Test
    public void kartenEinsammeln() {

        Spieler s1 = new Spieler(12345);
        s1.betreten(casino);
        s1.setzen(1234);
        Spieler s2 = new Spieler(54321);
        s2.betreten(casino);
        s2.setzen(5432);
        Spieler s3 = new Spieler(23456);
        s3.betreten(casino);
        s3.setzen(2345);
        Spieler s4 = new Spieler(65432);
        s4.betreten(casino);
        s4.setzen(6543);
        Spieler s5 = new Spieler(34567);
        s5.betreten(casino);
        s5.setzen(3456);
        Spieler s6 = new Spieler(76543);
        s6.betreten(casino);
        s6.setzen(7654);
        Spieler s7 = new Spieler(45678);
        s7.betreten(casino);
        s7.setzen(4567);
        Spieler s8 = new Spieler(87654);
        s8.betreten(casino);
        s8.setzen(8765);

        // 2.
        // Tisch---------------------------------------------------------------

        Spieler s9 = new Spieler(56789);
        s9.betreten(casino);
        s9.setzen(5678);
        Spieler s10 = new Spieler(98765);
        s10.betreten(casino);
        s10.setzen(9876);
        // Austeilen und Einsammeln erster
        // Tisch----------------------------------------------------------------
        casino.getTische().get(0).getDealer().kartenAusteilen();

        assertEquals(3, s1.getHand().size());
        assertEquals(3, s2.getHand().size());
        assertEquals(3, s3.getHand().size());
        assertEquals(3, s4.getHand().size());
        assertEquals(3, s5.getHand().size());
        assertEquals(3, s6.getHand().size());
        assertEquals(3, s7.getHand().size());
        assertEquals(3, s8.getHand().size());

        casino.getTische().get(0).getDealer().kartenEinsammeln();
        assertEquals(0, s1.getHand().size());
        assertEquals(0, s2.getHand().size());
        assertEquals(0, s3.getHand().size());
        assertEquals(0, s4.getHand().size());
        assertEquals(0, s5.getHand().size());
        assertEquals(0, s6.getHand().size());
        assertEquals(0, s7.getHand().size());
        assertEquals(0, s8.getHand().size());

        // Austeilen und Einsammeln 2.
        // Tisch----------------------------------------------------

        casino.getTische().get(1).getDealer().kartenAusteilen();

        assertEquals(3, s9.getHand().size());
        assertEquals(3, s10.getHand().size());
        casino.getTische().get(1).getDealer().kartenEinsammeln();
        assertEquals(0, s9.getHand().size());
        assertEquals(0, s10.getHand().size());
    }

    @Test
    public void testGetTeilnehmer() {

        Spieler s1 = new Spieler(12345);
        s1.betreten(casino);
        s1.setzen(1234);
        Spieler s2 = new Spieler(54321);
        s2.betreten(casino);
        s2.setzen(5432);
        Spieler s3 = new Spieler(23456);
        s3.betreten(casino);
        s3.setzen(2345);
        assertTrue(casino.getTische().get(0).getTeilnehmer().containsValue(s1));
        assertTrue(casino.getTische().get(0).getTeilnehmer().containsValue(s2));
        assertTrue(casino.getTische().get(0).getTeilnehmer().containsValue(s3));
    }

    @Test
    public void testHoehePot() {

        Spieler s1 = new Spieler(12345);
        s1.betreten(casino);
        s1.setzen(1234);
        Spieler s2 = new Spieler(54321);
        s2.betreten(casino);
        s2.setzen(5432);
        Spieler s3 = new Spieler(23456);
        s3.betreten(casino);
        s3.setzen(2345);

        assertEquals(9011, casino.getTische().get(0).getHoehePot());
    }

    @Test
    public void testGetAnzahlTische() {
        Spieler s1 = new Spieler(12345);
        s1.betreten(casino);
        Spieler s2 = new Spieler(54321);
        s2.betreten(casino);
        Spieler s3 = new Spieler(23456);
        s3.betreten(casino);
        Spieler s4 = new Spieler(65432);
        s4.betreten(casino);
        Spieler s5 = new Spieler(34567);
        s5.betreten(casino);
        Spieler s6 = new Spieler(76543);
        s6.betreten(casino);
        Spieler s7 = new Spieler(45678);
        s7.betreten(casino);
        Spieler s8 = new Spieler(87654);
        s8.betreten(casino);
        Spieler s9 = new Spieler(12345);
        s9.betreten(casino);

        Spieler s10 = new Spieler(54321);
        s10.betreten(casino);

        Spieler s11 = new Spieler(23456);
        s11.betreten(casino);

        Spieler s12 = new Spieler(65432);
        s12.betreten(casino);

        Spieler s13 = new Spieler(34567);
        s13.betreten(casino);

        Spieler s14 = new Spieler(76543);
        s14.betreten(casino);

        Spieler s15 = new Spieler(45678);
        s15.betreten(casino);

        Spieler s16 = new Spieler(87654);
        s16.betreten(casino);
        Spieler s17 = new Spieler(87654);
        s17.betreten(casino);

        assertEquals(3, casino.getAnzahlTische());
    }

    @Test
    public void testGewonnen() {

    }

    @Test
    public void testGewinnerIst() {

    }
}
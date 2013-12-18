package casino;

import org.junit.Test;

import tisch.Kartendeck;
import tisch.Spieler;
import java.util.LinkedList;
import static org.junit.Assert.*;
public class CasinoTest {

    Casino casino = new Casino("casino");
    Spieler heinz = new Spieler(100);

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
        LinkedList leer = new LinkedList();
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
    public void testAnzahlKartenImDeck() {

        Kartendeck deck = new Kartendeck();

        assertEquals(52, deck.getDeck().size());

        deck.getDeck().pop();
        assertEquals(51, deck.getDeck().size());
        deck.getDeck().clear();
        assertEquals(0,deck.getDeck().size());
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
}
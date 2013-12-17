package casino;

import org.junit.Test;
import tisch.Spieler;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class CasinoTest {
    Casino casino = new Casino("casino");
    Spieler heinz = new Spieler("Heinz", 100);
    Tisch tischEins = new Tisch();
    Tisch tischZwei = new Tisch();

    @Test
    public void testCasino() {
        assertEquals(0, casino.getGewinn());
        assertEquals(0, casino.getAnzahlTische());
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
    public void testDealer() {
        assertEquals("11", tischEins.getDealer().getId());
        assertEquals("11", tischZwei.getDealer().getId());
        assertEquals("Der Dealer", tischZwei.getDealer().getName());
    }

}

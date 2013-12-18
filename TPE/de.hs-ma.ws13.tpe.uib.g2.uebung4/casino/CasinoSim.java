package casino;

import tisch.Spieler;

import java.util.LinkedList;

/**
 * Klasse um eine Casinobesuch von beliebig vielen Spielern zu simulieren. Dabei werden in den einzelnen Methode
 * die wichtigsten Methoden des Programms getestet und, wenn noetig, ausgegeben, um zu kontrollieren.
 */
public class CasinoSim {

    public static Casino casino = new Casino("Bellagio");
    public static LinkedList<Spieler> bus = new LinkedList<Spieler>();

    public static <T> void main(String[] args) {

        busKommt(50);
        casinoBesuchen();
        setzen();
        dealerSetzen();
        kartenMischen();
        kartenAusteilen();
        gewinnerEmitteln();
        busAusgeben();
        kartenEinsammeln();
    }

    public static void busKommt(int anzahl) {
        for (int i = 0; i < anzahl; i++) {
            int vermoegen = (int) (Math.random() * 1000);
            bus.add(new Spieler(vermoegen));
        }
    }

    public static void casinoBesuchen() {
        for (Spieler it : bus) {
            it.betreten(casino);
        }
    }

    public static void setzen() {
        for (Spieler it : bus) {
            it.setzen(250000);
        }
    }

    public static void dealerSetzen() {
        for (Tisch it : casino.getTische()) {
            it.getDealer().setzen(500000);
        }
    }

    public static void kartenMischen() {
        for (Tisch it : casino.getTische()) {
            it.getDealer().kartenMischen();
        }
    }

    public static void kartenAusteilen() {
        for (Tisch it : casino.getTische()) {
            it.getDealer().kartenAusteilen();
        }
    }

    public static void gewinnerEmitteln() {
        for (Tisch it : casino.getTische()) {
            it.getDealer().gewinnerIst();
        }
    }

    public static void kartenEinsammeln() {
        for (Tisch it : casino.getTische()) {
            it.getDealer().kartenEinsammeln();
        }
    }

    public static void busAusgeben() {
        for (Spieler it : bus) {
            System.out.println(it);
        }
    }
}

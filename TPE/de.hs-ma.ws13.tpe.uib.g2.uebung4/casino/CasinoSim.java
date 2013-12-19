package casino;

import tisch.Spieler;

import java.util.LinkedList;

/**
 * Klasse um eine Casinobesuch von beliebig vielen Spielern zu simulieren. Dabei
 * werden in den einzelnen Methode die wichtigsten Methoden des Programms
 * getestet und, wenn noetig, ausgegeben, um zu kontrollieren.
 *
 * @author Johannes Weber
 * @author Amanpreet Singh Chahota
 * @author Yannick Appolain Fowa
 */
public class CasinoSim {

    public static Casino casino = new Casino("Bellagio");
    public static LinkedList<Spieler> bus = new LinkedList<Spieler>();

    public static <T> void main(String[] args) {

        busKommt(200);
        casinoBesuchen();
        setzen();
        dealerSetzen();
        einsaetzeErmitteln();
        kartenMischen();
        kartenAusteilen();
        gewinnAuszahlen();
        System.out.println();
        gewinnerEmitteln();
        System.out.println();
        busAusgeben();
        kartenEinsammeln();

    }

    public static void busKommt(int anzahl) {
        for (int i = 0; i < anzahl; i++) {
            int vermoegen = (int) (Math.random() * 1000);
            bus.add(new Spieler(500));
        }
    }

    public static void casinoBesuchen() {
        for (Spieler it : bus) {
            it.betreten(casino);
        }
    }

    public static void setzen() {
        for (Spieler it : bus) {
            it.setzen(500);
        }
    }

    public static void dealerSetzen() {
        for (Tisch it : casino.getTische()) {
            it.getDealer().setzen(1000);
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

    public static void einsaetzeErmitteln() {
        for (Tisch it : casino.getTische()){
            System.out.println("Die Einsaetze an TischNr.: " + casino.getTische().indexOf(it));
            for (Spieler spieler : it.getTeilnehmer().values()) {
                System.out.println(it.getDealer().getEinsatz(spieler));
            }
        }
    }

    public static void gewinnerEmitteln() {
        System.out
                .println("Die Gewinner der einzelnen Tische (wenn die Liste leer ist, hat der Dealer gewonnen!)");
        for (Tisch it : casino.getTische()) {
            System.out.println(it.getDealer().gewinnerIst());
        }
    }

    public static void gewinnAuszahlen(){
        for(Tisch it : casino.getTische()){
            it.getDealer().gewinnAuszahlen();
        }
    }

    public static void kartenEinsammeln() {
        for (Tisch it : casino.getTische()) {
            it.getDealer().kartenEinsammeln();
        }
    }

    public static void busAusgeben() {
        System.out.println("Alle Besucher des Casinos:");
        for (Spieler it : bus) {
            System.out.println(it);
        }
    }
}

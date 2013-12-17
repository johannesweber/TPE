package casino;

import tisch.Spieler;

import java.util.LinkedList;

/**
 * Die Klasse fuer ein Casino. Ein Casino hat einen Namen, einen Gewinn und besteht aus beliebig vielen Tischen.
 * Sobald ein Casin erstellt wird, wird auch der erste tisch dem Casino hinzugefuegt.
 */
public class Casino {

    private String name;
    private int gewinn;
    private LinkedList<Tisch> tische;

    public Casino(String name) {
        this.name = name;
        this.tische = new LinkedList<Tisch>();
        this.tische.add(new Tisch());
    }

    /**
     * @return liefert den Gewinn des Casinos zurueck
     */
    public int getGewinn() {
        return this.gewinn;
    }

    /**
     * Methode, welche den Gewinn des Casinos um einen beliebigen betrag erhoeht.
     *
     * @param gewinn der Gewinn (falls der Dealer gewonnen hat)
     */
    public void gewonnen(int gewinn) {
        this.gewinn += gewinn;
    }

    /**
     * @return liefert die Anzahl der Tische zurueck.
     */
    public int getAnzahlTische() {
        return this.tische.size();
    }

    /**
     * Methode um einen Besucher einem freien Tisch zuzuordnen
     *
     * @param besucher der Besucher
     */
    public void besucherZuordnen(Spieler besucher) {
        boolean hinsetzen = false;
        while (!hinsetzen) {
            for (Tisch it : this.tische) {
                if (it.AnzahlTeilnehmer() < 8) {
                    it.hinsetzen(besucher);
                    hinsetzen = true;
                }
            }
            if (!hinsetzen) {
                tische.add(new Tisch());
            }
        }
    }
}

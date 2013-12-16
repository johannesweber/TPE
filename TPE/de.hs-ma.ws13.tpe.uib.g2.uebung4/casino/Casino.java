package casino;

import java.util.LinkedList;

/**
 * Die Klasse fuer ein Casino. Ein Casino hat einen Namen, einen Gewinn und besteht aus beliebig vielen Tischen.
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

}

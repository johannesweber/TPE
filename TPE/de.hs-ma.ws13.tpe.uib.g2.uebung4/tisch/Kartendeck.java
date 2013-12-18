package tisch;

import kartendeck.*;
import java.util.Stack;

/**
 * Klasse um ein Kartendeck zu simulieren. Das Kartendeck besteht aus 52 karten, welche innerhalb des
 * Konstruktors generiert und zugewiesen werden.
 */
public class Kartendeck {

    private Stack<Karte> deck;

    public Kartendeck() {
        this.deck = new Stack<Karte>();
        for (Kartenfarbe farbe : Kartenfarbe.values()) {
            for (Kartenwert wert : Kartenwert.values()) {
                deck.add(new Karte(farbe, wert));
            }
        }
    }

    /**
     * @return das Kartendeck
     */
    public Stack<Karte> getDeck() {
        return deck;
    }

    @Override
    public String toString() {
        return "Kartendeck{" +
                "deck=" + deck +
                '}';
    }
}
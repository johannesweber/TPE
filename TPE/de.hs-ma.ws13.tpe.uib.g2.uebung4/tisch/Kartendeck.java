package tisch;

import kartendeck.*;
import java.util.Stack;

/**
 * Klasse um ein Kartendeck zu simulieren. Das Kartendeck besteht aus 52 karten,
 * welche innerhalb des Konstruktors generiert und zugewiesen werden.
 * 
 * @author Johannes Weber
 * @author Amanpreet Singh Chahota
 * @author Yannick Appolain Fowa
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kartendeck)) return false;

        Kartendeck that = (Kartendeck) o;

        if (deck != null ? !deck.equals(that.deck) : that.deck != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return deck != null ? deck.hashCode() : 0;
    }
}
package tisch;

import kartendeck.*;
import java.util.Stack;

public class Kartendeck {
	
	private Stack<Karte> deck;
	
	public Kartendeck(){
		this.deck = new Stack<Karte>();
	      for (Kartenfarbe farbe : Kartenfarbe.values())  {
              for (Kartenwert wert : Kartenwert.values()) {
                  deck.add(new Karte(farbe, wert));
              }
          }
    }

	public Stack<Karte> getDeck() {
		return deck;
	}
}
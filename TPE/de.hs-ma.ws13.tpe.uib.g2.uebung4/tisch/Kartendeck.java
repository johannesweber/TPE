package tisch;

import java.util.ArrayDeque;
import java.util.Queue;
import kartendeck.*;

public class Kartendeck {
	
	private Queue<Karte> deck;
	
	public Kartendeck(){
		this.deck = new ArrayDeque<Karte>();
	      for (Kartenfarbe farbe : Kartenfarbe.values())  {
              for (Kartenwert wert : Kartenwert.values()) {
                  deck.add(new Karte(farbe, wert));

              }
          }
	}

	public Queue<Karte> getDeck() {
		return deck;
	}
}
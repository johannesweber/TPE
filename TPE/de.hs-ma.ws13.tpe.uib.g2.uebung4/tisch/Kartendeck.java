package tisch;

import java.util.ArrayDeque;
import java.util.Queue;
import kartendeck.*;

public class Kartendeck {
	
	private Queue<Karte> deck;
	
	public Kartendeck(){
		this.deck = new ArrayDeque<Karte>();
		int zaehler = 0;
	      for (Kartenfarbe farbe : Kartenfarbe.values()) {
	         for (Kartenwert wert : Kartenwert.values()) {
	        	 
	         }
	      }
	}

	public Queue<Karte> getDeck() {
		return deck;
	}
}
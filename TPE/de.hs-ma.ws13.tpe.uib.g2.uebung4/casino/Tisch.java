package casino;

import tisch.Kartendeck;
import tisch.Spieler;

import java.util.HashMap;
import java.util.Map;

public class Tisch {

	private Map<String, Integer> pot;
    private int tischNr = 0;
    private Map<String, Spieler> spieler;
    private Kartendeck kartendeck;

    public Tisch(){
        this.tischNr++;
        this.spieler = new HashMap<String, Spieler>();
        this.kartendeck = new Kartendeck();
        this.pot = new HashMap<String, Integer>();
    }

    public int getTischNr(){
        return this.tischNr;
    }

    public Map<String, Spieler> getSpieler(){
        return this.spieler;
    }


}

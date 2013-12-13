package tisch;

import kartendeck.Karte;
import java.util.LinkedList;

public class Spieler {

	private String name;
	private String id;
    private int idInt = 0;
    private Integer idIntW = new Integer(idInt);
	private int vermoegen = 0;
    private LinkedList<Karte> hand;

    public Spieler(String name, int vermoegen){
        this.name = name;
        this.vermoegen = vermoegen;
        this.idInt++;
        this.id = idIntW.toString();
        this.hand = new LinkedList<Karte>();
    }
	/**
	 * Methode, mit welcher der Spieler ein Betrag setzen kann. Das Vermoegen wird verringert.
	 * 
	 * @param betrag
	 *            der zu setzende Betrag
	 */
	public void setzen(int betrag) {
        this.vermoegen -= betrag;
	}

    /**
     * Methode die eingesetzt wird wenn der Spieler gewinnt.Das Vermoegen wird erhoeht.
     *
     * @param betrag   Der Betrag um welchen das Vermoegen erhoeht wird.
     */
    public void gewonnen(int betrag){
        this.vermoegen += betrag;
    }

    public String getName(){
        return this.name;
    }

    public String getId(){
        return this.id;
    }

    public int getVermoegen(){
        return this.vermoegen;
    }

    public void setHand(Karte karte){
        this.hand.add(karte);
    }

    public int getPunktzahl(){
        int punktzahl = 0;
        for(Karte i : this.hand){
            punktzahl += i.getWert();
        }
        return punktzahl;
    }
}

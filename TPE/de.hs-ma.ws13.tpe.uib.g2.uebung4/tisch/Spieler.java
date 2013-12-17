package tisch;

import casino.Casino;
import kartendeck.Karte;

import java.util.LinkedList;

/**
 * Eine Klasse fuer einen Spieler an einem Tisch. Jeder Spieler hat einen Namen und eine eindeutige ID. Zusaetzlich
 * besitzt jeder Spieler ein vermoegen und eine "Hand" in der alle seine Karten, welche er an einem Tisch bekommt,
 * gespeichert sind.
 */
public class Spieler {

    protected String name;
    protected String id;
    protected int idInt = 0;
    protected Integer idIntW;
    protected int vermoegen = 0;
    protected LinkedList<Karte> hand;

    public Spieler(String name, int vermoegen) {
        this.name = name;
        this.vermoegen = vermoegen;
        this.idInt++;
        this.idIntW = new Integer(idInt);
        this.id = idIntW.toString();
        this.hand = new LinkedList<Karte>();
    }

    /**
     * Methode, mit welcher der Spieler ein Betrag setzen kann. Das Vermoegen wird verringert.
     *
     * @param betrag der zu setzende Betrag
     */
    public void setzen(Pot pot, int betrag) {
        pot.put(this.id, betrag);
        this.vermoegen -= betrag;
    }

    /**
     * Methode die eingesetzt wird wenn der Spieler gewinnt.Das Vermoegen wird erhoeht.
     *
     * @param betrag Der Betrag um welchen das Vermoegen erhoeht wird.
     */
    public void gewonnen(int betrag) {
        this.vermoegen += betrag;
    }

    /**
     * @return der Name des Spielers
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return die ID des Spielers
     */
    public String getId() {
        return this.id;
    }

    /**
     * @return das Vermoegen des Spielers
     */
    public int getVermoegen() {
        return this.vermoegen;
    }

    /**
     * Methode welche dem Spieler eine Karte austeilt.
     *
     * @param karte die auszuteilende Karte
     */
    public void karteAusteilen(Karte karte) {
        this.hand.add(karte);
    }

    /**
     * Methode, welche alle Karten des Spielers einsammelt.
     */
    public void karteEinsammeln() {
        this.hand.clear();
    }

    /**
     * Mit dieser methode wird die Punktzahl des Spielers berechnet.
     *
     * @return die Punktzahl
     */
    public int berechnePunkte() {
        int punktzahl = 0;
        for (Karte i : this.hand) {
            punktzahl += i.getWert();
        }
        return punktzahl;
    }

    public void betreten(Casino casino){
        casino.besucherZuordnen(this);
    }
}

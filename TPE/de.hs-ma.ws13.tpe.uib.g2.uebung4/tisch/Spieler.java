package tisch;

import casino.*;

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
    protected int vermoegen;
    protected LinkedList<Karte> hand;

    public Spieler(String name, int vermoegen) {
        this.id = "" + System.identityHashCode(this);
        this.name = name;
        this.vermoegen = vermoegen;
        this.hand = new LinkedList<Karte>();
    }

    /**
     * Methode, mit welcher der Spieler ein Betrag setzen kann. Das Vermoegen wird verringert.
     *
     * @param betrag der zu setzende Betrag
     */
    public void setzen(Tisch tisch, int betrag) {
        tisch.getPot().put(this.getId(), betrag);
        this.vermoegen -= betrag;
    }

    /**
     * @return liefert die Hand des Spielers zurueck.
     */
    public LinkedList<Karte> getHand() {
        return this.hand;
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

    /**
     * Methode um ein bestimmtes Casino zu besuchen.
     *
     * @param casino Das Casino, welches besucht werden soll.
     */
    public void betreten(Casino casino) {
        casino.besucherZuordnen(this);
    }

    @Override
    public String toString() {
        return "Spieler{" +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", vermoegen=" + vermoegen +
                ", hand=" + hand +
                '}';
    }
}

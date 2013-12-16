package casino;

import kartendeck.Karte;
import tisch.*;

import java.util.*;

public class Tisch {

    private Map<String, Integer> pot;
    private int tischNr = 0;
    private Map<String, Spieler> teilnehmer;
    private Kartendeck kartendeck;

    /**
     * Konstruktor fuer einen Tisch. Jeder Tisch bekommt eine TischNr, ein Kartendeck und ein Pot.
     * Zusaetzlich sitzen an jedem Tisch Teilnehmer.
     */
    public Tisch() {
        this.tischNr++;
        this.teilnehmer = new HashMap<String, Spieler>();
        this.kartendeck = new Kartendeck();
        this.pot = new HashMap<String, Integer>();
    }

    /**
     * Eine Methode welche die TischNr zurueckliefert.
     *
     * @return die Tischnummer.
     */
    public int getTischNr() {
        return this.tischNr;
    }

    /**
     * @return Liefert alle Teilnehmer an diesem Tisch zureuck.
     */
    public Map<String, Spieler> getTeilnehmer() {
        return this.teilnehmer;
    }

    /**
     * Innere Klasse fuer einen Dealer. Genauso wie ein Spieler besitzt der Dealer ein Namen, ein vermoegen,
     * welches er Setzen kann und eine Hand.
     */
    class dealer {  //Singleton nachgucken

        private String name;
        private int vermoegen = 0;
        private LinkedList<Karte> hand;

        public dealer(String name, int vermoegen) {
            this.name = name;
            this.vermoegen = vermoegen;
            this.hand = new LinkedList<Karte>();
        }

        /**
         * Methode welche das Kartendeck, mit Hilfe des Kartenmischers, mischt
         */
        public void kartenMischen() {
            KartenMischer.mischen(Tisch.this.kartendeck);
        }

        /**
         * Mit dieser Methode teilt der Dealer sich selber und allen Teilnehmern drei karten aus.
         */
        public void austeilen() {
            int kartenAnzahl = 0;
            while (kartenAnzahl != 3) {
                for (Spieler it : Tisch.this.teilnehmer.values()) {
                    it.karteAusteilen(Tisch.this.kartendeck.getDeck().pop());
                    this.hand.add(Tisch.this.kartendeck.getDeck().pop());
                    kartenAnzahl++;
                }
            }
        }

        /**
         * @return die Punktzahl des Dealers
         */
        public int berechnePunkte() {
            int punktzahl = 0;
            for (Karte i : this.hand) {
                punktzahl += i.getWert();
            }
            return punktzahl;
        }

        /**
         * Methode die eingesetzt wird wenn der Dealer gewinnt.Der Gewinn geht an das Casino.
         *
         * @param betrag Der Betrag um welchen das Vermoegen des Casinos erhoeht wird.
         */
        public void gewonnen(Casino casino, int betrag) {
            casino.gewonnen(betrag);
        }

        /**
         * Methode welche der Einsatz eines beliebigen Spielers ausgibt.
         *
         * @param spieler Der Spieler, dessen Einsatz ausgegeben werden soll.
         * @return Der Einsatz des Spielers
         */
        public int getEinsatz(Spieler spieler) {
            String id = spieler.getId();
            return Tisch.this.pot.get(id);
        }

        /**
         * Methode um den Gewinner einer Runde ausfindig zu machen.
         *
         * @return der Gewinner der Runde
         */
        public LinkedList<Spieler> gewinnerIst() {
            LinkedList<Spieler> moeglicheGewinner = new LinkedList<Spieler>();
            LinkedList<Spieler> gewinnerListe = new LinkedList<Spieler>();
            Spieler gewinner = null;
            for (Spieler it : Tisch.this.teilnehmer.values()) {
                if (it.berechnePunkte() <= 21) {
                    moeglicheGewinner.add(it);
                }
            }
            Spieler tmpGewinner = moeglicheGewinner.getFirst();
            for (Spieler it : moeglicheGewinner) {
                if (it.berechnePunkte() > tmpGewinner.berechnePunkte() || it.berechnePunkte()
                        == tmpGewinner.berechnePunkte()) {
                    gewinnerListe.add(it);
                    tmpGewinner = it;
                }
            }
            return null;
        }

        /**
         * Methode welche den Gewinn an den Gewinner /die Gewinner auszahlt.
         *
         * @param gewinner Der/Die Gewinner
         * @param betrag   der Betrag im Pot
         */
        public void gewinnAuszahlen(Casino casino, LinkedList<Spieler> gewinner, int betrag) {
            if (gewinner.isEmpty()) {
                this.gewonnen(casino, betrag);
            }
            if (gewinner.size() == 1) {
                for (Spieler it : gewinner) {
                    it.gewonnen(betrag);
                }
            } else {
                for (Spieler it : gewinner) {
                    it.gewonnen((betrag / gewinner.size()));
                }
            }
        }

        /**
         * Methode um die Karten aller Teilnehmer einsammeln zu lassen.
         */
        public void kartenEinsammeln() {
            for (Spieler it : Tisch.this.teilnehmer.values()) {
                it.karteEinsammeln();
                this.hand.clear();
            }
        }
    }
}

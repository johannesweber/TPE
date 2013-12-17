package casino;

import tisch.*;

import java.util.*;

public class Tisch {

    private int tischNr = 0;
    private Map<String, Spieler> teilnehmer;
    private Kartendeck kartendeck;
    private Pot pot;

    /**
     * Konstruktor fuer einen Tisch. Jeder Tisch bekommt eine TischNr, ein Kartendeck und ein Pot.
     * Zusaetzlich sitzen an jedem Tisch Teilnehmer.
     */
    public Tisch() {
        this.tischNr++;
        this.teilnehmer = new HashMap<String, Spieler>();
        this.kartendeck = new Kartendeck();
        this.pot = new Pot();
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
     * @return liefert die Gewinnerliste zurueck
     */
    public LinkedList<Spieler> getGewinner() {
        Dealer dealer = new Dealer("Heinz");
        return dealer.gewinnerIst();
    }

    /**
     *
     * @return  gibt den insgesamt gesetzten Betrag zurueck
     */
    public int getHoehePot() {
        int hoehePot = 0;
        for (int it : this.pot.values()) {
            hoehePot += it;
        }
        return hoehePot;
    }

    /**
     * Innere Klasse fuer einen Dealer. Genauso wie ein Spieler besitzt der Dealer ein Namen, ein Vermoegen,
     * welches er Setzen kann, und eine Hand. Deswegen erbt der Dealer von Spieler
     */
    class Dealer extends Spieler {

        public Dealer(String name) {
            super(name, 100000);
            this.idInt += idInt++;
        }

        /**
         * Methode die eingesetzt wird wenn der Dealer gewinnt.Der Gewinn eines Casinos wird erhoeht.
         *
         * @param betrag Der Betrag um welchen der Gewinn erhoeht wird.
         */
        public void gewonnen(Casino casino, int betrag) {
            casino.gewonnen(betrag);
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
            LinkedList<Spieler> gewinner = new LinkedList<Spieler>(Tisch.this.teilnehmer.values());
            int max = 0;
            for (Spieler it : gewinner) {
                if (it.berechnePunkte() > 21) {
                    gewinner.remove(it);
                }
                max = sucheMax(gewinner);
                for (Spieler it2 : gewinner) {
                    if (it2.berechnePunkte() < max) {
                        gewinner.remove(it2);
                    } else {
                        if (this.berechnePunkte() <= 21) {
                            if (this.berechnePunkte() >= it2.berechnePunkte()) {
                                gewinner.remove(it2);
                            }
                        }
                    }
                }

            }
            return gewinner;
        }

        private int sucheMax(LinkedList<Spieler> liste) {
            int max = 0;
            ListIterator<Spieler> it = liste.listIterator();
            max = it.next().berechnePunkte();
            while (!liste.isEmpty()) {
                it.next();
                if (it.next().berechnePunkte() > max) {
                    max = it.next().berechnePunkte();
                }
            }
            return max;
        }

        /**
         * Methode welcher den Pot an den Gewinner/ die Gewinner auszahlt.
         *
         * @param casino Das Casino in welchem gespielt wurde
         * @param tisch  Der Tisch an welchem gespielt wurde
         */
        public void gewinnAuszahlen(Casino casino, Tisch tisch) {
            int betrag = Tisch.this.getHoehePot();
            LinkedList<Spieler> gewinner = new LinkedList<Spieler>();
            gewinner = tisch.getGewinner();
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
            Tisch.this.teilnehmer.clear();
        }
    }
}

package casino;

import tisch.*;

import java.util.*;

public class Tisch {

    private Map<String, Spieler> teilnehmer;
    private Kartendeck kartendeck;
    private Pot pot;
    private Dealer dealer;

    /**
     * Konstruktor fuer einen Tisch. Jeder Tisch bekommt eine TischNr, ein Kartendeck und ein Pot.
     * Zusaetzlich sitzen an jedem Tisch Teilnehmer.
     */
    public Tisch() {
        this.teilnehmer = new HashMap<String, Spieler>();
        this.kartendeck = new Kartendeck();
        this.pot = new Pot();
        this.dealer = new Dealer("Der Dealer");
    }

    /**
     * Gestattet den Zugriff von außen auf den Dealer.
     *
     * @return der Dealer des Tisches.
     */
    public Dealer getDealer() {
        return this.dealer;
    }

    /**
     * @return Liefert alle Teilnehmer an diesem Tisch zureuck.
     */
    public Map<String, Spieler> getTeilnehmer() {
        return this.teilnehmer;
    }

    public int AnzahlTeilnehmer() {
        return teilnehmer.size();
    }

    /**
     * @return liefert den Pot des Tischen zurueck.
     */
    public Pot getPot() {
        return pot;
    }

    /**
     * @return gibt den insgesamt gesetzten Betrag zurueck
     */
    public int getHoehePot() {
        int hoehePot = 0;
        for (int it : this.pot.values()) {
            hoehePot += it;
        }
        return hoehePot;
    }

    /**
     * Methode um einen Spieler einem Tisch zuzuordnen.
     *
     * @param spieler der Spieler der zugeordnet wird.
     */
    public void hinsetzen(Spieler spieler) {
        this.teilnehmer.put(spieler.getId(), spieler);
    }

    /**
     * Innere Klasse fuer einen Dealer. Genauso wie ein Spieler besitzt der Dealer ein Namen, ein Vermoegen,
     * welches er Setzen kann, und eine Hand. Deswegen erbt der Dealer von Spieler
     */
    class Dealer extends Spieler {

        public Dealer(String name) {
            super(name, 10000000);
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
        public void kartenAusteilen() {
            if (Tisch.this.getHoehePot() == 0) {
                System.out.println("Bitte zuerst die Einsaetze taetigen!");
            }
            int kartenAnzahl = 0;
            while (kartenAnzahl < 3) {
                for (Spieler it : Tisch.this.teilnehmer.values()) {
                    it.getHand().add(Tisch.this.kartendeck.getDeck().pop());
                }
                this.hand.add(Tisch.this.kartendeck.getDeck().pop());
                kartenAnzahl++;
            }
        }

        /**
         * Methode welche der Einsatz eines beliebigen Spielers ausgibt.
         *
         * @param spieler Der Spieler, dessen Einsatz ausgegeben werden soll.
         * @return Der Einsatz des Spielers
         */
        public int getEinsatz(Spieler spieler) {
            return Tisch.this.pot.get(spieler.getId());
        }

        /**
         * Methode um den Gewinner einer Runde ausfindig zu machen.
         *
         * @return der Gewinner der Runde
         */
        public LinkedList<Spieler> gewinnerIst() {
            LinkedList<Spieler> unter21 = new LinkedList<Spieler>();
            LinkedList<Spieler> fastGewinner = new LinkedList<Spieler>();
            LinkedList<Spieler> gewinner = new LinkedList<Spieler>();
            int max = 0;
            for (Spieler it : Tisch.this.teilnehmer.values()) {
                if (it.berechnePunkte() <= 21) {
                    unter21.add(it);
                }
            }
            max = sucheMax(unter21);
            if (max != 0) {
                for (Spieler it2 : unter21) {
                    if (it2.berechnePunkte() == max) {
                        fastGewinner.add(it2);
                    }
                }
                if (this.berechnePunkte() <= max) {
                    for (Spieler it3 : fastGewinner) {
                        if (it3.berechnePunkte() > this.berechnePunkte()) {
                            gewinner.add(it3);
                        }
                    }
                } else {
                    gewinner.addAll(fastGewinner);
                }
            }
            return gewinner;
        }

        /**
         * Methode um das Maximum der Punkte in einer Liste zu suchen
         *
         * @param liste Die Liste, in der gesucht werden soll.
         * @return Das Maximum der Punktzahl in der Liste
         */
        private int sucheMax(LinkedList<Spieler> liste) {
            Spieler tmpSpieler;
            int max = 0;
            ListIterator<Spieler> it = liste.listIterator();
            if (!liste.isEmpty()) {
                tmpSpieler = it.next();
                max = tmpSpieler.berechnePunkte();
                while (it.hasNext()) {
                    tmpSpieler = it.next();
                    if (tmpSpieler.berechnePunkte() > max) {
                        max = tmpSpieler.berechnePunkte();
                    }
                }
            }
            return max;
        }

        /**
         * Methode welcher den Pot an den Gewinner/ die Gewinner auszahlt.
         */
        public void gewinnAuszahlen() {
            LinkedList<Spieler> gewinner = this.gewinnerIst();
            int betrag = Tisch.this.getHoehePot();
            if (gewinner.isEmpty()) {
                Casino.gewonnen(betrag);
            }
            if (gewinner.size() == 1) {
                for (Spieler it : gewinner) {
                    it.gewonnen(betrag);
                }
            }
            if (gewinner.size() > 1) {
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
                it.getHand().clear();
            }
            this.hand.clear();
            Tisch.this.teilnehmer.clear();
        }
    }
}

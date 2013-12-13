package casino;

import kartendeck.Karte;
import tisch.*;

import java.util.*;

public class Tisch {

	private Map<String, Integer> pot;
    private int tischNr = 0;
    private Map<String, Spieler> teilnehmer;
    private Kartendeck kartendeck;

    public Tisch(){
        this.tischNr++;
        this.teilnehmer = new HashMap<String, Spieler>();
        this.kartendeck = new Kartendeck();
        this.pot = new HashMap<String, Integer>();
    }

    public int getTischNr(){
        return this.tischNr;
    }

    public Map<String, Spieler> getSpieler(){
        return this.teilnehmer;
    }
        class dealer {  //Singleton nachgucken auch zu den Teilnehmern hinzufuegen

            private String name;
            private int vermoegen = 0;
            private LinkedList<Karte> hand;

            public dealer(String name, int vermoegen){
                this.name = name;
                this.vermoegen = vermoegen;
                this.hand = new LinkedList<Karte>();
            }

            public void kartenMischen(){
                KartenMischer.mischen(Tisch.this.kartendeck);
            }

            public void austeilen(){
                int kartenAnzahl = 0;
                while (kartenAnzahl != 3){
                    for (Spieler it : Tisch.this.teilnehmer.values()){
                        it.setHand(Tisch.this.kartendeck.getDeck().pop());
                        kartenAnzahl++;
                    }
                }
            }

            public int getEinsatz(Spieler spieler){
                String id = spieler.getId();
                return Tisch.this.pot.get(id);
            }

            public Spieler gewinnerIst(){
                LinkedList<Spieler> moeglicheGewinner = new LinkedList<Spieler>();
                LinkedList<Spieler> gewinnerListe = new LinkedList<Spieler>();
                Spieler gewinner = null;
                for (Spieler it : Tisch.this.teilnehmer.values()){
                    if(it.getPunktzahl() <= 21){
                        moeglicheGewinner.add(it);
                    }
                }
                Spieler tmpGewinner = moeglicheGewinner.getFirst();
                for (Spieler it : moeglicheGewinner){
                    if(it.getPunktzahl() > tmpGewinner.getPunktzahl() || it.getPunktzahl() == tmpGewinner.getPunktzahl()){
                        gewinnerListe.add(it);
                        tmpGewinner = it;
                    }
                }
                return null;
            }

            public void gewinnAuszahlen(){

            }

            public void kartenEinsammeln(){

            }

        }
}

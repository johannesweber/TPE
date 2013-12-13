package casino;

import kartendeck.Karte;
import tisch.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

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
        class dealer {  //Singleton nachgucken

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
                    for (Spieler i : Tisch.this.teilnehmer.values()){
                        i.setHand(Tisch.this.kartendeck.getDeck().pop());
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
                for (Spieler i : Tisch.this.teilnehmer.values()){
                    if(i.getPunktzahl() <= 21){
                        moeglicheGewinner.addFirst(i);
                    }
                }
                if(!moeglicheGewinner.isEmpty()){
                    for(Spieler it : moeglicheGewinner){

                        }

                    }
                }
                return moeglicheGewinner.getFirst();
            }

            public void gewinnAuszahlen(){

            }

            public void kartenEinsammeln(){

            }

        }
}

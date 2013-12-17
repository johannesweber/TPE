package casino;

import tisch.Spieler;

public class CasinoSim {

    public static <T> void main(String[] args) {

        Casino casino = new Casino("casino");
        Spieler heinz = new Spieler("Heinz", 100);
        Spieler dörte = new Spieler("Dörte", 20000);
        Spieler jessica = new Spieler("Jessica", 300);
        Spieler dieter = new Spieler("Dieter", 25000);
        Spieler ute = new Spieler("Ute", 1530);
        Spieler hannelore = new Spieler("Hannelore", 2043200);
        Spieler aman = new Spieler("Aman", 10665);
        Spieler joo = new Spieler("Joo", 20530);
        Spieler lucas = new Spieler("Lucas", 105);
        Spieler phillip = new Spieler("Phillip", 200500);
        Spieler bodo = new Spieler("Bodo", 1000000);
        Spieler djachim = new Spieler("djAchim", 205230);


        dörte.betreten(casino);
        heinz.betreten(casino);
        jessica.betreten(casino);
        dieter.betreten(casino);
        ute.betreten(casino);
        hannelore.betreten(casino);
        aman.betreten(casino);
        joo.betreten(casino);
        lucas.betreten(casino);
        phillip.betreten(casino);
        bodo.betreten(casino);
        djachim.betreten(casino);

        System.out.println(casino.getAnzahlTische());

        casino.getTische().get(0).getDealer().kartenMischen();
        casino.getTische().get(1).getDealer().kartenMischen();

        System.out.println(casino.getTische().get(0).AnzahlTeilnehmer());
        System.out.println(casino.getTische().get(1).AnzahlTeilnehmer());


        heinz.setzen(casino.getTische().get(0), 150);
        dörte.setzen(casino.getTische().get(0), 1000);
        jessica.setzen(casino.getTische().get(0), 150);
        dieter.setzen(casino.getTische().get(0), 1000);
        ute.setzen(casino.getTische().get(0), 150);
        hannelore.setzen(casino.getTische().get(0), 1000);
        aman.setzen(casino.getTische().get(0), 150);
        joo.setzen(casino.getTische().get(0), 1000);
        casino.getTische().get(0).getDealer().setzen(casino.getTische().get(0), 1000);

        lucas.setzen(casino.getTische().get(1), 150);
        phillip.setzen(casino.getTische().get(1), 1000);
        bodo.setzen(casino.getTische().get(1), 150);
        djachim.setzen(casino.getTische().get(1), 1000);
        casino.getTische().get(1).getDealer().setzen(casino.getTische().get(1), 1000);

        casino.getTische().get(0).getDealer().kartenAusteilen();
        casino.getTische().get(1).getDealer().kartenAusteilen();

        System.out.println(casino.getTische().get(0).getTeilnehmer());
        System.out.println(casino.getTische().get(1).getTeilnehmer());

        System.out.println(heinz.berechnePunkte());
        System.out.println(dörte.berechnePunkte());
        System.out.println(jessica.berechnePunkte());
        System.out.println(dieter.berechnePunkte());
        System.out.println(ute.berechnePunkte());
        System.out.println(hannelore.berechnePunkte());
        System.out.println(aman.berechnePunkte());
        System.out.println(joo.berechnePunkte());
        System.out.println(lucas.berechnePunkte());
        System.out.println(phillip.berechnePunkte());
        System.out.println(bodo.berechnePunkte());
        System.out.println(djachim.berechnePunkte());

        System.out.println();
        System.out.println(casino.getTische().get(0).getDealer().berechnePunkte());
        System.out.println(casino.getTische().get(1).getDealer().berechnePunkte());

        System.out.println(casino.getTische().get(0).getDealer().gewinnerIst());
        System.out.println(casino.getTische().get(1).getDealer().gewinnerIst());

        System.out.println();
        System.out.println(casino.getTische().get(0).getHoehePot());
        System.out.println(casino.getTische().get(1).getHoehePot());
        System.out.println();
        System.out.println(casino.getTische().get(1).getPot());
        System.out.println();

        casino.getTische().get(0).getDealer().gewinnAuszahlen();
        casino.getTische().get(1).getDealer().gewinnAuszahlen();

        System.out.println(heinz.getVermoegen());
        System.out.println(dörte.getVermoegen());
        System.out.println(jessica.getVermoegen());
        System.out.println(dieter.getVermoegen());
        System.out.println(ute.getVermoegen());
        System.out.println(hannelore.getVermoegen());
        System.out.println(aman.getVermoegen());
        System.out.println(joo.getVermoegen());
        System.out.println(phillip.getVermoegen());
        System.out.println(bodo.getVermoegen());
        System.out.println(djachim.getVermoegen());

        System.out.println(casino.getGewinn());

        casino.getTische().get(0).getDealer().kartenEinsammeln();
        casino.getTische().get(1).getDealer().kartenEinsammeln();

        System.out.println(heinz.getHand());
        System.out.println(dörte.getHand());
        System.out.println(casino.getTische().get(0).getDealer().getHand());
        System.out.println(djachim.getHand());

    }


}

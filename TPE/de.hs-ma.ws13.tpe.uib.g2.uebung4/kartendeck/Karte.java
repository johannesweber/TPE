package kartendeck;

/**
 * Eine Klasse um eine einzelne Karte zu modellieren. Jeder Karte besteht aus einem Wert und einer Farbe.
 */
public class Karte {

    private Kartenfarbe farbe;
    private Kartenwert wert;

    public Karte(Kartenfarbe farbe, Kartenwert wert) {
        this.farbe = farbe;
        this.wert = wert;
    }

    /**
     * @return liefert die farbe der Karte
     */
    public Kartenfarbe getFarbe() {
        return this.farbe;
    }

    /**
     * @return liefert den Wert der Karte
     */
    public int getWert() {
        return this.wert.getWert();
    }
}

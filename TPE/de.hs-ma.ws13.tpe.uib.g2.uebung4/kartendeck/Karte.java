package kartendeck;

/**
 * Eine Klasse um eine einzelne Karte zu modellieren. Jeder Karte besteht aus
 * einem Wert und einer Farbe.
 * 
 * @author Johannes Weber
 * @author Amanpreet Singh Chahota
 * @author Yannick Appolain Fowa
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

	@Override
	public String toString() {
		return "Karte{" + "farbe=" + farbe + ", wert=" + wert + '}';
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Karte)) return false;

        Karte karte = (Karte) o;

        if (farbe != karte.farbe) return false;
        if (wert != karte.wert) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = farbe != null ? farbe.hashCode() : 0;
        result = 31 * result + (wert != null ? wert.hashCode() : 0);
        return result;
    }
}

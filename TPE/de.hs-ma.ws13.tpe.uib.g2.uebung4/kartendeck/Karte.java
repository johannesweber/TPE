package kartendeck;

public class Karte {

	private Kartenfarbe farbe;
	private Kartenwert wert;
	
	public Karte(Kartenfarbe farbe, Kartenwert wert){
		this.farbe = farbe;
		this.wert = wert;
	}

	public Kartenfarbe getFarbe() {
		return this.farbe;
	}

	public int getWert() {
		return this.wert.getWert();
	}
}

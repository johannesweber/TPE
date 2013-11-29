package kartendeck;

public class Karte {

	private Kartenfarbe farbe;
	private Kartenwert wert;
	
	public Karte(Kartenfarbe farbe, Kartenwert wert){
		this.farbe = farbe;
		this.wert = wert;
	}

	public Kartenfarbe getFarbe() {
		return farbe;
	}

	public Kartenwert getWert() {
		return wert;
	}
}

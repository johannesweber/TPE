package kartendeck;

public enum Kartenwert {

	ZWEI(2), DREI(3), VIER(4), FUENF(5), SECHS(6), SIEBEN(7), ACHT(8), NEUN(9), ZEHN(
			10), BUBE(10), DAME(10), KOENIG(10), ASS(11);

    private int wert;

    private Kartenwert(int wert) {
		this.wert = wert;
	}

	public int getWert() {
		return wert;
	}

}

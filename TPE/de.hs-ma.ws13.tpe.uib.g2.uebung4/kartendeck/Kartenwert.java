package kartendeck;

/**
 * Eine Enum Klasse fuer den Kartenwert. Die Enum Klasse besitzt auch einen
 * Konstruktor. Mit dessen Hilfe wird den verschiedenen Enum Werten ein int Wert
 * zugeordnet um spaeter die Punktzahl eines Spielers ermitteln zu koennen.
 * 
 * @author Johannes Weber
 * @author Amanpreet Singh Chahota
 * @author Yannick Appolain Fowa
 */
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

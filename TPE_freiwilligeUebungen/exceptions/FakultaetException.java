/**
 * Created by Johannes on 01.01.14.
 */
public class FakultaetException extends Exception {

    private int wert;

    public FakultaetException(String nachricht, int wert) {
        super(nachricht);
        this.wert = wert;
    }

    public int getWert() {
        return wert;
    }
}

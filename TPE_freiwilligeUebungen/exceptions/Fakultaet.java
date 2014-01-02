/**
 * Created by Johannes on 01.01.14.
 */
public class Fakultaet {

    public static void main(String[] args) throws FakultaetException {

        System.out.println(berechneFakultaet(20));

    }

    public static long berechneFakultaet(int wert) throws FakultaetException {
        long ergebnis = 1;
        if (wert > 20) {
            throw new FakultaetException("Bitte ein Wert unter 20 angeben.", wert);
        }

        if (wert < 0) {
            throw new FakultaetException("Bitte ein Wert ueber null eingeben.", wert);
        }

        if (wert == 0) {
            ergebnis = 0;
        }else{
            for (int i = 1; i <= wert; i++) {
                ergebnis *= i;
            }
        }
        return ergebnis;
    }
}

package aufgabeD;

/**
 * Created by Johannes on 02.01.14.
 */
public class FakultaetParallel {

    private long[] ergebnisse;

    public FakultaetParallel(int bis) {
        this.ergebnisse = new long[bis+1];
    }

    public long berechneFakultaet(int bis) {
        long ergebnis = 1;
        if (bis == 0) {
            ergebnis = 0;
        } else {
            for (int i = 1; i <= bis; i++) {
                ergebnis *= i;
            }
        }
        return ergebnis;
    }

    public long[] calculate(int von, int bis){

        for (int i = von; i < bis; i++){
            this.ergebnisse[von] = berechneFakultaet(von);
        }
        return this.ergebnisse;
    }
}

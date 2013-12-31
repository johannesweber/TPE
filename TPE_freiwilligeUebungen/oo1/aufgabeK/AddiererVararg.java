package aufgabeK;

/**
 * Created by Johannes on 31.12.13.
 */
public class AddiererVararg {

    public int addieren(int zahl1, int zahl2){
        return zahl1 + zahl2;
    }

    public int addieren(int zahl1, int zahl2, int zahl3){
        return zahl1 + zahl2 + zahl3;
    }

    public int addierenVararg(int...zahl){
        int summe = 0;
        for (int i : zahl){
            summe +=i;
        }
        return summe;
    }
}

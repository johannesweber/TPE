package aufgabeBff;

/**
 * Created by Johannes on 01.01.14.
 */
public class Datenhalter {

    private int attribut;

    public Datenhalter(int attribut) {
        this.attribut = attribut;
    }

    public Beobachter getAttribut(){
        return new DatenhalterInnen();
    }

    private class DatenhalterInnen implements Beobachter {
        public int getValue() {
            return Datenhalter.this.attribut;
        }
    }
}

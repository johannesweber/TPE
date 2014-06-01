package aufgabeBff;

/**
 * Created by Johannes on 01.01.14.
 */
public class Datenhalter {

    private int attribut = 5;

    public Datenhalter(int attribut) {
        this.attribut = attribut;
    }

    private class DatenhalterInnen implements Beobachter {

        public int getValue() {
            return attribut;
        }
    }
}

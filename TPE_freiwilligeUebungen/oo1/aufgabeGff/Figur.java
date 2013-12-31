package aufgabeGff;

/**
 * Created by Johannes on 31.12.13.
 */
public class Figur {

    private int flaeche;

    Figur(int flaeche){
        this.flaeche = flaeche;
    }

    Figur(){
        this.flaeche = 0;
    }

    public int getFlaeche() {
        return this.flaeche;
    }
}

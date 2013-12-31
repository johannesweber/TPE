package aufgabeBff;

/**
 * Created by Johannes on 31.12.13.
 */
public class Rechteck extends Form{

    double laenge;
    double breite;

    public Rechteck(double xpos, double ypos, double laenge, double breite){
        super(xpos, ypos);
        this.laenge = laenge;
        this.breite = breite;
    }

    @Override
    public double flaeche() {
        return this.laenge * this.breite;
    }

    @Override
    public double umfang() {
        return (2*this.laenge) + (2*this.breite);
    }
}

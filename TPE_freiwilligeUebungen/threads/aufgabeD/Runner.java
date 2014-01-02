package aufgabeD;

/**
 * Created by Johannes on 02.01.14.
 */
public class Runner implements Runnable{

    private int von;
    private int bis;

    public Runner(int von, int bis) {
        this.von = von;
        this.bis = bis;
    }

    public void run(){

        FakultaetParallel fakultaet = new FakultaetParallel(this.bis);

        fakultaet.berechneFakultaet(this.bis);
        System.out.println(fakultaet.calculate(this.von, this.bis));

    }
}

package aufgabeI;


/**
 * Created by Johannes on 02.01.14.
 */
public class Synchronizer {

    public int einziges;

    public synchronized void addAntPrint() {
        System.out.println(this.einziges++);
    }
}

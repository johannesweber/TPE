package aufgabeI;

/**
 * Created by Johannes on 02.01.14.
 */
public class Main {

    public static void main(String[] args) {

        final Synchronizer sync = new Synchronizer();

        Runnable runner = new Runnable() {
            public void run() {
                while (true) {
                    sync.addAntPrint();
                }
            }
        };

        Thread t1 = new Thread(runner);
        Thread t2 = new Thread(runner);

        t1.start();
        t2.start();
    }
}

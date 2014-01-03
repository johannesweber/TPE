package aufgabeE;

/**
 * Created by Johannes on 02.01.14.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Interrupted(), "interrupted");

        t1.start();
        Thread.sleep(2000);
        t1.interrupt();
    }
}

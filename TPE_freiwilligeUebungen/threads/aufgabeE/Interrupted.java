package aufgabeE;

/**
 * Created by Johannes on 02.01.14.
 */
public class Interrupted implements Runnable {

    @Override
    public void run() {

        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("ich bin noch wach...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}

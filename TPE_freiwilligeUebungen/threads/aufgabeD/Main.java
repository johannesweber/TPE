package aufgabeD;

/**
 * Created by Johannes on 02.01.14.
 */
public class Main {

    public static void main(String[] args){

        Runner runner1 = new Runner(1,10);
        Runner runner2 = new Runner(11,20);
        Thread t1 = new Thread(runner1);
        Thread t2 = new Thread(runner2);

        t1.start();
        t2.start();
    }
}

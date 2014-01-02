package aufgabeBff;

/**
 * Created by Johannes on 02.01.14.
 */
public class Threads {

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            public void run(){
                while(true){
                    System.out.println("Thread 1 spicht");
                    Thread.yield();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run(){
                while(true){
                    System.out.println("Thread 2 spicht");
                    Thread.yield();
                }
            }
        });

        t1.start();
        t2.start();

        while(true){
            System.out.println("Hier spricht der Main Thread");
            Thread.yield();
        }
    }
}

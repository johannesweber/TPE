package aufgabeL;

/**
 * Created by Johannes on 31.12.13.
 */
public class Dackel extends Lebewesen{

    @Override
    public void bewegen(){
        System.out.println("Auf kurzen Beinen vorwaerts wackeln");
    }

    public void bellen(){
        System.out.println("wau wau wau");
    }
}

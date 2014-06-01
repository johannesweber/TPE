/**
 * Created by Johannes on 11.01.14.
 */
public class SerialNumberGenerator {

    private volatile int seriennummer = 0;

    public synchronized int naechsteNummer(){
        this.seriennummer++;
        return seriennummer;
    }

    public static void main (String[] args){

    }
}

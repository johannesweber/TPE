package aufgabeJ;

/**
 * Created by Johannes on 02.01.14.
 */
public class Notifier {

    private String einziges;

    public synchronized void setString(String string){
        if(this.einziges.equals(null)){
            this.einziges = string;
        }else{

        }
    }

    public synchronized String getString(){
        String ergebnis = this.einziges;
        this.einziges = null;
        return ergebnis;
    }
}

package aufgabeAff;

import java.util.LinkedList;

/**
 * Created by Johannes on 01.01.14.
 */
public class PairList <Pair> extends LinkedList<Pair>{

    private int max;

    public PairList(int max){
        this.max = max;
    }

    public void add(int index, Pair objekt){
        if(index < this.max){
            this.add(index, objekt);
        }else{
            System.out.println("Max. Laenge erreicht.");
        }
    }

    public Pair get(int index){
        return this.get(index);
    }
}

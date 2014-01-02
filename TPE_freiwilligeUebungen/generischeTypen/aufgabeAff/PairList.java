package aufgabeAff;

import java.util.LinkedList;

/**
 * Created by Johannes on 01.01.14.
 */
public class PairList <T> {

    private LinkedList<T> pairList;
    private int max;

    public PairList(int max){
        this.pairList = new LinkedList<T>();
        this.max = max;
    }

    public void add(int index, T objekt){
        if(index < this.max){
            this.pairList.add(index, objekt);
        }else{
            System.out.println("Max. Laenge erreicht.");
        }
    }

    public void get(int index){
        this.pairList.get(index);
    }
}

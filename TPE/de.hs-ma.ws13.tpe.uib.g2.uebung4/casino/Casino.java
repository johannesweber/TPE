package casino;

import java.util.LinkedList;

public class Casino {

    private String name;
    private int gewinn;
    private LinkedList<Tisch> tische;

    public Casino(String name){
        this.name = name;
        this.tische = new LinkedList<Tisch>();
        this.tische.add(new Tisch());
    }

    public int getGewinn(){
        return this.gewinn;
    }

    public void setGewinn(int gewinn){
        this.gewinn += gewinn;
    }

    public int getAnzahlTische(){
        return this.tische.size();
    }

}

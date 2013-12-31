package aufgabeBff;

/**
 * Created by Johannes on 31.12.13.
 */
public abstract class Form {

    double xpos;
    double ypos;

    public Form(double xpos, double ypos){
        this.xpos = xpos;
        this.ypos = ypos;
    }

    public abstract double flaeche();
    public abstract double umfang();
}

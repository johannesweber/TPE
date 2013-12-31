package aufgabeF;

/**
 * Created by Johannes on 31.12.13.
 */
public class Student implements Comparable {

    private String vorname;
    private String nachname;
    private int matrikelNr;

    public Student(String vorname, String nachname, int matrikelNr) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.matrikelNr = matrikelNr;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, (%d)", nachname, vorname, matrikelNr);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

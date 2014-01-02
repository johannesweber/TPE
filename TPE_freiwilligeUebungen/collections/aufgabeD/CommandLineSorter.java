package aufgabeD;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Johannes on 01.01.14.
 */
public class CommandLineSorter {

    public static <T> void main(String[] args) {
        Set<String> woerter = new TreeSet<String>(Arrays.asList(args));

        for (String it : woerter){
            System.out.println(it);
        }
    }
}

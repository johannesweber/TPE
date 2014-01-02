package aufgabeC;

import java.util.*;

/**
 * Created by Johannes on 01.01.14.
 */
public class CommandLineSorter2 {

    public static <T> void main(String[] args) {
        List<String> woerter = Arrays.asList(args);
        Collections.sort(woerter);

        for (String it : woerter){
            System.out.println(it);
        }
    }
}

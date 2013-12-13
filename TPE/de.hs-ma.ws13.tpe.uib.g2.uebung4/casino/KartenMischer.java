package casino;

import tisch.Kartendeck;
import java.util.Collections;

public class KartenMischer {

	
	public static void mischen(Kartendeck deck){
        Collections.shuffle(deck.getDeck());
    }
}

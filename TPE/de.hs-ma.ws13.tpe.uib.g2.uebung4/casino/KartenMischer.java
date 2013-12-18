package casino;

import tisch.Kartendeck;
import java.util.Collections;

/**
 * der zentrale kartenmischer. Er kuemmert sich nur um das Mischen der einzelnen kartendecks.
 */
public class KartenMischer {

    /**
     * Methode welche ein Uebung4.haupt.kartendeck mischt.
     * Das Kartendeck wird mit Hilfe der Methode shuffle() von den Collections gemischt.
     *
     * @param deck das Kartendeck welches gemischt werden soll.
     */
    public static void mischen(Kartendeck deck) {
        Collections.shuffle(deck.getDeck());
    }
}

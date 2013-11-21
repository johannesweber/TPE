package metropolis;

/**
 * Extra Klasse fuer die Konstanten welche für die Berechnung der
 * Einkommensteuer benoetigt werden.
 * 
 * @author Johannes Weber
 * @author Amanpreet Singh Chahota
 * @author Constantin Schneider
 */
public class Konstanten {

	private static final int BASIS20K = (20000 / 100) * 10;
	public static final int BASIS40K = ((20000 / 100) * 25) + BASIS20K;
	public static final int BASIS60k = ((20000 / 100) * 25) + BASIS40K;
	public static final int BASIS120k = ((60000 / 100) * 35) + BASIS60k;

}

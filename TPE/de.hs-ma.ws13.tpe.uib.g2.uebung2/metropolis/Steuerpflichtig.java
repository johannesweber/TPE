package metropolis;

/**
 * Schnittstelle fuer alle steuerpflichtigen Subjekte. Dieses Interface enthaelt
 * die abstrakte Methode berechneSteuer().Durch dieses Interface is es moeglich
 * in der Klasse Finanzamt eine Liste zu erstellen in welcher nur die
 * steuerpflichtigen Buerger aufgenommen werden koennen.
 * 
 * @author Johannes Weber
 * @author Amanpreet Singh Chahota
 * @author Constantin Schneider
 */
public interface Steuerpflichtig {

	public int berechneSteuer();
}

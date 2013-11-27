package interfaces;

import graph.Node;
import graph.NodeListImpl;

/**
 * Schnittstelle Search Strategy welche die zwei abstrakten Methoden search und
 * getPath fuer die Klassen Breitensuche und tiefensuche bereitstellt.
 * 
 * @author Johannes Weber
 * @author Amanpreet Singh Chahota
 * @author Yannick Appolain Fowa
 * 
 * @param <T>
 *            Ein beliebiger Datenyp
 */
public interface SearchStrategy<T> {

	/**
	 * Abstrakte Methode welche nach dem uebergebenen Knoten sucht.
	 * 
	 * @param search
	 *            den zu suchenden Knoten
	 * @param firstNode
	 *            den Anfangsknoten
	 * @return Eine Liste mit den gefundenen Knoten
	 */
	abstract NodeListImpl<T> search(Node<T> firstNode, Node<T> search);

	/**
	 * Abstrakte methode welche den Pfad der letzten Suche zurueckgibt.
	 * 
	 * @return NodeListImpl<T> liefert den Pfad der letzen Suche zurueck
	 */
	abstract NodeListImpl<T> getPath();
}

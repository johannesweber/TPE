package graph;

import interfaces.SearchStrategy;

/**
 * 
 * Die Klasse eines Graphen. jeder Graph besteht aus einem
 * Anfangsknoten(firstNode) von welchem sich alle anderen Knoten ableiten
 * lassen.
 * 
 * @author Johannes Weber
 * @author Amanpreet Singh Chahota
 * 
 * @param <T>
 *            ein beliebiger Datentyp
 */
public class Graph<T> {

	private Node<T> firstNode;

	/**
	 * Konstruktor eines Graphen
	 * 
	 * @param firstNode
	 *            der Knoten mit welchem der Graph beginnen soll.
	 */
	public Graph(Node<T> firstNode) {
		this.firstNode = firstNode;
	}

	/**
	 * @param search
	 *            der Knoten der gesucht werden soll.
	 * @param strategy
	 *            die gewaehlte Suchstrategie
	 * @return Eine Liste der uebereinstimmenden Knoten
	 */
	public NodeListImpl<T> search(Node<T> search, SearchStrategy<T> strategy) {
		return strategy.search(this.firstNode, search);
	}

	/**
	 * Kopiert alle Knoten des Graphen in eine neue Liste
	 * 
	 * @param list
	 *            Die Liste in welche die Knoten kopiert werden.
	 * @return die neue gefuellte Liste
	 */
	public NodeListImpl<T> copyInto(NodeListImpl<T> list) {
		return copyIntoRek(this.firstNode, list);
	}

	/**
	 * Eigentliche Rekursive Methode. In dieser Methode wird nochmal mit der
	 * Tiefensuche durch den Graphen gegangen um die einzelnen Knoten in einer
	 * separaten Liste zu speichern.
	 * 
	 * @param start
	 *            Der Anfangspunkt
	 * @param list
	 *            Die Liste in welche kopiert wird
	 * @return eine neue Liste
	 */
	private NodeListImpl<T> copyIntoRek(Node<T> start, NodeListImpl<T> list) {
		if (start != null) {
			if (!list.contains(start)) {
				list.add(start);
				for (Node<T> it : start.getChildren()) {
					copyIntoRek(it, list);
				}
			}
		}
		return list;
	}

	/**
	 * @return liefert den Anfangsknoten
	 */
	public Node<T> getFirstNode() {
		return this.firstNode;
	}
}

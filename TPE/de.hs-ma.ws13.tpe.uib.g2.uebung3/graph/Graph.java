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
	private NodeListImpl<T> all = new NodeListImpl<T>();

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
	 *            der Knoten nach welchem gesucht werden soll.
	 * @param strategy
	 *            die gewaehlte Suchstrategie
	 * @return Eine Liste der uebereinstimmenden Knoten
	 */
	public NodeListImpl<T> search(Node<T> search, SearchStrategy<T> strategy) {
		NodeListImpl<T> found = new NodeListImpl<T>();
		found = strategy.search(this.firstNode, search);
		return found;
	}

	/**
	 * Kopiert alle Knoten des Graphen in eine neue Liste
	 * 
	 * @param list
	 *            Die Liste in welche die Knoten kopiert werden.
	 * @return die neue gefuellte Liste
	 */
	public NodeListImpl<T> copyInto(NodeListImpl<T> list) {
		for(Node<T> it : this.all){
			list.add(it);
		}
		return list;
	}
	
	/**
	 * 
	 * @return liefert den Anfangsknoten
	 */
	public Node<T> getFirstNode(){
		return this.firstNode;
	}
}

package graph;

import interfaces.SearchStrategy;

/**
 * Klasse um die Tiefensuche zu verwirklichen. Diese Klasse implementiert das
 * Interface SearchStrategy und somit auch dessen beide Methoden search und
 * getPath. Zusaetzlich besitzt diese methode noch eine Liste um den gelaufenen
 * Pfad zu speichern.
 * 
 * @author Johannes Weber
 * @author Amanpreet Singh Chahota
 * 
 * @param <T>
 *            Ein beliebiger Datentyp
 */
public class Tiefensuche<T> implements SearchStrategy<T> {

	private NodeListImpl<T> path = new NodeListImpl<T>();
	private NodeListImpl<T> found;

	@Override
	public NodeListImpl<T> search(Node<T> firstNode, Node<T> search) {
		this.found = new NodeListImpl<T>();
		this.path.clear();

		if (firstNode.getValue().equals(search.getValue())) {
			this.path.add(firstNode);
			found.add(firstNode);
		} else {
			this.path.add(firstNode);
			for (Node<T> it : firstNode.getChildren()) {
				if (!this.path.contains(it)) {
					besucheRek(it, search);
				}
			}
		}
		return found;
	}

	/**
	 * Hilfsklasse fuer die Tiefensuche. Ruft die eigentliche Rekursion der
	 * Tiefensuche auf.
	 * 
	 * @param node
	 *            der zu durchsuchende Knoten
	 */
	private void besucheRek(Node<T> node, Node<T> search) {
		this.path.add(node);
		for (Node<T> it : node.getChildren()) {
			if (it.getValue().equals(search.getValue())) {
				this.found.add(it);
			}
			if (!this.path.contains(it)) {
				besucheRek(it, search);
			}
		}
	}

	/**
	 * @return liefert den Pfad der letzten Suche zurueck.
	 */
	@Override
	public NodeListImpl<T> getPath() {
		return this.path;
	}
}

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
	private Node<T> search;
	private NodeListImpl<T> found;

	@Override
	public NodeListImpl<T> search(Node<T> firstNode, Node<T> search) {
		this.found = new NodeListImpl<T>();
		this.path.clear();
		this.search = search;

		if (firstNode.getValue().equals(search.getValue())) {
			this.path.add(firstNode);
			found.add(firstNode);
			firstNode.setVisited(true);
		} else {
			this.path.add(firstNode);
			firstNode.setVisited(true);
			for (Node<T> it : firstNode.getChildren()) {
				if (!it.isVisited()) {
					besucheRek(it);
				}
			}
		}
		clean();
		return found;
	}

	/**
	 * Hilfsklasse fuer die Tiefensuche. Ruft die eigentliche Rekursion der
	 * Tiefensuche auf.
	 * 
	 * @param node
	 *            der zu durchsuchende Knoten
	 */
	private void besucheRek(Node<T> node) {
		node.setVisited(true);
		this.path.add(node);
		if (node.getValue().equals(this.search.getValue())) {
			this.found.add(node);
		}
		for (Node<T> it : node.getChildren()) {
			if (!it.isVisited()) {
				besucheRek(it);
			}
		}
	}

	@Override
	public NodeListImpl<T> getPath() {
		return this.path;
	}
	
	private void clean(){
		for(Node<T> it : this.path){
			it.setVisited(false);
		}
	}
}

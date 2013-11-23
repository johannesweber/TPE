package graph;

import interfaces.SearchStrategy;

public class Tiefensuche<T> implements SearchStrategy<T> {

	private NodeListImpl<T> path;
	private Node<T> search;
	private NodeListImpl<T> found;

	@Override
	public NodeListImpl<T> search(Node<T> firstNode, Node<T> search) {
		this.found = new NodeListImpl<T>();
		this.path = new NodeListImpl<T>();
		this.search = search;

		if (firstNode.getName().equals(search.getName())) {
			this.path.add(firstNode);
			found.add(firstNode);
			firstNode.setVisited(true);
		} else {
			for (Node<T> it : firstNode.getChildren()) {
				if (!it.isVisited()) {
					besucheRek(it);
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
	private void besucheRek(Node<T> node) {
		node.setVisited(true);
		this.path.add(node);
		if (node.getName().equals(this.search.getName())) {
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
}

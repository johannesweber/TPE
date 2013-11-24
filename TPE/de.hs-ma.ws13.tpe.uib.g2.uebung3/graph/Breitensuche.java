package graph;

import interfaces.SearchStrategy;

/**
 * Klasse um die Breitensuche zu verwirklichen. Diese Klasse implementiert das
 * Interface SearchStrategy und somit auch dessen beide Methoden search und
 * getPath. Zusätzlich besitzt diese methode noch eine Liste um den gelaufenen
 * Pfad zu speichern.
 * 
 * @author Johannes Weber
 * @author Amanpreet Singh Chahota
 * 
 * @param <T>
 *            Ein beliebiger Datentyp
 */
public class Breitensuche<T> implements SearchStrategy<T> {

	private NodeListImpl<T> path = new NodeListImpl<T>();

	/**
	 * Implemetierte Methode search() welche die eigentliche Breitensuche
	 * verwirklicht und nebenher den gelaufenen Pfad speichert.
	 */
	@Override
	public NodeListImpl<T> search(Node<T> firstNode, Node<T> search) {
		Node<T> tempNode;
		NodeListImpl<T> tmpList = new NodeListImpl<T>();
		NodeListImpl<T> found = new NodeListImpl<T>();
		
		this.path.clear();
		this.path.add(firstNode);

		if (search.getValue().equals(firstNode.getValue())) {
			found.add(firstNode);
		} else {
			tmpList.add(firstNode);
			while (!tmpList.isEmpty()) {
				tempNode = tmpList.removeFirst();
				tempNode.setVisited(true);
					for (Node<T> it : tempNode.getChildren()) {
						if (!it.isVisited()) {
							it.setVisited(true);
							tmpList.add(it);
							this.path.add(it);
							if (search.getValue().equals(it.getValue())) {
								found.add(it);
							}
						}
					}
			}
		}
		clean();
		return found;
	}

	/**
	 * Implementierte Methode getPath.
	 * 
	 * @return liefert den zuvor gelaufenen Pfad zurueck.
	 */

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

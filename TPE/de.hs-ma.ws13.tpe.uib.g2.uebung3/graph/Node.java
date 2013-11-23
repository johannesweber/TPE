package graph;

/**
 * Klasse Node welche ein Knoten im Graphen darstellen soll. Ein Knoten besteht
 * aus einem Namen und einem beliebigen datentyp. Des weiteren besitzt der
 * Knoten noch eine Liste mit all seinen Kindern und ein boolean visited welches
 * kennzeichnet ob man bei den Suchverfahren den Knoten schon abgelaufen ist.
 * 
 * @author Johannes Weber
 * @author Amanpreet Sing Chahota
 * 
 * @param <T>
 *            Ein beliebiger Datentyp
 */
public class Node<T> {

	private String name;
	private T value;
	private NodeListImpl<T> children;
	private boolean visited;

	public Node(String name, T value) {
		this.children = new NodeListImpl<T>();
		this.name = name;
		this.value = value;
	}

	public void addChild(Node<T> child) {
		this.children.add(child);
	}

	public NodeListImpl<T> getChildren() {
		return this.children;
	}

	public String getName() {
		return this.name;
	}

	public T getValue() {
		return this.value;
	}

	public void setVisited(Boolean set) {
		this.visited = set;
	}

	public boolean isVisited() {
		return this.visited;
	}
}

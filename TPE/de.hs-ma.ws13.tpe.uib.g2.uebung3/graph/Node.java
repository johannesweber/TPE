package graph;

/**
 * Klasse Node welche ein Knoten im Graphen darstellen soll. Ein Knoten besteht
 * aus einem Namen und einem beliebigen datentyp. Des weiteren besitzt der
 * Knoten noch eine Liste mit all seinen Kindern und ein boolean visited welches
 * kennzeichnet ob man bei den Suchverfahren den Knoten schon abgelaufen ist.
 * 
 * @author Johannes Weber
 * @author Amanpreet Singh Chahota
 * 
 * @param <T>
 *            Ein beliebiger Datentyp
 */
public class Node<T> {

	private String name;
	private T value;
	private NodeListImpl<T> children;

	/**
	 * Konstruktor fuer einen Knoten. In diesem wird sofort beim anlegen des
	 * Knoten eine Liste fuer die Anzahl der Kinder angelegt.
	 * 
	 * @param name
	 *            Der Name des Knotens
	 * @param value
	 *            der Wert des Knotens
	 */
	public Node(String name, T value) {
		this.children = new NodeListImpl<T>();
		this.name = name;
		this.value = value;
	}

	/**
	 * Fuegt ein Knoten/Kind zu der Liste des Knotens hinzu
	 * 
	 * @param child
	 *            das Kind das hinzugefuegt werden soll.
	 */
	public void addChild(Node<T> child) {
		this.children.add(child);
	}

	/**
	 * @return eine Liste aller Kinder des Knotens
	 */
	public NodeListImpl<T> getChildren() {
		return this.children;
	}

	/**
	 * @return der Name des Knotens
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return der Wert des Knotens
	 */
	public T getValue() {
		return this.value;
	}

	/**
	 * ueberschreibt die vorhandene toString Methode und gibt dadurch einen
	 * leserlichen Wert aus.
	 */
	@Override
	public String toString() {
		return name;
	}

}

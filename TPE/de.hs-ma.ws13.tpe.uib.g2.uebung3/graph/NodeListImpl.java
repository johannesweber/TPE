package graph;

import interfaces.NodeList;

/**
 * Klasse NodeListImpl welche eine erweiterung der Klasse ListImpl darstellt.
 * Dieser liste ist es nur erlaubt Node (Knoten) aufzunehmen. Im Vergleich dazu
 * darf die Klasse ListImpl alle Datentypen aufnehmen.
 * 
 * @author Johannes Weber
 * @author Amanpreet Singh Chahota
 * 
 * @param <T>
 *            Ein beliebiger Datentyp
 */

public class NodeListImpl<T> extends ListImpl<Node<T>> implements NodeList<T> {

	private static final long serialVersionUID = 9060376770788969273L;

}

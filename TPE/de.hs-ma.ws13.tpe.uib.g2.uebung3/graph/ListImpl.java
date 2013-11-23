package graph;

import interfaces.List;
import java.util.LinkedList;

/**
 * Klasse ListImpl welche von der java internen Klasse LinkedList erbt.
 * 
 * @author Johannes Weber
 * @author Amanpreet Singh Chahota
 * 
 * @param <T>
 *            in beliebiger Datentyp
 */
public class ListImpl<T> extends LinkedList<T> implements List<T> {

	private static final long serialVersionUID = 3130055300544467423L;

}

package graph;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Johannes Weber
 * @author Amanpreet Singh Chahota
 */
public class GraphTestUnit {

	@Test
	public void test() {

		NodeListImpl<String> tiefen = new NodeListImpl<String>();
		NodeListImpl<String> breiten = new NodeListImpl<String>();
		NodeListImpl<String> notfound = new NodeListImpl<String>();
		NodeListImpl<String> first = new NodeListImpl<String>();
		NodeListImpl<String> found = new NodeListImpl<String>();
		NodeListImpl<String> copy = new NodeListImpl<String>();
		
		Tiefensuche<String> tiefensuche = new Tiefensuche<String>();
		Breitensuche<String> breitensuche = new Breitensuche<String>();
		

		Node<String> a = new Node<String>("A", "A");
		Node<String> b = new Node<String>("B", "B");
		Node<String> c = new Node<String>("C", "C");
		Node<String> d = new Node<String>("D", "D");
		Node<String> e = new Node<String>("E", "E");
		Node<String> f = new Node<String>("F", "F");
		Node<String> g = new Node<String>("G", "G");
		Node<String> h = new Node<String>("H", "H");
		Node<String> i = new Node<String>("I", "I");
		Node<String> j = new Node<String>("J", "J");
		Node<String> k = new Node<String>("K", "K");
		Node<String> l = new Node<String>("L", "L");
		Node<String> m = new Node<String>("M", "M");
		Node<String> n = new Node<String>("N", "N");
		Node<String> o = new Node<String>("O", "O");
		Node<String> p = new Node<String>("P", "P");
		Node<String> x = new Node<String>("X", "X");

		a.addChild(b);
		a.addChild(c);
		a.addChild(d);
		b.addChild(e);
		b.addChild(f);
		b.addChild(g);
		c.addChild(l);
		c.addChild(m);
		d.addChild(o);
		d.addChild(p);
		e.addChild(h);
		e.addChild(i);
		f.addChild(j);
		f.addChild(k);
		m.addChild(n);
		
		tiefen.add(a);
		tiefen.add(b);
		tiefen.add(e);
		tiefen.add(h);
		tiefen.add(i);
		tiefen.add(f);
		tiefen.add(j);
		tiefen.add(k);
		tiefen.add(g);
		tiefen.add(c);
		tiefen.add(l);
		tiefen.add(m);
		tiefen.add(n);
		tiefen.add(d);
		tiefen.add(o);
		tiefen.add(p);
		
		breiten.add(a);
		breiten.add(b);
		breiten.add(c);
		breiten.add(d);
		breiten.add(e);
		breiten.add(f);
		breiten.add(g);
		breiten.add(l);
		breiten.add(m);
		breiten.add(o);
		breiten.add(p);
		breiten.add(h);
		breiten.add(i);
		breiten.add(j);
		breiten.add(k);
		breiten.add(n);
		
		first.add(a);
		
		found.add(h);

		Graph<String> graph = new Graph<String>(a);
		
		assertEquals(found, graph.search(h, breitensuche));
		assertEquals(breiten, breitensuche.getPath());
		
		assertEquals(found, graph.search(h, tiefensuche));
		assertEquals(tiefen, tiefensuche.getPath());
		
		assertEquals(notfound, graph.search(x, breitensuche));
		assertEquals(notfound, graph.search(x, tiefensuche));
		
		assertEquals(first, graph.search(a, breitensuche));
		assertEquals(first, graph.search(a, tiefensuche));
		
		assertEquals(tiefen, graph.copyInto(copy));
	}

}

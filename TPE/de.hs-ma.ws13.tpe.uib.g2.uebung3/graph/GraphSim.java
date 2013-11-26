package graph;

/**
 * @author Johannes Weber
 * @author Amanpreet Singh Chahota
 */
public class GraphSim {

	public static <T> void main(String[] args) {
		
		NodeListImpl<String> list= new NodeListImpl<String>();
		
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
		
		a.addChild(d);
		a.addChild(c);
		a.addChild(b);
		b.addChild(g);
		b.addChild(f);
		b.addChild(e);
		b.addChild(a);
		g.addChild(d);
		f.addChild(k);
		f.addChild(j);
		k.addChild(d);
		j.addChild(i);
		e.addChild(i);
		e.addChild(k);
		h.addChild(b);

		Graph<String> graph = new Graph<String>(a);
		
		System.out.println(graph.search(k, breitensuche));
		System.out.println("Breitensuche: " + breitensuche.getPath());
		
		System.out.println(graph.search(k, tiefensuche));
		System.out.println("Tiefensuche: " + tiefensuche.getPath());
	}
}

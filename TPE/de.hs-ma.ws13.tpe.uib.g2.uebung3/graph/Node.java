package graph;

public class Node<T> {
	
	private String name;
	private T value;
	private Node<T> child;
	NodeListImpl<T> children;
	
	public Node(String name, T value){
		children = new NodeListImpl<T>();
		this.name = name;
		this.value = value;
	}
	
	public void addChild(Node<T> child){
		children.add(child);
	}
	
	public Node<T> getChildren(){
		return child;
	}
	
	public String getName(){
		return name;
	}
	
	public T getValue(){
		return value;
	}

}

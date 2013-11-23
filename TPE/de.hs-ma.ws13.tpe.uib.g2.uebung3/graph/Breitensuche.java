package graph;

import interfaces.SearchStrategy;

public class Breitensuche<T> implements SearchStrategy<T> {

	private NodeListImpl<T> path;

	@Override
	public NodeListImpl<T> search(Node<T> firstNode, Node<T> search) {
		Node<T> tempNode;
		NodeListImpl<T> tmpList = new NodeListImpl<T>();
		NodeListImpl<T> found = new NodeListImpl<T>();
		this.path = new NodeListImpl<T>();

		this.path.add(firstNode);

		if (!search.getName().equals(firstNode.getName())) {
			found.add(firstNode);
		} else {
			tmpList.add(firstNode);
			while (!tmpList.isEmpty()) {
				tempNode = tmpList.removeFirst();
				tempNode.setVisited(true);
				while (!tempNode.getChildren().isEmpty()) {
					for (Node<T> it : tempNode.getChildren()) {
						if(!it.isVisited()){
							it.setVisited(true);
							this.path.add(it);
							if (search.getName().equals(it.getName())) {
								found.add(it);
							}
						}
					}
				}
			}
		}
		return found;
	}

	@Override
	public NodeListImpl<T> getPath() {
		return this.path;

	}

}

package DataStructureForCurcuit;

import java.util.ArrayList;

public class NodeWithDepth <T> {
	ArrayList<NodeWithDepth<T> > Parent = null;
	ArrayList<NodeWithDepth<T> > Destination = null;
	int depth;
	T element;
	
	public NodeWithDepth(ArrayList<NodeWithDepth<T>> prevNodes, ArrayList<NodeWithDepth<T>> nextNodes, int d, T entry) {
		for (int i = 0; i < prevNodes.size(); i++) {
			if(prevNodes != null) {
				Destination.add(nextNodes.get(i));
			}
		}
		for (int i = 0; i < nextNodes.size(); i++) {
			if(nextNodes != null) {
				Parent.add(prevNodes.get(i));
			}
		}
		depth = d;
		element = entry;
	}
	
	public int getDepth() {
		return depth;
	}
	public ArrayList<NodeWithDepth<T> > getDestination() {
		return Destination;
	}
	public T getElement() {
		return element;
	}
	public ArrayList<NodeWithDepth<T> > getParent() {
		return Parent;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public void addDestination(NodeWithDepth<T> destination) {
		if (destination != null) {
			Destination.add(destination);
		}
	}
	public void removeDestination(NodeWithDepth<T> destination) {
		for(int i=0; i<Destination.size(); i++) {
			if(destination.equals(Destination.get(i))) {
				Destination.remove(i);
			}
		}
	}
	public void setElement(T element) {
		this.element = element;
	}
	public void addParent(NodeWithDepth<T> parent) {
		Parent.add(parent);
	}
	public void removeParent(NodeWithDepth<T> parent) {
		for(int i=0; i<Parent.size(); i++) {
			if(parent.equals(Parent.get(i))) {
				Parent.remove(i);
			}
		}
	}
	
}

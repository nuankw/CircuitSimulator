package DataStructureForCurcuit;

public class NodeWithDepth <T> {
	NodeWithDepth<T> Parent = null;
	NodeWithDepth<T> Destionation = null;
	int depth;
	T element;
	
	public NodeWithDepth(NodeWithDepth<T> from, NodeWithDepth<T> to, int d, T entry) {
		Destionation = to;
		Parent = from;
		depth = d;
		element = entry;
	}
	
	public int getDepth() {
		return depth;
	}
	public NodeWithDepth<T> getDestionation() {
		return Destionation;
	}
	public T getElement() {
		return element;
	}
	public NodeWithDepth<T> getParent() {
		return Parent;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public void setDestionation(NodeWithDepth<T> destionation) {
		Destionation = destionation;
	}
	public void setElement(T element) {
		this.element = element;
	}
	public void setParent(NodeWithDepth<T> parent) {
		Parent = parent;
	}
}

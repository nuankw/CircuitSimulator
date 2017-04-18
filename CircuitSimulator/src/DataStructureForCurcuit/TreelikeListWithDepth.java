package DataStructureForCurcuit;

import java.util.ArrayList;
import java.util.Iterator;


// power supply must be of depth order 0
// how to loop through this data structure? from and to the "power supply"? O(n)?

// (irrelevant from this data structure, but just wondering ...)
// how do we detect the depth of each component 
// say we come up with a method, then which position in the depth layer do we add the component to? Last, first, or the actual...

public class TreelikeListWithDepth <T> {
	NodeWithDepth<T> head; // must be of depth 0
	NodeWithDepth<T> tail; // must be of depth 0
	int maxDepth = -1;
	int numberOfNodes = 0;
	ArrayList<NodeWithDepth<T>> inventory = new ArrayList<>();
	
//	public TreelikeListWithDepth(NodeWithDepth<T> head) { not very useful
//		this.head = head;
//	}
	
	public void add(T thisComponent, T prevComponent, int toDepth, T nextComponent) { 
		if (toDepth > maxDepth + 1) {
			// wish it would not happen
			System.out.println("Error triggled when adding a node to the LinkedListWithDepth. "
					+ "\nThe designated depth is not within the list scope "
					+ "(toDepth > maxDepth + 1).");
		}
		else {
			NodeWithDepth<T> prevNode = getNode_givenComponent(prevComponent);
			NodeWithDepth<T> nextNode = getNode_givenComponent(nextComponent);
			NodeWithDepth<T> newNode = new NodeWithDepth<T>(prevNode, nextNode, toDepth, thisComponent);
			// prev
			if (prevNode.equals(null)) {
				System.out.println("The given previous component is either a NULL, or not found. ");
				// set the head
				if (head.equals(null) & toDepth == 0) {
					head = newNode;
				}
			}
			else // the previous node exists
			{
				prevNode.setDestionation(newNode);
			}
			// next
			if (getNode_givenComponent(nextComponent).equals(null)) {
				System.out.println("The given next component is either a NULL, or not found. ");
				// set the tail
				if (tail.equals(null) & toDepth == 0) {
					tail = newNode;
				}
			}
			else { // the next node exists
				newNode.setParent(newNode);
			}
			// list
			inventory.add(newNode);
			if (toDepth > maxDepth) {
				maxDepth = toDepth;
			}
			numberOfNodes++;
		}
	}
	
	public NodeWithDepth<T> getNode_givenComponent(T component) {
		Iterator<NodeWithDepth<T>> iterator = inventory.iterator();
		while (iterator.hasNext()) {
			NodeWithDepth<T> currentNode = iterator.next();
			if (currentNode.getElement().equals(component)) {
				return currentNode;
			}
		}
		return null;
	}
	
	
	public boolean remove(T component) {
		Iterator<NodeWithDepth<T>> iterator = inventory.iterator();
		while (iterator.hasNext()) {
			NodeWithDepth<T> currentNode = iterator.next();
			if (currentNode.getElement().equals(component)) {
				// change the node's destination 
				NodeWithDepth<T> theNext = currentNode.getDestionation();
				theNext.setParent(currentNode.getParent());
				// change the node's parent 
				NodeWithDepth<T> thePrev = currentNode.getParent();
				thePrev.setDestionation(currentNode.getDestionation());
				// delete it
				iterator.remove();
				return true;
			}
		}
		return false;
	}
}

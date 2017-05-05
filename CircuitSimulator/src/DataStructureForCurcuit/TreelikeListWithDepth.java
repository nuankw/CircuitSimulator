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
	
	public int getMaxDepth() {
		return maxDepth;
	}
	public ArrayList<NodeWithDepth<T>> getInventory() {
		return inventory;
	}
	
	public void add(T thisComponent, T[] prevComponents, T[] nextComponents, int toDepth) { 
		if (toDepth > maxDepth + 1) {
			// wish it would not happen
			System.out.println("Error triggled when adding a node to the LinkedListWithDepth. "
					+ "\nThe designated depth is not within the list scope "
					+ "(toDepth > maxDepth + 1).");
		}
		else {
			// create a new Node
			ArrayList<NodeWithDepth<T>> prevNodes = new ArrayList<>();
			ArrayList<NodeWithDepth<T>> nextNodes = new ArrayList<>();
			for (int i = 0; i < prevComponents.length; i++) {
				prevNodes.add(getNode_givenComponent(prevComponents[i]));
			}
			for (int i = 0; i < nextComponents.length; i++) {
				nextNodes.add(getNode_givenComponent(nextComponents[i]));
			}
			NodeWithDepth<T> newNode = new NodeWithDepth<T>(prevNodes, nextNodes, toDepth, thisComponent);
			
			// modify all prevNodes
			if (prevNodes.isEmpty()) {
				System.out.println("The given previous component is either a NULL, or not found. ");
				// set the head
				if (head.equals(null) & toDepth == 0) {
					head = newNode;
				}
			}
			else // has prevNode(s)
			{
				for (int i = 0; i < prevNodes.size();i++) {
					prevNodes.get(i).addDestination(newNode);
				}
			}
			
			// modify all nextNodes
			if (nextNodes.isEmpty()) {
				System.out.println("The given next component is either a NULL, or not found. ");
				// set the tail
				if (tail.equals(null) & toDepth == 0) {
					tail = newNode;
				}
			}
			else { // has nextNode(s)
				for (int i = 0; i < nextNodes.size();i++) {
					nextNodes.get(i).addParent(newNode);
				}
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
				// make change to the node's destinations (disconnect)
				ArrayList<NodeWithDepth<T>> theNexts = currentNode.getDestination();
				for (int i = 0; i < theNexts.size();i++) {
					theNexts.get(i).removeParent(currentNode);
				}
				// make change to the node's parent 
				ArrayList<NodeWithDepth<T>> thePrevs = currentNode.getParent();
				for (int i = 0; i < theNexts.size();i++) {
					thePrevs.get(i).removeDestination(currentNode);
				}
				// delete it
				iterator.remove();
				return true;
			}
		}
		return false;
		
		
	}
	
	public static void main(String[] args) {
		String batt1 = "batt1";
		String wire1 = "wire1";
		String wire2 = "wire2";
		String wire3 = "wire3";
		String res1 = "res1";
		String wire4 = "wire4";
		String res2 = "res2";
		String res3 = "res3";
		String wire5 = "wire5";
		String wire6 = "wire6";
		String wire7 = "wire7";
		
		TreelikeListWithDepth<String> circuit = new TreelikeListWithDepth<>();
		String[] forBatt1 = new String[1];
		forBatt1[0] = wire1;
		circuit.add(batt1, null, forBatt1, 0);
		
		String[] forWire1 = new String[1];
		forWire1[0] = wire2;
		circuit.add(wire1, null, forWire1, 0);
		
		String[] forWire2 = new String[1];
		forWire2[0] = wire3;
		circuit.add(wire2, null, forWire2, 0);
		
		String[] forWire3 = new String[1];
		forWire3[0] = res1;
		circuit.add(wire3, null, forWire3, 0);
		
		String[] forRes1 = new String[1];
		forRes1[0] = wire4;
		circuit.add(res1, null, forRes1, 0);
		
		String[] forWire4 = new String[2];
		forWire4[0] = res2;
		forWire4[1] = res3;
		circuit.add(wire4, null, forWire4, 0);
		
		String[] forRes2 = new String[1];
		forRes2[0] = wire5;
		circuit.add(res2, null, forRes2, 0);
		
		String[] forRes3 = new String[1];
		forRes3[0] = wire5;
		circuit.add(res3, null, forRes3, 0);
		
		String[] forWire5 = new String[1];
		forWire5[0] = wire6;
		circuit.add(wire5, null, forWire5, 0);
		
		String[] forWire6 = new String[1];
		forWire6[0] = wire7;
		circuit.add(wire6, null, forWire6, 0);
		
		String[] forWire7 = new String[1];
		forWire7[0] = batt1;
		circuit.add(wire7, null, forWire7, 0);
		
		
	}
}

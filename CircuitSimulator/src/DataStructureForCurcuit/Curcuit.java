package DataStructureForCurcuit;

import Components.AbstractComponent;

import java.util.ArrayList;
import java.util.Iterator;

public class Curcuit {
	private TreelikeListWithDepth<AbstractComponent> circuit = new TreelikeListWithDepth<>();
	public double calculateTotalResistance() {
		int maxDepth = circuit.getMaxDepth();
		Iterator<NodeWithDepth<AbstractComponent>> iterator = circuit.getInventory().iterator();
		while (iterator.hasNext()) {
			NodeWithDepth<Components.AbstractComponent> nodeWithDepth = (NodeWithDepth<Components.AbstractComponent>) iterator
					.next();
			
		}
		return 0;
	}
}

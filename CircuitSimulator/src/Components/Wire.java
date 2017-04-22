package Components;

import java.awt.Image;

public class Wire extends AbstractResistor{
	
	public Wire(double x, double y, boolean i, Image image, // component 
				double r, double c) { // resistor, no volt
		super(x, y, i, image, r, c, 0);
	}
	

}

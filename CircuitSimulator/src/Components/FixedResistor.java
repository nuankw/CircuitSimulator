package Components;

import java.awt.Image;

public class FixedResistor extends AbstractResistor{
	
	public FixedResistor(double x, double y, boolean i, Image image, 
						double r, double c, double v) {
		super(x, y, i, image, c, v, r);
	}
	
	@Override
	public void setResistance(double resistance) {
		// set empty on purpose (fixed r!)
	}
	

}

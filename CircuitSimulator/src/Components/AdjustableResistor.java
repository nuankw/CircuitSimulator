package Components;
import java.awt.Image;

public class AdjustableResistor extends AbstractResistor{
	
	double maxResistance;
	
	public AdjustableResistor(double x, double y, boolean i,Image image, // component
								double r, double c, double v, // resistor
								double m) {
		super(x, y, i,image, r, c, v);
		maxResistance = m;
	}
	public double getMaxResistance() {
		return maxResistance;
	}
	public void setMaxResistance(double maxResistance) {
		this.maxResistance = maxResistance;
	}
}

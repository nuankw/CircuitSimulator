package Components;
import java.awt.Image;

public class Bulb extends AbstractResistor{
	double powerLimit;
	public Bulb(double x, double y, boolean i, Image image,
				double r, double c, double v, 
				double p) {
		super(x, y, i,image, r, c, v);
		powerLimit = p; 
	}
	public double getPowerLimit() {
		return powerLimit;
	}
	public void setPowerLimit(double powerLimit) {
		this.powerLimit = powerLimit;
	}
}


public class Bulb extends Resistor{
	double powerLimit;
	public Bulb(double x, double y, boolean i, double r, double c, double v, double p) {
		super(x, y, i, r, c, v);
		powerLimit = p; 
	}
	public double getPowerLimit() {
		return powerLimit;
	}
	public void setPowerLimit(double powerLimit) {
		this.powerLimit = powerLimit;
	}
	
}

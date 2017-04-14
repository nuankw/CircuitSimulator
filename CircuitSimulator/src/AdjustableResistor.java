
public class AdjustableResistor extends Resistor{
	
	double maxResistance;
	
	public AdjustableResistor(double x, double y, boolean i, double r, double c, double v, double m) {
		super(x, y, i, r, c, v);
		maxResistance = m;
	}
	public double getMaxResistance() {
		return maxResistance;
	}
	public void setMaxResistance(double maxResistance) {
		this.maxResistance = maxResistance;
	}
}

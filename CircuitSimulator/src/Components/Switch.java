package Components;
import java.awt.Image;

public class Switch extends AbstractResistor{
	boolean isOn;
	
	public Switch(double x, double y, boolean i, Image image, // component
					double r, double c, double v, // resistor
				  boolean o) {
		super(x, y, i,image, r, c, v);
		isOn = o;
	}
	
	boolean isOn() {
		return isOn;
	}
	
	public void setOn(boolean isOn) {
		this.isOn = isOn;
		if (isOn) {
			this.setResistance(0);
		}
		else
		{
			this.setResistance(Double.MAX_VALUE);
		}
	}
	
}

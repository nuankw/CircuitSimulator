package Components;
import java.awt.Image;

public class Power extends AbstractComponent{
	double voltage;
	double maxPower;
	public Power(double x, double y, boolean i, Image image, double v, double m) {
		super(x, y, i, image);
		voltage = v;
		maxPower = m;
	}
	
	public double getMaxPower() {
		return maxPower;
	}
	public double getVoltage() {
		return voltage;
	}
	public void setMaxPower(double maxPower) {
		this.maxPower = maxPower;
	}
	public void setVoltage(double voltage) {
		this.voltage = voltage;
	}
}

package Components;
import java.awt.Image;

public abstract class AbstractResistor extends AbstractComponent{
	double resistance;
	double currenct;
	double volt;
	public AbstractResistor(double x, double y, boolean i, Image image, // component
							double r, double c, double v) { // resistor
		super(x, y, i, image);
		resistance = r;
		currenct = c;
		volt = v;
	}
	public double getCurrenct() {
		return currenct;
	}
	public double getResistance() {
		return resistance;
	}
	public double getVolt() {
		return volt;
	}
	public void setCurrenct(double currenct) {
		this.currenct = currenct;
	}
	public void setResistance(double resistance) {
		this.resistance = resistance;
	}
	public void setVolt(double volt) {
		this.volt = volt;
	}
}

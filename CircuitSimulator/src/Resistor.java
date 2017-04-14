
public class Resistor extends AbstractComponent{
	double resistance;
	double currenct;
	double volt;
	public Resistor(double x, double y, boolean i, double r, double c, double v) {
		super(x, y, i);
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

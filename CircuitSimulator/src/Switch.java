
public class Switch extends AbstractComponent{
	boolean isOn;
	
	public Switch(double x, double y, boolean r, boolean o) {
		super(x, y, r);
		isOn = o;
	}
	
	boolean isOn() {
		return isOn;
	}
	
	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}
	
}

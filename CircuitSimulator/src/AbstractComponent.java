//import java.util.ArrayList;

public abstract class AbstractComponent {
//	ArrayList<AbstractComponent> toThePos = new ArrayList<>();
//	ArrayList<AbstractComponent> toTheNeg = new ArrayList<>();
	double xPos;
	double yPos;
	final boolean isReal; // 0 if for Menu, 1 if real

	public double getxPos() {
		return xPos;
	}
	public double getyPos() {
		return yPos;
	}
	public void setxPos(double xPos) {
		this.xPos = xPos;
	}
	public void setyPos(double yPos) {
		this.yPos = yPos;
	}
	boolean isReal() {
		return isReal;
	}
	public AbstractComponent(double x, double y, boolean i) {
		xPos = x;
		yPos = y;
		isReal = i;
	}
		
}

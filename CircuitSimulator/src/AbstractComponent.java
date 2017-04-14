//import java.util.ArrayList;

public abstract class AbstractComponent {
//	ArrayList<AbstractComponent> toThePos = new ArrayList<>();
//	ArrayList<AbstractComponent> toTheNeg = new ArrayList<>();
	double xPos;
	double yPos;
	boolean isReal; // 0 if for Menu, 1 if real

	void setCoordinates(double x, double y) {
		xPos = x;
		yPos = y;
	}
	
	double[] getCoordinates() {
		double[] returnCor= {xPos,yPos};
		return returnCor;
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

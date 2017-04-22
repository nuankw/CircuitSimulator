package Components;
import java.awt.Image;
import java.util.ArrayList;

public abstract class AbstractComponent {
	// if multiple elements in lists, then they are all parallel
	ArrayList<AbstractComponent> fromList = new ArrayList<>(); 
	ArrayList<AbstractComponent> toList = new ArrayList<>();
	ArrayList<AbstractComponent> connected = new ArrayList<>();
	Image image;
	
	double xPos;
	double yPos;
	final boolean isReal; // 0 if for Menu, 1 if real
	
	public AbstractComponent(double x, double y, boolean i, Image image) {
		xPos = x;
		yPos = y;
		isReal = i;
		this.image = image;
	}
	public void addFromConnection(AbstractComponent from){
		fromList.add(from);
	}
	public void addToConnection(AbstractComponent to){
		toList.add(to);
	}
	// get set methods
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

		
}

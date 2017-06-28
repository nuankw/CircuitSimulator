package Levels;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;

// a note to front-end: notice the resetting part in setR

public class AbstractLevel{
	int size; 	//num for res1+res2+switch
	int level;
	// the confirmation switch is always the last one -basic level settings
	int size_r1; // num for resistor 1
	int size_r2; // num for resistor 2
	int size_s;	// num for switches (including the confirmation switch)
	int r1remaining;
	int r2remaining;
	int sremaining;
	BufferedImage image1;
	BufferedImage image2;
	// for check and calculation
	ArrayList<Double> r = new ArrayList<Double>();  // resistance for each "box"
	ArrayList<Integer> x = new ArrayList<Integer>(); // x position
	ArrayList<Integer> y = new ArrayList<Integer>(); // y position
	// new game-like features: need to discuss more!
	double r_wanted;
	double i_wanted;
	// constructor
	public AbstractLevel(int size) {
		this.size = size;
		for (int i = 0; i < size; i++) {
			r.add(Double.MIN_VALUE);
		}
	}
	// all get functions
	public int getLevel() {return level;}
	public ArrayList<Double> getR() {return r;}
	public int getR1remaining() {return r1remaining;}
	public int getR2remaining() {return r2remaining;}
	public double getRwanted() {return r_wanted;}
	public int getSremaining() {return sremaining;}
	public ArrayList<Integer> getX() {return x;}
	public ArrayList<Integer> getY() {return y;}
	public int getX(int pos) { return x.get(pos); }
	public int getY(int pos) { return y.get(pos); }
	public int getSize() {return size;}
	public int getSize_r1() {return size_r1; }
	public int getSize_r2() {return size_r2; }
	public int getSize_s() {return size_s; }
	public BufferedImage getImage1(){return image1;}
	public BufferedImage getImage2(){return image2;}
	
	// set and remove
	public boolean confirm() {
		// called when (pos == size - 1) && (res == 0)
		if (isFull()) {
			if (match()) { // full and correct
				//System.out.println("Great! You got it!");
				// ... level up maybe?
				return true;
			}
			else { // full, but not the exact circuit I want
				//System.out.println("Whoops! Something was wrong.");
				// ... punishment?
				return false;
			}
		}
		else { // not full yet
			//System.out.println("Whoops! You haven't finished the circuit yet.");
			// ... punishment? 
			return false;
		}
	}
	
	public void setR(int pos, double res) {
		if ((pos == size - 1) && (res == 0)) { // the user is confirming his/her completion 
			confirm();
		}
		else if (r.get(pos) == Double.MIN_VALUE) { // nothing there yet
			r.set(pos, res);
			if (res == 1) {
				r1remaining--;
			}
			else if (res == 2) {
				r2remaining--;
			}
			else if ((res == 0) || (res == Double.MAX_VALUE)) {
				sremaining--;
			}
			else {
				System.out.println("unknown input");
			}
		}
		else { // resetting 
			/*===front-end ATTENTION auto-return of components!===*/
			removeR(pos);
			setR(pos, res);
		}
	}
	
	public void removeR(int pos) {
		if (r.get(pos) != Double.MIN_VALUE) { // something has been created
			if (r.get(pos) == 1) {
				r1remaining++;
			}
			else if (r.get(pos) == 2) {
				r2remaining++;
			}
			else if ((r.get(pos) == 0) || (r.get(pos) == Double.MAX_VALUE)) {
				sremaining++;
			}
			r.set(pos,Double.MIN_VALUE);
		}
		else { // nothing there yet
			System.out.println("This position was initially empty");
		}
	}
	
	// check and calculate
	public boolean isFull() {
		for (int i = 0; i < size; i++) {
			if (r.get(i) == Double.MIN_VALUE) {
				return false;
			}
		}
		return true;
	}
	public double findRes(){return 0;}
	public boolean match() {
		if ((findRes() >= (r_wanted-0.01)) && (findRes() <= (r_wanted+0.01))) {
			return true;
		}
		return false;
	}
}

package Levels;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class Level1 extends AbstractLevel{

	/*
		(0)Left: 100, 93
		(1)Right top: 300, 45
		(2)Right bot: 300, 143
		(3)switch for confirmation Integer.MIN_VALUE, Integer.MIN_VALUE
	 */
	public Level1() {
		//SET POSITIONS HERE
		super(4);
		level = 1;
		size_r1 = 1;
		size_r2 = 2;
		size_s = 1;
		r1remaining = size_r1;
		r2remaining = size_r2;
		sremaining = size_s;
		r_wanted = 2.5;
		x.addAll(Arrays.asList(100,300,300,487)); // remember to change the last one!
		y.addAll(Arrays.asList(93,45,143,213));   // same
		this.setR(3, Double.MAX_VALUE);
		try {
			image1 = ImageIO.read(new File("src/levelImages/01-Off.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			image2 = ImageIO.read(new File("src/levelImages/01-On.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public double findRes() {
		assert(isFull());
		double finalRes;
		finalRes = r.get(0) + 1/(1/r.get(1) + 1/r.get(2));
		return finalRes;
	}
}

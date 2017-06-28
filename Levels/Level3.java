package Levels;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class Level3 extends AbstractLevel{
	/*
		(0)Left: 62, 100
		(1)Right top: 289, 2
		(2)Right mid: 285, 142
		(3)Right bot: 285, 212
		(4)switch for confirmation: 512,233
	 */
	
	public Level3() {
		super(5);
		level = 3;
		size_r1 = 2;
		size_r2 = 2;
		size_s = 1;
		r1remaining = size_r1;
		r2remaining = size_r2;
		sremaining = size_s;
		r_wanted = 1.5;
		x.addAll(Arrays.asList(62,289,285,285,512));
		y.addAll(Arrays.asList(100,2,142,212,233));
		this.setR(4, Double.MAX_VALUE);
		try {
			image1 = ImageIO.read(new File("src/levelImages/03-Off.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			image2 = ImageIO.read(new File("src/levelImages/03-On.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public double findRes() {
		assert(isFull());
		double finalRes;
		finalRes = r.get(0) + 1/(1/r.get(1) + 1/r.get(2) + 1/r.get(3));
		return finalRes;
	}
	
}

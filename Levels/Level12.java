package Levels;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class Level12 extends AbstractLevel {
	//(0)left-up		= 58, 65
	//(1)left-down		= 58, 242
	//(2)middle-up		= 221, 2
	//(3)middle-down	= 208, 138
	//(4)right-up		= 397, 16
	//(5)right-down		= 397, 118
	//(6)switch			= 522, 227
	public Level12() {
		super(7);
		level = 12;
		size_r1 = 2;
		size_r2 = 4;
		size_s = 1;
		r1remaining = size_r1;
		r2remaining = size_r2;
		sremaining = size_s;
		r_wanted = 4;
		x.addAll(Arrays.asList(58,58,221,208,397,397,522));
		y.addAll(Arrays.asList(65,242,2,138,16,118,227));
		this.setR(6, Double.MAX_VALUE);
		try {
			image1 = ImageIO.read(new File("src/levelImages/12-Off.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			image2 = ImageIO.read(new File("src/levelImages/12-On.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public double findRes() {
        double temp1 = 1/(1/r.get(2) + 1/r.get(3));
        double temp2 = 1 / (1 / (r.get(0) + temp1) + 1 / r.get(1));
		return temp2 + r.get(4) + r.get(5);
	}
}

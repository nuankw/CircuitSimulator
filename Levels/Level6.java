package Levels;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class Level6 extends AbstractLevel{

	/* 
		(0) Top left: 96, 13
		(1) Top right: 238, 13
		(2) 2nd row left: 44, 83
		(3) 2nd row right: 352, 84
		(4) 3rd row left: 44, 153
		(5) 3rd row right: 352, 154
		(6) switch for confirmation: 522, 227
	*/

	public Level6() {
		super(7);
		level = 6;
		size_r1 = 2;
		size_r2 = 4;
		size_s = 1;
		r1remaining = size_r1;
		r2remaining = size_r2;
		sremaining = size_s;
		r_wanted = 1;
		x.addAll(Arrays.asList(96,238,44,44,352,352,522));
		y.addAll(Arrays.asList(13,13,83,153,84,154,227));
		this.setR(6, Double.MAX_VALUE);
		try {
			image1 = ImageIO.read(new File("src/levelImages/06-Off.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			image2 = ImageIO.read(new File("src/levelImages/06-On.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public double findRes() {
		assert(isFull());
		double temp1 = r.get(0) + r.get(1);
		double temp2 = 1 / ((1 / r.get(2)) + (1 / r.get(3)));
		double temp3 = 1 / ((1 / r.get(4)) + (1 / r.get(5)));
		double finalRes = 1 / ( 1 / temp1 + (1/(temp2 + temp3)) );
		return finalRes;
	}

}

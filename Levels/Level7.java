package Levels;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class Level7 extends AbstractLevel{
/*
	(0) Left top: 44, 11
	(1) Left 2nd row: 44, 83
	(2) Left bot: 44, 153
	(3) Right top: 352, 12
	(4) Right 2nd row: 352, 84
	(5) Right bot: 352, 154
	(6) switch for confirmation: 522, 227
*/ 

	public Level7() {
		super(7);
		level = 7;
		size_r1 = 3;
		size_r2 = 3;
		size_s = 1;
		r1remaining = size_r1;
		r2remaining = size_r2;
		sremaining = size_s;
		r_wanted = 1;
//		r_wanted = -1;
		x.addAll(Arrays.asList(44,44,44,352,352,352,522));
		y.addAll(Arrays.asList(11,83,153,12,84,154,227));
		this.setR(6, Double.MAX_VALUE);
		try {
			image1 = ImageIO.read(new File("src/levelImages/07-Off.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			image2 = ImageIO.read(new File("src/levelImages/07-On.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public double findRes() {
		assert(isFull());
		double finalRes;
		double temp1, temp2, temp3, temp4;
		double R1 = r.get(0), R2 = r.get(1), R3 = 0, R4 = r.get(3), R5 = r.get(4);
		temp1 = R1*R2*R3 + R1*R2*R4 + R1*R2*R5 + R1*R3*R5 + R1*R4*R5 + R2*R3*R4 + R2*R4*R5 + R3*R4*R5;
		temp2 = R1*R3 + R1*R4 + R1*R5 + R2*R3 + R2*R4 + R2*R5 + R3*R4 + R3*R5;
		temp3 = (temp1 / temp2);
		temp4 = r.get(2) + r.get(5);
		finalRes = 1/(1/temp3 + 1/temp4);
		return finalRes;
//		return -1;
	}

}

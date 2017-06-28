package Levels;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class Level11 extends AbstractLevel{
	/*
		(0) Left top: 44, 11
		(1) Left bot: 45, 123
		(2) Mid: 206, 67
		(3) Right top: 352, 12
		(4) Right bot: 352, 124
		(5) switch for confirmation: 522, 227
	*/


	public Level11() {
		super(6);
		level = 11;
		size_r1 = 2;
		size_r2 = 3;
		size_s = 1;
		r1remaining = size_r1;
		r2remaining = size_r2;
		sremaining = size_s;
		r_wanted = 1.5;
//		r_wanted = -1;
		x.addAll(Arrays.asList(44,45,206,352,352,522));
		y.addAll(Arrays.asList(11,123,67,12,124,227));
		this.setR(5, Double.MAX_VALUE);
		try {
			image1 = ImageIO.read(new File("src/levelImages/11-Off.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			image2 = ImageIO.read(new File("src/levelImages/11-On.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public double findRes() {
		assert(isFull());
		double finalRes;
		double temp1, temp2;
		double R1 = r.get(0), R2 = r.get(1), R3 = r.get(2), R4 = r.get(3), R5 = r.get(4);
		temp1 = R1*R2*R3 + R1*R2*R4 + R1*R2*R5 + R1*R3*R5 + R1*R4*R5 + R2*R3*R4 + R2*R4*R5 + R3*R4*R5;
		temp2 = R1*R3 + R1*R4 + R1*R5 + R2*R3 + R2*R4 + R2*R5 + R3*R4 + R3*R5;
		finalRes = (temp1 / temp2);
		return finalRes;
//		return -1;
	}

}

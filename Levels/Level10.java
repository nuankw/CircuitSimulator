package Levels;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class Level10 extends AbstractLevel{
	//(0)up				= 97, 15
	//(1)middle-left	= 54, 95
	//(2)middle-middle	= 198, 95
	//(3)middle-right	= 349, 95
	//(4)down			= 273, 167
	//(5)switch			= 522, 227
	public Level10() {
		super(6);
		level = 10;
		size_r1 = 4;
		size_r2 = 1;
		size_s = 1;
		r1remaining = size_r1;
		r2remaining = size_r2;
		sremaining = size_s;
		r_wanted = 1;
		x.addAll(Arrays.asList(97,54,198,349,273,522));
		y.addAll(Arrays.asList(15,95,95,95,167,227));
		this.setR(5, Double.MAX_VALUE);
		try {
			image1 = ImageIO.read(new File("src/levelImages/10-Off.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			image2 = ImageIO.read(new File("src/levelImages/10-On.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public double findRes() {
		assert(isFull());
		double finalRes;
		double temp1, temp2;
		double R3 = r.get(0), R2 = r.get(1), R1 = r.get(2), R4 = r.get(3), R5 = r.get(4);
		temp1 = R1*R2*R3 + R1*R2*R4 + R1*R2*R5 + R1*R3*R5 + R1*R4*R5 + R2*R3*R4 + R2*R4*R5 + R3*R4*R5;
		temp2 = R1*R3 + R1*R4 + R1*R5 + R2*R3 + R2*R4 + R2*R5 + R3*R4 + R3*R5;
		finalRes = (temp1 / temp2);
		return finalRes;
	}

}

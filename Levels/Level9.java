package Levels;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class Level9 extends AbstractLevel{
	//(0)left		= 54, 67
	//(1)middle		= 198, 67
	//(2)right		= 349, 67
	//(3)switch		= same (522, 227)
	public Level9() {
		super(4);
		level = 9;
		size_r1 = 1;
		size_r2 = 2;
		size_s = 1;
		r1remaining = size_r1;
		r2remaining = size_r2;
		sremaining = size_s;
		r_wanted = 0.5;
		x.addAll(Arrays.asList(54,198,349,522));
		y.addAll(Arrays.asList(67,67,67,227));
		this.setR(3, Double.MAX_VALUE);
		try {
			image1 = ImageIO.read(new File("src/levelImages/09-Off.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			image2 = ImageIO.read(new File("src/levelImages/09-On.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public double findRes() {
		assert(isFull());
		return 1 / (1 / r.get(0) + 1 / r.get(1) + 1 / r.get(2));
	}
}

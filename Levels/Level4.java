package Levels;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class Level4 extends AbstractLevel {
	//(0)up			= 219, 45
	//(1)mid		= 219, 108
	//(2)down		= 218, 169
	//(3)switch		= same (522, 227)
	public Level4() {
		super(4);
		level = 4;
		size_r1 = 1;
		size_r2 = 2;
		size_s = 1;
		r1remaining = size_r1;
		r2remaining = size_r2;
		sremaining = size_s;
		r_wanted = 0.5;
		x.addAll(Arrays.asList(219,219,218,522));
		y.addAll(Arrays.asList(45,108,169,227));
		this.setR(3, Double.MAX_VALUE);
		try {
			image1 = ImageIO.read(new File("src/levelImages/04-Off.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			image2 = ImageIO.read(new File("src/levelImages/04-On.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public double findRes() {
		return 1 / (1 / r.get(0) + 1 / r.get(1) + 1 / r.get(2));
	}
}

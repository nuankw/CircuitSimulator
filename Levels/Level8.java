package Levels;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;

public class Level8 extends AbstractLevel{
//	(0) Top: 238,13
//	(1) 2nd row left: 97, 169 
//	(2) 2nd row right: 239, 169
//	(3) Bot: 267, 276
//	(4) Switch: 522, 227
	public Level8() {
		super(5);
		level = 8;
		size_r1 = 1;
		size_r2 = 3;
		r1remaining = size_r1;
		r2remaining = size_r2;
		sremaining = size_s;
		r_wanted = 0.75;
		x.addAll(Arrays.asList(238,97,239,267,522));
		y.addAll(Arrays.asList(13,169,169,276,227));
		this.setR(4, Double.MAX_VALUE);
		try {
			image1 = ImageIO.read(new File("src/levelImages/08-Off.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			image2 = ImageIO.read(new File("src/levelImages/08-On.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public double findRes() {
		return 1 / (1 / r.get(0) + 1 / (r.get(1) + r.get(2)) + 1 / r.get(3));
	}

}

package Levels;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class Level5 extends AbstractLevel{
//		Circuit lv4:
//		(0) Left top: 102, 2
//		(1) Left 2nd row: 101, 77
//		(2) Left 3rd row: 101, 147
//		(3) Left bot: 101, 207
//		(4) Right top: 354, 1
//		(5) Right 2nd row: 350, 141
//		(6) Right bot: 350, 211
//		(7) Switch: 521, 218
	
	public Level5() {
		super(8);
		level = 5;
		size_r1 = 1;
		size_r2 = 6;
		size_s = 1;
		r1remaining = size_r1;
		r2remaining = size_r2;
		sremaining = size_s;
		r_wanted = 1;
		x.addAll(Arrays.asList(102,101,101,101,354,350,350,521));
		y.addAll(Arrays.asList(2,77,147,207,1,141,211,218));
		this.setR(7, Double.MAX_VALUE);
		try {
			image1 = ImageIO.read(new File("src/levelImages/05-Off.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			image2 = ImageIO.read(new File("src/levelImages/05-On.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public double findRes() {
		assert(isFull());
		double finalRes;
		double temp1, temp2;
		temp1 = 1/r.get(0) + 1/r.get(1) + 1/r.get(2) + 1/r.get(3);
		temp2 = 1/r.get(4) + 1/r.get(5) + 1/r.get(6);
		finalRes = (1/temp1) + (1/temp2);
		return finalRes;
	}

}

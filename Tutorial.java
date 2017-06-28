import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Tutorial {
	ArrayList<BufferedImage> imageset = new ArrayList<BufferedImage>();
	int currentTut;
	BufferedImage tutorial1;
	BufferedImage tutorial2;
	BufferedImage tutorial3;
	BufferedImage tutorial4;
	BufferedImage tutorial5;
	public Tutorial(){
		currentTut = 0;
		try {
			tutorial1 = ImageIO.read(new File("src/images/1st.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			tutorial2 = ImageIO.read(new File("src/images/2nd.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			tutorial3 = ImageIO.read(new File("src/images/3rd.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			tutorial4 = ImageIO.read(new File("src/images/4th.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			tutorial5 = ImageIO.read(new File("src/images/5th.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		imageset.add(tutorial1);
		imageset.add(tutorial2);
		imageset.add(tutorial3);
		imageset.add(tutorial4);
		imageset.add(tutorial5);
	}
	public BufferedImage getImage(int i){
		return imageset.get(i);
	}
	public int getcurrentTut(){
		return currentTut;
	}
	public void set_currentTut(int i){
		currentTut = i;
	}
	public void next(){
		currentTut ++;
	}
}

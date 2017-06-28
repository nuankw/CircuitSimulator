
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class PartsImage {
	ArrayList<BufferedImage> imageset = new ArrayList<BufferedImage>();
	ArrayList<String> image_name =new ArrayList<String>();
	BufferedImage background;
	BufferedImage resistor1;
	BufferedImage resistor2;
	 public PartsImage(){
		 try {
				resistor1 = ImageIO.read(new File("src/images/Resistor1.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		 try {
				resistor2 = ImageIO.read(new File("src/images/Resistor2.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		 try {
				background = ImageIO.read(new File("src/images/Background.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		 this.imageset.add(resistor1);
		 this.image_name.add("1 ohm Resistor");
		 this.imageset.add(resistor2);
		 this.image_name.add("2 ohm Resistor");

	 }
	 public int get_size(){
		 return this.imageset.size();
	 }
	 
}

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class PartsImage {
	ArrayList<Image> imageset = new ArrayList<Image>();
	Image resistor; 
	 public PartsImage(){
		 try {
				resistor = ImageIO.read(new File("images/resistor5.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		 this.imageset.add(resistor);
		 
	 }
}

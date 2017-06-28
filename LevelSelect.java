import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import Levels.AbstractLevel;

public class LevelSelect {
	private  ArrayList<BufferedImage> lockImage = new ArrayList<>();
	private int unlockNum;
	private boolean transition = false;
	BufferedImage LevelSelectLocked1;
	BufferedImage LevelSelectLocked2;
	BufferedImage LevelSelectLocked3;
	BufferedImage LevelSelectLocked4;
	BufferedImage LevelSelectLocked5;
	BufferedImage LevelSelectLocked6;
	BufferedImage LevelSelectLocked7;
	BufferedImage LevelSelectLocked8;
	BufferedImage LevelSelectLocked9;
	BufferedImage LevelSelectLocked10;
	BufferedImage LevelSelectLocked11;
	BufferedImage LevelSelectLocked12;
	
	public LevelSelect(){
		try {
			LevelSelectLocked1 = ImageIO.read(new File("src/images/LevelSelectLocked1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			LevelSelectLocked2 = ImageIO.read(new File("src/images/LevelSelectLocked2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			LevelSelectLocked3 = ImageIO.read(new File("src/images/LevelSelectLocked3.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			LevelSelectLocked4 = ImageIO.read(new File("src/images/LevelSelectLocked4.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			LevelSelectLocked5 = ImageIO.read(new File("src/images/LevelSelectLocked5.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			LevelSelectLocked6 = ImageIO.read(new File("src/images/LevelSelectLocked6.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			LevelSelectLocked7 = ImageIO.read(new File("src/images/LevelSelectLocked7.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			LevelSelectLocked8 = ImageIO.read(new File("src/images/LevelSelectLocked8.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			LevelSelectLocked9 = ImageIO.read(new File("src/images/LevelSelectLocked9.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			LevelSelectLocked10 = ImageIO.read(new File("src/images/LevelSelectLocked10.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			LevelSelectLocked11 = ImageIO.read(new File("src/images/LevelSelectLocked11.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			LevelSelectLocked12 = ImageIO.read(new File("src/images/LevelSelectLocked12.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.lockImage.add(LevelSelectLocked1);
		this.lockImage.add(LevelSelectLocked2);
		this.lockImage.add(LevelSelectLocked3);
		this.lockImage.add(LevelSelectLocked4);
		this.lockImage.add(LevelSelectLocked5);
		this.lockImage.add(LevelSelectLocked6);
		this.lockImage.add(LevelSelectLocked7);
		this.lockImage.add(LevelSelectLocked8);
		this.lockImage.add(LevelSelectLocked9);
		this.lockImage.add(LevelSelectLocked10);
		this.lockImage.add(LevelSelectLocked11);
		this.lockImage.add(LevelSelectLocked12);
		
	}
	public BufferedImage getImage(int i){
		return lockImage.get(i);
	}
	public void setlock(int i){
		unlockNum = i;
	}
	public int checkCor (int x, int y){ //30,37 / 110, 73 / 145 (gap)
		int num = 0;
		for (int i = 0; i < 12; i++){
			if (i < 6){
				if (x>(30+i*145)&& x<(140+i*145) && y>37 && y<110)
				{
					if (i> unlockNum)
					{
						JOptionPane.showMessageDialog(null, "You have not unlock this level yet", "Illegal Selection", JOptionPane.ERROR_MESSAGE);
						break;
					}
					num = i;
					transition = true;
					return num;
				}
			}
			else {
				if (x>(30+(i-6)*145)&& x<(140+(i-6)*145) && y > 149 && y < 220){
					if (i> unlockNum)
					{
						JOptionPane.showMessageDialog(null, "You have not unlock this level yet", "Illegal Selection", JOptionPane.ERROR_MESSAGE);
						break;
					}
					num = i;
					transition = true;
					return num;
				}
			}
		}
		transition = false;
		return -1;
	}
	public boolean get_transition(){
		return transition;
	}
}

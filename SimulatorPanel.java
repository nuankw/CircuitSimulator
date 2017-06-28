
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import Levels.*;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;

public class SimulatorPanel extends JPanel implements MouseListener, MouseMotionListener{
	public static final int WIDTH = 900;
	public static final int HEIGHT = 600;
	public static final int menu_Width = 100;
	public static final int menu_parts_height = 50;
	public static final int menu_text_height = 10;
	public static final int circuit_offsetX = 200;
	public static final int circuit_offsetY = 100;
	public static final int box_width = 100;
	public static final int box_height = 49;
	public static final int switchWidth = 24;
	public static final int switchHeight = 26;
	
	PartsImage partsimage = new PartsImage();
	ArrayList<Integer> newPartsX = new ArrayList<Integer>();
	ArrayList<Integer> newPartsY = new ArrayList<Integer>();
	ArrayList<Integer> newPartsIndex = new ArrayList<Integer>();
	LevelSelect levSel = new LevelSelect();
	int gameState = 0;
	int levelIndex = 0;
	int motionX;
	int motionY;
	int motionIndex = -1;
	boolean newGame = false;
	SwitchPanel sw = new SwitchPanel();
//	SwitchPanelListenser swl= new SwitchPanelListenser(); 
	static int choice = -1;
	static int level = 1;
	static boolean popup = false;
	static boolean comp = false;
	static Boolean swi = false;
	static Boolean swi_GUI = false;
	static int temp1 = 0;
	boolean reset = false;
	boolean complete = false;
	All_Levels a_l;
	AbstractLevel currentLevel;
	Tutorial tutorial = new Tutorial();
	public SimulatorPanel() {
		super();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		//setBackground(Color.BLACK);
		setFocusable(true);
		setDoubleBuffered(true);
		try{
		    ObjectInputStream is = new ObjectInputStream(new FileInputStream("All_Levels.ser"));
		    a_l = (All_Levels) is.readObject();
		    int temp = a_l.level_complete();
		    a_l = new All_Levels();
		    a_l.level_unlock(temp);}
		catch (Exception ex){
		    a_l = new All_Levels();}
		currentLevel = a_l.getLevel(levelIndex);
		requestFocus();
		setBackground(new Color(255,225,128));
		sw.addMouseListener(new SwitchPanelListenser());
		sw.setVisible(false);
		this.add(this.sw);
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g2);

		if(gameState == 0) { // Start Screen
			BufferedImage startScreen = null;
			try {
				startScreen = ImageIO.read(new File("src/images/StartScreen.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}			
			g2.drawImage(startScreen, 0, 0, null);
		}
		else if(gameState == 1) { // Start menu
			BufferedImage menu = null;
			try {
				menu = ImageIO.read(new File("src/images/Menu.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}			
			g2.drawImage(menu, 0, 0, null);
		}
		else if(gameState == 2 ) { // New Game
			currentLevel = a_l.getLevel(levelIndex);
			sw.setVisible(true);
			initialDraw(g2, levelIndex, swi);
			drawNewparts(g2);
			if (motionIndex != -1)
			{drawPartsNow(g2);}
			sw.setBounds(currentLevel.getX(currentLevel.getSize()-1) + circuit_offsetX, currentLevel.getY(currentLevel.getSize()-1) + circuit_offsetY, switchWidth, switchHeight);	
//			sw.addMouseListener(new SwitchPanelListenser());
			this.add(this.sw);
			g2.dispose();
		}
		else if(gameState == 3) { // Continue Game
			if (levelIndex <= 0 && newGame == false){
			currentLevel = a_l.getLevel(a_l.level_complete());
			levelIndex = a_l.level_complete();}

			sw.setVisible(true);
			initialDraw(g2, levelIndex, swi);
			drawNewparts(g2);
			if (motionIndex != -1)
			{drawPartsNow(g2);}
			sw.setBounds(currentLevel.getX(currentLevel.getSize()-1) + circuit_offsetX, currentLevel.getY(currentLevel.getSize()-1) + circuit_offsetY, switchWidth, switchHeight);	
//			sw.addMouseListener(new SwitchPanelListenser());
//			this.add(this.sw);
			g2.dispose();
		}
		else if(gameState == 4) { // Level Select
			BufferedImage menu = null;
			levSel.setlock(a_l.level_complete());
			menu = levSel.getImage(a_l.level_complete());
			g2.drawImage(menu, 0, 0, null);
		}
		else if(gameState == 5) { // Exit
			System.exit(0);
		}
		else if (gameState == 6){ // Tutorial
			BufferedImage tut= null;
			tut = tutorial.getImage(tutorial.getcurrentTut());
			g2.drawImage(tut, 0, 0, null);
		}
	}

	private void drawPartsNow(Graphics2D g2) {
		g2.drawImage(partsimage.imageset.get(motionIndex), motionX, motionY, null);
	}

	private void drawNewparts(Graphics2D g2) {
		for (int i = 0; i < newPartsIndex.size(); i++)
		{g2.drawImage(partsimage.imageset.get(newPartsIndex.get(i)),newPartsX.get(i),newPartsY.get(i), null);}
		
	}

	private void initialDraw(Graphics2D g2, int levelIndex, Boolean swi) {
		//System.out.println(swi);
		int partsSize = partsimage.imageset.size();
		g2.drawImage(partsimage.background, 0,0,null);
		Font default_font = g2.getFont();
		g2.setFont(new Font("Futra", 1, 48));
		g2.setColor(new Color(255, 88, 23));
		g2.drawString(Double.toString(currentLevel.getRwanted()), 400, 68);
		g2.setFont(new Font("Futra", 1, 36));
		g2.drawString(Integer.toString(currentLevel.getLevel()), 470, 568);
		g2.setFont(default_font);
		g2.setColor(Color.BLACK);
		for (int i = 0; i < partsSize; i++){
			g2.drawImage(partsimage.imageset.get(i), 0, 200+30*(i+1)+i*(menu_parts_height+menu_text_height) + (menu_parts_height-partsimage.imageset.get(i).getHeight()) / 2, null);
			g2.setFont(new Font("Futra", 1, 20));
			g2.drawString(partsimage.image_name.get(i), 0, 200+40*(i+1)+(i+1)*(menu_parts_height+menu_text_height));
			g2.setFont(default_font);
			if (swi == false) {
				//System.out.println("1");
				g2.drawImage(currentLevel.getImage1(), circuit_offsetX, circuit_offsetY,null);
			}
			else if (swi == true) {
				//System.out.println("2");
				g2.drawImage(currentLevel.getImage2(), circuit_offsetX, circuit_offsetY,null);
			}
		}
		if(swi_GUI == false && swi == true) {
			swi_GUI = true;
		}
		if(swi_GUI == true && swi == false) {
			swi_GUI = false;
			choice = -1;
		}
		//System.out.println(level + " " + currentLevel.getLevel());
		if(level + 1 == currentLevel.getLevel()) {
			level += 1;
			choice = -1;
		}
	}
	
	public void checkCorPic(int x, int y){
		for (int i = 0; i < partsimage.get_size() ; i++)
		{if ( 200+30*i+i*(menu_parts_height + menu_text_height) < y  && y < 200+30*i+(i+1)*(menu_parts_height + menu_text_height))
				{motionIndex = i;
				break;}
			}
		}
	public int checkCollsion (int x, int y, AbstractLevel currentLevel){
		for (int i = 0; i < currentLevel.getSize() - currentLevel.getSize_s() ; i++)
			{
				if (checkCorFCollsion(x,y,i))
				{
	    			return i;
				}
			}
		if (motionIndex != -1){
		JOptionPane.showMessageDialog(null, "Illegal position to release.", "Illegal Move", JOptionPane.ERROR_MESSAGE);}
		return -1;
	}
	public Boolean checkCorFCollsion(int x, int y, int i){
		Boolean collision = false;
		if (x>currentLevel.getX(i)+circuit_offsetX && x<currentLevel.getX(i)+box_width+circuit_offsetX &&
				y>currentLevel.getY(i)+circuit_offsetY && y< currentLevel.getY(i)+box_height+circuit_offsetY){
			return true;
		}
		return collision;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(gameState == 0) {
			if(e.getX()>285 && e.getY() > 320 && e.getX() < 618 && e.getY() < 404)
			{gameState = 1;}
			else if (e.getX()>285 && e.getY() > 447 && e.getX() < 618 && e.getY() < 531){
			gameState = 6;
			}
		}
		else if(gameState == 1) {
			if(e.getX() > 230 && e.getX() < 670 && e.getY() > 140 && e.getY() < 219) {
				levelIndex = 0;
				newGame = true;
				gameState = 2;

			}
			else if(e.getX() > 230 && e.getX() < 670 && e.getY() > 250 && e.getY() < 329) {
				gameState = 3;
			}
			else if(e.getX() > 230 && e.getX() < 670 && e.getY() > 360 && e.getY() < 439) {
				gameState = 4;
			}
			else if(e.getX() > 230 && e.getX() < 670 && e.getY() > 470 && e.getY() < 549) {
				gameState = 5;
			}
		}
		else if (gameState == 4) {
			if(e.getX() > 29 && e.getX() < 246 && e.getY() > 508 && e.getY() < 576) {
				gameState = 1;
			}
			levelIndex = levSel.checkCor(e.getX(), e.getY());
			if (levelIndex != -1 && levSel.get_transition())
				{
				currentLevel = a_l.getLevel(levelIndex);
				gameState = 3;
				}
			else {
				levelIndex = currentLevel.getLevel();
			}
			
		}
		else if (gameState == 2 || gameState ==3){
			if(e.getX()>0 && e.getX()<200 && e.getY()>500 && e.getY()<600)
			{
				gui_reset();
			}
			else if (e.getX()>700 && e.getX()<900 && e.getY()>500 && e.getY()<600){
				gameState = 1;
				levelIndex = 0;
				sw.setVisible(false);
				gui_reset();
			}
			
		}
		else if (gameState == 6){
			if (tutorial.getcurrentTut() == 4){
				JOptionPane.showMessageDialog(null, "This is the end of tutorial", "Tutorial", JOptionPane.INFORMATION_MESSAGE);
				tutorial.set_currentTut(0);
				gameState = 0;
			}
			else {
				tutorial.next();
			}
		}
		// TODO Auto-generated method stub	
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		int boxIndex = checkCollsion(x, y, currentLevel);
		int res = 0;
		if (motionIndex == 0){res = 1;}
		else if (motionIndex == 1){res = 2;}
		if (x>menu_Width && motionIndex != -1 && boxIndex != -1){
			newPartsIndex.add(motionIndex);
			newPartsX.add(currentLevel.getX(boxIndex)+circuit_offsetX);
			newPartsY.add(currentLevel.getY(boxIndex)+circuit_offsetY);
			currentLevel.setR(boxIndex, res);
		}
		motionIndex = -1;
		this.repaint();
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		if (motionIndex != -1)
		{motionX= 0;
		motionY = 0;
		motionIndex = -1;
		JOptionPane.showMessageDialog(null, "You cannot go out the frame.", "Illegal Move", JOptionPane.ERROR_MESSAGE);}
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		if (x < menu_Width)
		{checkCorPic(x,y);}
		motionX = x - 50;
		motionY = y - 25;
		this.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	private void gui_reset() {
		newPartsX.clear();
		newPartsY.clear();
		newPartsIndex.clear();
		this.repaint();
	}
	private class SwitchPanelListenser implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			if(swi == false && popup == false) {
				swi = true;
				popup = true;
				System.out.println(currentLevel.findRes());
				System.out.println(currentLevel.match());
				System.out.println(currentLevel.isFull());
				boolean complete = currentLevel.confirm();
				if(complete) {
					if (levelIndex == (a_l.getNum()-1))
					{	choice = JOptionPane.showOptionDialog(null, "Congratulations, you have completed all the levels", "Level Complete", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"Return"}, null);
						swi = false;
						sw.setVisible(false);
						gui_reset();
						gameState = 1;
					}
					else
					{
					choice = JOptionPane.showOptionDialog(null, "Great! You Got it!", "Level Complete", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"Level Up"}, null);
					swi = false;
					levelIndex++;
					currentLevel = a_l.getLevel(levelIndex);
					a_l.level_unlock(levelIndex);
					try{
						FileOutputStream fos = new FileOutputStream("All_Levels.ser");
						ObjectOutputStream os = new ObjectOutputStream(fos);
						os.writeObject(a_l);
						os.close();}
						catch(IOException ex){ex.printStackTrace();}}
					gui_reset();}
				else {
					choice = JOptionPane.showOptionDialog(null, "Whoops! Something was wrong.", "Level Incomplete",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE,null, new Object[]{"Try Again"},null);
					swi = false;
				}
			}
			else if (choice == 0) {
			}
			else {
				popup = false;
			}
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub	
		}
	}
}

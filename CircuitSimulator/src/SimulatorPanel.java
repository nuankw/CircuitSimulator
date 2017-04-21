import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.BasicStroke;
import java.awt.Color;

public class SimulatorPanel extends JPanel implements MouseListener, MouseMotionListener{
	public static final int WIDTH = 900;
	public static final int HEIGHT = 600;
	Boolean NewParts = false;
	PartsImage partsimage = new PartsImage();
	ArrayList<Integer> newPartsX = new ArrayList<Integer>();
	ArrayList<Integer> newPartsY = new ArrayList<Integer>();
	ArrayList<Integer> newPartsIndex = new ArrayList<Integer>();
	int motionX;
	int motionY;
	int motionIndex = -1;
	public SimulatorPanel() {
		super();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		//setBackground(Color.BLACK);
		setFocusable(true);
		setDoubleBuffered(true);
		requestFocus();
		//addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g2);
		
		initialDraw(g2);
		
		
		drawNewparts(g2);
		if (motionIndex != -1)
		{drawPartsNow(g2);}
		g2.dispose();
	}
	
	private void drawPartsNow(Graphics2D g2) {
		// TODO Auto-generated method stub
		g2.drawImage(partsimage.imageset.get(motionIndex), motionX, motionY, null);
	}

	private void drawNewparts(Graphics2D g2) {
		for (int i = 0; i < newPartsIndex.size(); i++)
		{g2.drawImage(partsimage.imageset.get(newPartsIndex.get(i)),newPartsX.get(i),newPartsY.get(i), null);}
		
	}

	private void initialDraw(Graphics2D g2) {
		int partsSize = partsimage.imageset.size();
		for (int i = 0; i < partsSize; i++){
		g2.drawImage(partsimage.imageset.get(i), 0, i*50, null);}
	}

	
	
	
	public void checkCorPic(int x, int y){
		if(0 < x && x < 100){
		for (int i = 0; i < partsimage.imageset.size() ; i++)
		{if ( i*50 < y  && y < (i+1)*50)
			{
				motionIndex = i;
				break;
			}
		}}
		/*else if ((newPartsX.size() + 1) == newPartsIndex.size() && x > 100)
		{newPartsX.add(x);
		newPartsY.add(y);
		NewParts = true;}*/
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
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
		if (x>100 && motionIndex != -1){
			newPartsIndex.add(motionIndex);
			newPartsX.add(x);
			newPartsY.add(y);
			
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		if (x < 100)
		{checkCorPic(x,y);}
		motionX = x;
		motionY = y;
		this.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

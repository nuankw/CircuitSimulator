import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.BasicStroke;

public class SimulatorPanel extends JPanel{
	public static final int WIDTH = 900;
	public static final int HEIGHT = 600;
	public SimulatorPanel() {
		super();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		//setBackground(Color.BLACK);
		setFocusable(true);
		setDoubleBuffered(true);
		requestFocus();
		
		//addKeyListener(this);
		//addMouseListener(this);
		//addMouseMotionListener(this);
	}
}

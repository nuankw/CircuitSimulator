
import javax.swing.JFrame;

public class SimulatorDriver {
	public static void main(String[] args) throws InterruptedException{
		JFrame Window = new JFrame("Circuit Simulator");
		SimulatorPanel Panel = new SimulatorPanel();
		Window.setContentPane(Panel);
		Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Window.setResizable(false);
		Window.pack();
		Window.setLocationRelativeTo(null);
		Window.setVisible(true);
		while(true){
			//Panel.update();
			Panel.repaint();
			Thread.sleep(1000 / 60); 
		}	
	}
}

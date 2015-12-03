package foxman.pi;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class PiFrame extends JFrame{
	
	public PiFrame(){
		
		setTitle("Pi");
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container container = getContentPane();
		JLabel label = new JLabel("Pi Calculation in progress.");
		container.add(label);
		
		PiCalculationThread thread = new PiCalculationThread(label);
		
		thread.start();
		
	
	}
	
	public static void main (String[] arg){
		new PiFrame().setVisible(true);
	}

}

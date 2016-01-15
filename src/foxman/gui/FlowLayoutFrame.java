package foxman.gui;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FlowLayoutFrame extends JFrame{
	public FlowLayoutFrame(){
		
		setTitle("WEATHER");
		setSize(700, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		setLayout(new FlowLayout(FlowLayout.CENTER, 50,3));
		
		JLabel label = new JLabel("Hello");
		JButton button = new JButton("Whats up??");
		JLabel labelTwo = new JLabel("Ahuva");
		JLabel labelr = new JLabel("Hello");
		JButton buttonv = new JButton("Whats up??");
		JLabel labelTwoc = new JLabel("Ahuva");
		JLabel labelx = new JLabel("Hello");
		JButton buttonr = new JButton("Whats up??");
		JLabel labelTwow = new JLabel("Ahuva");
		add(label);
		add(button);
		add(labelTwo);
		
		add(labelr);
		add(buttonv);
		add(labelTwoc);
		add(labelx);
		add(buttonr);
		add(labelTwow);
		
		
		
	}
	
	public static void main(String[] args){
		new FlowLayoutFrame().setVisible(true);
	}
	
}



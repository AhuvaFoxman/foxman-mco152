package foxman.connectFour;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ConnectFourComponent extends JPanel{
	
	public ConnectFourComponent(){
		
	}

	protected void paintComponent(Graphics g, String color) {
		
		super.paintComponent(g);
		
		g.setColor(Color.getColor(color));
		g.drawOval(50, 50, 100, 100);
	}
	

}

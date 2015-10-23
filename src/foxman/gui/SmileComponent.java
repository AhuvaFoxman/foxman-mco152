package foxman.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileComponent extends JComponent {

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.setColor(Color.yellow);
		g.fillOval(210, 100, 300, 300);
		
		g.setColor(Color.BLUE);
		g.fillOval(275, 175, 50, 50);
		
		g.setColor(Color.BLUE);
		g.fillOval(375,175,50,50);
		
		g.setColor(Color.GREEN);
		g.fillOval(387,187,25,25);
		
		g.setColor(Color.GREEN);
		g.fillOval(287,187,25,25);
		
		g.setColor(Color.RED);
		g.fillArc(260, 180, 200, 200, 180, 180);
		
		//make teeth
		g.setColor(Color.white);
		g.fillRect(335, 280, 15, 20);
		
		
		g.setColor(Color.white);
		g.fillRect(356, 280, 15, 20);
	//	g.drawLine(0, 300, 600, 50);
		
	}
	

}

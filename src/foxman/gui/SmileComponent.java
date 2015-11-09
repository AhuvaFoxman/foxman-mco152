package foxman.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class SmileComponent extends JPanel {

	private int y = 170;

	public SmileComponent() {
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);

		g.setColor(Color.yellow);
		g.fillOval(210, 100, 300, 300);

		g.setColor(Color.BLUE);
		g.fillOval(275, 175, 50, 50);

		g.setColor(Color.BLUE);
		g.fillOval(375, 175, 50, 50);

		g.setColor(Color.GREEN);
		g.fillOval(284, 175, 25, 25);

		g.setColor(Color.GREEN);
		g.fillOval(384, 175, 25, 25);
		y++;

		if (y == 170) {
			y = 175;
		}

		try {
			Thread.sleep(16);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		super.repaint();
		g.setColor(Color.RED);
		g.fillArc(260, 180, 200, 200, 180, 180);

		// make teeth
		g.setColor(Color.white);
		g.fillRect(335, 280, 15, 20);

		g.setColor(Color.white);
		g.fillRect(356, 280, 15, 20);
		// g.drawLine(0, 300, 600, 50);

	}

}

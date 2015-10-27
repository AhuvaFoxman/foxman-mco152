package foxman.projectile;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

public class ProjectileComponent extends JComponent {

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D graphic = (Graphics2D) g;
		Projectile p = new Projectile(31, 20, 0);

		double x = p.getX();
		double y = p.getY();

		for (int i = 1; i < 20; i++) {
			p.setTime(i);
			graphic.setColor(Color.MAGENTA);
			graphic.draw(new Line2D.Double(x, getHeight() - y, p.getX(),
					getHeight() - p.getY()));
			
			x = p.getX();
			y = p.getY();
		}
	}

}

package foxman.projectile;

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

		for (double i = 0.0; i < 20; i += .1) {
			p.setTime(i);
			double x2 = p.getX();
			double y2 = p.getY();
			graphic.draw(new Line2D.Double(x, getHeight() - y, x2, getHeight() - y2));

			x = x2;
			y = y2;
		}
	}

}

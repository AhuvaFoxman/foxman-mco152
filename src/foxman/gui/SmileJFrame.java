package foxman.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SmileJFrame extends JFrame {

	public SmileJFrame() {

		setTitle("Smile");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		BorderLayout layout = new BorderLayout();
		Container container = getContentPane();
		container.setLayout(layout);

		// put the smileComponent in the center because it expands
		// need to specify a zone
		container.add(new SmileComponent(), BorderLayout.CENTER);

	}

	public static void main(String args[]) {

		new SmileJFrame().setVisible(true);

	}

}

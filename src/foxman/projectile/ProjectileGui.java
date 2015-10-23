package foxman.projectile;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ProjectileGui extends JFrame {

	private JLabel labelOne;
	private JTextField textOne;
	private JLabel labelTwo;
	private JTextField textTwo;
	private JLabel labelThree;
	private JTextField textThree;
	private JButton button;
	private JLabel answer;

	public ProjectileGui() {

		setTitle("Projectile");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exits the program
														// when u close ur
														// window

		Container container = getContentPane(); //
		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		labelOne = new JLabel("Angle");
		add(labelOne);
		textOne = new JTextField();

		add(textOne);

		labelTwo = new JLabel("Velocity");
		add(labelTwo);
		textTwo = new JTextField();

		add(textTwo);

		labelThree = new JLabel("Time");
		add(labelThree);

		textThree = new JTextField();
		add(textThree);

		button = new JButton("Calculate");
		add(button);
		answer = new JLabel();

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				double angle = Double.parseDouble(textOne.getText());
				double velocity = Double.parseDouble(textTwo.getText());
				double time = Double.parseDouble(textThree.getText());
				Projectile p = new Projectile(angle, velocity, time);

				answer.setText("X = " + p.getX() + " Y = " + p.getY());
			}

		}); // action listener is an interface

		add(button);
		add(answer);

	}

}

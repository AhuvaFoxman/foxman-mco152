package foxman.quadratic;

import java.awt.Button;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class QuadraticGui extends JFrame {

	private JLabel labelOne;
	private JTextField textOne;
	private JLabel labelTwo;
	private JTextField textTwo;
	private JLabel labelThree;
	private JTextField textThree;
	private JButton button;
	private JLabel answer;

	public QuadraticGui() {
		setTitle("Quadratic Equation");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exits the program
														// when u close ur
														// window

		Container container = getContentPane(); //
		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		labelOne = new JLabel("A");
		add(labelOne);
		textOne = new JTextField();

		add(textOne);

		labelTwo = new JLabel("B");
		add(labelTwo);
		textTwo = new JTextField();

		add(textTwo);

		labelThree = new JLabel("C");
		add(labelThree);

		textThree = new JTextField();
		add(textThree);

		button = new JButton("Calculate");
		add(button);
		answer = new JLabel();

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				try {
					double a = Double.parseDouble(textOne.getText());
					double b = Double.parseDouble(textTwo.getText());
					double c = Double.parseDouble(textThree.getText());
					QuadraticEquation q = new QuadraticEquation(a, b, c);

			
					answer.setText("Positive X = " + q.getNegativeX()
							+ " Negative X = " + q.getPositiveX());

				} catch (InvalidDataException e) {
					System.out.print("Invalid Data");
					e.printStackTrace();
				}
			}

		}); // action listener is an interface

		add(button);
		add(answer);

	}

}

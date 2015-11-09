package foxman.connectFour;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import foxman.gui.SmileJFrame;

public class ConnectFourJFrame extends JFrame {

	private JButton[] buttons = new JButton[7];
	private JLabel[] labels;
	private ConnectFour connectFour;

	public ConnectFourJFrame() {

		connectFour = new ConnectFour();

		setTitle("Connect Four");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GridLayout layout = new GridLayout(7, 6);
		Container container = getContentPane();

		container.setLayout(layout);

		labels = new JLabel[42];

		for (int i = 0; i < 42; i++) {

			labels[i] = new JLabel();
			labels[i].setBorder(new LineBorder(Color.BLUE));
			add(labels[i]);

		}

		for (int i = 0; i < buttons.length; i++) {
			container.add(buttons[i] = new JButton("Column " + (i + 1)));
			int count = i;
			buttons[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {

					connectFour.playerTurn(count);
					labels[count] = new JLabel(new ImageIcon(this.getClass().getResource("./RedCircle.png")));

					//if (connectFour.getTurn().getColor() == "RED") {
					//	labels[count] = new JLabel(new ImageIcon(this
						//		.getClass().getResource("./RedCircle.png")));
						//add(labels[count]);

					//} else if (connectFour.getTurn().getColor() == "YELLOW") {
					//	labels[count] = new JLabel(new ImageIcon(this
							//	.getClass().getResource("./YellowCircle.png")));
					//	add(labels[count]);

					//}

				}

			});

		}

	}

	public static void main(String args[]) {

		new ConnectFourJFrame().setVisible(true);

	}

}

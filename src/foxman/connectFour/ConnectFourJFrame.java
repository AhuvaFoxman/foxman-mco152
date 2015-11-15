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
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

public class ConnectFourJFrame extends JFrame {

	private JButton[] buttons = new JButton[7];
	private JLabel[][] labels;
	private ConnectFour connectFour;

	public ConnectFourJFrame() {

		int playAgain = 0;

		this.connectFour = new ConnectFour();
		this.buttons = new JButton[7];
		this.labels = new JLabel[6][7];

		setTitle("Connect Four");
		setResizable(false); // wont allow the user to resize the board

		setSize(700, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GridLayout layout = new GridLayout(7, 6);
		Container container = getContentPane();

		container.setLayout(layout);

		ImageIcon arrow = new ImageIcon("./Arrow.png");
		ImageIcon thumbsUp = new ImageIcon("./ThumbsUp.png");
		ImageIcon tieGame = new ImageIcon("./TieGame");

		for (int i = 0; i < buttons.length; i++) {
			container.add(buttons[i] = new JButton());
			buttons[i].setIcon(arrow);
			int count = i;
			buttons[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {

					int row = 0;
					boolean exceptionThrown = false;
					try {
						row = connectFour.playerTurn(count);
					} catch (FilledColumnException e) {
						JOptionPane.showMessageDialog(null,
								"The column is full. Choose a different column."
										+ "");
						exceptionThrown = true;
					}

					if (!exceptionThrown) {
						setIcon(row, count);

					}

					else {
						connectFour.changeTurn(connectFour.getPlayerTurn());
						setIcon(row, count);
					}

					boolean winner = connectFour.checkBoard();
					boolean isFull = false;

					if (winner == true) {

						int playAgain = JOptionPane
								.showConfirmDialog(
										null,
										connectFour.getPlayerTurn().getColor()
												+ " won! \nDo you want to play again? ",
										"Connect Four",
										JOptionPane.YES_NO_OPTION,
										JOptionPane.PLAIN_MESSAGE, thumbsUp);
						if (playAgain == JOptionPane.NO_OPTION) {
							JOptionPane.showMessageDialog(null,
									"Goodbye! Thanks for playing");
							turnOff();

						} else {
							turnOff();
							new ConnectFourJFrame().setVisible(true);
						}

					}
					if (winner == false) {
						isFull = connectFour.checkFull(); // draw
						if (isFull) {
							JOptionPane.showMessageDialog(null, "Tie Game!");
							JOptionPane.showConfirmDialog(null,
									"Do you want to play again? ",
									"Connect Four", JOptionPane.YES_NO_OPTION,
									JOptionPane.PLAIN_MESSAGE, tieGame);
							if (playAgain == JOptionPane.NO_OPTION) {
								JOptionPane.showMessageDialog(null,
										"Goodbye! Thanks for playing");
								turnOff();
							} else {
								turnOff();
								new ConnectFourJFrame().setVisible(true);
							}

						} else {
							connectFour.changeTurn(connectFour.getPlayerTurn());
						}

					}

				}

			});

		}

		for (int row = 0; row < labels.length; row++) {
			for (int col = 0; col < labels[row].length; col++) {
				labels[row][col] = new JLabel();
				labels[row][col].setBackground(Color.BLACK);
				labels[row][col].setOpaque(true);
				labels[row][col].setBorder(new LineBorder(Color.BLUE, 3));
				add(labels[row][col]);

			}
		}

	}

	public void turnOff() {
		for (int i = 0; i < buttons.length; i++) {
			for (ActionListener a : buttons[i].getActionListeners()) {
				buttons[i].removeActionListener(a);
			}
		}

	}

	public void setIcon(int row, int column) {
		ImageIcon imageOne = new ImageIcon("./RedCircle.png");
		ImageIcon imageTwo = new ImageIcon("./YellowCircle.png");
		if (connectFour.getPlayerTurn().getColor() == "RED") {
			labels[row][column].setIcon(imageOne);

		} else if (connectFour.getPlayerTurn().getColor() == "YELLOW") {
			labels[row][column].setIcon(imageTwo);

		}

	}

	public static void main(String args[]) {

		new ConnectFourJFrame().setVisible(true);

	}

}

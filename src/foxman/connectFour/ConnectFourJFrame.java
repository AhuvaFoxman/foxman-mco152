package foxman.connectFour;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ConnectFourJFrame extends JFrame {

	private JButton[] buttons = new JButton[7];
	private JLabel[][] labels;
	private ConnectFour connectFour;
	private ImageIcon arrow;
	private ImageIcon thumbsUp;
	private ImageIcon tieGame;
	private ImageIcon goodBye;
	private ImageIcon whiteCircle;
	private ImageIcon redCircle;
	private ImageIcon yellowCircle;

	public ConnectFourJFrame() {

		// all the images in the game
		this.arrow = new ImageIcon("./Arrow.png");
		this.thumbsUp = new ImageIcon("./ThumbsUp.png");
		this.tieGame = new ImageIcon("./TieGame.png");
		this.goodBye = new ImageIcon("./goodBye.png");
		this.whiteCircle = new ImageIcon("./WhiteCircle.png");
		this.redCircle = new ImageIcon("./RedCircle.png");
		this.yellowCircle = new ImageIcon("./YellowCircle.png");

		this.connectFour = new ConnectFour();
		this.buttons = new JButton[7];
		this.labels = new JLabel[6][7];

		setTitle("CONNECT FOUR");
		setResizable(false); // wont allow the user to resize the board

		setSize(700, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// set the Layout of the JFrame
		setLayout(new BorderLayout());

		// set the layout of the center panel
		GridLayout layout = new GridLayout(7, 6);
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(layout);
		// add it to the center
		add(mainPanel, BorderLayout.CENTER);

		// make a JPanel to hold a restartButton
		JPanel restart = new JPanel();
		restart.setLayout(new BorderLayout());
		add(restart, BorderLayout.NORTH); // add to the top

		for (int i = 0; i < buttons.length; i++) {

			mainPanel.add(buttons[i] = new JButton());
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

					// if there is a winner..
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
									"Goodbye! Thanks for playing",
									"Connect Four", JOptionPane.PLAIN_MESSAGE,
									goodBye);
							dispose();

						} else { // if the user wants to play again
							dispose();
							new ConnectFourJFrame().setVisible(true);
						}

					}
					// if there is no winner yet
					if (winner == false) {
						// check if there is a draw
						isFull = connectFour.checkFull();
						// if it is not a draw, change the player's turn
						if (!isFull) {
							connectFour.changeTurn(connectFour.getPlayerTurn());
						} else { // draw
							int playAgain = JOptionPane.showConfirmDialog(null,
									"Tie Game! \nDo you want to play again?",
									"Connect Four", JOptionPane.YES_NO_OPTION,
									JOptionPane.PLAIN_MESSAGE, tieGame);

							if (playAgain == JOptionPane.NO_OPTION) {
								JOptionPane.showMessageDialog(null,
										"Goodbye! Thanks for playing!",
										"Connect Four",
										JOptionPane.PLAIN_MESSAGE, goodBye);
								dispose();

							} else {
								dispose(); // close the board
								new ConnectFourJFrame().setVisible(true); // reopen
																			// one
							}

						}

					}

				}

			});

		}

		for (int row = 0; row < labels.length; row++) {
			for (int col = 0; col < labels[row].length; col++) {
				labels[row][col] = new JLabel();
				labels[row][col].setIcon(whiteCircle);
				labels[row][col].setOpaque(true);
				mainPanel.add(labels[row][col]);

			}
		}

		// if the user wants to restart the game in middle
		JButton restartButton = new JButton("Restart Game");

		restartButton.setBackground(Color.GREEN);
		restartButton.setForeground(Color.WHITE);
		restartButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		restartButton.setOpaque(true);
		restart.add(restartButton);
		restartButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new ConnectFourJFrame().setVisible(true);
				;
			}

		}

		);

	}

	private void setIcon(int row, int column) {
		
		String color = connectFour.getPlayerTurn().getColor();

		if (color == "RED") {

			setTitle("CONNECT FOUR  Player Yellow's Turn");
			labels[row][column].setIcon(redCircle);

		} else if (color == "YELLOW") {
			setTitle("CONNECT FOUR  Player Red's Turn");
			labels[row][column].setIcon(yellowCircle);

		}

	}

	public static void main(String args[]) {

		new ConnectFourJFrame().setVisible(true);

	}

}

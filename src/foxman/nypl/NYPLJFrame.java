package foxman.nypl;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NYPLJFrame extends JFrame {

	private JList<String> list;
	private JTextField searchText;
	private JButton search;
	private JButton previous;
	private JButton next;
	private JLabel numbers;
	private JLabel imageLabel;
	private ArrayList<String> array;
	private int picNum = 0;
	private ArrayList<String> imageURLs;
	private ArrayList<ImageIcon> icon;

	public NYPLJFrame() {
		setTitle("New York Public Library"); // sets the title
		setSize(800, 600); // set the size in pixels
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exits the program
														// when u close ur
														// window

		Container container = getContentPane(); //
		setLayout(new BorderLayout());

		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 3));

		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 3));

		add(topPanel, BorderLayout.NORTH);
		add(panel, BorderLayout.AFTER_LINE_ENDS);

		array = new ArrayList<String>();
		imageURLs = new ArrayList<String>();
		list = new JList<String>();
		searchText = new JTextField(60);
		search = new JButton("Search");
		previous = new JButton("Previous");
		previous.setEnabled(false);
		next = new JButton("Next");
		next.setEnabled(false);
		numbers = new JLabel();
		imageLabel = new JLabel();

		add(imageLabel, BorderLayout.CENTER);
		add(list, BorderLayout.LINE_START);

		searchText.setMaximumSize(new Dimension(Integer.MAX_VALUE, 3));
		topPanel.add(searchText);
		topPanel.add(search);
		panel.add(previous);
		panel.add(numbers);
		panel.add(next);

		previous.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (picNum == 0) {
					picNum = icon.size() - 1;

				} else {
					picNum--;
				}

				changeImage();

			}

		});

		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (picNum == icon.size() - 1) {
					picNum = 0;
				} else {
					picNum++;
				}
				changeImage();

			}

		});

		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				String text = searchText.getText().trim();
				NYPLThread thread = new NYPLThread(text, NYPLJFrame.this,
						array, list, previous, next, imageLabel);
				thread.start();

				MouseListener mouseListener = new MouseAdapter() {

					public void mouseClicked(MouseEvent e) {
						if (e.getClickCount() == 1) {

							int index = list.locationToIndex(e.getPoint());
							ImageDownloadThread imgThread = null;
							try {
								imgThread = new ImageDownloadThread(array
										.get(index), imageLabel,
										NYPLJFrame.this);
							} catch (MalformedURLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							imgThread.start();

						}
					}

				};
				list.addMouseListener(mouseListener);

			}
		}

		);

	}

	public void showImage(ArrayList<ImageIcon> icons) {
		icon = icons;
		changeImage();

	}

	public void changeImage() {
		imageLabel.setIcon(icon.get(picNum));
		add(imageLabel);
		setNumDisplay();
	}

	public void setNumDisplay() {
		numbers.setText((picNum + 1) + " of " + "8");
	}

	public static void main(String[] args) {
		new NYPLJFrame().setVisible(true);
	}
}

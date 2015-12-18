package foxman.contacts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import foxman.weather.InvalidZipException;
import foxman.weather.WeatherGui;
import foxman.weather.WeatherThread;

public class ContactGui extends JFrame {

	private JList<String> list;
	private JButton button;
	private JFrame detailFrame;
	private ContactThread thread;
	private CurrentContactsList contacts;

	public ContactGui() {

		setTitle("CONTACTS");
		setSize(700, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, 2));

		button = new JButton("View Contacts:");
		button.setBackground(Color.YELLOW);
		button.setForeground(Color.RED);

		panel.add(button);
		add(panel, BorderLayout.NORTH);

		DefaultListModel dlm = new DefaultListModel();

		list = new JList<String>(dlm);
		add(list, BorderLayout.CENTER);

		this.thread = new ContactThread(list);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				thread.start();
			}
		});

		MouseListener mouseListener = new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {

					for (Contact c : contacts) {
						if (list.getSelectedValue() == c.getName()) {
							new ContactDetailsJFrame(c).setVisible(true);
						}
					}
				}
			}

		};
		list.addMouseListener(mouseListener);

	}

	public static void main(String[] args) {
		new ContactGui().setVisible(true);
	}

}

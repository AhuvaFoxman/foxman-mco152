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
	private ContactThread thread;
	private CurrentContactsList contacts;

	public ContactGui() {

		setTitle("CONTACTS");
		setSize(700, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());


		list = new JList<String>();
		add(list, BorderLayout.CENTER);

		this.thread = new ContactThread(list);

		thread.start();

		MouseListener mouseListener = new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {

					int index = list.locationToIndex(e.getPoint());
					CurrentContactsList contacts = thread.getContacts();
					new ContactDetailsJFrame(contacts.get(index))
							.setVisible(true);

				}
			}

		};
		list.addMouseListener(mouseListener);

	}

	public static void main(String[] args) {
		new ContactGui().setVisible(true);
	}

}

package foxman.contacts;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ContactDetailsJFrame extends JFrame {

	private JLabel email;
	private JLabel street;
	private JLabel suite;
	private JLabel city;
	private JLabel zipCode;
	private JLabel phone;
	private CurrentContactsList contacts;

	public ContactDetailsJFrame(Contact c) {

		setTitle("CONTACT DETAILS");
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		Container container = getContentPane();
		setLayout((new BoxLayout(container, BoxLayout.Y_AXIS)));

		this.email = new JLabel();
		this.street = new JLabel();
		this.suite = new JLabel();
		this.city = new JLabel();
		this.zipCode = new JLabel();
		this.phone = new JLabel();
		add(email);
		add(street);
		add(suite);
		add(city);
		add(zipCode);
		add(phone);

		email.setText(c.getEmail());
		street.setText(c.getAddress().getStreet());
		suite.setText(c.getAddress().getSuite());
		city.setText(c.getAddress().getCity());
		zipCode.setText(c.getAddress().getZipcode());
		phone.setText(c.getPhone());

	}

}

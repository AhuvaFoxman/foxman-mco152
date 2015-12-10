package foxman.weather;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class WeatherGui extends JFrame {

	private JLabel label;
	private JTextField text;
	private JButton button;
	private JTextField temp;
	private JTextField desc;
	private JTextField humidity;
	private JTextField pressure;
	private JLabel iconLabel;
	private ImageIcon icon;

	public WeatherGui() throws IOException {

		setTitle("WEATHER");
		setSize(700, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		Font font = new Font("Serif", Font.BOLD, 30);

		label = new JLabel();
		label.setBackground(Color.BLUE);
		label.setText("Enter a zipcode to find the weather: ");
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setFont(font);
		add(label);

		text = new JTextField();
		text.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
		text.setBackground(Color.CYAN);
		text.setForeground(Color.BLUE);
		text.setAlignmentX(Component.CENTER_ALIGNMENT);
		text.setFont(font);
		add(text);

		button = new JButton("GET WEATHER!");
		button.setBackground(Color.GREEN);
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(button);

		temp = new JTextField();
		temp.setMaximumSize(new Dimension(Integer.MAX_VALUE, 55));
		temp.setAlignmentX(Component.CENTER_ALIGNMENT);
		temp.setBackground(Color.YELLOW);
		temp.setForeground(Color.RED);

		desc = new JTextField();
		desc.setMaximumSize(new Dimension(Integer.MAX_VALUE, 55));
		desc.setAlignmentX(Component.CENTER_ALIGNMENT);
		desc.setBackground(Color.YELLOW);
		desc.setForeground(Color.RED);

		humidity = new JTextField();
		humidity.setMaximumSize(new Dimension(Integer.MAX_VALUE, 55));
		humidity.setAlignmentX(Component.CENTER_ALIGNMENT);
		humidity.setBackground(Color.YELLOW);
		humidity.setForeground(Color.RED);

		pressure = new JTextField();
		pressure.setMaximumSize(new Dimension(Integer.MAX_VALUE, 55));
		pressure.setAlignmentX(Component.CENTER_ALIGNMENT);
		pressure.setBackground(Color.YELLOW);
		pressure.setForeground(Color.RED);

		iconLabel = new JLabel();
		iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		icon = new ImageIcon();


		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				WeatherConnection weather = null;
				try {
					weather = new WeatherConnection(text.getText());
				} catch (InvalidZipException e) {
					JOptionPane.showMessageDialog(null,
							"You did not enter a zip code with 5 digits.");
					dispose();
					return;
				}

				Weather[] weatherArray = null;
				try {
					weatherArray = weather.getWeather();
					icon = weather.getImageIcon();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				Main main = weather.getMain();

				Font font = new Font("Times New Roman", Font.BOLD, 20);
				temp.setText("Temperature: " + main.getTemp() + " �F");
				desc.setText("Description: " + weatherArray[0].getDescription());
				pressure.setText("Pressure: " + main.getPressure() + " Pa");
				humidity.setText("Humidity: " + main.getHumidity());
				temp.setFont(font);
				desc.setFont(font);
				pressure.setFont(font);
				humidity.setFont(font);

				iconLabel.setIcon(icon);

			}
		});
		add(temp);
		add(desc);
		add(pressure);
		add(humidity);
		add(iconLabel);

	}

	public static void main(String args[]) throws IOException {

		new WeatherGui().setVisible(true);

	}

}

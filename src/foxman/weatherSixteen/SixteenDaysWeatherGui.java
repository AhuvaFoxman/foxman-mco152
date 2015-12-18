package foxman.weatherSixteen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class SixteenDaysWeatherGui extends JFrame {

	private JLabel intro;
	private JLabel temp;
	private JLabel[] labelArray;
	private JButton button;

	public SixteenDaysWeatherGui() {
		setTitle("Sixteen Day Weather");
		setSize(700, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		setLayout(new BorderLayout());

		
		this.labelArray = new JLabel[80];

		JPanel north = new JPanel();
		add(north,BorderLayout.NORTH);
		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(16,5));
		add(center,BorderLayout.CENTER);
		
		for(int i = 0; i < 80; i++){
			labelArray[i] = new JLabel();
			labelArray[i].setBackground(Color.BLUE);
			center.add(labelArray[i]);
		}
		
		intro = new JLabel("Get 16 Day Weather Forcast for Inwood");
		intro.setForeground(Color.RED);
		intro.setBackground(Color.YELLOW);
		north.add(intro);

		temp = new JLabel();

		this.labelArray = new JLabel[16];

		this.button = new JButton();
		button.setText("Get Weather!");
		add(button);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				WeatherURLConnection connection = new WeatherURLConnection();
				List[] list = null;
				try {
					list = connection.getList();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for (int i = 0; i < 16; i++) {
					double temperature = list[i].getTemp().getMax();
					double minTemp = list[i].getTemp().getMin();
					temp.setText("Max Temp: " + temperature + " Min Temp: "
							+ minTemp);
					labelArray[i] = new JLabel();

					labelArray[i].add(temp);
					container.add(labelArray[i]);
				}

			}
		});

	}

	public static void main(String args[]) throws IOException {

		new SixteenDaysWeatherGui().setVisible(true);

	}

}

package foxman.weather;

import java.awt.Font;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class WeatherThread extends Thread{
	
	private WeatherConnection connection;
	private Weather[] weatherArray;
	private String zip;
	private String place;
	private Main main;
	private JTextField text;
	private JButton button;
	private JTextField temp;
	private JTextField desc;
	private JTextField humidity;
	private JTextField pressure;
	private JTextField name;
	private JLabel iconLabel;
	private ImageIcon icon;

	
	
	
	public WeatherThread(String zip, JTextField text,
			JButton button, JTextField temp, JTextField desc, 
			JTextField humidity, JTextField pressure,
			JTextField name, JLabel iconLabel, ImageIcon icon) throws IOException, InvalidZipException{
		this.zip = zip;
		this.text = text;
		this.button = button;
		this.temp = temp;
		this.desc = desc;
		this.humidity = humidity;
		this.pressure = pressure;
		this.name = name;
		this.iconLabel = iconLabel;

		
		
	}
	
	public void run()
	{
		try {
			connection = new WeatherConnection(zip);
		} catch (InvalidZipException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.weatherArray = connection.getWeather();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.place = connection.getName();
		this.main = connection.getMain();
		Font font = new Font("Times New Roman", Font.BOLD, 20);
		name.setText("Location: " + place);
		temp.setText("Temperature: " + main.getTemp() + " °F");
		desc.setText("Description: " + weatherArray[0].getDescription());
		pressure.setText("Pressure: " + main.getPressure() + " Pa");
		humidity.setText("Humidity: " + main.getHumidity());
		name.setFont(font);
		temp.setFont(font);
		desc.setFont(font);
		pressure.setFont(font);
		humidity.setFont(font);
		try {
			this.icon = connection.getImageIcon();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		iconLabel.setIcon(icon);

	}
}

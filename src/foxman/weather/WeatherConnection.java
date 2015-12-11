package foxman.weather;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.google.gson.Gson;

public class WeatherConnection {
	private String zipCode;

	private CurrentWeather currentWeather;

	public WeatherConnection(String zip) throws InvalidZipException {
		this.zipCode = zip;

		if (zipCode.length() != 5) {
			throw new InvalidZipException();
		}
		currentWeather = new CurrentWeather();

	}

	public Weather[] getWeather() throws IOException {

		StringBuilder builder = new StringBuilder();
		builder.append("http://api.openweathermap.org/data/2.5/weather?zip=");
		builder.append(zipCode);
		builder.append(",us&appid=2de143494c0b295cca9337e1e96b00e0&units=imperial");
		URL url = new URL(builder.toString());
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		java.io.InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		final Gson gson = new Gson();

		this.currentWeather = gson.fromJson(reader, CurrentWeather.class);
		Weather[] weather = this.currentWeather.getWeather();
		return weather;

	}

	public Main getMain() {
		Main main = currentWeather.getMain();
		return main;
	}

	public ImageIcon getImageIcon() throws IOException {

		ImageIcon icon;
		Weather[] weatherArray = getWeather();
		String imageLink = weatherArray[0].getIcon();
		StringBuffer buffer = new StringBuffer();
		buffer.append("http://openweathermap.org/img/w/");
		buffer.append(imageLink);
		buffer.append(".png");
		String link = buffer.toString();
		URL imageURL = new URL(link);

		BufferedImage image = ImageIO.read(imageURL);
		icon = new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(
				125, 125, Image.SCALE_DEFAULT));
		return icon;

	}
	
	
	public String getName(){
		return currentWeather.getName();
		
	}

}

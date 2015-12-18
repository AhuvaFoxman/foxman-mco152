package foxman.weatherSixteen;

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

public class WeatherURLConnection {

	private CurrentWeather currentWeather;
	private List[] list;
	private City city;

	public List[] getList() throws IOException {

		URL url = new URL(
				"http://api.openweathermap.org/data/2.5/forecast/daily?q=Inwood&mode=json&units=Imperial&cnt=16&appid=ca1d966caacad3ba9ed500104b1b3c75");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		java.io.InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		final Gson gson = new Gson();

		this.currentWeather = gson.fromJson(reader, CurrentWeather.class);

		this.list = this.currentWeather.getList();

		return list;

	}

	public City getCity() {
		this.city = this.currentWeather.getCity();
		return city;
	}

	public ImageIcon getIcon() throws IOException {
		ImageIcon icon;
		Weather[] weather = this.list[0].getWeather();
		String imageLink = weather[0].getIcon();
		
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

}

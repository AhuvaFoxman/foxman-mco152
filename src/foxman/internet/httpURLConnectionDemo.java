package foxman.internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class httpURLConnectionDemo {
	
	public static void main (String[] args) throws IOException{
		
		//not working with the socket
		URL url = new URL("http://api.openweathermap.org/data/2.5/weather?zip=11691,us&appid=2de143494c0b295cca9337e1e96b00e0&units=imperial");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		
		java.io.InputStream in =  connection.getInputStream();
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(in));
		String line;
		while((line = reader.readLine()) != null){
			System.out.println(line);
			
		}
		
		
	}

}

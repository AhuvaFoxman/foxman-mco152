package foxman.weatherSixteen;

import java.io.IOException;

public class main {
	
	public static void main(String[] args) throws IOException{
		
		WeatherThread thread = new WeatherThread();
		thread.run();
		
		
		
	}

}

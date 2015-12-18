package foxman.weatherSixteen;

import java.io.IOException;

public class WeatherThread extends Thread{
	
	private double maxTemp;
	private double minTemp;
	private String desc;
	private List[] list;
	private Weather[] weather;
	
	public WeatherThread(){
		
	}
	
	public void run(){
		WeatherURLConnection connection = new WeatherURLConnection();
		try {
			this.list = connection.getList();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i<16 ;i++){
			maxTemp = list[i].getTemp().getMax();
			minTemp = list[i].getTemp().getMin();
			desc = list[i].getWeather()[0].getDescription();
			System.out.println("Tempature: " + maxTemp + " " + minTemp);
			System.out.println("Description: " + desc);
		}
		
			
		
	}
	
	
	

}

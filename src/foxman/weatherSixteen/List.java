package foxman.weatherSixteen;

public class List {
	
	private Long dt;
	private Temp temp;
	private Weather[] weather;
	
	public Long getDate(){
		return this.dt;
	}
	
	public Temp getTemp(){
		return this.temp;
	}
	
	public Weather[] getWeather(){
		return this.weather;
	}
	
	
}

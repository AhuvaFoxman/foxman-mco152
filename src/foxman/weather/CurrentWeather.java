package foxman.weather;

public class CurrentWeather {

	private Weather[] weather;
	private Main main;
	private String name;

	public Weather[] getWeather() {
		return this.weather;
	}

	public Main getMain() {
		return this.main;
	}
	
	public String getName(){
		return this.name;
	}
}

package foxman.connectFour;

public class Player {
	
	private String color;
	private String name;
	
	public Player(String color, String name){
		this.color = color;
		this.name = name;
	}
	
	public void setColor(String color){
		this.color = color;
	}
	
	public void setName (String name){
		this.name = name;
	}
	
	public String getColor(){
		return this.color;
	}
	
	public String getName(){
		return this.name;
	}

}

package foxman.projectile;

public class Projectile {
	private double angle;
	private double velocity;
	private double time;
	private double radians;

	public Projectile(double angle, double velocity, double time) {
		this.angle = angle;
		this.velocity = velocity;
		this.time = time;
		this.radians = Math.toRadians(angle);
		// in the constructor so it doesn't have to be redone many times
	}

	public double getX() {
		return Math.sin(this.radians) * this.velocity * this.time;

	}

	public double getY() {
		return Math.cos(this.radians) * this.velocity * this.time - (.5 * 9.8 * time * time);

	}
	
	public void setTime(double time){
		this.time = time;
		
	}
}



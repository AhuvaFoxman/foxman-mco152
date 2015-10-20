package foxman.projectile;

public class ProjectileMain {
	public static void main(String[] args) {

		double angle = 31;
		double velocity = 20;
		double time = 2.7;
		double radians = Math.toRadians(angle);
		double x = Math.sin(radians) * velocity * time;
		double y = Math.cos(radians) * velocity * time - (.5 * 9.8 * time * time);

		System.out.println("x = " + x);
		System.out.println("y = " + y);

		Projectile proj = new Projectile(angle, velocity, time);
		for (int i = 0; i <= 10; i++){
			
			proj.setTime(i);
			System.out.println("x =" + proj.getX());
			System.out.println("y =" + proj.getY());
		}
	}

}

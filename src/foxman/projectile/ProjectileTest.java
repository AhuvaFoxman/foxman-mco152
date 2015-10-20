package foxman.projectile;
	
	import org.junit.Assert;
	import org.junit.Test;

	public class ProjectileTest {

		// proper annotation
		@Test
		public void testGetX() {
			Projectile p = new Projectile(31, 20, 2.7);
			double x = p.getX();
			Assert.assertEquals(27.81, x, 0.01);
			// gives it a range when working with doubles
		}
		@Test
		public void testGetY() {
			Projectile p = new Projectile(31, 20, 2.7);
			double y = p.getY();
			Assert.assertEquals(10.56, y, 0.01);

		}
	}



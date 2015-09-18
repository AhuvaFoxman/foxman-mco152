package foxman.pythagorean;

import org.junit.Assert;
import org.junit.Test;

import foxman.quadratic.InvalidDataException;

public class PythagoreanTheormTest {

	@Test
	public void testSetAB() {
		PythagoreanTheorm p = new PythagoreanTheorm();
		p.setAB(3, 4);
		Assert.assertEquals(5.0, p.getC(), 0.01);
	}
	@Test
	public void testSetBC() throws InvalidDataException {
		PythagoreanTheorm p = new PythagoreanTheorm();
		p.setBC(5, 13);
		Assert.assertEquals(12.0, p.getA(), 0.01);
	}
	@Test
	public void testSetAC() throws InvalidDataException {
		PythagoreanTheorm p = new PythagoreanTheorm();
		p.setAC(9, 15);
		Assert.assertEquals(12.0, p.getB(), 0.01);
	}

}

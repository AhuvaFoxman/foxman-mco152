package foxman.quadratic;

import org.junit.Assert;
import org.junit.Test;

public class QuadraticEquationTest {

	@Test
	public void testInvalidDataException() {
		try {
			new QuadraticEquation(0, 0, 0);
			Assert.fail("Didn't throw exception.");
		} catch (InvalidDataException e) {
			//if invalid data was entered this is what should happen
			//The test should pass.
		}
	}

	@Test
	public void testGetPositiveX() throws InvalidDataException {

		QuadraticEquation e = new QuadraticEquation(1, 2, -8);
		double positiveX = e.getPositiveX();

		Assert.assertEquals(2.0, positiveX, 0.01);

	}

	@Test
	public void testGetNegativeX() throws InvalidDataException {
		QuadraticEquation e = new QuadraticEquation(1, 2, -8);
		double negativeX = e.getNegativeX();
		Assert.assertEquals(-4.0, negativeX, 0.01);
	}
}

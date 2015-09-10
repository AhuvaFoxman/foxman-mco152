package foxman.pythagorean;

import foxman.quadratic.InvalidDataException;

public class PythagoreanTheorm {

	private double a;
	private double b;
	private double c;

	public PythagoreanTheorm() {

	}

	// sets a and b and computes c
	public void setAB(double a, double b) {
		this.a = a;
		this.b = b;
		this.c = Math.sqrt((a * a) + (b * b));
	}

	// set a and c and computes b
	public void setAC(double a, double c) throws InvalidDataException {
		this.a = a;
		this.c = c;
		if (a > c) {
			throw new InvalidDataException();
		}

		this.b = Math.sqrt((c * c) - (a * a));

	}

	// sets b and c and computes a
	public void setBC(double b, double c) throws InvalidDataException {
		this.b = b;
		this.c = c;
		if (b > c) {
			throw new InvalidDataException();
		}

		this.a = Math.sqrt((c * c) - (b * b));

	}

	public double getA() {

		return this.a;
	}

	public double getB() {
		return this.b;
	}

	public double getC() {
		return this.c;
	}
}

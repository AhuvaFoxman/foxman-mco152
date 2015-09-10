package foxman.quadratic;

public class QuadraticEquation {

	private double a;
	private double b;
	private double c;

	public QuadraticEquation(double a, double b, double c)
			throws InvalidDataException {
		if (a == 0) {
			throw new InvalidDataException();
		} else {
			this.a = a;
		}

		if (b == 0) {
			throw new InvalidDataException();
		} else {
			this.b = b;
		}
		this.c = c;
	}

	public double getPositiveX() {
		return (-this.b + Math.sqrt((this.b * this.b) - 4 * this.a * this.c))
				/ (2 * a);
	}

	public double getNegativeX() {
		return (-this.b - Math.sqrt((this.b * this.b) - 4 * this.a * this.c))
				/ (2 * a);

	}

}

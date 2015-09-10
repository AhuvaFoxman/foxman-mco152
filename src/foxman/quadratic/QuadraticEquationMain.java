package foxman.quadratic;

public class QuadraticEquationMain {

	public static void main(String[] args) {

		QuadraticEquation e = null;
		try {
			e = new QuadraticEquation(0, 2, -8);
		} catch (InvalidDataException e1) {
			System.out.println(e1.getMessage());
		}

		System.out.println("Positive root: " + e.getPositiveX());
		System.out.println("Negative root: " + e.getNegativeX());
	}
}

package foxman.pythagorean;

import foxman.quadratic.InvalidDataException;

public class PythagoreanMain {

	public static void main(String[] args) {
		
		
		PythagoreanTheorm p = new PythagoreanTheorm();
		
		try {
			p.setBC(3,5);
		} catch (InvalidDataException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("A = " + p.getA());
		
	}

}

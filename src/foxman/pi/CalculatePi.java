package foxman.pi;

public class CalculatePi {

	public static void main(String[] args) {
		
		PiCalculator pi = new PiCalculator();
		System.out.println(pi.calculate(500000));
	}

}

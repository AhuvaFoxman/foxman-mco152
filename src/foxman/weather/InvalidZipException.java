package foxman.weather;

public class InvalidZipException extends Exception {

	public InvalidZipException() {
		super("Invalid Zip Code.");
	}
}

package foxman.morsecode;

public class MorseCode {

	private char[] alphabet;
	private String[] morseCode;

	public MorseCode() {
		this.alphabet = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
				'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
				'U', 'V', 'W', 'X', 'Y', 'Z' };
		this.morseCode = new String[] { ".-", "-...", "-.-.", "-..", ".",
				"..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.",
				"---", ".---.", "--.-", ".-.", "...", "-", "..-", "...-",
				".--", "-..-", "-.--", "--..", ".----", "..---", "...--",
				"....-", ".....", "-....", "--...", "---..", "----.", "-----",
				"--..--", ".-.-.-", "..--.." };
	}

	public String encode(String message) {

		
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < message.length(); i++) {

			if (message.toUpperCase().charAt(i) == ' ') {
				builder.append(" ");
			}
			for (int y = 0; y < alphabet.length; y++) {
				if (message.toUpperCase().charAt(i) == alphabet[y]) {
					if (i < message.length() - 1) {
						builder.append(morseCode[y] + " ");
					} else {
						builder.append(morseCode[y]); // take away the last
														// space
					}
				}
			}
		}

		return builder.toString();

	}

	public String decode(String message) {
		String[] code = new String[message.length()];
		code = message.split("   ");
		String[] letter = new String[100];
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < code.length; i++) {
			letter = code[i].split(" ");

			for (int y = 0; y < letter.length; y++) {
				for (int k = 0; k < morseCode.length; k++) {

					if (letter[y].equalsIgnoreCase(morseCode[k])) {
						builder.append(alphabet[k]);
					}
				}

			}
			if (i < code.length - 1) {
				builder.append(" ");
			}
		}
		return builder.toString();

	}

}

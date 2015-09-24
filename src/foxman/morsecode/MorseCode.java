package foxman.morsecode;

import java.util.HashMap;

public class MorseCode {

	private String[] alphabet;
	private String[] morseCode;
	private HashMap<String, String> alpha;

	public MorseCode() {
		this.alphabet = new String[] { "A", "B", "C", "D", "E", "F", "G", "H",
				"I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
				"U", "V", "W", "X", "Y", "Z" };
		this.morseCode = new String[] { ".-", "-...", "-.-.", "-..", ".",
				"..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.",
				"---", ".---.", "--.-", ".-.", "...", "-", "..-", "...-",
				".--", "-..-", "-.--", "--..", ".----", "..---", "...--",
				"....-", ".....", "-....", "--...", "---..", "----.", "-----",
				"--..--", ".-.-.-", "..--.." };

		alpha = new HashMap<String, String>();
		// fill the HashMap
		for (int i = 0; i < alphabet.length; i++) {
			alpha.put(alphabet[i], morseCode[i]);
			alpha.put(morseCode[i], alphabet[i]);

		}

	}

	public String encode(String message) {

		StringBuilder builder = new StringBuilder();

		String letter;
		for (int i = 0; i < message.length(); i++) {
			letter = message.toUpperCase().substring(i, i + 1);
			if (letter.equals(" ")) {
				builder.append("  ");
			}
			if (alpha.containsKey(letter)) {
				if (i < message.length() - 1) {
					builder.append(alpha.get(letter) + " ");
				} else {
					builder.append(alpha.get(letter));
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

				if (alpha.containsKey(letter[y])) {

					builder.append(alpha.get(letter[y]));
				}
			}

			if (i < code.length - 1) {
				builder.append(" ");
			}
		}
		return builder.toString();

	}

}

package foxman.scrabble;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class ScrabbleDictionary {

	private HashSet<String> dictionary;

	public ScrabbleDictionary() throws FileNotFoundException {
		this.dictionary = new HashSet<String>();

		Scanner input = new Scanner(new File("US.dic"));

		while (input.hasNext()) {
			this.dictionary.add(input.next());

		}

		input.close();

	}

	public boolean contains(String word) {
		return this.dictionary.contains(word);
	}
}

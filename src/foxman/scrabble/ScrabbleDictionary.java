package foxman.scrabble;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class ScrabbleDictionary {

	private HashSet<String> dictionary;

	public ScrabbleDictionary() throws IOException {
		this.dictionary = new HashSet<String>();

		BufferedReader input = new BufferedReader(new FileReader ("US.dic"));

		String line;
		while ((line = input.readLine()) != null) {
			this.dictionary.add(line);

		}

		input.close();

	}

	public boolean contains(String word) {
		return this.dictionary.contains(word);
	}
}

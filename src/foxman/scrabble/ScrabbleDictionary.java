package foxman.scrabble;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ScrabbleDictionary {

	private ArrayList<String> dictionary;

	public ScrabbleDictionary() throws FileNotFoundException{
		this.dictionary = new ArrayList<String>();

		
			Scanner input = new Scanner(new File("US.dic"));

			while (input.hasNext()) {
				this.dictionary.add(input.next());
			}
			input.close();

		

	}

	public ArrayList<String> getDictionary() {
		return this.dictionary;
	}

	public boolean contains(String word) {
		if (this.dictionary.contains(word)) {
			return true;
		} else {
			return false;
		}
	}
}

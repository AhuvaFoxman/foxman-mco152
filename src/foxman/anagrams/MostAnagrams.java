package foxman.anagrams;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class MostAnagrams {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File("US.dic"));
		HashMap<String, Integer> dictionary = new HashMap<String, Integer>();
		ArrayList<String> dictArray = new ArrayList<String>();

		while (file.hasNext()) {
			dictArray.add(file.next());
		}
		file.close();
		char[] letters;
		Integer value = null;
		Integer maxValue = 0; // assume that there is at least one anagram
		for (String word : dictArray) {
			letters = word.toCharArray();
			Arrays.sort(letters);

			String sortedWord = new String(letters);

			value = dictionary.get(sortedWord);
			if (value == null) {
				dictionary.put(sortedWord, 1);
				value = dictionary.get(sortedWord);
			} else {
				dictionary.put(sortedWord, value + 1);
				value = dictionary.get(sortedWord);
			}

			if (value > maxValue) {
				maxValue = value;

			}

		}

		// StringBuilder anagram1 = new StringBuilder();
		ArrayList<String> anagram = new ArrayList<String>();
		for (String word : dictArray) {
			String unSorted = word;
			letters = word.toCharArray();
			Arrays.sort(letters);
			String sorted = new String(letters);
			Integer val = dictionary.get(sorted);

			if (val == maxValue) {

				anagram.add(unSorted + " ");

			}

		}

		System.out.println("The anagram contains " + maxValue + " words:");
		System.out.println(anagram.toString());

	}

}

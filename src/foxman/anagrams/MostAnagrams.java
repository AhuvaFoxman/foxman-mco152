package foxman.anagrams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class MostAnagrams {

	public static void main(String[] args) throws IOException {
		BufferedReader file = new BufferedReader(new FileReader("US.dic"));
		HashMap<String, Integer> dictionary = new HashMap<String, Integer>();
		ArrayList<String> dictArray = new ArrayList<String>();

		String line;
		while ((line = file.readLine()) != null) {
			dictArray.add(line);
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

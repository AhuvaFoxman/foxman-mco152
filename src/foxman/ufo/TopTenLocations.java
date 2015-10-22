package foxman.ufo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class TopTenLocations {

	public static void main(String[] args) throws IOException {

		// read in the Json file
		BufferedReader in = new BufferedReader(new FileReader(
				"./ufo_awesome.json"));

		Gson gson = new Gson();

		UFOSightingList list = gson.fromJson(in, UFOSightingList.class);

		// make a hashmap of each location and its corresponding value
		HashMap<String, Integer> sightings = new HashMap<String, Integer>();

		// enter the locations and the amt of times they appear into the hashmap
		String key = null;
		Integer value;
		for (int i = 0; i < list.size(); i++) {
			key = list.get(i).getLocation().trim();
			value = sightings.get(key);
			if (value == null) { // if the value is null, then put one in the
									// hashmap
				sightings.put(key, 1);

			} else { // if not null, then put the value + 1
				sightings.put(key, value + 1);
			}

		}

		int largestValue = 0;
		String location = null;

		// for the top 10 locations, print out the location and its value
		System.out.println("Top Ten Sightings:");
		for (int i = 0; i < 10; i++) {
			// reset the value to zero so that it can search for the max again
			largestValue = 0;

			// go through the hashmap to find the largest value.
			for (Map.Entry<String, Integer> entry : sightings.entrySet()) {
				if (entry.getValue() > largestValue) {
					largestValue = entry.getValue();
					location = entry.getKey();
				}
			}

			System.out.println((i + 1) + ". " + location + "- " + largestValue
					+ " sightings");
			// remove the largest one so that it can calculate the next largest
			// value
			sightings.remove(location);
			sightings.remove(largestValue);
		}

		in.close();

	}
}

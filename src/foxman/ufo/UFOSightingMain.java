package foxman.ufo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

public class UFOSightingMain {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new FileReader("./ufo_awesome.json"));
		
		//Gson is not a standard class in java so we need to import other libraries so have to download it
		final Gson gson = new Gson();
	    final UFOSightingList list = gson.fromJson(in, UFOSightingList.class);

		in.close();
		
		System.out.println(list);
		
		//What are the top 10 UFO Sightings Location- the top 10 places that have UFO sightings in order 
		//and list how many UFO Sighting in them

	}

}

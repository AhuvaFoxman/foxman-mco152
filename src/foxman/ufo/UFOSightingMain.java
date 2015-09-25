package foxman.ufo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

public class UFOSightingMain {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new FileReader("./ufo_awesom.json"));
		
		//Gson is not a standard class in java so we need to import other libraries so have to download it
		Gson gson = new Gson();
		in.close();

	}

}

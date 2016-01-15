package foxman.contacts;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.JList;

import com.google.gson.Gson;

public class ContactThread extends Thread {

	private CurrentContactsList contacts;
	private JList<String> list;

	public ContactThread(JList<String> list) {
		this.list = list;
	}

	public void run() {

		URL url = null;
		try {
			url = new URL("http://jsonplaceholder.typicode.com/users");
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		HttpURLConnection connection;

		java.io.InputStream in = null;
		try {
			connection = (HttpURLConnection) url.openConnection();
			in = connection.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		Gson gson = new Gson();

		this.contacts = gson.fromJson(reader, CurrentContactsList.class);

		addDataToList();
	}

	public CurrentContactsList getContacts(){
		return this.contacts;
	}
	
	public void addDataToList() {
		String[] array = new String[contacts.size()];

		int i = 0;

		for (Contact c : contacts) {
			array[i] = c.getName();
			i++;
		}

		Arrays.sort(array);

		this.list.setListData(array);
	}

}

package foxman.nypl;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import com.google.gson.Gson;

import foxman.contacts.CurrentContactsList;

public class NYPLThread extends Thread {

	private Search search;
	String text;
	JList<String> list;
	private StringBuilder builder;
	private Result[] result;
	private ArrayList<String> array;
	private NYPLJFrame frame;
	private JButton prev;
	private JButton next;
	private JLabel imageLabel;

	public NYPLThread(String text, NYPLJFrame frame, ArrayList<String> array,
			JList<String> list, JButton prev, JButton next, JLabel image) {
		this.text = text;
		this.frame = frame;
		this.array = array;
		this.list = list;
		this.prev = prev;
		this.next = next;
		this.imageLabel = image;

	}

	public void run() {
		builder = new StringBuilder();
		URL url = null;
		try {
			builder.append("http://api.repo.nypl.org/api/v1/items/search?q=");
			builder.append(text);
			builder.append("&publicDomainOnly=true");
			url = new URL(builder.toString());
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		HttpURLConnection connection;

		java.io.InputStream in = null;
		try {
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("Authorization",
					"Token token=\"z2a5a4ebwj9eaq81\"");
			in = connection.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		Gson gson = new Gson();

		this.search = gson.fromJson(reader, Search.class);
		this.result = search.getNyplAPI().getResponse().getResult();

		for (int i = 0; i < result.length - 1; i++) {
			array.add(result[i].getApiItemURL());
		}

		prev.setEnabled(true);
		next.setEnabled(true);

		addDataToList();

	}

	public ArrayList<String> getImagesArray() {
		return this.array;
	}

	public void addDataToList() {

		String[] array = new String[result.length];
		for (int i = 0; i < result.length; i++) {
			array[i] = result[i].getTitle();
		}

		this.list.setListData(array);
	}

}

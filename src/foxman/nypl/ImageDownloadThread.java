package foxman.nypl;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.google.gson.Gson;

public class ImageDownloadThread extends Thread {

	private String url;
	private JLabel label;
	private ArrayList<String> imageList;
	private NYPLJFrame frame;
	private ArrayList<ImageIcon> icons;

	public ImageDownloadThread(String url, JLabel imageLabel, NYPLJFrame frame)
			throws MalformedURLException {

		this.frame = frame;
		this.imageList = new ArrayList<String>();
		this.url = url;
		this.label = imageLabel;
		icons = new ArrayList<ImageIcon>();
	}

	@Override
	public void run() {
		URL imageURL = null;

		try {

			imageURL = new URL(url);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		HttpURLConnection connection;

		java.io.InputStream in = null;
		try {
			connection = (HttpURLConnection) imageURL.openConnection();
			connection.setRequestProperty("Authorization",
					"Token token=\"z2a5a4ebwj9eaq81\"");
			in = connection.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		Gson gson = new Gson();

		Search search = gson.fromJson(reader, Search.class);
		Capture[] capture = search.getNyplAPI().getResponse().getCapture();

		for (int i = 0; i < capture.length; i++) {
			imageList.add(capture[i].getImageLink().getImageLinkArray()[3]);
			URL url = null;
			try {
				url = new URL(capture[i].getImageLink().getImageLinkArray()[3]);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			icons.add(new ImageIcon(url));
		}

		frame.showImage(icons);

	}

	public ArrayList<String> getImages() {
		return imageList;
	}

}

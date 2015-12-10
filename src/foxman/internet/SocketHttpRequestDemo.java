package foxman.internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import org.omg.CORBA.portable.InputStream;

public class SocketHttpRequestDemo {

	public static void main(String[] args) throws UnknownHostException, IOException{
		//socket is an endpoint for communication between 2 machines
		
		//choose port 80
		Socket socket = new Socket("www.google.com",80 );
		
		//this is the request the computer sends.
		String httpRequestString = "GET /index.html\n\n";
		
		//getting the output string from the socket and writing to the socket
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		out.write(httpRequestString);
		out.flush();//must do this or it wont work
		
		java.io.InputStream in =  socket.getInputStream();
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(in));
		String line;
		while((line = reader.readLine()) != null){
			System.out.println(line);
			
		}
		
		socket.close();
	}
}

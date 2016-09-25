package j2ee.mvn.war.a.httpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class SimpleUrlConnectionHttpClient {
	public static void main(String[] args) {
		// Main argument
		if (args.length < 1) {
			System.err.println("Usage: UrlConnectionClient <url>");
//			return;
			args = new String[]{"https://www.google.fr"};
		}
		try {
			// Parse the URL
			URL url = new URL(args[0].trim());
			// Connect to socket
			URLConnection sock = url.openConnection();
			// Read and print
			BufferedReader reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			String next_record = null;
			while ((next_record = reader.readLine()) != null) {
				System.out.println(next_record);
			}
			// Close connection
			reader.close();
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
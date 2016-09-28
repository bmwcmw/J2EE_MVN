package j2ee.mvn.war.b.adage;

import java.net.InetSocketAddress;

import javax.ws.rs.ext.RuntimeDelegate;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

/**
 * com.sun.net.httpserver is indicated as non resolved due to an access
 * restriction, add an access rule "Accessible" in Java Build Path ==> JRE System Library
 * for the pattern com/sun/net/httpserver/**
 * 
 * http://stackoverflow.com/questions/9266632/access-restriction-is-not-
 * accessible-due-to-restriction-on-required-library/10642163#10642163
 * 
 * @author bmwcmw
 *
 */
public class AdagesPublisher {
	private static final int port = 9876;
	private static final String uri = AdageConstants.PATH + "/";
	private static final String url = "http://localhost:" + port + uri;

	public static void main(String[] args) {
		new AdagesPublisher().publish();
	}

	private void publish() {
		HttpServer server = getServer();
		HttpHandler requestHandler = 
				RuntimeDelegate.getInstance().createEndpoint(new RestfulAdage(),
				HttpHandler.class);
		server.createContext(uri, requestHandler);
		server.start();
		msg(server);
	}

	private HttpServer getServer() {
		HttpServer server = null;
		int backlog = 8;
		try {
			server = HttpServer.create(new InetSocketAddress("localhost", port), backlog);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return server;
	}

	private void msg(HttpServer server) {
		String out = "Publishing RestfulAdage on " + url + ". Hit any key to stop.";
		System.out.println(out);
		try {
			System.in.read();
		} catch (Exception e) {
		}
		server.stop(0); // normal termination
	}
}

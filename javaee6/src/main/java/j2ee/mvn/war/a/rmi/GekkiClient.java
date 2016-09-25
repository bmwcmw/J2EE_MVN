package j2ee.mvn.war.a.rmi;

import java.rmi.Naming;

public class GekkiClient {

	public static void main(String arg[]) {
		// I download server's stubs ==> must set a SecurityManager
		System.setSecurityManager(new SecurityManager());

		try {
			Gekki obj = (Gekki) Naming.lookup("//" + "127.0.0.1" + "/GekkiServer"); 
			// objectname in registry
			System.out.println(obj.sayGekki());
		} catch (Exception e) {
			System.out.println("GekkiClient exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}

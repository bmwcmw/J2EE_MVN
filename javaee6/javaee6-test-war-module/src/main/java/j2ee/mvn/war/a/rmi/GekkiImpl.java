package j2ee.mvn.war.a.rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;

public class GekkiImpl implements Gekki {

	public GekkiImpl() throws RemoteException {}

	@Override
	public String sayGekki() throws RemoteException {
		return "Hello !";
	}

	public static void main(String args[]) {
		try {
			GekkiImpl obj = new GekkiImpl();
			// Bind this object instance to the name "GekkiServer"
			Naming.rebind("GekkiServer", obj);
		} catch (Exception e) {
			System.out.println("HelloImpl err: " + e.getMessage());
			e.printStackTrace();
		}
	}
}

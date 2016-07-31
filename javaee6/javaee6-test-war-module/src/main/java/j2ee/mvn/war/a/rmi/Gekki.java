package j2ee.mvn.war.a.rmi;

import java.rmi.RemoteException;

/**
 * Hello
 * 
 * @author bmwcmw
 *
 */
public interface Gekki extends java.rmi.Remote {
	
	String sayGekki() throws RemoteException;
	
}

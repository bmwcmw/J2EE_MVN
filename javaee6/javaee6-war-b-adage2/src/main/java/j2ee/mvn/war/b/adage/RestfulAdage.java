package j2ee.mvn.war.b.adage;

import java.util.Set;
import java.util.HashSet;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath(AdageConstants.PATH)
public class RestfulAdage extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> set = new HashSet<Class<?>>();
		set.add(AdageResource.class);
		return set;
	}

}

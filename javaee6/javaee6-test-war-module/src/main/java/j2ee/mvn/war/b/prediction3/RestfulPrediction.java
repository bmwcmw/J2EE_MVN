package j2ee.mvn.war.b.prediction3;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/prediction3")
public class RestfulPrediction extends Application {
	
	public Set<Class<?>> getClasses() {
		Set<Class<?>> set = new HashSet<Class<?>>();
		set.add(PredictionsResource.class);
		return set;
	}
	
}

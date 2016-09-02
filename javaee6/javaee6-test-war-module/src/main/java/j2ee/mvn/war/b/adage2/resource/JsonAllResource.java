package j2ee.mvn.war.b.adage2.resource;

import java.util.List;

import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import j2ee.mvn.war.b.adage2.Adage;
import j2ee.mvn.war.b.adage2.Adages;

public class JsonAllResource extends ServerResource {
	public JsonAllResource() {
	}

	@Get
	public Representation toJson() {
		List<Adage> list = Adages.getList();
		JsonRepresentation json = null;
		try {
			json = new JsonRepresentation(new StringRepresentation(list.toString()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}
}

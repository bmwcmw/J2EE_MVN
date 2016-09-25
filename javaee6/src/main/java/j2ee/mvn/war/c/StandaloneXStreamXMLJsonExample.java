package j2ee.mvn.war.c;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;

public class StandaloneXStreamXMLJsonExample {

	public static void main(String[] args) {
		personNoPropsToFromXML();
		personPropsToFromXML();
		personNoPropsToJson();
	}

	static void personNoPropsToFromXML() {
		PersonNoProps bd = new PersonNoProps("Bjoern Daehlie", 49, "Male");
		// setup
		XStream xstream = new XStream(new DomDriver());
		xstream.alias("skier", PersonNoProps.class); // for readability
		// serialize
		String xml = xstream.toXML(bd);
		System.out.println(xml);
		// deserialize and confirm
		PersonNoProps bdClone = (PersonNoProps) xstream.fromXML(xml);
		System.out.println(xstream.toXML(bdClone));
	}

	static void personPropsToFromXML() {
		// Create a person and set only the name.
		PersonProps person = new PersonProps();
		person.setName("Bruno");
		XStream xstream = new XStream(new DomDriver());
		xstream.registerConverter(new PersonPropsConverter());
		xstream.alias("name", PersonProps.class);
		String xml = xstream.toXML(person);
		System.out.println(xml);
		PersonProps clone = (PersonProps) xstream.fromXML(xml);
		System.out.println(clone.getName()); // Bruno
	}

	static void personNoPropsToJson() {
		PersonNoProps bd = new PersonNoProps("Bjoern Daehlie", 49, "Male");
		XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
		String json = xstream.toXML(bd); // it's really toJson now 
		System.out.println(json);
	}

	@SuppressWarnings("unused")
	static class PersonNoProps {
		private String name;
		private int age;
		private String gender;

		public PersonNoProps(String name, int age, String gender) {
			this.name = name;
			this.age = age;
			this.gender = gender;
		}
	}

	static class PersonPropsConverter implements Converter {
		@Override
		public boolean canConvert(@SuppressWarnings("rawtypes") Class c) {
			return c.equals(PersonProps.class);
		}

		// As proof of concept, marshal/unmarshal only the name.
		@Override
		public void marshal(Object object, HierarchicalStreamWriter writer, MarshallingContext context) {
			PersonProps person = (PersonProps) object;
			writer.startNode("Person");
			writer.setValue(person.getName());
			writer.endNode();
		}

		@Override
		public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
			PersonProps person = new PersonProps();
			reader.moveDown();
			person.setName(reader.getValue());
			reader.moveUp();
			return person;
		}
	}

	static class PersonProps {
		private String name;
		private int age;
		private String gender;

		// constructor
		public PersonProps() {
		}

		// properties
		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return this.name;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public int getAge() {
			return this.age;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getGender() {
			return this.gender;
		}
	}
}

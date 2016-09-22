package j2ee.mvn.war.c;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

public class StandaloneJAXBExample {

	private static final String fileName = "c.StandaloneJAXBExample.xml";

	public static void main(String[] args) {
		try {
			JAXBContext ctx = JAXBContext.newInstance(Skier.class);
			Marshaller m = ctx.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			// Marshal a Skier object: 1st to stdout, 2nd to file
			Skier skier = createSkier();
			m.marshal(skier, System.out);
			FileOutputStream out = new FileOutputStream(fileName);
			m.marshal(skier, out);
			out.close();
			// Unmarshal as proof of concept
			Unmarshaller u = ctx.createUnmarshaller();
			Skier bdClone = (Skier) u.unmarshal(new File(fileName));
			System.out.println();
			m.marshal(bdClone, System.out);
		} catch (JAXBException e) {
			System.err.println(e);
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	private static Skier createSkier() {
		Person bd = new Person("Bjoern Daehlie", 49, "Male");
		List<String> list = new ArrayList<String>();
		list.add("12 Olympic Medals");
		list.add("9 World Championships");
		list.add("Winningest Winter Olympian");
		list.add("Greatest Nordic Skier");
		return new Skier(bd, "Norway", list);
	}

	@XmlType
	public static class Person {
		private String name;
		private int age;
		private String gender;

		public Person() {
		}

		public Person(String name, int age, String gender) {
			setName(name);
			setAge(age);
			setGender(gender);
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}
	}

	@XmlRootElement
	public static class Skier {
		private Person person;
		private String nationalTeam;
		private Collection<?> majorAchievements;

		public Skier() {
		} // required for unmarshaling

		public Skier(Person person, String nationalTeam, Collection<String> majorAchievements) {
			setPerson(person);
			setNationalTeam(nationalTeam);
			setMajorAchievements(majorAchievements);
		}

		// properties
		public Person getPerson() {
			return this.person;
		}

		public void setPerson(Person person) {
			this.person = person;
		}

		public String getNationalTeam() {
			return this.nationalTeam;
		}

		public void setNationalTeam(String nationalTeam) {
			this.nationalTeam = nationalTeam;
		}

		public Collection<?> getMajorAchievements() {
			return this.majorAchievements;
		}

		public void setMajorAchievements(Collection<?> majorAchievements) {
			this.majorAchievements = majorAchievements;
		}
	}
}

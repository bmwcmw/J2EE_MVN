package j2ee.mvn.war.b.adage3;

import java.util.Iterator;

import j2ee.mvn.war.b.adage2.Adage;
import j2ee.mvn.war.b.adage2.Adages;

public class Adages3 extends Adages {

	public static Object getListAsArray() {
		return adages.toArray();
	}

	public static void remove(Adage adage) {
		Iterator<Adage> iterator = adages.iterator();
		while (iterator.hasNext()) {
			Adage a = iterator.next();
			if (a.toString().equals(adage.toString())) {
				iterator.remove();
				return;
			}
		}
	}
	
}
package j2ee.mvn.war.c.amazon2;

import java.io.ByteArrayInputStream;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import j2ee.mvn.war.c.amazon1.RestfulAmazonClient;

/**
 * Client that parses xml stream into Document
 *
 */
public class _RestfulAmazonClient2 extends RestfulAmazonClient {

	public static void main(String[] args) {
		RestfulAmazonClient.main(args);
	}

	@Override
	protected String getAuthor(String xml) {
		String author = null;
		try {
			// Create an XML Schema object
			final String fileName = "amazon.xsd"; // downloaded XML Schema
			final String schemaUri = XMLConstants.W3C_XML_SCHEMA_NS_URI;
			SchemaFactory factory = SchemaFactory.newInstance(schemaUri);
			Schema schema = factory.newSchema(new StreamSource(fileName));
			// Create a JAX-B context for unmarshaling
			JAXBContext ctx = JAXBContext.newInstance(ItemLookupResponse.class);
			Unmarshaller um = ctx.createUnmarshaller();
			um.setSchema(schema);
			// Generate a Java ItemSearchResponse instance.
			ItemLookupResponse ilr = (ItemLookupResponse) um.unmarshal(new ByteArrayInputStream(xml.getBytes()));
			// Use the standard POJO idiom to extract the author.
			List<Items> itemsList = ilr.getItems(); // list of lists
			for (Items items : itemsList) { // outer list
				List<Item> list = items.getItem(); // inner list
				for (Item item : list) { // items in inner list
					ItemAttributes attributes = item.getItemAttributes();
					List<String> authors = attributes.getAuthor(); // could be
																	// several
					author = authors.get(0); // in this case, only one
				}
			}
		} catch (JAXBException e) {
			throw new RuntimeException(e);
		}

		catch (Exception e) {
			throw new RuntimeException(e);
		}
		return author;
	}
}

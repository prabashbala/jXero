package com.softlysoftware.jxero;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import com.softlysoftware.jxero.Xml;
import com.softlysoftware.jxero.core.Address;
import com.softlysoftware.jxero.core.Contact;
import com.softlysoftware.jxero.wrappers.Contacts;

@RunWith(JUnit4.class)
public class XmlTest {

	private static String FRED_IN_LONDON = "<Contacts><Contact><Name>Fred</Name><Addresses><Address><City>London</City></Address></Addresses><Phones/></Contact></Contacts>";

	@Test
	public void testToXml() {
		Contact contact = new Contact();
		contact.setName("Fred");
		Address address = new Address();
		address.setCity("London");
		contact.getAddresses().add(address);
		Contacts contacts = new Contacts();
		contacts.getList().add(contact);
		String xml = Xml.toXml(contacts);
		assertEquals("XML doesn't match.", FRED_IN_LONDON, xml);
	}

    @Test
    public void testFromXml() {
    	Contacts contacts = (Contacts)Xml.fromXml(FRED_IN_LONDON, Contacts.class);
    	assertEquals("Wrong number of contacts in list.", 1, contacts.getList().size());
    	Contact contact = contacts.getList().get(0);
    	assertEquals("Wrong number name for contact.", "Fred", contact.getName());
    	assertEquals("Wrong number of addresses.", 1, contact.getAddresses().size());
    	assertEquals("Wrong city name.", "London", contact.getAddresses().get(0).getCity());
    }

}
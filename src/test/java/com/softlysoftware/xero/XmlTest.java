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
		contact.Name = "Fred";
		Address address = new Address();
		address.City = "London";
		contact.Addresses.add(address);
		Contacts contacts = new Contacts();
		contacts.list.add(contact);
		String xml = Xml.toXml(contacts);
		assertEquals("XML doesn't match.", FRED_IN_LONDON, xml);
	}

    @Test
    public void testFromXml() {
    	Contacts contacts = (Contacts)Xml.fromXml(FRED_IN_LONDON, Contacts.class);
    	assertEquals("Wrong number of contacts in list.", 1, contacts.list.size());
    	Contact contact = contacts.list.get(0);
    	assertEquals("Wrong number name for contact.", "Fred", contact.Name);
    	assertEquals("Wrong number of addresses.", 1, contact.Addresses.size());
    	assertEquals("Wrong city name.", "London", contact.Addresses.get(0).City);
    }

}
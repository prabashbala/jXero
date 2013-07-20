package com.softlysoftware.jxero;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import com.softlysoftware.jxero.Xml;
import com.softlysoftware.jxero.XeroClient;
import com.softlysoftware.jxero.core.Address;
import com.softlysoftware.jxero.core.Contact;
import com.softlysoftware.jxero.ContactsEndpoint;

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
		ContactsEndpoint contacts = new ContactsEndpoint(new XeroClient("a", "b", "c"));
		contacts.getList().add(contact);
		String xml = Xml.toXml(contacts);
		assertEquals("XML doesn't match.", FRED_IN_LONDON, xml);
	}

    @Test
    public void testFromXml() {
    	ContactsEndpoint contacts = (ContactsEndpoint)Xml.fromXml(FRED_IN_LONDON, ContactsEndpoint.class);
    	assertEquals("Wrong number of contacts in list.", 1, contacts.getList().size());
    	Contact contact = contacts.getList().get(0);
    	assertEquals("Wrong number name for contact.", "Fred", contact.getName());
    	assertEquals("Wrong number of addresses.", 1, contact.getAddresses().size());
    	assertEquals("Wrong city name.", "London", contact.getAddresses().get(0).getCity());
    }

}
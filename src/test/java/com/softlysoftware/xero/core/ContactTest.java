package com.softlysoftware.jxero;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import com.softlysoftware.jxero.core.Contact;
import com.softlysoftware.jxero.wrappers.Contacts;
import org.apache.commons.io.IOUtils;

@RunWith(JUnit4.class)
public class ContactTest {

    @Test
    public void testFromXml() throws IOException {
    	String xml = IOUtils.toString(getClass().getClassLoader().getResourceAsStream("Contacts.xml"), "UTF-8");
    	Contacts contacts = (Contacts)Xml.fromXml(xml, Contacts.class);
    	assertEquals(1, contacts.getList().size());
    	Contact contact = contacts.getList().get(0);
    	assertEquals(Contact.Status.ACTIVE, contact.getStatus());
    	assertEquals("a.dutchess@abclimited.com", contact.getEmailAddress());
    	assertEquals("6011", contact.getAddresses().get(0).getPostalCode());
    	assertEquals(4, contact.getPhones().size());
    	assertEquals("1111111", contact.getPhones().get(0).getPhoneNumber());
    }

}
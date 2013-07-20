package com.softlysoftware.jxero;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.io.InputStream;
import org.junit.Assert;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import com.softlysoftware.jxero.XeroClient;
import com.softlysoftware.jxero.wrappers.Contacts;

@RunWith(JUnit4.class)
public class XeroClientTest {

	@Test(expected=RuntimeException.class)
	public void testClasspathConstructor() {
		new XeroClient(false);
	}

	/**
	* This one relies on the a set of OAuth credentials being available
	* on the classpath, along with some test data as described in the properties
	* file. If any of this is missing, this one fails safe and just returns;
	*/
	@Test
	public void testConnection() throws IOException {
		Properties properties = new Properties();
		InputStream propertiesStream = this.getClass().getClassLoader().getResourceAsStream("jxero.oauth.properties");
		if (propertiesStream == null) return;
		properties.load(propertiesStream);
		propertiesStream.close();
		String email = properties.getProperty("jxero.test.contact.email");
		String name = properties.getProperty("jxero.test.contact.name");
		if (email == null || email.equals("test@example.com") || name == null || name.equals("Test Inc")) return;
		XeroClient client = new XeroClient(true);
		Contacts contacts = new Contacts(client);
		Assert.assertEquals(name, contacts.getByEmailAddress(email).getName());
	}


}
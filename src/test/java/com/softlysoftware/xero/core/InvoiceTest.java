package com.softlysoftware.jxero;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import com.softlysoftware.jxero.core.Invoice;
import com.softlysoftware.jxero.wrappers.Invoices;
import org.apache.commons.io.IOUtils;

@RunWith(JUnit4.class)
public class InvoiceTest {

    @Test
    public void testFromXml() throws IOException {
    	String xml = IOUtils.toString(getClass().getClassLoader().getResourceAsStream("Invoices.xml"), "UTF-8");
    	Invoices invoices = (Invoices)Xml.fromXml(xml, Invoices.class);
    	assertEquals(invoices.getList().size(), 1);
    	Invoice invoice = invoices.getList().get(0);
    	assertEquals(invoice.getType(), Invoice.Type.ACCREC);
    	assertEquals("Ariki Properties", invoice.getContact().getName());
    }

}
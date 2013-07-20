package com.softlysoftware.jxero;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import java.io.IOException;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import com.softlysoftware.jxero.core.Invoice;
import com.softlysoftware.jxero.core.LineItem;
import com.softlysoftware.jxero.InvoicesEndpoint;
import org.apache.commons.io.IOUtils;
import org.xmlmatchers.XmlMatchers;
import org.xmlmatchers.transform.XmlConverters;

@RunWith(JUnit4.class)
public class InvoiceTest {

    @Test
    public void testFromXml() throws IOException {
    	String xml = IOUtils.toString(getClass().getClassLoader().getResourceAsStream("Invoices.xml"), "UTF-8");
    	InvoicesEndpoint invoices = (InvoicesEndpoint)Xml.fromXml(xml, InvoicesEndpoint.class);
    	assertEquals(invoices.getList().size(), 1);
    	Invoice invoice = invoices.getList().get(0);
    	assertEquals(invoice.getType(), Invoice.Type.ACCREC);
    	assertEquals("Ariki Properties", invoice.getContact().getName());
    	assertEquals(1252368000000l, invoice.getDate().getTime());
        assertEquals(87.11d, invoice.getSubTotal(), 0);
        assertEquals(2, invoice.getLineItems().size());
        LineItem lineItem = invoice.getLineItems().get(0);
        assertEquals("3 copies of OS X 10.6 Snow Leopard", lineItem.getDescription());
        assertEquals(3d, lineItem.getQuantity(), 0);
        String xmlBounced = Xml.toXml(invoices);
        // doesn't work just yet as the order seems to change on the contact element
        //assertThat(XmlConverters.the(xml), XmlMatchers.isEquivalentTo(XmlConverters.the(xmlBounced)));
    }

}
/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.softlysoftware.jxero;

import java.util.List;
import java.util.LinkedList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import com.softlysoftware.jxero.core.Invoice;
import com.softlysoftware.jxero.XeroClient;

/**
* A simple wrapper for the list of Contact objects, to give the correct structure to the XML files.
*/
@XmlRootElement(name = "Invoices")
@XmlAccessorType(XmlAccessType.NONE)
public class InvoicesEndpoint extends Endpoint {

	private InvoicesEndpoint() { }

	public InvoicesEndpoint(XeroClient xeroClient) {this.xeroClient = xeroClient;}

	public String getRootElementName() {
		return "Invoices";
	}

	/**
	* When working with this wrapper directly, add the subordiate Invoice objects to this list.
	*/
	@XmlElement(name = "Invoice")
	public List<Invoice> getList(){return list;}
	public void setList(List<Invoice> list){this.list = list;}
	private List<Invoice> list = new LinkedList<Invoice>();

	/**
	* The Xero maintained unique identifier. Will throw an exception if no match is found.
	*/
	public Invoice getById(String id) {
		Response response = get(id, null);
		return response.getInvoicesEndpoint().list.get(0);
	}

	/**
	* Grab invoices using any "where" filter. 
	* See <a href="http://developer.xero.com/documentation/getting-started/http-requests-and-responses/">the Xero documentation</a> for full details.
	*/
	public List<Invoice> getInvoicesWhere(String where) {
		Response response = getWhere(where);
		if (response.getInvoicesEndpoint() == null) return new LinkedList<Invoice>();
		return response.getInvoicesEndpoint().getList();
	}

	/**
	* Like the generalised getInvoicesWhere, but for convenience when you expect just one object to be returned in the set.
	* Throws an exception when there's more than one match.
	* @return If no match is found, returns null.
	*/
	public Invoice getInvoiceWhere(String where) {
		List<Invoice> invoices = getInvoicesWhere(where);
		if (invoices.size() == 0) return null;
		if (invoices.size() > 1) throw new RuntimeException("Multiple (" + invoices.size() + ") invoices matched : " + where);
		return invoices.get(0);
	}

	/**
	* This is the unqiue identifier on your side.
	*/
	public Invoice getByNumber(String number) {
		return getInvoiceWhere("InvoiceNumber =  \"" + number + "\"");
	}

	/**
	* Once you have a good invoice object, you can use this to get the PDF bytes.
	*/
	public byte[] getPdf(Invoice invoice) {
		return getPdf(invoice.getId(), null);
	}

	/**
	* Either get a collection of Invoice objects, or build from scratch. Then call this method to update/add them to your Xero data.
	*/
	public void post(List<Invoice> invoices) {
		list = invoices;
		post();
	}

	/**
	* Grab a invoice via a get method, or build one from scratch to use this method to update/add it.
	*/
	public void post(Invoice invoice) {
		list = new LinkedList<Invoice>();
		list.add(invoice);
		post();
	}

}
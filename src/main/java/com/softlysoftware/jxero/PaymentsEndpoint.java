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
import com.softlysoftware.jxero.core.Payment;
import com.softlysoftware.jxero.XeroClient;

/**
* A simple wrapper for the list of Payment objects, to give the correct structure to the XML files.
*/
@XmlRootElement(name = "Payments")
@XmlAccessorType(XmlAccessType.NONE)
public class PaymentsEndpoint extends Endpoint {

	private PaymentsEndpoint() { }

	public PaymentsEndpoint(XeroClient xeroClient) {this.xeroClient = xeroClient;}

	public String getRootElementName() {
		return "Payments";
	}

	/**
	* When working with this wrapper directly, add the subordiate Payment objects to this list.
	*/
	@XmlElement(name = "Payment")
	public List<Payment> getList(){return list;}
	public void setList(List<Payment> list){this.list = list;}
	private List<Payment> list = new LinkedList<Payment>();

	/**
	* The Xero maintained unique identifier. Will throw an exception if no match is found.
	*/
	public Payment getById(String id) {
		Response response = get(id, null);
		return response.getPaymentsEndpoint().list.get(0);
	}

	/**
	* Grab payments using any "where" filter. 
	* See <a href="http://developer.xero.com/documentation/getting-started/http-requests-and-responses/">the Xero documentation</a> for full details.
	*/
	public List<Payment> getPaymentsWhere(String where) {
		Response response = getWhere(where);
		if (response.getPaymentsEndpoint() == null) return new LinkedList<Payment>();
		return response.getPaymentsEndpoint().getList();
	}

	/**
	* Like the generalised getPaymentsWhere, but for convenience when you expect just one object to be returned in the set.
	* Throws an exception when there's more than one match.
	* @return If no match is found, returns null.
	*/
	public Payment getPaymentWhere(String where) {
		List<Payment> payments = getPaymentsWhere(where);
		if (payments.size() == 0) return null;
		if (payments.size() > 1) throw new RuntimeException("Multiple (" + payments.size() + ") payments matched : " + where);
		return payments.get(0);
	}

	/**
	* Either get a collection of Payment objects, or build from scratch. Then call this method to update/add them to your Xero data.
	*/
	public List<Payment> post(List<Payment> payments) {
		list = payments;
		return post().getPaymentsEndpoint().getList();
	}

	/**
	* Grab a payment via a get method, or build one from scratch to use this method to update/add it.
	*/
	public Payment post(Payment payment) {
		list = new LinkedList<Payment>();
		list.add(payment);
		return post().getPaymentsEndpoint().getList().get(0);
	}

}
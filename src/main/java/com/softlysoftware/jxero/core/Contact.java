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
package com.softlysoftware.jxero.core;

import java.util.List;
import java.util.LinkedList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
* Xero's <a href="http://developer.xero.com/documentation/api/contacts/">Contact record</a>.
*/
@XmlRootElement(name = "Contact")
public class Contact {

	public String ContactID;
	public String ContactStatus;
	public String Name;
	public String FirstName;
	public String LastName;
	public String EmailAddress;
	public String SkypeUserName;
	public String BankAccountDetails;
	public String TaxNumber;
	public String AccountsReceivableTaxType;
	public String AccountsPayableTaxType;
	public String UpdatedDateUTC;
    public String IsSupplier;
    public String IsCustomer;
    public String DefaultCurrency;

	@XmlElementWrapper
	@XmlElement(name="Address")
	public List<Address> Addresses = new LinkedList<Address>();

	@XmlElementWrapper
	@XmlElement(name="Phone")
	public List<Phone> Phones = new LinkedList<Phone>();
}
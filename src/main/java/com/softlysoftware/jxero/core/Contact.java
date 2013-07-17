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
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
* Xero's <a href="http://developer.xero.com/documentation/api/contacts/">Contact record</a>.
*/
@XmlRootElement(name = "Contact")
@XmlAccessorType(XmlAccessType.NONE)
public class Contact {

	@XmlElement(name = "ContactID")
	public String getContactID(){return contactID;}
	public void setContactID(String contactID){this.contactID = contactID;}
	private String contactID;

	@XmlElement(name = "ContactStatus")
	public String getContactStatus(){return contactStatus;}
	public void setContactStatus(String contactStatus){this.contactStatus = contactStatus;}
	private String contactStatus;

	@XmlElement(name = "Name")
	public String getName(){return name;}
	public void setName(String name){this.name = name;}
	private String name;

	@XmlElement(name = "FirstName")
	public String getFirstName(){return firstName;}
	public void setFirstName(String firstName){this.firstName = firstName;}
	private String firstName;

	@XmlElement(name = "LastName")
	public String getLastName(){return lastName;}
	public void setLastName(String lastName){this.lastName = lastName;}
	private String lastName;

	@XmlElement(name = "EmailAddress")
	public String getEmailAddress(){return emailAddress;}
	public void setEmailAddress(String emailAddress){this.emailAddress = emailAddress;}
	private String emailAddress;

	@XmlElement(name = "SkypeUserName")
	public String getSkypeUserName(){return skypeUserName;}
	public void setSkypeUserName(String skypeUserName){this.skypeUserName = skypeUserName;}
	private String skypeUserName;

	@XmlElement(name = "BankAccountDetails")
	public String getBankAccountDetails(){return bankAccountDetails;}
	public void setBankAccountDetails(String bankAccountDetails){this.bankAccountDetails = bankAccountDetails;}
	private String bankAccountDetails;

	@XmlElement(name = "TaxNumber")
	public String getTaxNumber(){return taxNumber;}
	public void setTaxNumber(String taxNumber){this.taxNumber = taxNumber;}
	private String taxNumber;

	@XmlElement(name = "AccountsReceivableTaxType")
	public String getAccountsReceivableTaxType(){return accountsReceivableTypeType;}
	public void setAccountsReceivableTaxType(String accountsReceivableTypeType){this.accountsReceivableTypeType = accountsReceivableTypeType;}
	private String accountsReceivableTypeType;

	@XmlElement(name = "AccountsPayableTaxType")
	public String getAccountsPayableTaxType(){return accountsPayableTaxType;}
	public void setAccountsPayableTaxType(String accountsPayableTaxType){this.accountsPayableTaxType = accountsPayableTaxType;}
	private String accountsPayableTaxType;

	@XmlElement(name = "UpdatedDateUTC")
	public String getUpdatedDateUTC(){return updatedDateUTC;}
	public void setUpdatedDateUTC(String updatedDateUTC){this.updatedDateUTC = updatedDateUTC;}
	private String updatedDateUTC;

	@XmlElement(name = "IsSupplier")
	public String getIsSupplier(){return isSupplier;}
	public void setIsSupplier(String isSupplier){this.isSupplier = isSupplier;}
	private String isSupplier;

	@XmlElement(name = "IsCustomer")
	public String getIsCustomer(){return isCustomer;}
	public void setIsCustomer(String isCustomer){this.isCustomer = isCustomer;}
	private String isCustomer;

	@XmlElement(name = "DefaultCurrency")
	public String getDefaultCurrency(){return defaultCurrency;}
	public void setDefaultCurrency(String defaultCurrency){this.defaultCurrency = defaultCurrency;}
	private String defaultCurrency;

	@XmlElementWrapper(name = "Addresses")
	@XmlElement(name = "Address")
	public List<Address> getAddresses() {return addresses;}
	public void setAddresses(List<Address> addresses) {this.addresses = addresses;}
	private List<Address> addresses = new LinkedList<Address>();

	@XmlElementWrapper(name = "Phones")
	@XmlElement(name = "Phone")
	public List<Phone> getPhones(){return phones;}
	public void setPhones(List<Phone> phones){this.phones = phones;}
	private List<Phone> phones = new LinkedList<Phone>();

}
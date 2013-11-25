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

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlRootElement(name = "Payment")
@XmlAccessorType(XmlAccessType.NONE)
public class Payment {

	@XmlElement(name = "Invoice")
	private Invoice invoice;
	public Invoice getInvoice(){return invoice;}
	public void setInvoice(Invoice invoice){this.invoice = invoice;}

	@XmlElement(name = "Account")
	private Account account;
	public Account getAccount(){return account;}
	public void setAccount(Account account){this.account = account;}

	@XmlElement(name = "Date")
	private String date;
	public Date getDate(){return Formats.parseDate(date);}
	public void setDate(Date date){this.date = Formats.formatDate(date);}

	@XmlElement(name = "CurrencyRate")
	private String currencyRate;
	public double getCurrencyRate(){return Formats.parseQuantity(currencyRate);}
	public void setCurrencyRate(double currencyRate){this.currencyRate = Formats.formatQuantity(currencyRate);} 

	@XmlElement(name = "Amount")
	private String amount;
	public double getAmount(){return Formats.parseMoney(amount);}
	public void setAmount(double amount){this.amount = Formats.formatMoney(amount);} 

	@XmlElement(name = "Reference")
	private String reference;
	public String getReference(){return reference;}
	public void setReference(String reference){this.reference = reference;}

}
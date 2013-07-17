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

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlRootElement(name = "Address")
@XmlAccessorType(XmlAccessType.NONE)
public class Address {

	@XmlElement(name = "AddressType")
	public String getAddressType() {return addressType;}
	public void setAddressType(String addressType) {this.addressType = addressType;}
	private String addressType;

	@XmlElement(name = "AddressLine1")
	public String getAddressLine1(){return addressLine1;}
	public void setAddressLine1(String addressLine1){this.addressLine1 = addressLine1;}
	private String addressLine1;

	@XmlElement(name = "AddressLine2")
	public String getAddressLine2(){return addressline2;}
	public void setAddressLine2(String addressline2){this.addressline2 = addressline2;}
	private String addressline2;

	@XmlElement(name = "AddressLine3")
	public String getAddressLine3(){return addressLine3;}
	public void setAddressLine3(String addressLine3){this.addressLine3 = addressLine3;}
	private String addressLine3;

	@XmlElement(name = "AddressLine4")
	public String getAddressLine4(){return addressLine4;}
	public void setAddressLine4(String addressLine4){this.addressLine4 = addressLine4;}
	private String addressLine4;

	@XmlElement(name = "City")
	public String getCity(){return city;}
	public void setCity(String city){this.city = city;}
	private String city;

	@XmlElement(name = "PostalCode")
	public String getPostalCode(){return postalCode;}
	public void setPostalCode(String postalCode){this.postalCode = postalCode;}
	private String postalCode;

	@XmlElement(name = "Country")
	public String getCountry(){return country;}
	public void setCountry(String country){this.country = country;}
	private String country;

	@XmlElement(name = "AttentionTo")
	public String getAttentionTo(){return attentionTo;}
	public void setAttentionTo(String attentionTo){this.attentionTo = attentionTo;}
	private String attentionTo;

}
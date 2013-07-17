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

@XmlRootElement(name = "Phone")
@XmlAccessorType(XmlAccessType.NONE)
public class Phone {

	@XmlElement(name = "PhoneType")
	public String getPhoneType(){return phoneType;}
	public void setPhoneType(String phoneType){this.phoneType = phoneType;}
	private String phoneType;

	@XmlElement(name = "PhoneNumber")
	public String getPhoneNumber(){return phoneNumber;}
	public void setPhoneNumber(String phoneNumber){this.phoneNumber = phoneNumber;}
	private String phoneNumber;

	@XmlElement(name = "PhoneAreaCode")
	public String getPhoneAreaCode(){return phoneAreaCode;}
	public void setPhoneAreaCode(String phoneAreaCode){this.phoneAreaCode = phoneAreaCode;}
	private String phoneAreaCode;

	@XmlElement(name = "PhoneCountryCode")
	public String getPhoneCountryCode(){return phoneCountryCode;}
	public void setPhoneCountryCode(String phoneCountryCode){this.phoneCountryCode = phoneCountryCode;}
	private String phoneCountryCode;

}
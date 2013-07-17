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

@XmlRootElement(name = "Invoice")
@XmlAccessorType(XmlAccessType.NONE)
public class Invoice {

	public enum Type {ACCPAY, ACCREC};

	@XmlElement(name = "Type")
	private String type;
	public Type getType() {
		if (type == null) return null;
		if (type.equals("ACCPAY")) return Type.ACCPAY;
		if (type.equals("ACCREC")) return Type.ACCREC;
		throw new RuntimeException("Bad Invoice type : " + type);
	}
	public void setType(Type type) {this.type = type.toString();}

	@XmlElement(name = "Contact")
	private Contact contact;
	public Contact getContact(){return contact;}
	public void setContact(Contact contact){this.contact = contact;}

}
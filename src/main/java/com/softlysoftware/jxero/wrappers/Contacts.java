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
package com.softlysoftware.jxero.wrappers;

import java.util.List;
import java.util.LinkedList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import com.softlysoftware.jxero.core.Contact;
import com.softlysoftware.jxero.XeroClient.Method;

/**
* A simple wrapper for the list of Contact objects, to give the correct structure to the XML files.
*/
@XmlRootElement(name = "Contacts")
public class Contacts extends Endpoint {

	/**
	* Contacts supports all three kinds of method.
	*/
	public boolean supportsMethod(Method method) {
		return true;
	}

	/**
	* When working with this wrapper directly, add the subordiate Contact objects to this list.
	*/
	@XmlElement(name = "Contact")
	public List<Contact> list = new LinkedList<Contact>();

}
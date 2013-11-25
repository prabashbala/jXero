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

@XmlRootElement(name = "Account")
@XmlAccessorType(XmlAccessType.NONE)
public class Account {

	@XmlElement(name = "AccountID")
	private String id;
	public String getId(){return id;}
	public void setId(String id){this.id = id;}

	@XmlElement(name = "Code")
	private String code;
	public String getCode(){return code;}
	public void setCode(String code){this.code = code;}

	@XmlElement(name = "Name")
	private String name;
	public String getName(){return name;}
	public void setName(String name){this.name = name;}

}
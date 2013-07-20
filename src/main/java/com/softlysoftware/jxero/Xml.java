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

import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import com.softlysoftware.jxero.Wrapper;

/**
* Helper class to encapsulate the messy business of going to and from the XML.
* As with making sausages, you don't necessarily want to <i>see</i> this.
*/
public class Xml {

	/**
	* Any Wrapper object can be marshalled to XML this way. As with most of the documents
	* you see from the Xero service, we don't include the declaration.
	*/
	public static String toXml(Wrapper wrapper) {
		try {
			StringWriter stringWriter = new StringWriter();
			JAXBContext jaxbContext = JAXBContext.newInstance(wrapper.getClass());
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
			//marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(wrapper, stringWriter);
			return stringWriter.toString();
		} 
		catch (JAXBException je) {
			throw new RuntimeException("Problem with JAXB configuration.", je);
		}
	}

	/**
	* The other end of the sausage machine.
	*/
	public static Wrapper fromXml(String xml, Class wrapperClass) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(wrapperClass);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			return ((JAXBElement<Wrapper>)unmarshaller.unmarshal(new StreamSource(new StringReader(xml)), wrapperClass)).getValue();
		}
		catch (JAXBException je) {
			throw new RuntimeException("Problem with JAXB configuration.", je);
		}
	}

}
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
import java.io.IOException;
import java.io.InputStream;
import com.softlysoftware.jxero.Xml;
import com.softlysoftware.jxero.XeroClient;
import java.net.URISyntaxException;
import net.oauth.OAuthException;
import net.oauth.OAuthMessage;
import net.oauth.OAuth;
import net.oauth.client.OAuthClient;
import net.oauth.client.httpclient4.HttpClient4;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
* Models one of the endpoints of the Xero API, e.g. "Contacts".
*/
public abstract class Endpoint extends Wrapper {

	private static Log log = LogFactory.getLog("jxero.endpoint");

	private static String BASE =  "https://api.xero.com/api.xro/2.0/";

	protected XeroClient xeroClient;

	private enum Method {GET, POST, PUT};

	public abstract String getRootElementName();

	private byte[] invoke(Method method, String identifier, List<OAuth.Parameter> params, HttpClient4 httpClient) {
		try {
			OAuthClient oAuthClient = new OAuthClient(httpClient);
			String url = BASE + getRootElementName() + "/";
			if (identifier != null) url = url + identifier;
			if (params == null) params = OAuth.newList();
			log.trace("Invoking : " + method + " on " + url);
			log.trace("--------------------------------");
			for (OAuth.Parameter param : params) {
				log.trace(param.getKey() + " : " + param.getValue());
			}
			log.trace("--------------------------------");
			OAuthMessage message = oAuthClient.invoke(xeroClient.getOAuthAccessor(), method.toString(), url, params);
			InputStream in = message.getBodyAsStream();
			byte[] build = IOUtils.toByteArray(in);
			in.close();
			return build;
		}
		catch (URISyntaxException urise) {
			throw new RuntimeException("Should not happen?", urise);
		}
		catch (IOException ioe) {
			throw new RuntimeException("Something went wrong connecting to the service.", ioe);
		}
		catch (OAuthException oae) {
			//oae.printStackTrace();
			throw new RuntimeException("Something went wrong with the OAuth connection.", oae);
		}
	}

	protected Response get(String identifier, List<OAuth.Parameter> params) {
		return Response.getResponse(invoke(Method.GET, identifier, params, new HttpClient4()));
	}

	protected Response getWhere(String where) {
		return get(null, OAuth.newList("where", where));
	}

	protected byte[] getPdf(String identifier, List<OAuth.Parameter> params) {
		return  invoke(Method.GET, identifier, params, new HeaderSettableHttpClient("Accept", "application/pdf"));
	}

	protected Response post() {
		String xml = Xml.toXml(this);
		return Response.getResponse(invoke(Method.POST, null, OAuth.newList("xml", xml), new HttpClient4()));
	}

	protected Response put() {
		String xml = Xml.toXml(this);
		return Response.getResponse(invoke(Method.PUT, null, OAuth.newList("xml", xml), new HttpClient4()));
	}

}
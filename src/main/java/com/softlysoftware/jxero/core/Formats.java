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
import java.util.TimeZone;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

/**
* We use this class as a simple way to convert between strings
* and interesting values, after speaking direct to the API.
*/
public class Formats {

	// --------- Dates

	// TODO - Parse using the Xero Account's timezone
	private static SimpleDateFormat DATE = new SimpleDateFormat("yyyy-MM-dd'T00:00:00'");
	static {DATE.setTimeZone(TimeZone.getTimeZone("UTC"));}

	public static Date parseDate(String date) {
		try {return DATE.parse(date);}
		catch (ParseException e) {throw new RuntimeException(e);}
	}

	public static String formatDate(Date date) {
		return DATE.format(date);
	}

	// --------- Money

	private static NumberFormat MONEY = new DecimalFormat("0.00");

	public static double parseMoney(String money) {
		try {return MONEY.parse(money).doubleValue();}
		catch (ParseException e) {throw new RuntimeException(e);}
	}

	public static String formatMoney(double money) {
		return MONEY.format(money);
	}

	public static String formatMoney(BigDecimal money) {
		return MONEY.format(money);
	}

	// --------- Quantity

	private static NumberFormat QUANTITY = new DecimalFormat("0.0000");

	public static double parseQuantity(String quantity) {
		try {return QUANTITY.parse(quantity).doubleValue();}
		catch (ParseException e) {throw new RuntimeException(e);}
	}

	public static String formatQuantity(double quantity) {
		return QUANTITY.format(quantity);
	}

	public static String formatQuantity(BigDecimal quantity) {
		return QUANTITY.format(quantity);
	}

}
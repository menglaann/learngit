package com.ericsson.parking.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Jiarong Xu
 * @date Jun 4, 2013 10:11:11 AM
 *
 */

public class CalendarUtil {

	public static final String DEFAULT_DATE_FORMAT = "yyyyMMdd";
	
	public static final String DEFAULT_TIME_FORMAT = "yyyyMMddHHmm";

	public static Calendar parseDate(String input) {
		return parseDate(input, DEFAULT_DATE_FORMAT);
	}

	public static Calendar parseDate(String input, String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		Calendar calendar = Calendar.getInstance();
		try {
			Date date = dateFormat.parse(input);
			calendar.setTime(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		return calendar;
	}

	public static String toString(Calendar cal) {
		return toString(cal, DEFAULT_DATE_FORMAT);
	}
	
	public static String toString(Calendar cal, String format) {
		if (null == cal) {
			return null;
		}
		DateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(cal.getTime());
	}
}

package com.esoft.coursework.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	static final String DATE_FORMAT = "dd-MM-yyyy";
	
	public static Date getDateTime() throws ParseException {
	    return new Date();
	}
	
	public static Date stringToDateTime(String date) throws ParseException {
	    SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
	    
	    return dateFormat.parse(date);
	}
}

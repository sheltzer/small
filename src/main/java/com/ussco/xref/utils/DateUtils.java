package com.ussco.xref.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	
	public static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
	
	public static String nowAsString() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		
		return sdf.format(cal.getTime());
	}
	
	public static Date nowAsDate() {
		Calendar cal = Calendar.getInstance();
		
		return cal.getTime();
	}

}

package com.mostafa.sna.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormater {
	
	public String dateToStringConverter(Date date, String pattern) {
		
		DateFormat df = new SimpleDateFormat(pattern);
		String dateAsString = df.format(date);
		
		System.out.println("Date: "+dateAsString);
		
		return dateAsString;
		
	}
	
}

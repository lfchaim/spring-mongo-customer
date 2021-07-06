package com.lfchaim.springmongocustomer.util;

import java.util.Calendar;
import java.util.List;

public class LogUtil {

	public static String printTime( List<Calendar> list ) {
		StringBuffer sb = new StringBuffer();
		for( int i = 0; i < list.size(); i++ ) {
			if( i > 0 ) {
				sb.append("Tempo "+(i)+" ").append((list.get(i).getTimeInMillis()-list.get(i-1).getTimeInMillis())).append(" milisegundos ").append("\n");
			}
		}
		return sb.toString();
	}
}

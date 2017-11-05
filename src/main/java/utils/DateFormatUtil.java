package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateFormatUtil {
	
	
	/**
	 * Format date to model dd-MM-yyyy as usually used in Brazil
	 * 
	 * @param day day of the month
	 * @param month month of the year
	 * @param year year
	 * 
	 * @return formated string date pattern
	 */
	public String formatDateToString(int day, int month, int year) {
		
		Calendar date = GregorianCalendar.getInstance();
		date.set(year, month, day);
		Date currentDate = date.getTime();
		
		return new SimpleDateFormat("dd-MM-yyyy").format(currentDate);
	}
	
	/**
	 * Format date so its in Brazil's default pattern
	 * @param day day of the month
	 * @param month month of the year
	 * @param year year
	 * 
	 * @return formated date pattern 
	 */
	public Date formatDateBrazilDefault(int day, int month, int year) {
		Calendar date = GregorianCalendar.getInstance();
		date.set(year, month, day);
		return date.getTime();
	}

}

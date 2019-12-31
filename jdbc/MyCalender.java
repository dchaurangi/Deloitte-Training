package jdbc;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class MyCalender {
	static long diffDays;
		
		public static void main(String[] args)
		{
			Calendar cal = Calendar.getInstance();
			//System.out.println(cal);
			int yr = cal.get(Calendar.YEAR);
			int mon = cal.get(Calendar.MONTH);
			int day = cal.get(Calendar.DATE);
			//System.out.println(day+":"+(mon+1)+":"+yr);
			Date dt = new Date();
			long millis = dt.getTime();
			Calendar calndr = Calendar.getInstance();
			calndr.setTime(dt);
			calndr.setTimeInMillis(millis);
			
			LocalDate ld = LocalDate.now();
			//System.out.println(ld);
			DateTimeFormatter dft = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			//System.out.println(dft.format(ld));
			
			System.out.println("My next birthday from today is "+daysToDate("14-05-2020")+" days left");
			difference_between_two_dates("14-05-2020");	
		}
		
		public static long daysToDate(String date)
		{
			
			LocalDate ld = LocalDate.now();
			DateTimeFormatter dft = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String dateStart = dft.format(ld);
			String dateStop = date;

			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

			Date d1 = null;
			Date d2 = null;

			try {
				d1 = format.parse(dateStart);
				d2 = format.parse(dateStop);

				long diff = d2.getTime() - d1.getTime();
				 diffDays = diff / (24 * 60 * 60 * 1000);

			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return (diffDays);
		}
		
		public static void difference_between_two_dates(String date)
		{
		     LocalDate dateOfBirth = LocalDate.parse(date,  DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		     LocalDate currentDate = LocalDate.now();
		     long diffInDays = ChronoUnit.DAYS.between(currentDate, dateOfBirth);
		     long diffInMonths = ChronoUnit.MONTHS.between(currentDate, dateOfBirth);
		     long diffInYears = ChronoUnit.YEARS.between(currentDate, dateOfBirth);
		     System.out.println("The no. of days, months, years left for my next birthday are : "+diffInDays+":"+diffInMonths+":"+diffInYears);
		}




}

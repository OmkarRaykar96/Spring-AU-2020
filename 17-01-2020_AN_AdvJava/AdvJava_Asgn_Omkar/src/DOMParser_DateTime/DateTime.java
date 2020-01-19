package DOMParser_DateTime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
//import java.time.days;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class DateTime {
	public static void getDifferentTimeZone(String My, String Others, String Zone) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
			
			LocalDate mine = LocalDate.parse(My,formatter);
		    LocalDate other = LocalDate.parse(Others,formatter);
		    
		    LocalDateTime obj_ld_1 = mine.atStartOfDay();	    
		    LocalDateTime obj_ld_2 = other.atStartOfDay();
		    
		    ZonedDateTime two = obj_ld_2.atZone(ZoneId.of(Zone));
		    
		    long days = ChronoUnit.DAYS.between(obj_ld_1, two);
		    
		    System.out.println("Time gap in days: "+days);
		    
		}
		catch(Exception e) {
			System.out.println("Exception Occured: "+e);
			System.out.println("Inappropriate Time Zone");
		}   
	}
	
	public static void calDayTimeGap(String My, String Others){
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
			
			LocalDate mine = LocalDate.parse(My,formatter);
		    LocalDate other = LocalDate.parse(Others,formatter);
		    
		    LocalDateTime obj_ld_1 = mine.atStartOfDay();	    
		    LocalDateTime obj_ld_2 = other.atStartOfDay();
		 
		    long dayGap = ChronoUnit.DAYS.between(mine, other);
		    long timeGap = ChronoUnit.NANOS.between(obj_ld_1, obj_ld_2);
		    
		    System.out.println("Age gap in -> Days :"+dayGap + ", Time (Nanosec):"+timeGap);
		}
		catch(Exception e) {
			System.err.println("Exception Occured: " + e );
			System.out.println("Incorrect Date Format!!!");
		}
	}
	
	public static void  main(String[] args) {
			Scanner sc = new Scanner(System.in);
		
			System.out.println("Enter your DOB (dd/mm/yyyy): ");
			String MyBday = sc.next();
			
			System.out.println("Enter Family Member's DOB (dd/mm/yyyy):");
			String OtherBday = sc.next();
			
			calDayTimeGap(MyBday,OtherBday); 
			
			
			System.out.println("Enter the TimeZone:");
			String currTimeZone = sc.next();
			
			getDifferentTimeZone(MyBday,OtherBday,currTimeZone);
	}
}
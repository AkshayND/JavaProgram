/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/* Name of the class has to be "Main" only if the class is public. */
public class DatePgm {
    
    public void myDate(LocalDate fromDateLocal, LocalDate toDateLocal){


        DateTimeFormatter fromDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fromDate = fromDateLocal.format(fromDateFormatter);


        DateTimeFormatter toDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String toDate = toDateLocal.format(toDateFormatter);
        
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String todayDate = date.format(formatter);
        System.out.println("Today's date: " + todayDate);

        //String todayDate = "2016-11-14";
        String[] stodayDate = todayDate.split("-");
        String[] sfromDate = fromDate.split("-");
        String[] stoDate = toDate.split("-");
        Integer[] endDate = {31,28,31,30,31,30,31,31,30,31,30,31};
        int month;
        // first day of the month
        sfromDate[2] = "01";
        
        // check if toDate month is greater than todayDate month hence we will put the values of current date into toDate
        // year will be greater while month will be greater than or equal to. 
        if(Integer.parseInt(stoDate[1]) >= Integer.parseInt(stodayDate[1]) || Integer.parseInt(stoDate[0]) > Integer.parseInt(stodayDate[0])){
    	       stoDate[2] = stodayDate[2];
    	       stoDate[1] = stodayDate[1];
    	       stoDate[0] = stodayDate[0];
        }
        else{
            // since array starts from 0, hence for month June i.e. 06, entry in the array will be in endDate[5]. 
        	month = Integer.parseInt(stoDate[1])-1;

            // if month is Feb, we've to check for leap year.  
            if(month == 1){

                // if it is a leap year we've to create new Integer object of that month's end date i.e. 28 + 1.
                if(Integer.parseInt(stoDate[0].substring(2)) % 4 == 0)
                    stoDate[2] = (new Integer(endDate[month] + 1)).toString();
                
            }
            else{
                stoDate[2] = endDate[month].toString();
            }
	
        }	

        System.out.println("");
        System.out.println("From date: " + fromDate);
        System.out.println("Converted From Date: " + String.join("-",sfromDate));
        
        System.out.println("");
        System.out.println("To date: " + toDate);
        System.out.println("Converted To Date: " + String.join("-",stoDate));
    }
    
    public static void main(String args[]) {
        
        DatePgm m = new DatePgm();
        
        LocalDate fromDateLocal = LocalDate.of(2018, 4, 11);

        LocalDate toDateLocal = LocalDate.of(2016, 2, 12);

        System.out.println("First Iteration"); 
        m.myDate(fromDateLocal,toDateLocal);

        fromDateLocal = LocalDate.of(2018, 4, 11);

        toDateLocal = LocalDate.of(2018, 7, 12);

        System.out.println("");
        System.out.println("Second Iteration"); 
        m.myDate(fromDateLocal,toDateLocal);

    }
}
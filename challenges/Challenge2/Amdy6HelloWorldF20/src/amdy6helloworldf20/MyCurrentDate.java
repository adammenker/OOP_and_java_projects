/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amdy6helloworldf20;

import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;

/**
 *
 * @author adammenker
 */

// I used https://beginnersbook.com/2017/10/java-display-time-in-12-hour-format-with-ampm/ and used some code from here
public class MyCurrentDate {
    
    public void printDate(){   	
    	//Displaying current date and time in 12 hour format with AM/PM
    	DateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy hh:mmaa");
    	String dateString2 = dateFormat2.format(new Date());
    	System.out.println("Today's date is " + dateString2);
    }
}

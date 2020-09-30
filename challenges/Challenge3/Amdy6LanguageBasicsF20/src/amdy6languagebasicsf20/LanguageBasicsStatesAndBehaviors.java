/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amdy6languagebasicsf20;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author adammenker
 */
public class LanguageBasicsStatesAndBehaviors {
    
    public char c1;
    public char c2;
    public short qualityScore;
    public int months = 12;
    public float miles = 1023.5f;
    public float days = 365f;
    public boolean sunny = true;
    public boolean warm = false;
    
    public String greeting = "Hello";
    public String myPawPrint = "amdy6";
    
    public LanguageBasicsStatesAndBehaviors(char c1, char c2, short qualityScore, int months, float miles, float days, boolean sunny, boolean warm, String greeting, String myPawPrint){
        
        this.c1 = c1;
        this.c2 = c2;
        this.qualityScore = qualityScore;
        this.months = months;
        this.miles = miles;
        this.days = days;
        this.sunny = sunny;
        this.warm = warm; 
        this.greeting = greeting;
        this.myPawPrint = myPawPrint;
    }
    
    public void displayComparedChars(char a, char b) {
        if(a == b){
            System.out.printf("%c and %c are the same\n", a, b);
        } else {
            System.out.printf("%c and %c are NOT the same\n", a, b);
        }
    }
    
    public void displayQualityScore(int qualityScore){
        if(qualityScore >= 0 && qualityScore <= 75){
            System.out.printf("The quality is bad.\n");
        } else{
            System.out.printf("Good quality.\n");
        }
    }
    
    public void displayDcm(int months, float days) {
        float dcm = ((months * miles) / days);
        System.out.printf("My average daily car mileage = %.2f\n", dcm);
    }
    
    public void displayTodaysPlan(boolean sunny, boolean warm){
        if(sunny == true && warm == true){
            System.out.printf("Go swimming at beach.\n");
        } else if(sunny == false && warm == true){
            System.out.printf("Go for a drive.\n");
        } else {
            System.out.printf("Stay home and code.\n");
        }
    }

    // I used https://studyfied.com/tutorial/java/date-time/localtime/ to figure out how to access and find the system clocks local hour and time
    // I used https://docs.oracle.com/javase/8/docs/api/java/time/LocalTime.html#getHour-- to discover the methods for getting the hour and minute
    public void displayTheCurrentTimeOfDay(){
        LocalTime localTime = LocalTime.now();
        int hour = localTime.getHour();
        int minute = localTime.getMinute();
        
        // making single digits have '0' in front
        String minuteWithZero;
        if(minute < 10){
            minuteWithZero = "0" + minute;
        } else {
            minuteWithZero = "" + minute;
        }
        
        // establishing AM or PM
        String AM_PM;
        if(hour > 11){
            AM_PM = "PM";
        } else {
            AM_PM = "AM";
        }
        // using another variable to hold hour in normal time (instead of military)
        int hourWithConversion;
        hourWithConversion = (hour % 12);
        if(hourWithConversion == 0){
            hourWithConversion = 12;
        }
        
        // converted to 0-23 hour system instead of 1-24
        hour--;
        
        String timeString;
        switch (hour) {
            case (23): 
                    timeString = ("The current time is " + hourWithConversion + ":" + minuteWithZero + AM_PM + " in the NIGHT.\n");
                    break;
            case (0): 
                    timeString = ("The current time is " + hourWithConversion + ":" + minuteWithZero + AM_PM + " in the NIGHT.\n");
                    break;
            case (1): 
                    timeString = ("The current time is " + hourWithConversion + ":" + minuteWithZero + AM_PM + " in the NIGHT.\n");
                    break;
            case (2): 
                    timeString = ("The current time is " + hourWithConversion + ":" + minuteWithZero + AM_PM + " in the NIGHT.\n");
                    break;
            case (3): 
                    timeString = ("The current time is " + hourWithConversion + ":" + minuteWithZero + AM_PM + " in the NIGHT.\n");
                    break;
            case (4): 
                    timeString = ("The current time is " + hourWithConversion + ":" + minuteWithZero + AM_PM + " in the NIGHT.\n");
                    break;
            case (5): 
                    timeString = ("The current time is " + hourWithConversion + ":" + minuteWithZero + AM_PM + " in the MORNING.\n");
                    break;
            case (6): 
                    timeString = ("The current time is " + hourWithConversion + ":" + minuteWithZero + AM_PM + " in the MORNING.\n");
                    break;
            case (7): 
                    timeString = ("The current time is " + hourWithConversion + ":" + minuteWithZero + AM_PM + " in the MORNING.\n");
                    break;
            case (8): 
                    timeString = ("The current time is " + hourWithConversion + ":" + minuteWithZero + AM_PM + " in the MORNING.\n");
                    break;
            case (9): 
                    timeString = ("The current time is " + hourWithConversion + ":" + minuteWithZero + AM_PM + " in the MORNING.\n");
                    break;
            case (10): 
                    timeString = ("The current time is " + hourWithConversion + ":" + minuteWithZero + AM_PM + " in the MORNING.\n");
                    break;
            case (11): 
                    timeString = ("The current time is " + hourWithConversion + ":" + minuteWithZero + AM_PM + " in the AFTERNOON.\n");
                    break;
            case (12): 
                    timeString = ("The current time is " + hourWithConversion + ":" + minuteWithZero + AM_PM + " in the AFTERNOON.\n");
                    break;
            case (13): 
                    timeString = ("The current time is " + hourWithConversion + ":" + minuteWithZero + AM_PM + " in the AFTERNOON.\n");
                    break;
            case (14): 
                    timeString = ("The current time is " + hourWithConversion + ":" + minuteWithZero + AM_PM + " in the AFTERNOON.\n");
                    break;
            case (15): 
                    timeString = ("The current time is " + hourWithConversion + ":" + minuteWithZero + AM_PM + " in the AFTERNOON.\n");
                    break;
            case (16): 
                    timeString = ("The current time is " + hourWithConversion + ":" + minuteWithZero + AM_PM + " in the AFTERNOON.\n");
                    break;
            case (17): 
                    timeString = ("The current time is " + hourWithConversion + ":" + minuteWithZero + AM_PM + " in the EVENING.\n");
                    break;
            case (18): 
                    timeString = ("The current time is " + hourWithConversion + ":" + minuteWithZero + AM_PM + " in the EVENING.\n");
                    break;
            case (19): 
                    timeString = ("The current time is " + hourWithConversion + ":" + minuteWithZero + AM_PM + " in the EVENING.\n");
                    break;
            case (20): 
                    timeString = ("The current time is " + hourWithConversion + ":" + minuteWithZero + AM_PM + " in the EVENING.\n");
                    break;
            case (21): 
                    timeString = ("The current time is " + hourWithConversion + ":" + minuteWithZero + AM_PM + " in the EVENING.\n");
                    break;
            case (22): 
                    timeString = ("The current time is " + hourWithConversion + ":" + minuteWithZero + AM_PM + " in the EVENING.\n");
                    break;
            default: timeString = "You have the wrong time.\n";
                     break;
        }
        System.out.printf(timeString);
    }
    
    // I used https://www.javatpoint.com/how-to-generate-random-number-in-java to discover how to generate a random number
    // I interpretted and implemented 0.0 - 4.0 to be any number between these two values, not just a number to the tenths place
    public void displayGPA() {
        double grade = Math.random() * 4;
        
        String message = "";
        if(grade < 0.69){
            message = "The student’s GPA grade is an F in the class.";
        } else if(grade >= 0.70 && grade <= 0.99){
            message = "The student’s GPA grade is an D- in the class.";
        } else if(grade >= 1.00 && grade <= 1.29){
            message = "The student’s GPA grade is an D in the class.";
        } else if(grade >= 1.30 && grade <= 1.69){
            message = "The student’s GPA grade is an D+ in the class.";
        } else if(grade >= 1.70 && grade <= 1.99){
            message = "The student’s GPA grade is an C- in the class.";
        } else if(grade >= 2.00 && grade <= 2.29){
            message = "The student’s GPA grade is an C in the class.";
        } else if(grade >= 2.30 && grade <= 2.69){
            message = "The student’s GPA grade is an C+ in the class.";
        } else if(grade >= 2.70 && grade <= 2.99){
            message = "The student’s GPA grade is an B- in the class.";
        } else if(grade >= 3.00 && grade <= 3.29){
            message = "The student’s GPA grade is an B in the class.";
        } else if(grade >= 3.30 && grade <= 3.69){
            message = "The student’s GPA grade is an B+ in the class.";
        } else if(grade >= 3.70 && grade <= 3.99){
            message = "The student’s GPA grade is an A- in the class.";
        } else if(grade == 4.00){
            message = "The student’s GPA grade is an A in the class.";
        } else if(grade >= 4.00){
            message = "The student’s GPA grade is an A+ in the class.";
        }
        System.out.printf(message + "\n");
    }
    
    public void forCount(){
        for(int count = 9; count > 3; count--){
            if(count % 2 == 0){
                System.out.printf("%d\n", count);
            }
        }
        // purely for styling
        System.out.println("");
    }
    
    public void whileCountDown(){
        int countDown = 3;
        while(countDown > 0){
            System.out.println(countDown);
            countDown--;
        }
        System.out.println("Houston, we have a lift off!");
    }
    
    // I used https://beginnersbook.com/2017/10/java-display-time-in-12-hour-format-with-ampm/ and used some code from here
    // I copied and pasted from my challenge 2
    public void invokeMe(String greeting, String pawPrint){          
        
        DateFormat dateFormat2 = new SimpleDateFormat("MM/dd/yyyy hh:mmaa");
    	String dateString2 = dateFormat2.format(new Date());
        
        System.out.println(greeting + ", my pawprint is " + pawPrint + " and Today's date is " + dateString2);
    }
    
    public void oututMethods(){
        displayComparedChars(this.c1, this.c2);
        displayQualityScore(this.qualityScore);
        displayDcm(this.months, this.days);
        displayTodaysPlan(this.sunny, this.warm);
        displayTheCurrentTimeOfDay();
        displayGPA();
        forCount();
        whileCountDown();
        invokeMe(this.greeting, this.myPawPrint);
    }
}

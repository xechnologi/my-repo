package mypackage;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

   public class CCalendar {
	   
	 public CCalendar(){
		 
	 }
    public CCalendar(int days, int months, int years) {
		// TODO Auto-generated constructor stub
	}
	/** Print the calendar for a month in a year */

     static void printMonth(int year, int month) {

     //Print the headings of the calendar
      printMonthTitle(year, month);

     //Print the body of the calendar
      printMonthBody(year, month);
    }
     
     static void printYear(int year) {

    	 for(int i=1;i<13;i++){
    		//Print the headings of the calendar
             printMonthTitle(year, i);

            //Print the body of the calendar
             printMonthBody(year, i);
             System.out.print("\n");
    	 }
    	 
        }

    /** Print the month title, e.g., May, 1999 */

    static void printMonthTitle(int year, int month) {

    System.out.println("         " + getMonthName(month) + " " + year);
    System.out.println("–––––––––––––––––––––––––––––");
    System.out.println(" Sun Mon Tue Wed Thu Fri Sat");

    }

    /** Get the English name for the month */
    static String getMonthName(int month) {
      String monthName = null;
      switch (month) {
        case 1: monthName = "January"; break;
        case 2: monthName = "February"; break;
        case 3: monthName = "March"; break;
        case 4: monthName = "April"; break;
        case 5: monthName = "May"; break;
        case 6: monthName = "June"; break;
        case 7: monthName = "July"; break;
        case 8: monthName = "August"; break;
        case 9: monthName = "September"; break;
        case 10: monthName = "October"; break;
        case 11: monthName = "November"; break;
        case 12: monthName = "December";
      }
      return monthName;
    }

    /** Print month body */
    static void printMonthBody(int year, int month) {

      // Get start day of the week for the first date in the month
      int startDay = getStartDay(year, month);

      // Get number of days in the month
      int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);

      // Pad space before the first day of the month
      int i = 0;
      for (i = 0; i < startDay; i++)
        System.out.print("    ");
      for (i = 1; i <= numberOfDaysInMonth; i++) {
        if (i < 10)
          System.out.print("   " + i);
        else
          System.out.print("  " + i);
        if ((i + startDay) % 7 == 0)
          System.out.println();
      }
      System.out.println();
    }

    /** Get the start day of the first day in a month */

   static int getStartDay(int year, int month) {

      //Get total number of days since 1/1/1800 on tuesday
      int startDay1800 = 3;
      int totalNumberOfDays = getTotalNumberOfDays(year, month);

      //Return the start day
      return (totalNumberOfDays + startDay1800) % 7;
    }

    /** Get the total number of days since January 1, 1800 */

    static int getTotalNumberOfDays(int year, int month) {
     int total = 0;

     //Get the total days from 1800 to year - 1
     for (int i = 1800; i < year; i++)
     if (isLeapYear(i))
        total = total + 366;
      else
        total = total + 365;

      //Add days from January to the month prior to the calendar month
      for (int i = 1; i < month; i++)
        total = total + getNumberOfDaysInMonth(year, i);

      return total;
    }

    /** Get the number of days in a month */

    static int getNumberOfDaysInMonth(int year, int month) {
      if (month == 1 || month == 3 || month == 5 || month == 7 ||
        month == 8 || month == 10 || month == 12)
        return 31;

      if (month == 4 || month == 6 || month == 9 || month == 11)
        return 30;

      if (month == 2) return isLeapYear(year) ? 29 : 28;

      return 0; // If month is incorrect
    }

    /** Determine if it is a leap year */
    static boolean isLeapYear(int year) {
      return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
    
    public int getAge(Date dateOfBirth) {
        Calendar today = Calendar.getInstance();
        Calendar birthDate = Calendar.getInstance();
        birthDate.setTime(dateOfBirth);
        if (birthDate.after(today)) {
            throw new IllegalArgumentException("You don't exist yet");
        }
        int todayYear = today.get(Calendar.YEAR);
        int birthDateYear = birthDate.get(Calendar.YEAR);
        int todayDayOfYear = today.get(Calendar.DAY_OF_YEAR);
        int birthDateDayOfYear = birthDate.get(Calendar.DAY_OF_YEAR);
        int todayMonth = today.get(Calendar.MONTH);
        int birthDateMonth = birthDate.get(Calendar.MONTH);
        int todayDayOfMonth = today.get(Calendar.DAY_OF_MONTH);
        int birthDateDayOfMonth = birthDate.get(Calendar.DAY_OF_MONTH);
        int age = todayYear - birthDateYear;
        

        // If birth date is greater than todays date (after 2 days adjustment of leap year) then decrement age one year
        if ((birthDateDayOfYear - todayDayOfYear > 3) || (birthDateMonth > todayMonth)){
            age--;
        
        // If birth date and todays date are of same month and birth day of month is greater than todays day of month then decrement age
        } else if ((birthDateMonth == todayMonth) && (birthDateDayOfMonth > todayDayOfMonth)){
            age--;
        }
        return age;
    }
    
    static CCalendar calculateAge(Date birthDate)
    {
       int years = 0;
       int months = 0;
       int days = 0;
       //create calendar object for birth day
       Calendar birthDay = Calendar.getInstance();
       birthDay.setTimeInMillis(birthDate.getTime());
       //create calendar object for current day
       long currentTime = System.currentTimeMillis();
       Calendar now = Calendar.getInstance();
       now.setTimeInMillis(currentTime);
       //Get difference between years
       years = now.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
       int currMonth = now.get(Calendar.MONTH) + 1;
       int birthMonth = birthDay.get(Calendar.MONTH) + 1;
       //Get difference between months
       months = currMonth - birthMonth;
       //if month difference is in negative then reduce years by one and calculate the number of months.
       if (months < 0)
       {
          years--;
          months = 12 - birthMonth + currMonth;
          if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE))
             months--;
       } else if (months == 0 && now.get(Calendar.DATE) < birthDay.get(Calendar.DATE))
       {
          years--;
          months = 11;
       }
       //Calculate the days
       if (now.get(Calendar.DATE) > birthDay.get(Calendar.DATE))
          days = now.get(Calendar.DATE) - birthDay.get(Calendar.DATE);
       else if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE))
       {
          int today = now.get(Calendar.DAY_OF_MONTH);
          now.add(Calendar.MONTH, -1);
          days = now.getActualMaximum(Calendar.DAY_OF_MONTH) - birthDay.get(Calendar.DAY_OF_MONTH) + today;
       } else
       {
          days = 0;
          if (months == 12)
          {
             years++;
             months = 0;
          }
       }
     //Create new Age object
       return new CCalendar(days, months, years);
    }
}
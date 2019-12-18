package mypackage;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import mypackage.CCalendar;

public class Menu{

     public static void main(String [] args) throws IOException, ParseException

  {

    Scanner sc=new Scanner(System.in);
    CCalendar myCalender = new CCalendar();
    CCalendar myBirthday = new CCalendar();
	CCalendar myCalendar = null;
	//CCalendar myBirthday = null;

    /*System.out.println("Enter no.1:");

    int a=sc.nextInt();

    System.out.println("Enter no.2:");

    int b=sc.nextInt();*/

    boolean exit=false;

    do
    {
    	System.out.println("************ CALENDAR SYSTEM *****************");
        System.out.println("************ MAIN MENU *****************");
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    	Date date = new Date();
    	System.out.println("Today Date: "+dateFormat.format(date)); //2016/11/16 12:08:43
  	
      System.out.println("\n1.View YEARLY calendar");
      System.out.println("2.View MONTHLY calendar");
      System.out.println("3.Calculate Age");
      System.out.println("0.exit\n");
      System.out.print("Please select: ");
      Scanner sd=new Scanner(System.in);     
      int num=sd.nextInt();
      switch(num)
     {
       case 1:
    	   Scanner scan=new Scanner(System.in);
    	   //Prompt the user to enter year
    	     System.out.print("Enter full year (e.g., 2001): ");
    	     int year = scan.nextInt();
    	     while (year<=0) {
    	         System.out.println("That's not a number!");
    	         year=scan.nextInt(); // this is important!
    	     }    	      	    
    	     
    	     System.out.println("\n");
    	     myCalendar.printYear(year);
    	     System.out.println("\n");
    	     //pause
    	     System.out.println("Press Enter to continue");
    	     try{System.in.read();}
    	     catch(Exception e){}
       break;

       case 2:
    	   Scanner scan2=new Scanner(System.in);
    	   //Prompt the user to enter year
    	     System.out.print("Enter full year (e.g., 2001): ");
    	     year = scan2.nextInt();
    	     while (year<0) {
    	         System.out.println("That's not a number!");
    	         year=scan2.nextInt(); // this is important!
    	     }
    	    

    	     // Prompt the user to enter month
    	     System.out.print("Enter month in number between 1 and 12: ");
    	     int month = scan2.nextInt();

	
		// Print calendar for the month of the year
    	      if (month < 1 || month > 12 || year < 1980)
    	       System.out.println("Wrong input!");
    	       else
    	    	   
    	           myCalendar.printMonth(year, month);
    	     System.out.println("\n");
    	     //pause
    	     System.out.println("Press Enter to continue");
    	     try{System.in.read();}
    	     catch(Exception e){}
       break;


       case 3:    	
    	   Date mydob = date;
    	   
    	   
    	   Scanner scan3=new Scanner(System.in);
    	   System.out.println("********** Calculate Age ************");
    	   System.out.print("Enter year of Birth in yyyy(example :1980):- ");
  	       year = scan3.nextInt();
  	       System.out.print("Enter month of Birth in M (example :1):- ");
	       month = scan3.nextInt();
	       System.out.print("Enter day of Birth in dd example :20):- ");
  	       int day = scan3.nextInt();
  	      

    	     if (year > 2018){
    	       System.out.println("Wrong input!");
    	       System.exit(0);
    	     }
  	     SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");  
  	     String dateInString = day+"-"+month+"-"+year;
  	       mydob = sdf.parse(dateInString);
  	       System.out.println("\n------------RESULT---------------");
  	       System.out.println("Your Birthday: " + dateInString);
    	   System.out.println("Your Age: " + myBirthday.getAge(mydob)+"years old");  // prints "age: 26"
    	  
       System.out.println("\n");
     //pause
	     System.out.println("Press Enter to continue");
	     try{System.in.read();}
	     catch(Exception e){}
       break;

       case 0:
       exit=true;
       System.out.println("GoodBye");
       System.exit(0);
       break;
      }
    }while(!exit);
}

	private static CCalendar calculateAge(Date mydob) {
		// TODO Auto-generated method stub
		return null;
	}
}
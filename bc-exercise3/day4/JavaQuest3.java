import java.util.Scanner;

public class JavaQuest3 {
  /**
   * Expected Output of Examples:
   * 
   * Input a month number: 2
   * Input a year: 2016
   * February 2016 has 29 days
   * 
   * Input a month number: 12
   * Input a year: 2014
   * December 2014 has 31 days
   */
  // Program toExercise3Ansumber of days that the month of a year has.

  public static void main(String[] strings) {

    Scanner input = new Scanner(System.in);
    
    int number_Of_DaysInMonth = 0;
    String MonthOfName = "Unknown";

    System.out.print("Input a month number: ");
    int month = input.nextInt();

    System.out.print("Input a year: ");
    int year = input.nextInt();
    input.close();
    
    // Complete the switch statement
    switch (month) {
          case 1:
        MonthOfName = "January";
        break;
          case 2:
        MonthOfName = "February";
        break;
          case 3:
        MonthOfName = "March";
        break;
          case 4:
        MonthOfName = "April";
        break;
          case 5:
        MonthOfName = "May";
        break;
          case 6:
        MonthOfName = "June";
        break;
          case 7:
        MonthOfName = "July";
        break;
          case 8:
        MonthOfName = "August";
        break;
          case 9:
        MonthOfName = "September";
        break;
          case 10:
        MonthOfName = "October";
        break;
          case 11:
        MonthOfName = "November";
        break;
          case 12:
        MonthOfName = "December";
        break;
        // Leap Year -> 29 days in February, otherwise 28.
        // Definition: If a year is divisible by 4, and Not divisible by 100, OR
        // divisible by 400.

        // Complete the other months
    }
    if(month == 2 && (year % 4 == 0 && !(year % 100 == 0) || year % 400 == 0)){
      number_Of_DaysInMonth= 29;
    }else if(month == 2){
      number_Of_DaysInMonth = 28;
    }else if(month % 2 == 1 && month <= 7 || month % 2 == 0 && month > 7){
      number_Of_DaysInMonth = 31;
    }else{
      number_Of_DaysInMonth = 30;
    }
    System.out.println(MonthOfName + " " + year + " has " + number_Of_DaysInMonth + " days");

  }
}

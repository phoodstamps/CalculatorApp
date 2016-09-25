//*******************************************************************
// Calculator class that handles the business logic and takes input
// @author Ryan Estevez
// @version 1.0
// @since 09/22/2016
//*******************************************************************
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

// Calculator Class
public class Calculator {
   private String input;
  
   // Default Constructor
   public Calculator() {
      input = " ";
   }
  
   // Takes user input
   public void userInput() {
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter Calculation: (EX:1+1)");
      input = scan.nextLine();
      saveInput();
   }
   
   // Extracts numbers and operand from input and assigns to variables
   public void saveInput() {
      int num1 = 0, num2 = 0;
      char oper = ' ';
      int count = 0;
      String line = input;
      String pattern = "(\\+?\\s*\\d+|\\-?\\s*\\d+|[\\+\\-\\*\\/])";
      
      //Creates Pattern object
      Pattern r = Pattern.compile(pattern);
      
      //Creates matcher object
      Matcher m = r.matcher(line);
      
      // Finds any matches within input
      while (m.find()) {
         if (count == 0) {
            // First match should be assigned to num1
            num1 = Integer.parseInt((m.group()).replaceAll("\\s+",""));
            count++;
         }
         else if (count == 1) {
            // Second match should be assigned to oper
            oper = (m.group()).charAt(0);
            if (m.group().length() > 1) {
               // If the matcher grabs both the operator and second number
               // NOTE: This only happens when subtracting
               num2 = Integer.parseInt((m.group()).substring(1).replaceAll("\\s+",""));
            }
            count++;
         }
         else if (count == 2) {
            // Third match should be assigned to num2
            num2 = Integer.parseInt((m.group()).replaceAll("\\s+",""));
         }
      }
      Calculate c = new Calculate(num1, num2, oper);
      c.doCalculation();
      //c.printValues();
   } 
}
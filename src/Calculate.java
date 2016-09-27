//*******************************************************************
// Calculate class - has all methods for calculation as required by
// any Calculator classes
//
// @author Ryan Estevez
// @version 1.0
// @since 09/22/2016
//*******************************************************************
import java.lang.Math;

public class Calculate {
   private char opers[];
   private double dAnswer;
   private double dNums[];

   // Constructor for basic calculations
   public Calculate(double dNums[], char opers[]) {
      this.dNums = dNums;
      this.opers = opers;
   }
   
   // Prints the result of calculation.
   public void getResult() {
      System.out.println(parse(dNums[0]) + " " + opers[0] + " " + parse(dNums[1]) + " " + "= " + parse(dAnswer));
   }
   
   // Returns the value as a string in either int or double format
   private String parse(double val) {
      if ((int) val == val) {
         return Integer.toString((int) val);
      }
      return String.valueOf(val);
   }
   
   // Calculates result based on the numbers and operator inputted by user.
   public void doCalculation() {
      switch (opers[0]) {
         case '+' :
            dAnswer = dNums[0] + dNums[1];
            break;
         case '-' :
            dAnswer = dNums[0] - dNums[1];
            break;
         case '*' :
            dAnswer = dNums[0] * dNums[1];
            break;
         case '/' :
            dAnswer = dNums[0] / dNums[1];
            break;
         default :
           System.out.println("Invalid operator was entered!");
           System.exit(0);             
      }
      getResult();
   }
   
   // Displays user input and variables for testing purposes
   public void printValues() {
      System.out.println("Num1 = " + parse(dNums[0]));
      System.out.println("Num2 = " + parse(dNums[1]));
      System.out.println("oper = " + opers[0]);
      System.out.println("Answer = " + parse(dAnswer));
   }
}
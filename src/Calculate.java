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
   private int num1;
   private int num2;
   private char oper;
   private int answer;
   private double dNums[];
   private int iNums[];

   // Constructor for basic calculations
   public Calculate(int num1, int num2, char oper) {
      this.num1 = num1;
      this.num2 = num2;
      this.oper = oper;
   }
   
   // Prints the result of calculation.
   public void getResult() {
      System.out.println(num1 + " " + oper + " " + num2 + " " + "= " + answer);
   }
   
   // Calculates result based on the numbers and operator inputted by user.
   public void doCalculation() {
      switch (oper) {
         case '+' :
            answer = num1 + num2;
            break;
         case '-' :
            answer = num1 - num2;
            break;
         case '*' :
            answer = num1 * num2;
            break;
         case '/' :
            answer = num1 / num2;
            break;
         default :
           System.out.println("Invalid operator was entered!");
           System.exit(0);             
      }
      getResult();
   }
   
   // Displays user input and variables for testing purposes
   public void printValues() {
      System.out.println("Num1 = " + num1);
      System.out.println("Num2 = " + num2);
      System.out.println("oper = " + oper);
      System.out.println("Answer = " + answer);
   }
}
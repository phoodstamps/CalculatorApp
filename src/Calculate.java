//*******************************************************************
// Calculate class - has all methods for calculation as required by
// any Calculator classes
//
// @author Ryan Estevez
// @version 1.0
// @since 09/22/2016
//*******************************************************************
import java.lang.Math;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;


public class Calculate {
   private double dAnswer;

   // Constructor for basic calculations
   public Calculate() { 
      dAnswer = 0;
   }
   
   // Prints the result of calculation.
   public void getResult() {
      System.out.println("Answer: " + dAnswer);
   }
   
   // Returns the value as a string in either int or double format
   // Currently not being used.
   @SuppressWarnings("unused")
private String parse(double val) {
      if ((int) val == val) {
         return Integer.toString((int) val);
      }
      return String.valueOf(val);
   }
   
   /**
    * Rounds the double value
    * NOTE: Rounding still needs some work. I only want to round for certain situations that don't lose precision.
    * Source: http://stackoverflow.com/questions/2808535/round-a-double-to-2-decimal-places
    * @param value
    * @param places
    * @return
    */
   public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	} 
   
   // Searches through expression to decide what operation to do first
   public void orderOfOperations(ArrayList<Double> numsList, ArrayList<Character> opersList) {
      char[] operTarget = {'^','*','/','+','-'};   // This is used to go through each order of operation
      // Loops through each operator in order of operation
      for (int i = 0; i < operTarget.length; i++) {
         int x = 0;
         // Loops through each operator in the expression
         while (opersList.size() != 0 && x < opersList.size()) {
            // If an operator matches, it calculates the the two numbers with it in doCalculation()
            if (opersList.get(x) == operTarget[i]) {
               dAnswer = doCalculation(numsList.get(x), numsList.get(x+1), opersList.get(x));
               numsList.set(x, dAnswer);
               numsList.remove(x+1);
               opersList.remove(x);
            }
            else {
               x++;
            }
         }
      }
   }
   
   // Calculates result based on the numbers and operator inputted by user.
   public double doCalculation(double dNum1, double dNum2, char oper) {
      double answer = 0.0;
      switch (oper) {
         case '+' :
            answer = dNum1 + dNum2;
            break;
         case '-' :
            answer = dNum1 - dNum2;
            break;
         case '*' :
            answer = round(dNum1 * dNum2, 2);
            break;
         case '/' :
            answer = dNum1 / dNum2;
            break;
         case '^' :
            answer = Math.pow(dNum1, dNum2);
            break;             
      }
      return answer;
   }
}
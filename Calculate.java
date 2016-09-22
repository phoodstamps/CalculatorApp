//*******************************************************************
// Calculate class
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

   public Calculate(int num1, int num2, char oper) {
      this.num1 = num1;
      this.num2 = num2;
      this.oper = oper;
   }
   
   // Accessor Methods
   public int getNum1() {
      return num1;
   }
  
   public int getNum2() {
      return num2;
   }
   
   public char getOper() {
      return oper;
   }
  
   public int getAnswer() {
      return answer;
   }
  
   // Mutator Methods
   public void setNum1(int num1) {
      this.num1 = num1;
   }
  
   public void setNum2(int num2) {
      this.num2 = num2;
   }
   
   public void setOper(char oper) {
      this.oper = oper;
   }
   
   public void setAnswer(int answer) {
      this.answer = answer;
   }
   
   // Displays user input and variables
   public void printValues() {
      System.out.println("Num1 = " + num1);
      System.out.println("Num2 = " + num2);
      System.out.println("oper = " + oper);
      System.out.println("Answer = " + answer);
   }
   
   // Add
   public int add(int num1, int num2) {
      return num1 + num2;
   }
  
   // Subtract
   public int sub(int num1, int num2) {
      return num1 - num2;
   }
  
   // Multiply
   public int mult(int num1, int num2) {
      return num1 * num2;
   }
  
   // Divide
   public int div(int num1, int num2) {
      return num1 / num2;
   }

   // Deciphers input and decides what operation to use
   private void inputLogic(String input) {
    
   }
}
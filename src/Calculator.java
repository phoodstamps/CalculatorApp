//*******************************************************************
// Calculator class that handles the business logic and takes input
// @author Ryan Estevez
// @version 1.0
// @since 09/22/2016
//*******************************************************************
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.ArrayList;

// Calculator Class
public class Calculator {
   private String input;
   private ArrayList numsList;
   private ArrayList opersList;
   
  
   // Default Constructor
   public Calculator() {
      input = " ";
      numsList = new ArrayList<Double>();
      opersList = new ArrayList<Character>();
   }
   
   public ArrayList getNumsList() {
      return numsList;
   }
   
   public ArrayList getOpersList() {
      return opersList;
   }
   
   public void setNumsList(ArrayList newNumsList) {
      numsList = newNumsList;
   }
   
   public void setOpersList(ArrayList newOpersList) {
      opersList = newOpersList;
   }
  
   // Takes user input
   public void userInput() {
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter Calculation: (EX:1+1)");
      input = scan.nextLine();
      saveInput();
   }
   //TODO: Still need to fix issue when first number entered is negative. It saves the negative operator in the operList
   // Extracts numbers and operand from input and assigns to variables
   public void saveInput() {
      int count = 0;
      String line = input;
      String pattern = "([\\+\\-\\*\\/\\^\\+\\-]{2}\\d+\\.?\\d*|\\d+\\.?\\d*|[\\+\\-\\*\\/\\^\\(\\)])";
      
      //Creates Pattern object
      Pattern r = Pattern.compile(pattern);
      
      // Creates matcher object
      Matcher m = r.matcher(line.replaceAll("\\s+",""));
      
      // Finds any matches within input
      while (m.find()) {
         // If a number or decimal was found
         if (m.group().matches("\\d+\\.?\\d*")) {
            if (opersList.size()-1 > -1 && (char) opersList.get(opersList.size()-1) == '-') {
               opersList.set(opersList.size()-1, '+');
               numsList.add(Double.parseDouble((m.group()).replaceAll("\\s+",""))*-1);
            }
            else {
               numsList.add(Double.parseDouble((m.group()).replaceAll("\\s+","")));
            }
         }
         // If a negative value was entered
         else if (m.group().matches("[\\+\\-\\*\\/\\^]{2}\\d+\\.?\\d*")) {
            opersList.add(m.group().charAt(0));
            numsList.add(Double.parseDouble((m.group().substring(1)).replaceAll("\\s+","")));
            
            /**      
            if (opersList.size() == numsList.size()) {
               numsList.add(Double.parseDouble((m.group()).replaceAll("\\s+","")));
            }
            else {
               opersList.add(m.group().charAt(0));
               numsList.add(Double.parseDouble((m.group()).replaceAll("\\s+","")));
            }*/
         }
         // If an operator was found
         else if (m.group().matches("[\\+\\-\\*\\/\\^\\(\\)]")) {
            opersList.add(m.group().charAt(0));
         }
         else {
            System.out.println("ERROR! YOU MUST ENTER NUMBERS OR OPERATORS IN EXPRESSION!");
            System.exit(0);
         }
      }
   }
   
   // Displays user input and variables for testing purposes
   public void printValues() {
      System.out.println("Numbers: " + numsList);
      System.out.println("Operartors: " + opersList);
   }
    
}

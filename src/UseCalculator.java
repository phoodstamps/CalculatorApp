//*******************************************************************
// Calculator App
// @author Ryan Estevez
// @version 1.0
// @since 09/22/2016
//*******************************************************************

public class UseCalculator {
  public static void main(String[] args)
  {
    Calculator calc = new Calculator();
    Calculate doCalc = new Calculate();
    calc.userInput();
    calc.saveInput();
    calc.printValues();
    doCalc.orderOfOperations(calc.getNumsList(), calc.getOpersList());
    doCalc.getResult();
  }
}
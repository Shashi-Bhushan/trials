package in.shabhushan.algo_trials.algorithms.chapter1.section3.exercise;

import edu.princeton.cs.algs4.Stack;

public class Exercise9 {
  public static String getInfixExpression(String expWithoutStartingBrace) {
    Stack<String> operands = new Stack<>();
    Stack<String> operator = new Stack<>();

    for (String string : expWithoutStartingBrace.split("\\s")) {
      // Assuming "(" won't be there in String
      if (string.equals("+") || string.equals("-") || string.equals("/") || string.equals("*")) {
        operator.push(string);
      } else if (string.equals(")")) {
        String secondOperand = operands.pop();
        String firstOperand = operands.pop();

        operands.push("( " + firstOperand + " " + operator.pop() + " " + secondOperand + " )");
      } else {
        operands.push(string);
      }
    }

    return operands.peek();
  }
}

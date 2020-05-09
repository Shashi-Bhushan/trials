package in.shabhushan.algo_trials.algorithms.chapter1.section3.exercise;

import edu.princeton.cs.algs4.Stack;

public class Exercise10 {
  public static String infixToPostfix(String infixExpression) {
    Stack<String> operands = new Stack<>();
    Stack<String> operators = new Stack<>();

    for (String string: infixExpression.split("\\s")) {
      if (string.equals("(")) {

      } else if (string.equals("+") || string.equals("-") || string.equals("/") || string.equals("*")) {
        operators.push(string);
      } else if (string.equals(")")) {
        String secondOperand = operands.pop();
        String firstOperand = operands.pop();

        operands.push(firstOperand + " " + secondOperand + " " + operators.pop());
      } else {
        operands.push(string);
      }
    }

    return operands.pop();
  }
}

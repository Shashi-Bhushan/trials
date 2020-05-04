package in.shabhushan.algo_trials.algorithms.chapter1.section3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ExpressionEvaluation {
  private static final List<String> OPERATORS = List.of("+", "-", "/", "*");

  public static int evaluateExpression(String expression) {
    String[] exp = expression.split(" ");

    Stack<Integer> nums = new Stack<>();
    Stack<Operator> operator = new Stack<>();

    for (String c: exp) {
      if (c.equals("("));// do nothing
      else if (isOperator(c)) {
        operator.add(Operator.map.get(c));
      } else if (c.equals(")")) {
        //get operator and operands
        Operator pop = operator.pop();
        Integer secondOperand = nums.pop();
        Integer firstOperand = nums.pop();
        int result = pop.performOperation(firstOperand, secondOperand);

        nums.push(result);
      } else {
        int operand = Integer.parseInt(String.valueOf(c));

        nums.add(operand);
      }
    }

    return nums.get(0);
  }

  private static boolean isOperator(String c) {
    return OPERATORS.contains(c);
  }

  private enum Operator {
    PLUS("+"), MINUS("-"), DIVIDE("/"), MULTIPLY("*");

    private final String operator;

    Operator(String operator) {
      this.operator = operator;
    }

    public static Map<String, Operator> map = Map.ofEntries(
        Map.entry("+", PLUS),
        Map.entry("-", MINUS),
        Map.entry("/", DIVIDE),
        Map.entry("*", MULTIPLY)
    );

    public int performOperation(int firstOperand, int secondOperand) {
      switch (this.operator) {
        case "+":
          return firstOperand + secondOperand;
        case "-":
          return firstOperand - secondOperand;
        case "*":
          return firstOperand * secondOperand;
        case "/":
          return firstOperand / secondOperand;
        default:
          throw new IllegalStateException(String.format("%s is not a valid operator", this.operator));
      }
      /*
      return switch (this.operator) {
        case "+" -> firstOperand + secondOperand;
        case "-" -> firstOperand - secondOperand;
        case "*" -> firstOperand * secondOperand;
        case "/" -> firstOperand / secondOperand;
        default -> throw new IllegalStateException(String.format("%s is not a valid operator", this.operator));
      };*/
    }
  }
}

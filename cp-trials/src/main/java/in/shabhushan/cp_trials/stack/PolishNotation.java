package in.shabhushan.cp_trials.stack;

import java.util.Stack;

public class PolishNotation {
  /**
   * Given an infix String, get it's Reverse Polish notation(postfix expression)
   *
   * https://www.geeksforgeeks.org/stack-set-2-infix-to-postfix/
   */
  public static String getReversePolishNotation(String infixExpression) {
    Stack<Character> stack = new Stack<>();

    stack.push('(');
    infixExpression = infixExpression + ')';

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < infixExpression.length(); i++) {
      char c = infixExpression.charAt(i);

      if (Character.isLetterOrDigit(c)) {
        sb.append(c);
      } else if (c == '(') { // stack of round bracket
        stack.push(c);
      } else if (c == ')') { // end of round bracket
        while (!stack.isEmpty() && stack.peek() != '(') {
          sb.append(stack.pop());
        }

        // if (!stack.isEmpty() && stack.peek() != '(') it's invalid expression

        stack.pop(); // pop '(' from stack
      } else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') { // operator
        while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
          sb.append(stack.pop());
        }

        stack.push(c);
      }
    }

    return sb.toString();
  }

  private static int precedence(char ch) {
    switch (ch) {
      case '+':
      case '-':
        return 1;

      case '*':
      case '/':
        return 2;

      case '^':
        return 3;

      default:
        return -1;
    }
  }
}

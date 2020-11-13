package in.shabhushan.algo_trials.clrs.chapter12;

import javax.naming.OperationNotSupportedException;
import java.util.*;
import java.util.function.Supplier;

public class ExpressionTree<T> {
  private static final Set<Character> operators = Set.of('+', '-', '*', '/', '^');

  private final T data;
  private ExpressionTree<T> left;
  private ExpressionTree<T> right;

  public ExpressionTree(T data) {
    this.data = data;
  }

  public ExpressionTree(T data, ExpressionTree<T> left, ExpressionTree<T> right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }

  public ExpressionTree<T> getLeft() {
    return left;
  }

  public ExpressionTree<T> setLeft(ExpressionTree<T> left) {
    this.left = left;
    return this;
  }

  public ExpressionTree<T> getRight() {
    return right;
  }

  public ExpressionTree<T> setRight(ExpressionTree<T> right) {
    this.right = right;
    return this;
  }

  public T getData() {
    return data;
  }

  public static boolean isOperator(char c) {
    return operators.contains(c);
  }

  public static <T> ExpressionTree<T> toExpressionTree(String expression, Supplier<T> supplier) throws OperationNotSupportedException {
//    char[] chars = expression.trim().toCharArray();
//
//    expression.trim().chars().mapToObj(obj -> supplier.get());
//
//    Deque<ExpressionTree<T>> stack = new ArrayDeque<>();
//
//    for (char c: chars) {
//      if (isOperator(c)) {
//        ExpressionTree<T> right = stack.pop();
//        ExpressionTree<T> left = stack.pop();
//
//        stack.push(new ExpressionTree<T>(c, left, right));
//      } else {
//        stack.push(new ExpressionTree<T>(c));
//      }
//    }
//
//    return stack.pop();

    throw new OperationNotSupportedException();
  }
}

package in.shabhushan.algo_trials.algorithms.chapter1.section3.exercise;

import edu.princeton.cs.algs4.Stack;

public class Exercise5 {
  public static int[] getBinaryRepresentation(int n) {
    Stack<Integer> stack = new Stack<>();

    while (n > 0) {
      stack.push(n % 2);

      n = n / 2;
    }

    int[] binary = new int[stack.size()];

    int i = 0;
    for (int d: stack) {
      binary[i++] = d;
    }

    return binary;
  }
}

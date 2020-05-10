package in.shabhushan.cp_trials.math.fundamental;

public class Fibonacci {
  public static int counter = 0;
  public static int tailRecCounter = 0;

  public static int fib(int n) {
    counter++;

    if (n == 0)
      return 1;
    if (n == 1)
      return 1;
    else
      return fib(n - 1) + fib(n - 2);
  }

  public static int fibTailRec(int n) {
    return F(1, 0, n);
  }

  private static int F(int a, int b, int n) {
    tailRecCounter++;

    if (n == 0)
      return a + b;
    else
      return F(b, a + b, n - 1);
  }
}

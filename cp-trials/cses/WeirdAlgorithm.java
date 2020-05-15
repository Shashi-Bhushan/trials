import java.util.Scanner;

/**
 * Java solution for 
 * https://cses.fi/problemset/task/1068
 */
public class WeirdAlgorithm {
  public static void main(String... args) {
    Scanner sc = new Scanner(System.in);

    long x = sc.nextLong();

    while (x != 1) {
      System.out.print(String.format("%d ", x));
      if (x % 2 == 1) {
        x = x * 3 + 1;
      } else {
        x /= 2;
      }
    }

    System.out.print(x);
  }
}
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Java solution for 
 * https://cses.fi/problemset/task/1068
 */
public class WeirdAlgorithm {
  private static Scanner getInput() throws IOException {
    return new Scanner(new File("input.txt"));
  }

  private static PrintWriter getOutput() throws IOException {
    return new PrintWriter(new FileWriter("output.txt"));
  }

  public static void main(String... args) throws IOException {
    Scanner sc = getInput();
    PrintWriter out = getOutput();

    long x = sc.nextLong();

    while (x != 1) {
      out.print(String.format("%d ", x));
      if (x % 2 == 1) {
        x = x * 3 + 1;
      } else {
        x /= 2;
      }
    }

    out.print(x);
    out.close();
  }
}
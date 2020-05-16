import java.io.*;
import java.util.*;

public class MinMax {
  private static Scanner getInput() throws IOException {
    return new Scanner(new File("input.txt"));
  }

  private static PrintWriter getOutput() throws IOException {
    return new PrintWriter(new FileWriter("output.txt"));
  }

  public static void main(String... args) throws IOException {
    //Scanner sc = getInput();
    //PrintWriter out =  getOutput();

    Scanner sc = new Scanner(System.in);
    PrintStream out = System.out;

    int t = sc.nextInt();

    while (t-- > 0) {
      long a1 = sc.nextLong();
      long k = sc.nextLong();

      while (--k > 0) {
        long[] d = getDigits(a1);

        a1 = a1 + (d[0] * d[1]);
      }

      out.println(a1);
      
    }

    out.close();
  }

  private static long[] getDigits(long a1) {
    long max = 0;
    long min = 9;

    long a = a1;

    while(a > 0) {
      long r = a % 10;

      max = Math.max(max, r);
      min = Math.min(min, r);

      a /= 10;
    }

    return new long[]{max, min};
  }
}
import java.io.*;
import java.util.*;

public class Watermelon {
  private static Scanner getInput() throws IOException {
    return new Scanner(new File("input.txt"));
  }

  private static PrintWriter getOutput() throws IOException {
    return new PrintWriter(new FileWriter("output.txt"));
  }

  public static void main(String... args) throws IOException {
    Scanner sc = getInput();
    PrintWriter out =  getOutput();

    //Scanner sc = new Scanner(System.in);
    //PrintStream out = System.out;

    long x = sc.nextLong();

    out.println(x % 2 == 0 && x > 2 ? "YES" : "NO");

    out.close();
  }
}
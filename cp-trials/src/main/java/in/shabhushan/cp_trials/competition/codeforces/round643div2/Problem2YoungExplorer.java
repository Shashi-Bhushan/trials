package in.shabhushan.cp_trials.competition.codeforces.round643div2;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Java solution for
 * https://codeforces.com/contest/1355/problem/B
 */
public class Problem2YoungExplorer {
  public static long getNumberOfGroups(long[] groups) {
    Arrays.sort(groups);

    long num = 0;
    for (int i = 0; i < groups.length; i++) {
      long x = 1;

      while (i < groups.length - 1 && x < groups[i]) {
        x++;
        i++;
      }

      if (groups[i] <= x) {
        num++;
      }
    }

    return num;
  }

  public static long getNumberOfGroups2(long[] groups) {
    Map<Long, Long> map = new HashMap<>();

    for (long num: groups) {
      map.put(num, map.getOrDefault(num, 0L) + 1);
    }

    long sum = 0;
    long temp = 0;
    for (Map.Entry<Long, Long> entry: map.entrySet()) {
      long k = entry.getKey();
      long v = entry.getValue() + temp;

      sum += (v / k);
      temp = v % k;
    }

    return sum;
  }

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
      int x = sc.nextInt();

      long[] e = new long[x];

      for (int i = 0; i < x; i++) {
        e[i] = sc.nextLong();
      }

      out.println(getNumberOfGroups(e));
    }

    out.close();
  }
}

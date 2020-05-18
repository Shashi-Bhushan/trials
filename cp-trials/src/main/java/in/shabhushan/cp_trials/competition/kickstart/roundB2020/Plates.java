package in.shabhushan.cp_trials.competition.kickstart.roundB2020;

import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Round A 2020 - Problem 2 "Plates" solution
 */
public class Plates {

  public static void main(String[] args) throws Exception {
    Locale.setDefault(Locale.US);

    Scanner sc = new Scanner(System.in);
    PrintWriter pw = new PrintWriter(System.out);

    ExecutorService executor = Executors.newFixedThreadPool(16);

    int testCases = sc.nextInt();
    Future<Integer>[] futures = new Future[testCases];

    for (int testCase = 0; testCase < testCases; testCase++) {
      int numStacks = sc.nextInt(); // N
      int numPlates = sc.nextInt(); // K
      int p = sc.nextInt();

      int[][] stack = new int[numStacks][numPlates];

      for (int i = 0; i < numStacks; i++) {
        for (int j = 0; j < numPlates; j++) {
          stack[i][j] = sc.nextInt();
        }
      }

      futures[testCase] = executor.submit(() -> {
        int[][] prefixArray = new int[numStacks][numPlates + 1];

        for (int i = 0; i < numStacks; i++) {
          for (int j = 1; j <= numPlates; j++) {
            prefixArray[i][j] = prefixArray[i][j - 1] + stack[i][j - 1];
          }

          //System.out.println("Prefix Array " + Arrays.toString(prefixArray[i]));
        }

        return rec(numStacks, numPlates, p, prefixArray,0, 0);
      });
    }

    for (int testCase = 0; testCase < testCases; testCase++) {
      Integer res = futures[testCase].get();
      pw.printf("Case #%d: %d%n", testCase + 1, res);
      pw.flush();
    }

    pw.close();
    sc.close();
    executor.shutdown();
  }

  private static int rec(
      final int numStacks, final int numPlates, final int P, final int[][] prefix,
      int index, int taken
  ) {
    if (taken == P)
      return 0;
    else if (index >= numStacks || taken > P)
      return Integer.MIN_VALUE;

    int ans = Integer.MIN_VALUE;

    for (int i = 0 ; i <= numPlates; i++) {
      ans = Math.max(ans, prefix[index][i] + rec(numStacks, numPlates, P, prefix,index + 1, taken + i));
    }

    return ans;
  }
}

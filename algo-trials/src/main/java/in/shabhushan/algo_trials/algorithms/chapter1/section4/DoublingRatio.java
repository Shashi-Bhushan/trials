package in.shabhushan.algo_trials.algorithms.chapter1.section4;

import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.ThreeSum;

import java.util.stream.IntStream;

public class DoublingRatio {
  private static final int MAXIMUM_INTEGER = 1000000;

  // This class should not be instantiated.
  private DoublingRatio() {
  }

  /**
   * Returns the amount of time to call {@code ThreeSum.count()} with <em>n</em>
   * random 6-digit integers.
   *
   * @param n the number of integers
   * @return amount of time (in seconds) to call {@code ThreeSum.count()}
   * with <em>n</em> random 6-digit integers
   */
  public static double timeTrial(int n) {
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = StdRandom.uniform(-MAXIMUM_INTEGER, MAXIMUM_INTEGER);
    }
    Stopwatch timer = new Stopwatch();
    ThreeSum.count(a);
    return timer.elapsedTime();
  }

  public static void draw(double[][] results) {
    int N = 5;

    int xLast = results.length + 1;
    int yLast = (int) results[results.length - 1][0] + 1;

    StdDraw.clear();
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.setXscale(-0.5, xLast + 1.0);
    StdDraw.setYscale(-0.5, yLast*1.2);   // leave a border to write text

    StdDraw.line(0, 0, 0, yLast);
    StdDraw.line(0, 0, xLast, 0);

    for (int i = 0; i < xLast; i++) {
      StdDraw.text(i, -0.2, String.valueOf(i));
    }
    for (int i = 0; i < yLast; i++) {
      StdDraw.text(-0.2, i, String.valueOf(i));
    }

    for (int i = 0; i < results.length; i++) {
      StdDraw.setPenColor(StdDraw.BOOK_RED);
      StdDraw.filledCircle(i, results[i][0], yLast * 0.005);

      StdDraw.setPenColor(StdDraw.GREEN);
      StdDraw.filledCircle(i, results[i][1], yLast * 0.005);

      StdOut.println("For " + i + " Time taken " + results[i][0] + " Log(Time taken) " + results[i][1]);
    }
  }

  public static void doublingSetup(int numIterations) {
    int x = 250;

    double[][] results = new double[numIterations][2];
    for (int i = 0; i < numIterations; i++) {
      // Add math.log instead of actual time value
      double result = timeTrial(x);
      results[i] = new double[]{x, result, Math.log(result)};
      x *= 2;
    }

    for (int i = 1; i < results.length; i++) {
      StdOut.println("x " + results[i][0] + " time(seconds) " + results[i][1] + " Log(time) " + results[i][2]
      + " Ratio (time) " + results[i][1]/results[i - 1][1] + " Ratio (log time) " + results[i][2]/results[i - 1][2]);
    }

    // This gave a constant time * 8 on my machine, also a should have been close to 3. Might have to try multiple iterations
    // x 500.0 time(seconds) 0.045 Log(time) -3.101092789211817 Ratio (time) 3.4615384615384617 Ratio (log time) 0.7140758406551111
    // x 1000.0 time(seconds) 0.395 Log(time) -0.9288695140810151 Ratio (time) 8.777777777777779 Ratio (log time) 0.2995297391011313
    // x 2000.0 time(seconds) 2.85 Log(time) 1.0473189942805592 Ratio (time) 7.215189873417722 Ratio (log time) -1.1275200428089547
    // x 4000.0 time(seconds) 22.798 Log(time) 3.126672812814587 Ratio (time) 7.9992982456140345 Ratio (log time) 2.985406385150505
    // x 8000.0 time(seconds) 181.964 Log(time) 5.203808865313558 Ratio (time) 7.981577331344855 Ratio (log time) 1.6643279219961498
    // x 16000.0 time(seconds) 363.938 Log(time) 5.896983523458665 Ratio (time) 2.0000549559253478 Ratio (log time) 1.1332052494789968

    // 51.1 = a * 8000 ^3
    //draw(results);
  }

  public static void main(String[] args) {
    doublingSetup(7);
  }
}

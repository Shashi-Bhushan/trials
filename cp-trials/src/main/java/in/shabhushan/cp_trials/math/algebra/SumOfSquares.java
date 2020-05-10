package in.shabhushan.cp_trials.math.algebra;

import java.util.*;

public class SumOfSquares {

  public static int nSquaresFor(int n) {
    // perfect square
    double d = Math.sqrt(n);
    if (d % 1 == 0)
      return 1;

    int s = (int)d;

    List<Integer> counts = new ArrayList<>();

    for (int i = 1; i <= s; i++) {
      int sum = i * i;

      int remainder = n - sum;

      int count = 1;
      // greedily take the square of remainder and subtract from the required sum
      while (sum != n) {
        int sqrt = (int) Math.sqrt(remainder);

        sum += sqrt * sqrt;
        remainder = n - sum;

        count++;
      }

      counts.add(count);
    }

    return counts.stream().min(Integer::compareTo).get();
  }
}

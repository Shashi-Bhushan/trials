package in.shabhushan.algo_trials.arrays;

import java.util.HashMap;
import java.util.Map;

public class PairSum {
  public static int getPairSum(int[] arr, int sum) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i: arr) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }

    int count = 0;

    for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
      int alt = sum - entry.getKey();

      if (map.containsKey(alt)) {
        if (entry.getKey() == alt) {
          count += 2 * (factorial(entry.getValue() - 1));
        } else {
          count += map.get(alt) * entry.getValue();
        }
      }
    }

    return count / 2;
  }

  private static int factorial(int x) {
    int ans = 1;

    for (int i = 2; i <= x; i++) {
      ans *= i;
    }

    return ans;
  }
}

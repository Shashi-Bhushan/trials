package in.shabhushan.algo_trials;

import java.util.HashMap;
import java.util.Map;

/**
 * aabbccbbaa
 *
 * FMADASM
 *    ^
 *
 *    D
 *   A  A
 *  M    S - M
 *
 *  AAAAAA
 *
 *  =========
 *
 *  Integer value
 *  3
 *  ((()))
 *  ()()()
 *  (())()
 *  ()(())
 *    ()()
 *  ()))((
 *  -- -- --
 *
 *  open close
 *  3    3
 *  0    0
 *
 *  open >= close
 *
 */
public class HackrankTest {
  private static Map<Map.Entry<Integer, Integer>, Integer> map;

  public static int getSolution(String string) {
    map = new HashMap<>();

    return helper(string, 0, string.length() - 1);
  }
  private static int helper(String string, int start, int end) {
    if (start > end) return 0;
    else if (start == end) return 1;
    else {
      Map.Entry<Integer, Integer> entry = Map.entry(start, end);

      if (!map.containsKey(entry)) {
        if (string.charAt(start) == string.charAt(end)) {
          map.put(entry, 2 + helper(string, start + 1, end - 1));
        } else {
          // either of two
          map.put(entry, Math.max(
              helper(string, start + 1, end),
              helper(string, start, end - 1)
          ));
        }
      }

      return map.get(entry);
    }
  }
}

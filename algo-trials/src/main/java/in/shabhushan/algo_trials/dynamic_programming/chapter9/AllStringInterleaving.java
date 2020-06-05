package in.shabhushan.algo_trials.dynamic_programming.chapter9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static in.shabhushan.algo_trials.dynamic_programming.chapter8.StringInterleaving.dropFirstChar;
import static in.shabhushan.algo_trials.dynamic_programming.chapter8.StringInterleaving.firstChar;

/**
 * Given two Strings one and two, return all their string interleavings
 */
public class AllStringInterleaving {
  public static List<String> getTotalStringInterleaving(String one, String two) {
    if (one.isBlank() && two.isBlank()) return Collections.emptyList();
    else if (one.isEmpty()) return List.of(two);
    else if (two.isBlank()) return List.of(one);

    char c = firstChar(one);
    List<String> first = getTotalStringInterleaving(dropFirstChar(one), two).stream().map(s -> c + s).collect(Collectors.toList());

    char d = firstChar(two);
    List<String> second = getTotalStringInterleaving(one, dropFirstChar(two)).stream().map(s -> d + s).collect(Collectors.toList());

    List<String> answer = new ArrayList<>();
    answer.addAll(first);
    answer.addAll(second);

    return answer;
  }

  public static List<String> interleave(String s, String t) {
    List<String> result = new ArrayList<>();
    if (t.isEmpty()) {
      result.add(s);
    } else if (s.isEmpty()) {
      result.add(t);
    } else {
      char c = firstChar(t);
      String last = t.substring(1);

      for (int i = 0; i <= s.length(); i++) {
        String left = s.substring(0, i);
        String right = s.substring(i);

        for (String u : interleave(right, last)) {
          result.add(left + c + u);
        }
      }
    }
    return result;
  }
}

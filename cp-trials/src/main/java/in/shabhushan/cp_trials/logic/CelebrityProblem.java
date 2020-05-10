package in.shabhushan.cp_trials.logic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Leetcode solution for
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3325/
 */
public class CelebrityProblem {
  /**
   * Create a Map<Pair[0], Set(<Pair[1]>)>
   * map.keySet() will have all who trust someone. So they can't be judge.
   * Remove them from potential list of judge. After this removal, there should be only be one potential judge.
   *
   * Iterate over map entries again and check if everyone else trust this judge.
   */
  public static int findJudge(int N, int[][] trust) {
    Map<Integer, Set<Integer>> m = new HashMap<>();

    for (int[] pair: trust) {
      if (m.containsKey(pair[0])) {
        m.get(pair[0]).add(pair[1]);
      } else {
        Set<Integer> s = new HashSet<>();
        s.add(pair[1]);
        m.put(pair[0], s);
      }
    }


    Set<Integer> s = IntStream.rangeClosed(1, N).boxed().collect(Collectors.toSet());
    s.removeAll(m.keySet());

    if (s.size() != 1) {
      return -1;
    }

    int judge = s.iterator().next();

    for (Map.Entry<Integer, Set<Integer>> entry: m.entrySet()) {
      if (!entry.getValue().contains(judge)) {
        return -1;
      }
    }

    return judge;
  }

  /**
   * Based on directed graph solution.
   * The judge should have an in-degree of N- 1 and out degree of 0.
   */
  public static int findJudge2(int N, int[][] trust) {
    int[] inDegree = new int[N];
    int[] outDegree = new int[N];

    for (int[] pair: trust) {
      // increase in degree of the trusted
      // increase out degree of the trustee (-1 since the pair is one based)
      inDegree[pair[1] - 1]++;
      outDegree[pair[0] - 1]++;
    }

    for (int i = 0; i < N; i++) {
      if (inDegree[i] == N - 1 && outDegree[i] == 0)
        return i + 1;
    }

    return -1;
  }
}

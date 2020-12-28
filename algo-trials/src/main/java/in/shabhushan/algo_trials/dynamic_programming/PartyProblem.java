package in.shabhushan.algo_trials.dynamic_programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * There are N people in a party. Each person has a choice, either he can enjoy alone or pair with someone to enjoy.
 * How many unique ways are there to enjoy ?
 *
 * Eg. If there are 4 persons names 1,2,3 and 4 They can enjoy in following 8 ways
 *
 * [1, 2, 3, 4]
 * [12, 3, 4] [12, 34]
 * [13, 2, 4] [13, 24]
 * [14, 2, 3] [14, 23]
 * [23, 1, 4]
 */
public class PartyProblem {
  private static Map<Integer, Integer> map;

  public static int getPartyProblem(int n) {
    map = new HashMap<>();

    //return helper(1, n);

    return helper(n);
  }

  private static int helper(int numPeople) {
    if (numPeople <= 1) return 1;
    else if (map.containsKey(numPeople)) return map.get(numPeople);
    else {
      int ans = helper(numPeople - 1) + (numPeople - 1) * helper(numPeople - 2);

      map.put(numPeople, ans);
      return ans;
    }
  }

  private static int helper(int start, int end) {
    if (start >= end) return 1;
    else if (map.containsKey(end - start)) return map.get(end - start);
    else {
      int count = 0;

      for (int i = start; i <= end; i++) {
        count = count + helper(i + 1, end);
      }

      map.put(end - start, count);
      return count;
    }
  }

  public static List<List<Integer>> getPartyProblemList(int n) {
    List<List<Integer>> result = new ArrayList<>();

    helperList(1, n, result, new ArrayList<>());

    return result;
  }

  private static void helperList(int start, int end, List<List<Integer>> result, List<Integer> list) {
    if (start >= end) {
      result.add(new ArrayList<>(list));
    } else if (start == end) {
      list.add(start);
      result.add(new ArrayList<>(list));
      list.remove(list.size() - 1);
    } else {
      for (int i = start; i <= end; i++) {
        if (i == start) list.add(i);
        else {
          /*for (int j = start; j < i; j++) {
            list.add(j);
          }*/
          list.add(start * 10 + i);
        }

        helperList(i + 1, end, result, list);

        list.remove(list.size() - 1);
        /*if (i != start) {
          for (int j = start; j < i; j++) {
            list.remove(list.size() - 1);
          }
        }*/
      }
    }
  }
}

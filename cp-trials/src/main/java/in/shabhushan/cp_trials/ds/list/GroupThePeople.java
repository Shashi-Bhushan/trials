package in.shabhushan.cp_trials.ds.list;

import java.util.*;

/**
 * Leetcode solution for
 * https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/submissions/
 */
public class GroupThePeople {
  public static List<List<Integer>> groupThePeople(int[] groupSizes) {
    Map<Integer, List<Integer>> map = new HashMap<>();

    for (int i = 0; i < groupSizes.length; i++) {
      if (map.containsKey(groupSizes[i])) {
        map.get(groupSizes[i]).add(i);
      } else {
        List<Integer> l = new ArrayList<>();
        l.add(i);
        map.put(groupSizes[i], l);
      }
    }

    List<List<Integer>> answer = new ArrayList<>();

    for (Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
      // keep adding until list reached the size
      if (entry.getValue().size() <= entry.getKey()) {
        answer.add(entry.getValue());
      } else {
        // break list into parts upto entry.key()
        int x = 0;

        while (x < entry.getValue().size()) {
          List<Integer> l = entry.getValue().subList(x, Math.min(x + entry.getKey(), entry.getValue().size()));
          answer.add(l);

          x += entry.getKey();
        }
      }
    }

    return answer;
  }

  /**
   * Because of a single loop of groupSizes, this solution is faster
   */
  public static List<List<Integer>> groupThePeople2(int[] groupSizes) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    List<List<Integer>> answer = new ArrayList<>();

    for (int i = 0; i < groupSizes.length; i++) {
      int size = groupSizes[i];
      List<Integer> list = map.getOrDefault(size, new ArrayList<>());

      list.add(i);

      if (list.size() == size) {
        // list has reached size, add to answer and remove from the map
        answer.add(list);
        map.remove(size);
      } else {
        // list hasn't reached size, add another entry into it
        map.put(size, list);
      }
    }

    return answer;
  }
}

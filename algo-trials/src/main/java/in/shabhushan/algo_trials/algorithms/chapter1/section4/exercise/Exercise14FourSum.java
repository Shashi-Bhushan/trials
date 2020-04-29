package in.shabhushan.algo_trials.algorithms.chapter1.section4.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercise14FourSum {
  public static List<int[]> fourSum(int[] array) {
    // Map<Sum, index of which pairs have that sum>
    Map<Integer, List<Tuple>> pairs = new HashMap<>();

    for (int i = 0; i < array.length; i++) {
      for (int j = i + 1; j < array.length; j++) {
        int sum = array[i] + array[j];

        if (!pairs.containsKey(sum)) {
          pairs.put(sum, new ArrayList<>());
        }

        pairs.get(sum).add(new Tuple(i, j));
      }
    }

    List<int[]> list = new ArrayList<>();
    for (int sum : pairs.keySet()) {
      // means sum + (-sum) would equate to 0
      if (pairs.containsKey(-sum)) {
        List<Tuple> pairsOne = pairs.get(sum);
        List<Tuple> pairsTwo = pairs.get(-sum);

        for (Tuple tuple: pairsOne) {
          for (Tuple tupleTwo: pairsTwo) {
            if (tuple.getSecond() < tupleTwo.getFirst()) {
              list.add(new int[]{
                  array[tuple.getFirst()], array[tuple.getSecond()], array[tupleTwo.getFirst()], array[tupleTwo.getSecond()]
              });
            }
          }
        }
      }
    }

    return list;
  }

  private static class Tuple {
    private int first;
    private int second;

    public Tuple(int first, int second) {
      this.first = first;
      this.second = second;
    }

    public int getFirst() {
      return first;
    }

    public int getSecond() {
      return second;
    }
  }
}

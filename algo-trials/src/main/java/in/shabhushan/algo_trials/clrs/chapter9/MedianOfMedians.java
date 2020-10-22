package in.shabhushan.algo_trials.clrs.chapter9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedianOfMedians {

  /**
   * Sort the List and return the middle elemnt
   */
  public static int getMedian(List<Integer> list) {
    Collections.sort(list);

    return list.get(list.size() / 2);
  }

  public static int getMedianOfMedians(List<List<Integer>> values) {
    List<Integer> medians = new ArrayList<>();

    for (int i = 0; i < values.size(); i++) {
      int m = getMedian(values.get(i));

      medians.add(m);
    }

    return getMedian(medians);
  }

  /**
   * Finds what's the value at index ${key} in the sorted arr array without actually sorting it
   * key is 0 based
   */
  public static int getSelectionByMedianOfMedians(List<Integer> values, int key) {
    List<List<Integer>> dividedList = new ArrayList<>();

    int count = 0;
    while (count < values.size()) {
      int rowCount = 0;
      List<Integer> list = new ArrayList<>();

      while (rowCount < 5 && count < values.size()) {
        list.add(values.get(count));

        rowCount++;
        count++;
      }

      dividedList.add(list);
    }

    int medianOfMedians = getMedianOfMedians(dividedList);

    List<Integer> l1 = new ArrayList<>();
    List<Integer> l2 = new ArrayList<>();

    for (List<Integer> outerList: dividedList) {
      for (int num: outerList) {
        if (num < medianOfMedians) {
          l1.add(num);
        } else if (num > medianOfMedians) {
          l2.add(num);
        }
      }
    }

    // this includes +1 for pivot as well, since l1.size() is one based index and key is zero based
    // key will be +1 than l1.size() anyhow
    if (key == l1.size()) {
      return medianOfMedians;
    } else if (key < l1.size()) {
      return getSelectionByMedianOfMedians(l1, key);
    } else {
      return getSelectionByMedianOfMedians(l2, key - l1.size() - 1);
    }
  }
}

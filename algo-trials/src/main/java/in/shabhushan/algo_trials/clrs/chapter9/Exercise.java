package in.shabhushan.algo_trials.clrs.chapter9;

import java.util.ArrayList;
import java.util.List;

import static in.shabhushan.algo_trials.clrs.chapter9.MedianOfMedians.getSelectionByMedianOfMedians;

public class Exercise {
  /**
   * Given a list of n distinct number and a positive integer k <= n,
   * determine the k numbers in the List that are closest to the median of the list.
   * @return
   */
  public static List<Integer> problem9_3_7(List<Integer> numbers, int key) {
    // essentially need to find [n/2 - k/2, n/2 + k/2]

    // Step 1. Find element at index [n/2 - k/2]
    int n = numbers.size();
    int lowerBound = getSelectionByMedianOfMedians(numbers, n/2 - key/2);
    int upperBound = getSelectionByMedianOfMedians(numbers, n/2 + key/2);

    List<Integer> ans = new ArrayList<>();
    for (int num: numbers) {
      if (lowerBound <= num && num <= upperBound) {
        ans.add(num);
      }
    }

    return ans;
  }
}

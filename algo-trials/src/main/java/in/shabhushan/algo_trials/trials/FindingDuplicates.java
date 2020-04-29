package in.shabhushan.algo_trials.trials;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * Input: Given an array of n elements which contains elements from 0 to n-1,
 * with any of these numbers appearing any number of times.
 * Find these repeating numbers in O(n) and using only constant memory space
 *
 */
public class FindingDuplicates {

  /**
   * It's based on the fact that if there is number `1` at position `0`
   * I could move this `1` to it's position and move the number there to position `0`.
   * Basically, if the index is not equal to value, I would move value to it's correct position.
   */
  public static List<Integer> findDuplicates(int[] numbers) {
    for (int i = 0; i < numbers.length; i++) {
      while (numbers[numbers[i]] != numbers[i]) {
        // move numbers[i] to numbers[numbers[i]]
        int temp = numbers[numbers[i]];
        numbers[numbers[i]] = numbers[i];
        numbers[i] = temp;
      }
    }

    return IntStream.range(0, numbers.length).filter(i -> numbers[i] != i).map(i -> numbers[i]).boxed().collect(Collectors.toList());
  }

  /**
   * If there are n numbers, choosing 2 at once
   * there would be nC2 pairs = [n * n - 1]/2
   */
  public static int findDuplicateCount(int[] numbers) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int num: numbers) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    int answer = 0;
    for(Integer key : map.keySet()) {
      Integer n = map.get(key);
      answer += (n * (n - 1)) / 2;
    }

    return answer;
  }
}

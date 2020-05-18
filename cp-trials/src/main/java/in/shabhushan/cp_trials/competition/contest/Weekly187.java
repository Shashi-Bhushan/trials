package in.shabhushan.cp_trials.competition.contest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class Weekly187 {
  /**
   * Leetcode solution for
   * https://leetcode.com/contest/weekly-contest-187/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
   */
  public static int longestSubarray(int[] nums, int limit) {
    TreeMap<Integer, Integer> frequency = new TreeMap<>();

    int max = 0;

    int pointToRemove = 0;
    for (int i = 0; i < nums.length; i++) {
      // Increase frequency in tree
      frequency.put(nums[i], frequency.getOrDefault(nums[i], 0) + 1);

      while (frequency.lastKey() - frequency.firstKey() > limit) {
        // If reached limit, decrease frequency in limit
        if (frequency.get(nums[pointToRemove]) == 1) {
          frequency.remove(nums[pointToRemove]);
        } else {
          frequency.put(nums[pointToRemove], frequency.get(nums[pointToRemove]) - 1);
        }

        pointToRemove++;
      }

      max = Math.max(max, i - pointToRemove + 1);
    }

    return max;
  }

  public static int longestSubarray2(int[] nums, int limit) {
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      int j = i;

      while (j < nums.length && Math.abs(nums[j] - nums[i]) <= limit) {
        j++;
      }


      max = Math.max(max, j - i);
      System.out.println("i = " + i + " j = " + j + " max = " + max);
    }

    return max;
  }

  /**
   * Leetcode solution for
   * https://leetcode.com/contest/weekly-contest-187/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows/
   */
  public static int kthSmallest(int[][] mat, int k) {
    List<Integer> list = new ArrayList<>();

    int n = mat.length;
    int m = mat[0].length;

    list.add(0);

    for (int row = 0; row < n; row++) {
      List<Integer> temp = new ArrayList<>();

      for (int col = 0; col < m; col++) {
        for (int x : list) {
          temp.add(mat[row][col] + x);
        }
      }

      Collections.sort(temp);
      list = new ArrayList<>();

      // take top k values
      for (int j = 0; j <= k && j < temp.size(); j++) {
        list.add(temp.get(j));
      }
    }

    return list.get(k - 1);
  }

  /**
   * TLE
   */
  public static int kthSmallest2(int[][] mat, int index) {
    List<Integer> list = new ArrayList<>();

    if (mat.length != 1) {
      for (int j = 0; j < mat[0].length; j++) {
        k(mat, 1, j, mat[0][j], list);
      }
    } else {
      for (int j = 0; j < mat[0].length; j++) {
        list.add(mat[0][j]);
      }
    }

    Collections.sort(list);
    for (int r : list) {
      System.out.print(r + ", ");
    }

    return list.get(index - 1);
  }

  public static void k(int[][] mat, int row, int col, int sum, List<Integer> list) {
    if (row + 1 == mat.length) {
      for (int k = 0; k < mat[row].length; k++) {
        list.add(sum + mat[row][k]);
      }
      return;
    }

    // for each element in current row
    for (int j = 0; j < mat[row].length; j++) {
      k(mat, row + 1, j, sum + mat[row][j], list);
    }
  }
}

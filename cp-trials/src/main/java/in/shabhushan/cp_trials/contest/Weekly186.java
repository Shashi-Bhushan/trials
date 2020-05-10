package in.shabhushan.cp_trials.contest;

import java.util.ArrayList;
import java.util.List;

public class Weekly186 {
  public static int maxScore(int[] cards, int k) {
    int[] c = new int[cards.length + 1];

    for (int i = 0; i < cards.length; i++) {
      c[i + 1] = c[i] + cards[i];
    }

    int total = 0;
    for (int i = 0; i < k; i++) {
      // c[last] - c[last - k + i] will give sum from right
      total = Math.max(total, c[cards.length] - c[cards.length - k + i]);
    }

    return total;
  }

  /**
   * TLE Since it's O(n^2)
   * @param nums
   * @return
   */
  public int[] findDiagonalOrder(List<List<Integer>> nums) {
    int max = 0;
    int total = 0;
    for (List<Integer> num : nums) {
      max = Math.max(max, num.size());
      total += num.size();
    }

    int[] ans = new int[total];
    int index = 0;

    for (int i = 0; i < nums.size(); i++) {

      List<List<Integer>> l = getIndex(i, 0, i);

      for (List<Integer> x: l) {

        try {
          if (nums.get(x.get(0)) != null) {
            List<Integer> y = nums.get(x.get(0));

            if (y.get(x.get(1)) != null) {
              ans[index++] = y.get(x.get(1));
            }
          }
        } catch (IndexOutOfBoundsException cause) {}
      }
    }

    int row = nums.size() - 1;
    for (int i = 1; i < max; i++) {
      //System.out.println("max " + max + " i : " + i);
      List<List<Integer>> l = getIndex(row, i, row + i);

      for (List<Integer> x: l) {
        //System.out.println("x : " + x);
        try {
          if (nums.get(x.get(0)) != null) {
            List<Integer> y = nums.get(x.get(0));

            if (y.get(x.get(1)) != null) {
              ans[index++] = y.get(x.get(1));
            }
          }
        } catch (IndexOutOfBoundsException cause) {}
      }

    }

    return ans;
  }

  private static List<List<Integer>> getIndex(int row, int col, int max) {
    List<List<Integer>> ans = new ArrayList<>();

    while (col <= max) {
      List<Integer> a = new ArrayList<>();

      a.add(row);
      a.add(col);

      ans.add(a);
      row--;
      col++;
    }

    return ans;
  }
}

package in.shabhushan.algo_trials.dynamic_programming;

import java.util.*;

/**
 * Given a chain of matrices A1, A2, A3,.....An, you have to figure out the most efficient way to multiply these matrices.
 * In other words, determine where to place parentheses to minimize the number of multiplications.
 *
 * You will be given an array p[] of size n + 1. Dimension of matrix Ai is p[i - 1]*p[i]. You need to find minimum number of multiplications needed to multiply the chain.
 */
public class MatrixChainMultiplication {
  private static Map<Map.Entry<Integer, Integer>, Integer> map;

  public static int mcm(int[] p){

    /* Your class should be named Solution
     * Don't write main().
     * Don't read input, it is passed as function argument.
     * Return output and don't print it.
     * Taking input and printing output is handled automatically.
     */

    map = new HashMap<>();

    return helper(p, 0, p.length - 1);
  }

  private static int helper(int[] arr, int start, int end) {
    if (start + 1 >= end) return 0; // if nothing between start and end
    Map.Entry<Integer, Integer> entry = new AbstractMap.SimpleEntry<>(start, end);

    if (map.containsKey(entry)) return map.get(entry);

    int min = Integer.MAX_VALUE;

    for (int i = start + 1; i < end; i++) {
      min = Math.min(min, (arr[start] * arr[i] * arr[end]) + helper(arr, start, i) + helper(arr, i, end));
    }

    map.put(entry, min);

    return min;
  }



}

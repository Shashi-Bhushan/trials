import java.util.*;

/**
 * Code : Pair Sum to 0
 * Send Feedback
 * Given a random integer array A of size N. Find and print the count of pair of elements in the array which sum up to 0.
 * Note: Array A can contain duplicate elements as well.
 *
 * 
 * 2 1 -2 2 3 => 2
 * 0 0 0 0 0 => 10
 */

public class Solution {
	public static int PairSum(int[] input, int size) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
        */
        int ans = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < input.length; i++) {
            map.put(input[i], map.getOrDefault(input[i], 0) + 1);
        }
        
        for (int i = 0; i < input.length; i++) {
            if (map.containsKey(-input[i])) {
                if (input[i] == 0) {
                    if (map.get(0) > 1)
                        ans += map.get(input[i]) - 1;
                } else {
                    ans += map.get(-input[i]);
                }

                decrease(map, input[i]);
            }
        }
        
        return ans;
	}
    
    private static void decrease(Map<Integer, Integer> map, int key) {
        if (map.get(key) == 1) {
            map.remove(key);
        } else {
            map.put(key, map.get(key) - 1);
        }
    }
}

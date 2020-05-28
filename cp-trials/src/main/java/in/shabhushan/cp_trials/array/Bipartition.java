package in.shabhushan.cp_trials.array;

import java.util.*;

/**
 * Leetcode solution for
 * https://leetcode.com/problems/possible-bipartition/submissions/
 *
 * see https://www.youtube.com/watch?v=qO_EkdJPf2Y for explanation
 */
public class Bipartition {
  public static boolean possibleBipartition(int N, int[][] dislikes) {
    List<List<Integer>> d = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      d.add(new ArrayList<Integer>());
    }

    for (int[] pair: dislikes) {
      d.get(pair[0] - 1).add(pair[1] - 1);
      d.get(pair[1] - 1).add(pair[0] - 1);
    }

    Colors[] colors = new Colors[N];

    for (int i = 0; i < N; i++) {
      if (colors[i] == null) {
        // Assign First to this item, other team to all it's dislikes
        colors[i] = Colors.BLUE;

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(i);


        while (!queue.isEmpty()) {
          int item = queue.pop();

          List<Integer> dislike = d.get(item);

          for (int hated: dislike) {
            if (colors[item].equals(colors[hated])) {
              // color already assigned as item color
              return false;
            }

            // if color not assigned
            if (colors[hated] == null) {
              colors[hated] = colors[item].equals(Colors.BLUE) ? Colors.RED : Colors.BLUE;
              queue.push(hated);
            }
          }
        }
      }
    }

    return true;
  }

  private static enum Colors {
    BLUE, RED;

    @Override
    public String toString() { return (this.equals(BLUE)) ? "BLUE" : "RED";}
  }
}

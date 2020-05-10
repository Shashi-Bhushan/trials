package in.shabhushan.cp_trials.tree;

import java.util.SortedSet;
import java.util.TreeSet;

class DoubleLinear {

  public static int dblLinear(int n) {
    int[] arr = new int[n + 1];
    arr[0] = 1;

    int i = 0, j = 0;
    for(int k = 1; k < n + 1; k++) {
      int y = 2 * arr[i] + 1;
      int z = 3 * arr[j] + 1;

      // choose smaller
      if (y < z) {
        arr[k] = y;
        i++;
      } else if (z < y) {
        arr[k] = z;
        j++;
      } else {
        arr[k] = y;
        i++;
        j++;
      }
    }

    return arr[n];
  }

  public static int dblLinear2(int n) {
    if (n == 0)
      return 1;

    SortedSet<Integer> set = new TreeSet<>();
    set.add(1);

    for (int i = 0; i < n; i++) {
      int x = set.first();

      set.add(x * 2 + 1);
      set.add(x * 3 + 1);

      set.remove(x);
    }

    return set.first();
  }

}

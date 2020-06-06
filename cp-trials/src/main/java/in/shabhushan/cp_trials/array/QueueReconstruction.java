package in.shabhushan.cp_trials.array;

import java.util.*;

class QueueReconstruction {
  public int[][] reconstructQueue(int[][] people) {
    Arrays.sort(people, (a, b) -> {
      if (a[1] != b[1])
        return a[1] - b[1];
      else
        return a[0] - b[0];
    });

    List<int[]> ans = new ArrayList<>();

    // Brute force method, sort of like insertion sort. Find the correct position of person to insert in ans list
    for (int[] person: people) {
      if (ans.isEmpty()){
        ans.add(person);
      } else {
        int count = 0;

        boolean added = false;

        for (int i = 0; i < ans.size(); i++) {
          // ans's height is >= person's height
          if (ans.get(i)[0] >= person[0]) {
            count++;
          }

          // count is greater than person's position
          if (count > person[1]) {
            ans.add(i, person);
            /*for(int[] x: ans) {
              System.out.print(Arrays.toString(x));
            }
            System.out.println();*/
            added = true;
            break;
          }
        }

        if (!added) ans.add(person);
      }
    }

    int[][] a = new int[ans.size()][2];

    for (int i = 0; i < ans.size(); i++) {
      a[i] = ans.get(i);
    }

    return a;
  }
}

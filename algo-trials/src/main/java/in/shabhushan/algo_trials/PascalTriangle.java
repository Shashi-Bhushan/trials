package in.shabhushan.algo_trials;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
  public static List<List<Integer>> getPascalTriangle(int depth) {
    List<List<Integer>> output = new ArrayList<>();

    for (int i = 0; i < depth; i++) {
      List<Integer> list = new ArrayList<>();
      list.add(1);

      output.add(list);
    }

    //
    for (int iter = 1; iter < depth; iter++) {

      int number = 1;

      for (int level = iter; level < depth; level++) {
        // get the list to add the number
        List<Integer> list = output.get(level);

        int lastNumber = list.get(list.size() - 1);
        list.add(number);

        number += lastNumber;
      }
    }

    System.out.println(depth + " " + output);

    return output;
  }
}

package in.shabhushan.cp_trials.string.logic;

import java.util.ArrayList;
import java.util.List;

public class ComposeRanges {
  public static final String[] composeRanges(int[] array) {
    List<String> strings = new ArrayList<>();

    for(int i = 0; i < array.length; i++) {
      int start = i;

      while (i + 1 < array.length && array[i] + 1 == array[i + 1])
        i++;

      int end = i;

      if (start == end) {
        strings.add(String.valueOf(array[start]));
      } else {
        strings.add(String.format("%d->%d", array[start], array[end]));
      }
    }

    return strings.toArray(String[]::new);
  }
}

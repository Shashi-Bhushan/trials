package in.shabhushan.algo_trials.trials;

import java.util.*;
import java.util.stream.IntStream;

public class UniqueElements {
  private static final int ARRAY_SIZE = 100_00_00_0;

  private static final int[] ar;

  static {
    ar = IntStream.range(0, ARRAY_SIZE).toArray();

    Random random = new Random();
    for (int i = 0; i < ar.length; i++) {
      ar[i] = random.nextInt(ARRAY_SIZE);
    }
  }

  public static int[] getArrayCopy() {
    return Arrays.copyOf(ar, ar.length);
  }

  public static int getUniqueElementsCountUsingHashSet(int[] array) {
    Set<Integer> set = new HashSet<>();

    for (int value : array) {
      set.add(value);
    }

    return set.size();
  }

  public static int getUniqueElementsCountUsingSorting(int[] array) {
    Arrays.sort(array);

    int count = 1;

    for (int i = 1; i < array.length; i++) {
      if (array[i - 1] != array[i])
        count++;
    }

    return count;
  }
}

package in.shabhushan.cp_trials.util;

import java.util.Random;
import java.util.stream.IntStream;

public class ArrayUtil {
  public static int[] getRandomArray(int arraySize) {
    int[] ar = IntStream.range(0, arraySize).toArray();

    Random rnd = new Random();
    for (int i = ar.length - 1; i > 0; i--) {
      int index = rnd.nextInt(i + 1);
      // Simple swap
      int a = ar[index];
      ar[index] = ar[i];
      ar[i] = a;
    }

    return ar;
  }
}

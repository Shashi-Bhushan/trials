package in.shabhushan.algo_trials.algorithms.utils;

public class CommonUtil {
  public static final <T> void swap(T[] array, int firstIndex, int secondIndex) {
    T element = array[firstIndex];
    array[firstIndex] = array[secondIndex];
    array[secondIndex] = element;
  }

  public static final void swap(char[] array, int firstIndex, int secondIndex) {
    char element = array[firstIndex];
    array[firstIndex] = array[secondIndex];
    array[secondIndex] = element;
  }
}

package in.shabhushan.cp_trials.google_interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddArrays {

  public static int[] addPadding(int[] array, int finalLength) {
    int[] finalArray = new int[finalLength];

    int x = finalLength - array.length;
    for (int i = 0; i < array.length; i++) {
      finalArray[x + i] = array[i];
    }

    return finalArray;
  }

  public static boolean isBiggerOrEqual(int[] first, int[] second) {
    for (int i =0; i < first.length; i++) {
      if (first[i] < second[i])
        return false;
      else if (first[i] > second[i])
        return true;
    }

    return true;
  }

  /**
   * This works on the assumption of first is equal or greater than the second and add relevant padding to either first or second
   * @param first
   * @param second
   * @return
   */
  public static int[] addArrays(int[] first, int[] second) {
    if (first.length != second.length) {
      if (first.length < second.length) {
        first = addPadding(first, second.length);
      } else {
        second = addPadding(second, first.length);
      }
    }

    // if padding is added to first in previous step, still it will stay small then second. this takes care of our initial assumption.
    if (!isBiggerOrEqual(first, second))
      return addArrays(second, first);

    int carry = 0;
    List<Integer> list = new ArrayList<>();

    for (int i = first.length - 1; i >= 0; i--) {
      int x = first[i] + second[i] + carry;
      carry = 0;

      if (x < 10) {
        list.add(0, x);
      } else {
        list.add(0, x % 10);
        carry = x / 10;
      }
    }

    if (carry != 0) {
      list.add(0, carry);
    }

    return list.stream().mapToInt(n -> n).toArray();
  }

  /**
   * Coding of the actual add function along with moving carry forward
   * Faster than List based solution
   */
  public static int[] addArrays2(int[] first, int[] second) {
    if (first.length != second.length) {
      if (first.length < second.length) {
        first = addPadding(first, second.length);
      } else {
        second = addPadding(second, first.length);
      }
    }

    // if padding is added to first in previous step, still it will stay small then second. this takes care of our initial assumption.
    if (!isBiggerOrEqual(first, second))
      return addArrays2(second, first);

    return addArrays2Helper(reverse(first), reverse(second));
  }

  public static int[] addArrays2Helper(int[] first, int[] second) {
    int[] answer = new int[first.length];
    int carry = 0;

    for (int i = 0; i < first.length; i++) {
      int x = first[i] + second[i] + carry;
      carry = 0;

      if (x < 10) {
        answer[i] = x;
      } else {
        answer[i] = x % 10;
        carry = x / 10;
      }
    }

    if (carry == 0) return reverse(answer); else {
        int[] n = Arrays.copyOf(answer, answer.length + 1);
        n[n.length - 1] = carry;

        return reverse(n);
    }
  }

  private static int[] reverse(int[] array) {
    int[] r = new int[array.length];

    for (int i = 0; i < array.length; i++) {
      r[r.length - i - 1] = array[i];
    }

    return r;
  }
}

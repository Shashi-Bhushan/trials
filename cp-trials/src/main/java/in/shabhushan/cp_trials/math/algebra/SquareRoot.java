package in.shabhushan.cp_trials.math.algebra;

public class SquareRoot {
  private SquareRoot() {}

  public static boolean isPerfectSquareVersion1(int num) {
    if (num == 0 || num == 1)
      return true;

    int x = 2 * 2;
    for (int i = 2; x <= num && 0 < x; i++) {
      if (x == num) {
        return true;
      }

      x = i * i;
    }

    return false;
  }

  public static boolean isPerfectSquareVersion2(int num) {
    if (num == 0 || num == 1)
      return true;

    int low = 1;
    int high = num;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      int remainder = num % mid;
      int divisor = num / mid;

      if (remainder == 0 && divisor == mid) {
        return true;
      } else if (mid < divisor) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return false;
  }
}

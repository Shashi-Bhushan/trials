package in.shabhushan.algo_trials.collections.utils;

public final class Math {
  public static final int pow(int base, int pow) {
    int result = 1;

    while (pow > 0) {
      if ((pow & 1) != 0) {
        result = result * base;
      }

      base *= base;
      pow >>= 1;
    }

    return result;
  }
}

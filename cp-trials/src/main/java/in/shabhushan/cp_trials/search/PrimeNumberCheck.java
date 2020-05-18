package in.shabhushan.cp_trials.search;

public class PrimeNumberCheck {
  public static boolean isPrime(int x) {
    if (x == 1 || x == 2 || x == 3)
      return true;

    // cover corner cases
    if (x < 1 || x % 2 == 0 || x % 3 == 0)
      return false;

    // start loop using 5 (not 6)
    for (int i = 5; i * i <= x; i += 6) {
      // These will be prime numbers. we simply check if they divide x or not.
      if (x % i == 0 || x % (i + 2) == 0)
        return false;
    }

    return true;
  }
}

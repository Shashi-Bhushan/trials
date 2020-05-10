package in.shabhushan.cp_trials.math.logic;

public class ProperFractions {
  /**
   * A Bruteforce solution for this is
   * Assume all numbers from [1, n]/n are proper fractions
   * To denote this, create an array of size n. 0 denotes this number is proper fraction.
   *
   * Loop: 2..Sqrt(n)
   * if index % n != 0, it divides n and hence is not proper fraction. assign 1.
   *
   * Answer would be number of entries still 0.
   *
   * //////////////////////////////
   *
   * Better solution is build on top of the brute force solution.
   *
   * answer = n
   * Loop: 2..Sqrt(n)
   * __if (index % n == 0)
   * ____reduce n while index divides n perfectly
   *
   * __Since the potential number of valid answers has been reduced by index
   * __answer = answer - answer / index
   * __ for eg, if 2 divides n, the potential answers are now half. for 3, it's now 2/3rd.
   *
   * if n is still greater than 1,
   * __ answer = answer - answer / n
   * __
   *
   * @param n
   * @return
   */
  public static long properFractions(long n) {
    if (n == 1) return 0;

    long answer = n;

    for (long index = 2; index * index <= n; index++) {
      if (n % index == 0) {
        while (n % index == 0)
          n /= index;

        answer = answer - (answer / index);
      }
    }

    // to check this, visualize with n == 15
    if (n > 1)
      answer = answer - (answer / n);

    return answer;
  }
}

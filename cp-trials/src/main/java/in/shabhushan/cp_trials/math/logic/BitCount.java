package in.shabhushan.cp_trials.math.logic;

import java.math.BigInteger;

public class BitCount {

  public static BigInteger countOnes(long left, long right) {
    BigInteger count = BigInteger.ZERO;

    for (long l = left; l <= right; l++) {
      count = count.add(count(BigInteger.valueOf(l)));
    }

    return count;
  }

  private static int count(int n) {
    int count = 0;

    while ( n != 0) {
      n = n & (n - 1);
      count++;
    }

    return count;
  }

  private static BigInteger count(BigInteger n) {
    BigInteger count = BigInteger.ZERO;

    while ( !n.equals(BigInteger.ZERO)) {
      n = n.and(n.subtract(BigInteger.ONE));
      count = count.add(BigInteger.ONE);
    }

    return count;
  }
}

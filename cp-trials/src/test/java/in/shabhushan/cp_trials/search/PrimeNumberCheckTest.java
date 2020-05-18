package in.shabhushan.cp_trials.search;

import org.junit.Test;

import static in.shabhushan.cp_trials.search.PrimeNumberCheck.isPrime;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PrimeNumberCheckTest {
  @Test
  public void testPrimeNumber() {
    assertTrue(isPrime(2));
    assertTrue(isPrime(3));
    assertFalse(isPrime(4));
    assertTrue(isPrime(5));
    assertFalse(isPrime(6));
    assertTrue(isPrime(11));
    assertTrue(isPrime(13));
    assertFalse(isPrime(21));
    assertFalse(isPrime(25));
    assertTrue(isPrime(29));
    assertTrue(isPrime(31));
  }
}

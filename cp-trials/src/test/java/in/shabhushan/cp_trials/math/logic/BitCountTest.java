package in.shabhushan.cp_trials.math.logic;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class BitCountTest {
  @Test
  public void sampleTests() {
    assertEquals(new BigInteger("7"), BitCount.countOnes(5, 7));
    assertEquals(new BigInteger("51"), BitCount.countOnes(12, 29));
  }
}

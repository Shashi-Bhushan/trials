package in.shabhushan.cp_trials.ds.stack;

import org.junit.Test;

import static in.shabhushan.cp_trials.ds.stack.RemoveKDigits.removeKdigits;
import static org.junit.Assert.assertEquals;

public class RemoveKDigitsTest {
  @Test
  public void removeKDigits() {
    assertEquals("1219", removeKdigits("1432219", 3));
    assertEquals("200", removeKdigits("10200", 1));
    assertEquals("0", removeKdigits("10", 2));
    assertEquals("523000", removeKdigits("12345000000523000", 5));
    assertEquals("23000", removeKdigits("12345000000523000", 6));
    assertEquals("0", removeKdigits("9", 1));
  }
}

package in.shabhushan.algo_trials.dynamic_programming.chapter9;

import org.junit.Test;

import java.util.List;

import static in.shabhushan.algo_trials.dynamic_programming.chapter9.AllStringInterleaving.getTotalStringInterleaving;
import static org.junit.Assert.assertEquals;

public class AllStringsInterleavingTest {
  @Test
  public void testAllStringsInterleaving() {
    List<String> t = getTotalStringInterleaving("AB", "XY");

    assertEquals(List.of("ABXY", "AXBY", "AXYB", "XABY", "XAYB", "XYAB"), t);
  }
}

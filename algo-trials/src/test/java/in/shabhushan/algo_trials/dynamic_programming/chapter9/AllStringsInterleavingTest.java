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
    assertEquals(List.of("ABCDXYZ", "ABCXDYZ", "ABCXYDZ", "ABCXYZD", "ABXCDYZ", "ABXCYDZ", "ABXCYZD", "ABXYCDZ", "ABXYCZD", "ABXYZCD", "AXBCDYZ", "AXBCYDZ", "AXBCYZD", "AXBYCDZ", "AXBYCZD", "AXBYZCD", "AXYBCDZ", "AXYBCZD", "AXYBZCD", "AXYZBCD", "XABCDYZ", "XABCYDZ", "XABCYZD", "XABYCDZ", "XABYCZD", "XABYZCD", "XAYBCDZ", "XAYBCZD", "XAYBZCD", "XAYZBCD", "XYABCDZ", "XYABCZD", "XYABZCD", "XYAZBCD", "XYZABCD"), getTotalStringInterleaving("ABCD", "XYZ"));
  }
}

package in.shabhushan.cp_trials.competition.contest;

import in.shabhushan.cp_trials.competition.contest.Weekly185;
import org.junit.Test;

import static in.shabhushan.cp_trials.competition.contest.Weekly185.minNumberOfFrogs;
import static org.junit.Assert.assertEquals;

public class Weekly185Test {
  @Test
  public void testHappyString() {
    String and = new Weekly185().getHappyString(3, 3);
  }

  @Test
  public void testMinNumberOfFrogs() {
    assertEquals(1, minNumberOfFrogs("croakcroak"));
    assertEquals(2, minNumberOfFrogs("crcoakroak"));
    assertEquals(-1, minNumberOfFrogs("croakcrook"));
    assertEquals(-1, minNumberOfFrogs("croakcroa"));
  }
}

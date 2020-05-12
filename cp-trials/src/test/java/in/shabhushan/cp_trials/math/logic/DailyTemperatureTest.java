package in.shabhushan.cp_trials.math.logic;

import org.junit.Test;

import static in.shabhushan.cp_trials.math.logic.DailyTemperature.dailyTemperatures;
import static in.shabhushan.cp_trials.math.logic.DailyTemperature.dailyTemperatures2;
import static org.junit.Assert.assertArrayEquals;

public class DailyTemperatureTest {
  @Test
  public void test() {
    for (int i = 0; i < 10000; i++) {
      assertArrayEquals(new int[]{1, 1, 4, 2, 1, 1, 0, 0}, dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
      assertArrayEquals(new int[]{8, 1, 5, 4, 3, 2, 1, 1, 0, 0}, dailyTemperatures(new int[]{89, 62, 70, 58, 47, 47, 46, 76, 100, 70}));
    }
  }

  @Test
  public void testStackSolution() {
    for (int i = 0; i < 10000; i++) {
      assertArrayEquals(new int[]{1, 1, 4, 2, 1, 1, 0, 0}, dailyTemperatures2(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
      assertArrayEquals(new int[]{8, 1, 5, 4, 3, 2, 1, 1, 0, 0}, dailyTemperatures(new int[]{89, 62, 70, 58, 47, 47, 46, 76, 100, 70}));
    }
  }
}

package in.shabhushan.algo_trials.clrs.chapter15;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static in.shabhushan.algo_trials.clrs.chapter15.RodCutting.rodCutting;
import static in.shabhushan.algo_trials.clrs.chapter15.RodCutting.rodCuttingWithSizes;
import static org.junit.Assert.assertEquals;

public class RodCuttingTest {
  @Test
  public void testRodCutting() {
    assertEquals(6, rodCutting(new int[]{3, 5}));
    assertEquals(22, rodCutting(new int[]{1, 5, 8, 9, 10, 17, 17, 20}));
    assertEquals(24, rodCutting(new int[]{3, 5, 8, 9, 10, 17, 17, 20}));
  }

  @Test
  public void testRodCuttingWithSizes() {
    Map.Entry<Integer, List<Integer>> answer = rodCuttingWithSizes(new int[]{3, 5});
    assertEquals(Integer.valueOf(6), answer.getKey());
    assertEquals(List.of(0, 0), answer.getValue());

    answer = rodCuttingWithSizes(new int[]{1, 5, 8, 9, 10, 17, 17, 20});
    assertEquals(Integer.valueOf(22), answer.getKey());
    assertEquals(List.of(1, 5), answer.getValue()); // 5 + 17

    answer = rodCuttingWithSizes(new int[]{3, 5, 8, 9, 10, 17, 17, 20});
    assertEquals(Integer.valueOf(24), answer.getKey());
    assertEquals(List.of(0, 0, 0, 0, 0, 0, 0, 0), answer.getValue()); // always making a cut at first position
  }
}

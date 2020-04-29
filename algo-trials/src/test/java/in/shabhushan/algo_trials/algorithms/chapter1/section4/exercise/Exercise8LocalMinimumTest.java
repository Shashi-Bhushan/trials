package in.shabhushan.algo_trials.algorithms.chapter1.section4.exercise;

import org.junit.Test;

import static in.shabhushan.algo_trials.algorithms.chapter1.section4.exercise.Exercise18LocalMinimum.localMinimum;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class Exercise8LocalMinimumTest {
  @Test
  public void testLocalMinimum() {
    assertThat(localMinimum(new int[]{10, -9, 20, 25, 21, 40, 50, -20}), anyOf(is(-9), is(-20), is(210)));
    assertThat(localMinimum(new int[]{-4, -3, 9, 4, 10, 2, 20}), anyOf(is(4), is(-4), is(2)));
    assertThat(localMinimum(new int[]{5, -3, -5, -6, -7, -8}), anyOf(is(-8)));
    assertThat(localMinimum(new int[]{5}), anyOf(is(5)));
    assertThat(localMinimum(new int[]{10, 20}), anyOf(is(10)));
    assertThat(localMinimum(new int[]{7, 20, 30}), anyOf(is(7)));
    assertThat(localMinimum(new int[]{3, 2, 1, 0, 5, 6 ,7, 8, 9}), anyOf(is(0)));
  }
}

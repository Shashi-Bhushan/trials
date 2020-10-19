package in.shabhushan.algo_trials.clrs.chapter9;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static in.shabhushan.algo_trials.clrs.chapter7.QuickSort.getRandomArr;
import static in.shabhushan.algo_trials.clrs.chapter9.Exercise.problem9_3_7;
import static org.junit.Assert.assertEquals;

public class ExerciseTest {
  @Test
  public void testProblem9_3_7() {
    int size = 1000;

    List<Integer> list = Arrays.stream(getRandomArr(size)).boxed().map(a -> a + 1000).collect(Collectors.toList());

    List<Integer> ans = problem9_3_7(list, 50);

    ans.stream().min(Integer::compareTo).ifPresent(a -> assertEquals(Integer.valueOf(1475), a));
    ans.stream().max(Integer::compareTo).ifPresent(a -> assertEquals(Integer.valueOf(1525), a));
  }
}

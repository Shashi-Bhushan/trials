package in.shabhushan.algo_trials.algorithms.chapter1.section1.exercise;

import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

import java.util.Arrays;

import static in.shabhushan.algo_trials.algorithms.chapter1.section1.exercise.Exercise35.diceExperiments;
import static in.shabhushan.algo_trials.algorithms.chapter1.section1.exercise.Exercise35.diceSimulations;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Exercise35Test {
  @Test
  public void testDiceSimulations() {
    double[] doubles = diceSimulations();

    double[] experimentResult = diceExperiments(6000000);

    assertArrayEquals(doubles, experimentResult, 0.003);
  }
}

package in.shabhushan.algo_trials.algorithms.chapter1.section1.exercise;

import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

import static in.shabhushan.algo_trials.algorithms.chapter1.section1.exercise.Exercise39.mainExperiment;

public class Exercise39Test {
  @Test
  public void test() {

    int[] results = mainExperiment(30);

    StdOut.println("Results");

    StdOut.printf("10ˆ3: %7.4f \n", ((double)results[0]) / 30);
    StdOut.printf("10ˆ4: %7.4f \n", ((double)results[1]) / 30);
    StdOut.printf("10ˆ5: %7.4f \n", ((double)results[2]) / 30);
    StdOut.printf("10ˆ6: %7.4f \n", ((double)results[3]) / 30);
  }
}

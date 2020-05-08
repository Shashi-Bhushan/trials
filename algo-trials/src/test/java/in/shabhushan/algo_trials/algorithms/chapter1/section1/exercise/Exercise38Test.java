package in.shabhushan.algo_trials.algorithms.chapter1.section1.exercise;

import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static in.shabhushan.algo_trials.algorithms.chapter1.section1.exercise.Exercise38.calculateTime;

/**
 * For Large W,
 * BRUTEFORCE :: Time Duration: 4585243 nanoseconds.
 * Binary Search :: Time Duration: 3707 nanoseconds.
 *
 * For Large T,
 * BRUTEFORCE :: Time Duration: 4064195 nanoseconds.
 * Binary Search :: Time Duration: 4263 nanoseconds.
 */
public class Exercise38Test {
  @Test
  public void testBruteForce() throws URISyntaxException, IOException {
    int[] inputLargeW = extract("/largeW.txt");
    int[] inputLargeT = extract("/largeT.txt");

    calculateTime(760788, inputLargeW);
    calculateTime(760788, inputLargeT);
  }

  private int[] extract(String fileName) throws URISyntaxException, IOException {
    Path path = Paths.get(getClass().getResource(fileName).toURI());
    return Files.lines(path).map(String::trim).mapToInt(Integer::parseInt).toArray();
  }
}

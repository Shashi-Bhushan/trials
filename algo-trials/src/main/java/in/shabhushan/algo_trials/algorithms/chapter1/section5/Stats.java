package in.shabhushan.algo_trials.algorithms.chapter1.section5;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Stats {
  private static final String LINE_SEPARATOR = System.getProperty("line.separator");

  public static void generateStats(String exerciseNumber, UnionFind unionFind, int[][] operations) {
    try(FileWriter file = new FileWriter("Exercise" + exerciseNumber + ".txt")) {
      file.write("Exercise " + exerciseNumber + LINE_SEPARATOR);
      printStats(file, unionFind.getParent(), unionFind.getTotalCount());

      for (int[] operation: operations) {
        unionFind.union(operation[0], operation[1]);

        printStats(file, unionFind.getParent(), unionFind.getTotalCount());
      }
    } catch (IOException cause) { /* Should have handled this*/ }
  }

  private static void printStats(FileWriter file, int[] parent, int[] stats) throws IOException {
    String index = "index = " + IntStream.range(0, parent.length).mapToObj(s -> s + ", ").collect(Collectors.joining()) + LINE_SEPARATOR;
    String array = "array = " + Arrays.stream(parent).mapToObj(s -> s + ", ").collect(Collectors.joining()) + LINE_SEPARATOR;
    String statistics = String.format("Array accesses: %d (%d in find() + %d for checking parents + %d for updating parents) %s",
        stats[0], stats[1], stats[2], stats[3], LINE_SEPARATOR);

    file.write(index);
    file.write(array);
    file.write(statistics);
    file.write(LINE_SEPARATOR);
  }
}

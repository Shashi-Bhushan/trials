package in.shabhushan.algo_trials.benchmark.sort;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static in.shabhushan.algo_trials.benchmark.sort.countingsort.CountingSort.stableCountingSort;
import static in.shabhushan.algo_trials.benchmark.sort.countingsort.CountingSort.unstableCountingSort;
import static in.shabhushan.algo_trials.benchmark.sort.quicksort.QuickSort.*;
import static in.shabhushan.algo_trials.benchmark.sort.radixsort.RadixSort.radixSort;

/**
 * Benchmark                             Mode  Cnt     Score     Error  Units
 * Benchmarks.testRadixSort             thrpt   10   199.995 ±   1.320  ops/s
 * Benchmarks.testRandomQuickSort       thrpt   10   105.648 ±   0.678  ops/s
 * Benchmarks.testStableCountingSort    thrpt   10  1321.737 ±   9.023  ops/s
 * Benchmarks.testUnstableCountingSort  thrpt   10  3428.169 ± 204.408  ops/s
 */
@Warmup(iterations = 3, time = 2, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 2, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@State(Scope.Thread)
public class Benchmarks {
  private static final int ARRAY_SIZE = 100_000;

  private int[] arr;

  /*
  @Setup
  public void setup() {
    arr = getRandomArr(ARRAY_SIZE);
  }

  @Benchmark
  public void testRandomQuickSort(Blackhole blackhole) {
    int[] array = getRandomArr(ARRAY_SIZE);

    quickSortRandom(array, 0, array.length - 1);
  }

  @Benchmark
  public void testStableCountingSort(Blackhole blackhole) {
    stableCountingSort(arr, ARRAY_SIZE);
  }

  @Benchmark
  public void testUnstableCountingSort(Blackhole blackhole) {
    unstableCountingSort(arr, ARRAY_SIZE);
  }

  @Benchmark
  public void testRadixSort(Blackhole blackhole) {
    radixSort(arr);
  }
  */
}

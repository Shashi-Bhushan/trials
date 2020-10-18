package in.shabhushan.algo_trials.benchmark.clrs;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

import static in.shabhushan.algo_trials.clrs.chapter7.CountingSort.stableCountingSort;
import static in.shabhushan.algo_trials.clrs.chapter7.CountingSort.unstableCountingSort;

/**
 * Benchmark                             Mode  Cnt     Score     Error  Units
 * Benchmarks.testRadixSort             thrpt   10   199.995 ±   1.320  ops/s
 * Benchmarks.testRadixSortUsingList    thrpt   10    96.303 ±   2.600  ops/s
 * Benchmarks.testRandomQuickSort       thrpt   10   105.648 ±   0.678  ops/s
 * Benchmarks.testStableCountingSort    thrpt   10  1321.737 ±   9.023  ops/s
 * Benchmarks.testUnstableCountingSort  thrpt   10  3428.169 ± 204.408  ops/s
 *
 * Benchmark                                                            Mode  Cnt         Score         Error   Units
 * Benchmarks.testRadixSort                                            thrpt   10       199.426 ±       1.722   ops/s
 * Benchmarks.testRadixSort:·gc.alloc.rate                             thrpt   10       730.411 ±       6.373  MB/sec
 * Benchmarks.testRadixSort:·gc.alloc.rate.norm                        thrpt   10   4801233.021 ±       0.009    B/op
 * Benchmarks.testRadixSort:·gc.churn.G1_Eden_Space                    thrpt   10       957.843 ±      87.116  MB/sec
 * Benchmarks.testRadixSort:·gc.churn.G1_Eden_Space.norm               thrpt   10   6297408.014 ±  601810.211    B/op
 * Benchmarks.testRadixSort:·gc.churn.G1_Old_Gen                       thrpt   10         0.002 ±       0.001  MB/sec
 * Benchmarks.testRadixSort:·gc.churn.G1_Old_Gen.norm                  thrpt   10        10.726 ±       6.873    B/op
 * Benchmarks.testRadixSort:·gc.count                                  thrpt   10        86.000                counts
 * Benchmarks.testRadixSort:·gc.time                                   thrpt   10        49.000                    ms
 *
 * Benchmarks.testRadixSortUsingList                                   thrpt   10       113.052 ±       1.318   ops/s
 * Benchmarks.testRadixSortUsingList:·gc.alloc.rate                    thrpt   10      1068.468 ±      12.544  MB/sec
 * Benchmarks.testRadixSortUsingList:·gc.alloc.rate.norm               thrpt   10  12389433.815 ±       0.055    B/op
 * Benchmarks.testRadixSortUsingList:·gc.churn.G1_Eden_Space           thrpt   10      1069.427 ±      89.926  MB/sec
 * Benchmarks.testRadixSortUsingList:·gc.churn.G1_Eden_Space.norm      thrpt   10  12400069.462 ± 1017651.085    B/op
 * Benchmarks.testRadixSortUsingList:·gc.churn.G1_Old_Gen              thrpt   10         0.736 ±       0.213  MB/sec
 * Benchmarks.testRadixSortUsingList:·gc.churn.G1_Old_Gen.norm         thrpt   10      8524.372 ±    2423.481    B/op
 * Benchmarks.testRadixSortUsingList:·gc.churn.G1_Survivor_Space       thrpt   10         1.077 ±       0.807  MB/sec
 * Benchmarks.testRadixSortUsingList:·gc.churn.G1_Survivor_Space.norm  thrpt   10     12507.478 ±    9416.967    B/op
 * Benchmarks.testRadixSortUsingList:·gc.count                         thrpt   10        95.000                counts
 * Benchmarks.testRadixSortUsingList:·gc.time                          thrpt   10       125.000                    ms
 *
 * Benchmarks.testRandomQuickSort                                      thrpt   10       105.745 ±       1.029   ops/s
 * Benchmarks.testRandomQuickSort:·gc.alloc.rate                       thrpt   10        32.273 ±       0.316  MB/sec
 * Benchmarks.testRandomQuickSort:·gc.alloc.rate.norm                  thrpt   10    400041.940 ±       0.070    B/op
 * Benchmarks.testRandomQuickSort:·gc.churn.G1_Eden_Space              thrpt   10        40.827 ±      42.594  MB/sec
 * Benchmarks.testRandomQuickSort:·gc.churn.G1_Eden_Space.norm         thrpt   10    507033.622 ±  529018.765    B/op
 * Benchmarks.testRandomQuickSort:·gc.churn.G1_Old_Gen                 thrpt   10         0.032 ±       0.130  MB/sec
 * Benchmarks.testRandomQuickSort:·gc.churn.G1_Old_Gen.norm            thrpt   10       395.801 ±    1614.615    B/op
 * Benchmarks.testRandomQuickSort:·gc.churn.G1_Survivor_Space          thrpt   10         0.040 ±       0.191  MB/sec
 * Benchmarks.testRandomQuickSort:·gc.churn.G1_Survivor_Space.norm     thrpt   10       492.289 ±    2353.592    B/op
 * Benchmarks.testRandomQuickSort:·gc.count                            thrpt   10         7.000                counts
 * Benchmarks.testRandomQuickSort:·gc.time                             thrpt   10        26.000                    ms
 *
 * Benchmarks.testStableCountingSort                                   thrpt   10      1309.259 ±      44.743   ops/s
 * Benchmarks.testStableCountingSort:·gc.alloc.rate                    thrpt   10       798.729 ±      27.284  MB/sec
 * Benchmarks.testStableCountingSort:·gc.alloc.rate.norm               thrpt   10    800040.156 ±       0.006    B/op
 * Benchmarks.testStableCountingSort:·gc.churn.G1_Eden_Space           thrpt   10      1048.218 ±      82.389  MB/sec
 * Benchmarks.testStableCountingSort:·gc.churn.G1_Eden_Space.norm      thrpt   10   1049983.680 ±   74974.890    B/op
 * Benchmarks.testStableCountingSort:·gc.churn.G1_Old_Gen              thrpt   10         0.002 ±       0.001  MB/sec
 * Benchmarks.testStableCountingSort:·gc.churn.G1_Old_Gen.norm         thrpt   10         1.709 ±       1.360    B/op
 * Benchmarks.testStableCountingSort:·gc.count                         thrpt   10        93.000                counts
 * Benchmarks.testStableCountingSort:·gc.time                          thrpt   10        55.000                    ms
 *
 * Benchmarks.testUnstableCountingSort                                 thrpt   10      3475.703 ±     105.618   ops/s
 * Benchmarks.testUnstableCountingSort:·gc.alloc.rate                  thrpt   10      2120.465 ±      64.279  MB/sec
 * Benchmarks.testUnstableCountingSort:·gc.alloc.rate.norm             thrpt   10    800040.059 ±       0.002    B/op
 * Benchmarks.testUnstableCountingSort:·gc.churn.G1_Eden_Space         thrpt   10      2784.151 ±     169.264  MB/sec
 * Benchmarks.testUnstableCountingSort:·gc.churn.G1_Eden_Space.norm    thrpt   10   1050424.382 ±   54231.230    B/op
 * Benchmarks.testUnstableCountingSort:·gc.churn.G1_Old_Gen            thrpt   10         0.002 ±       0.002  MB/sec
 * Benchmarks.testUnstableCountingSort:·gc.churn.G1_Old_Gen.norm       thrpt   10         0.803 ±       0.620    B/op
 * Benchmarks.testUnstableCountingSort:·gc.count                       thrpt   10       141.000                counts
 * Benchmarks.testUnstableCountingSort:·gc.time                        thrpt   10       110.000                    ms
 */
@Warmup(iterations = 3, time = 2, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 2, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@State(Scope.Thread)
@BenchmarkMode(Mode.Throughput)
public class Benchmarks {
  private static final int ARRAY_SIZE = 100_000;

  private int[] arr;
  private int[] arr2;
  private int[] arr3;

/*
  @Setup
  public void setup() {
    arr = getRandomArr(ARRAY_SIZE);
    arr2 = getRandomArr(ARRAY_SIZE);
    arr3 = getRandomArr(ARRAY_SIZE);
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

  @Benchmark
  public void testRadixSortUsingList(Blackhole blackhole) {
    radixSortUsingList(arr3);
  }
  */
}

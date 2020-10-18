package in.shabhushan.algo_trials.benchmark.clrs.chapter9;

import org.openjdk.jmh.annotations.*;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static in.shabhushan.algo_trials.clrs.chapter7.QuickSort.getRandomArr;
import static in.shabhushan.algo_trials.clrs.chapter9.MedianOfMedians.getSelectionByMedianOfMedians;
import static in.shabhushan.algo_trials.clrs.chapter9.RandomizedSelection.randomSelection;

/**
 * Benchmark                                                                        Mode  Cnt           Score          Error   Units
 * Benchmarks.testMedianOfMedians_LargeArray                                       thrpt   10           0.406 ±        0.015   ops/s
 * Benchmarks.testMedianOfMedians_LargeArray:·gc.alloc.rate                        thrpt   10         495.179 ±       15.166  MB/sec
 * Benchmarks.testMedianOfMedians_LargeArray:·gc.alloc.rate.norm                   thrpt   10  1539768787.200 ±       15.299    B/op
 * Benchmarks.testMedianOfMedians_LargeArray:·gc.churn.G1_Eden_Space               thrpt   10         304.614 ±       18.356  MB/sec
 * Benchmarks.testMedianOfMedians_LargeArray:·gc.churn.G1_Eden_Space.norm          thrpt   10   947388416.000 ± 57709321.461    B/op
 * Benchmarks.testMedianOfMedians_LargeArray:·gc.churn.G1_Survivor_Space           thrpt   10           2.200 ±        5.135  MB/sec
 * Benchmarks.testMedianOfMedians_LargeArray:·gc.churn.G1_Survivor_Space.norm      thrpt   10     6815744.000 ± 15910116.727    B/op
 * Benchmarks.testMedianOfMedians_LargeArray:·gc.count                             thrpt   10          60.000                 counts
 * Benchmarks.testMedianOfMedians_LargeArray:·gc.time                              thrpt   10       12634.000                     ms
 * Benchmarks.testMedianOfMedians_SmallArray                                       thrpt   10        7561.789 ±     1074.876   ops/s
 * Benchmarks.testMedianOfMedians_SmallArray:·gc.alloc.rate                        thrpt   10        1453.449 ±      206.577  MB/sec
 * Benchmarks.testMedianOfMedians_SmallArray:·gc.alloc.rate.norm                   thrpt   10      252040.028 ±        0.006    B/op
 * Benchmarks.testMedianOfMedians_SmallArray:·gc.churn.G1_Eden_Space               thrpt   10        1457.107 ±      201.143  MB/sec
 * Benchmarks.testMedianOfMedians_SmallArray:·gc.churn.G1_Eden_Space.norm          thrpt   10      252864.006 ±    12003.482    B/op
 * Benchmarks.testMedianOfMedians_SmallArray:·gc.churn.G1_Old_Gen                  thrpt   10           0.033 ±        0.010  MB/sec
 * Benchmarks.testMedianOfMedians_SmallArray:·gc.churn.G1_Old_Gen.norm             thrpt   10           5.641 ±        1.492    B/op
 * Benchmarks.testMedianOfMedians_SmallArray:·gc.count                             thrpt   10         127.000                 counts
 * Benchmarks.testMedianOfMedians_SmallArray:·gc.time                              thrpt   10         100.000                     ms
 * Benchmarks.testRandomizedSelection_LargeArray                                   thrpt   10          15.561 ±        0.896   ops/s
 * Benchmarks.testRandomizedSelection_LargeArray:·gc.alloc.rate                    thrpt   10         475.735 ±       27.130  MB/sec
 * Benchmarks.testRandomizedSelection_LargeArray:·gc.alloc.rate.norm               thrpt   10    40000029.072 ±        0.936    B/op
 * Benchmarks.testRandomizedSelection_LargeArray:·gc.churn.G1_Eden_Space           thrpt   10           2.890 ±        0.281  MB/sec
 * Benchmarks.testRandomizedSelection_LargeArray:·gc.churn.G1_Eden_Space.norm      thrpt   10      242841.310 ±    13543.592    B/op
 * Benchmarks.testRandomizedSelection_LargeArray:·gc.churn.G1_Old_Gen              thrpt   10         483.810 ±       54.715  MB/sec
 * Benchmarks.testRandomizedSelection_LargeArray:·gc.churn.G1_Old_Gen.norm         thrpt   10    40644815.354 ±  2831886.422    B/op
 * Benchmarks.testRandomizedSelection_LargeArray:·gc.count                         thrpt   10          63.000                 counts
 * Benchmarks.testRandomizedSelection_LargeArray:·gc.time                          thrpt   10          48.000                     ms
 * Benchmarks.testRandomizedSelection_SmallArray                                   thrpt   10       95985.631 ±     1889.095   ops/s
 * Benchmarks.testRandomizedSelection_SmallArray:·gc.alloc.rate                    thrpt   10         293.961 ±        5.789  MB/sec
 * Benchmarks.testRandomizedSelection_SmallArray:·gc.alloc.rate.norm               thrpt   10        4016.002 ±        0.001    B/op
 * Benchmarks.testRandomizedSelection_SmallArray:·gc.churn.G1_Eden_Space           thrpt   10         297.790 ±        0.188  MB/sec
 * Benchmarks.testRandomizedSelection_SmallArray:·gc.churn.G1_Eden_Space.norm      thrpt   10        4068.948 ±       81.746    B/op
 * Benchmarks.testRandomizedSelection_SmallArray:·gc.churn.G1_Old_Gen              thrpt   10           0.004 ±        0.015  MB/sec
 * Benchmarks.testRandomizedSelection_SmallArray:·gc.churn.G1_Old_Gen.norm         thrpt   10           0.060 ±        0.207    B/op
 * Benchmarks.testRandomizedSelection_SmallArray:·gc.churn.G1_Survivor_Space       thrpt   10           0.040 ±        0.191  MB/sec
 * Benchmarks.testRandomizedSelection_SmallArray:·gc.churn.G1_Survivor_Space.norm  thrpt   10           0.536 ±        2.565    B/op
 * Benchmarks.testRandomizedSelection_SmallArray:·gc.count                         thrpt   10          50.000                 counts
 * Benchmarks.testRandomizedSelection_SmallArray:·gc.time                          thrpt   10          24.000                     ms
 */
@Warmup(iterations = 3, time = 2, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 2, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@State(Scope.Thread)
public class Benchmarks {
  private static final int ARRAY_SIZE = 1000;
  private static final int LARGE_ARRAY_SIZE = 100_000_00;

  private int[] arr;
  private int[] largeArr;

  /*
  @Setup
  public void setup() {
    arr = getRandomArr(ARRAY_SIZE);
    largeArr = getRandomArr(LARGE_ARRAY_SIZE);
  }

  @Benchmark
  public void testRandomizedSelection_SmallArray() {
    randomSelection(Arrays.copyOf(arr, arr.length), 526);
  }

  @Benchmark
  public void testMedianOfMedians_SmallArray() {
    List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

    getSelectionByMedianOfMedians(list, 526);
  }

  @Benchmark
  public void testRandomizedSelection_LargeArray() {
    randomSelection(Arrays.copyOf(largeArr, largeArr.length), 23136);
  }

  @Benchmark
  public void testMedianOfMedians_LargeArray() {
    List<Integer> list = Arrays.stream(largeArr).boxed().collect(Collectors.toList());

    getSelectionByMedianOfMedians(list, 23136);
  }
  */
}

package in.shabhushan.algo_trials.benchmark.clrs.chapter11;

import in.shabhushan.algo_trials.clrs.chapter11.NonUniformDTO;
import in.shabhushan.algo_trials.clrs.chapter11.UniformDTO;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import static in.shabhushan.algo_trials.clrs.chapter11.HashGenerator.generateNonUniformNumbers;
import static in.shabhushan.algo_trials.clrs.chapter11.HashGenerator.generateUniformNumbers;

/**
 * Benchmark                                                 Mode  Cnt       Score    Error   Units
 * NonUniformSetTest.testNonUniformSet                      thrpt   10       0.526 ±  0.003   ops/s
 * NonUniformSetTest.testNonUniformSet:·gc.alloc.rate       thrpt   10       0.071 ±  0.001  MB/sec
 * NonUniformSetTest.testNonUniformSet:·gc.alloc.rate.norm  thrpt   10  160204.000 ±  0.001    B/op
 * NonUniformSetTest.testNonUniformSet:·gc.count            thrpt   10         ≈ 0           counts
 * NonUniformSetTest.testUniformSet                         thrpt   10   21613.030 ± 93.915   ops/s
 * NonUniformSetTest.testUniformSet:·gc.alloc.rate          thrpt   10      ≈ 10⁻⁴           MB/sec
 * NonUniformSetTest.testUniformSet:·gc.alloc.rate.norm     thrpt   10       0.009 ±  0.001    B/op
 * NonUniformSetTest.testUniformSet:·gc.count               thrpt   10         ≈ 0           counts
 */
@Warmup(iterations = 3, time = 2, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 2, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@State(Scope.Thread)
@BenchmarkMode(Mode.Throughput)
public class NonUniformSetTest {
  private static final int ARRAY_SIZE = 10000;

  private Set<NonUniformDTO> nonUniformSet;
  private Set<UniformDTO> uniformSet;

  /*
  @Setup
  public void setup() {
    nonUniformSet = generateNonUniformNumbers(ARRAY_SIZE);
    uniformSet = generateUniformNumbers(ARRAY_SIZE);
  }

  /**
   * This means all Array_size = 50,000 entries going to one single bucket in HashSet
   * @param blackhole
   /
  @Benchmark
  public void testNonUniformSet(Blackhole blackhole) {
    for (int i = 0; i < ARRAY_SIZE; i++) {
      blackhole.consume(nonUniformSet.contains(new NonUniformDTO(i)));
    }
  }

  /**
   * This means all 50,000 entries going to 10,000 buckets. Hence one bucket will have 5 entries on average.
   * @param blackhole
   /
  @Benchmark
  public void testUniformSet(Blackhole blackhole) {
    for (int i = 0; i < ARRAY_SIZE; i++) {
      blackhole.consume(uniformSet.contains(new NonUniformDTO(i)));
    }
  }
  */
}

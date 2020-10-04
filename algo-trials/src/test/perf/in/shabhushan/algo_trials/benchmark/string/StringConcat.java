package in.shabhushan.algo_trials.benchmark.string;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/*
Benchmarking Results
Benchmark                        Mode  Cnt       Score      Error  Units
StringConcat.testStreamJoining  thrpt   10  245919.335 ? 3602.366  ops/s
StringConcat.testStringBuffer   thrpt   10  238881.209 ? 2147.942  ops/s
StringConcat.testStringBuilder  thrpt   10  250418.757 ? 1649.315  ops/s
StringConcat.testStringConcat   thrpt   10   21779.152 ?  251.060  ops/s
StringConcat.testStringFormat   thrpt   10    4402.856 ?   50.785  ops/s
StringConcat.testStringJoin     thrpt   10  217820.276 ?  636.872  ops/s
StringConcat.testStringPlus     thrpt   10   22226.296 ?  226.593  ops/s
 */
@Warmup(iterations = 3, time = 2, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 2, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@State(Scope.Thread)
public class StringConcat {
  /*
  private static final int STRING_LIST_LENGTH = 100;
  private static final List<String> stringList = new ArrayList<>();

  @Setup
  public void setup() {
    for (int index = 0; index < STRING_LIST_LENGTH; index++) {
      stringList.add(UUID.randomUUID().toString());
    }
  }

  @Benchmark
  public void testStringFormat(Blackhole blackhole) {
    String result = "";
    for (String string : stringList) {
      result = String.format("%s%s", result, string);
    }
    blackhole.consume(result);
  }

  @Benchmark
  public void testStringPlus(Blackhole blackhole) {
    String result = "";

    for (String string : stringList) {
      result += string;
    }
    blackhole.consume(result);
  }

  @Benchmark
  public void testStringBuilder(Blackhole bh) {
    StringBuilder sb = new StringBuilder();
    for (String s : stringList) {
      sb.append(s);
    }
    bh.consume(sb.toString());
  }

  @Benchmark
  public void testStringBuffer(Blackhole bh) {
    StringBuffer sb = new StringBuffer();
    for (String s : stringList) {
      sb.append(s);
    }
    bh.consume(sb.toString());
  }

  @Benchmark
  public void testStringJoin(Blackhole bh) {
    bh.consume(String.join("", stringList));
  }

  @Benchmark
  public void testStringConcat(Blackhole bh) {
    String combined = "";
    for (String s : stringList) {
      combined = combined.concat(s);
    }
    bh.consume(combined);
  }

  @Benchmark
  public void testStreamJoining(Blackhole bh) {
    String combined = stringList
      .stream()
      .collect(Collectors.joining());
    bh.consume(combined);
  }
  */
}

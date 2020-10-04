package in.shabhushan.algo_trials.benchmark;

import org.openjdk.jmh.profile.GCProfiler;
import org.openjdk.jmh.profile.StackProfiler;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * Refer to https://hg.openjdk.java.net/code-tools/jmh/file/tip/jmh-samples/src/main/java/org/openjdk/jmh/samples/
 */
public class Main {
  public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder()
      //.include(JMHSample_35_Profilers.Maps.class.getSimpleName())
      //.addProfiler(StackProfiler.class)
      .addProfiler(GCProfiler.class)
      .build();

    new Runner(opt).run();
  }
}

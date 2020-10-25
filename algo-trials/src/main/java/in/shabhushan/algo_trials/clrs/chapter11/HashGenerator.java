package in.shabhushan.algo_trials.clrs.chapter11;

import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HashGenerator {
  private static final Random random = new Random(System.currentTimeMillis());

  public static Set<NonUniformDTO> generateNonUniformNumbers(int size) {
    return IntStream.range(0, size).mapToObj(index -> new NonUniformDTO(index * 10000)).collect(Collectors.toSet());
  }

  public static Set<UniformDTO> generateUniformNumbers(int size) {
    return IntStream.range(0, size).mapToObj(index -> new UniformDTO(random.nextInt(size))).collect(Collectors.toSet());
  }
}

package in.shabhushan.algo_trials.clrs.chapter12;

@FunctionalInterface
public interface ExpressionNodeSupplier<T> {
  /**
   * Gets a result.
   *
   * @return a result
   */
  T get();
}


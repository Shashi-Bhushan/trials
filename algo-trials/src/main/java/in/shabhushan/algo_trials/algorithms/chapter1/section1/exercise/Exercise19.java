package in.shabhushan.algo_trials.algorithms.chapter1.section1.exercise;

import in.shabhushan.algo_trials.algorithms.utils.DoublingRatio;

public class Exercise19 extends DoublingRatio<Integer> {

  public Exercise19(int numTrials, Integer initialValue) {
    super(numTrials, initialValue);
  }

  @Override
  protected int performTrial(Integer input) {
    return fibonacci(input);
  }

  @Override
  protected void incrementNextValue() {
    super.initialValue++;
  }

  public int fibonacci(int n) {
    if (n == 0)
      return 0;
    else if (n == 1)
      return 1;
    else
      return fibonacci(n - 2) + fibonacci(n - 1);
  }
}

package in.shabhushan.algo_trials.algorithms.utils;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public abstract class DoublingRatio <TYPE> {

  protected int numTrials;
  protected double[] results;
  protected TYPE initialValue;

  public DoublingRatio(int numTrials, TYPE initialValue) {
    this.numTrials = numTrials;
    this.initialValue = initialValue;

    results = new double[numTrials];
  }

  protected abstract int performTrial(TYPE input);

  protected abstract void incrementNextValue();

  public final void runTrials() {
    StdOut.println("====> Doubling Ratio Trial Results");

    for (int i = 0; i < this.numTrials; i++) {
      Stopwatch stopwatch = new Stopwatch();
      performTrial(this.initialValue);

      results[i] = stopwatch.elapsedTime();

      if (i == 0) {
        System.out.println(String.format("%d ==> N = %d, Time taken %3.5f, Log(Time Taken) %3.5f", i, this.initialValue, results[i], Math.log(results[i])));
      } else {
        System.out.println(String.format("%d ==> N = %d, Time taken %3.5f, Log(Time Taken) %3.5f, Ratio(Time Taken) %3.5f, Ratio(Log(TimeTaken)) %3.5f",
            i, this.initialValue, results[i], Math.log(results[i]), results[i] / results[i - 1], Math.log(results[i]) / Math.log(results[i - 1])));
      }

      incrementNextValue();
    }
  }
}

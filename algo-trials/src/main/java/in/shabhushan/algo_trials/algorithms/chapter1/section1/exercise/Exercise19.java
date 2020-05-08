package in.shabhushan.algo_trials.algorithms.chapter1.section1.exercise;

import in.shabhushan.algo_trials.algorithms.utils.DoublingRatio;

/**
 * ====> Doubling Ratio Trial Results
 * 0 ==> N = 40, Time taken 0.52900, Log(Time Taken) -0.63677
 * 1 ==> N = 41, Time taken 0.85000, Log(Time Taken) -0.16252, Ratio(Time Taken) 1.60681, Ratio(Log(TimeTaken)) 0.25523
 * 2 ==> N = 42, Time taken 1.38400, Log(Time Taken) 0.32498, Ratio(Time Taken) 1.62824, Ratio(Log(TimeTaken)) -1.99963
 * 3 ==> N = 43, Time taken 2.21000, Log(Time Taken) 0.79299, Ratio(Time Taken) 1.59682, Ratio(Log(TimeTaken)) 2.44014
 * 4 ==> N = 44, Time taken 3.57500, Log(Time Taken) 1.27397, Ratio(Time Taken) 1.61765, Ratio(Log(TimeTaken)) 1.60653
 * 5 ==> N = 45, Time taken 5.80200, Log(Time Taken) 1.75820, Ratio(Time Taken) 1.62294, Ratio(Log(TimeTaken)) 1.38010
 * 6 ==> N = 46, Time taken 9.55600, Log(Time Taken) 2.25717, Ratio(Time Taken) 1.64702, Ratio(Log(TimeTaken)) 1.28379
 * 7 ==> N = 47, Time taken 15.49500, Log(Time Taken) 2.74052, Ratio(Time Taken) 1.62149, Ratio(Log(TimeTaken)) 1.21414
 * 8 ==> N = 48, Time taken 25.18300, Log(Time Taken) 3.22617, Ratio(Time Taken) 1.62523, Ratio(Log(TimeTaken)) 1.17721
 * 9 ==> N = 49, Time taken 40.34700, Log(Time Taken) 3.69752, Ratio(Time Taken) 1.60215, Ratio(Log(TimeTaken)) 1.14610
 */
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

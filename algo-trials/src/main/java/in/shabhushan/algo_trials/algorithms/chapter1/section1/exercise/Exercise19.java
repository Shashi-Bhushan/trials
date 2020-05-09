package in.shabhushan.algo_trials.algorithms.chapter1.section1.exercise;

import in.shabhushan.algo_trials.algorithms.utils.DoublingRatio;

/**
 * ====> Doubling Ratio Trial Results
 * 0 ==> N = 40, Time taken 0.43400, Log(Time Taken) -0.83471
 * 1 ==> N = 41, Time taken 0.69900, Log(Time Taken) -0.35810, Ratio(Time Taken) 1.61060, Ratio(Log(TimeTaken)) 0.42902
 * 2 ==> N = 42, Time taken 1.13300, Log(Time Taken) 0.12487, Ratio(Time Taken) 1.62089, Ratio(Log(TimeTaken)) -0.34869
 * 3 ==> N = 43, Time taken 1.83600, Log(Time Taken) 0.60759, Ratio(Time Taken) 1.62048, Ratio(Log(TimeTaken)) 4.86581
 * 4 ==> N = 44, Time taken 2.96300, Log(Time Taken) 1.08620, Ratio(Time Taken) 1.61383, Ratio(Log(TimeTaken)) 1.78772
 * 5 ==> N = 45, Time taken 4.83400, Log(Time Taken) 1.57567, Ratio(Time Taken) 1.63145, Ratio(Log(TimeTaken)) 1.45063
 * 6 ==> N = 46, Time taken 7.77800, Log(Time Taken) 2.05130, Ratio(Time Taken) 1.60902, Ratio(Log(TimeTaken)) 1.30185
 * 7 ==> N = 47, Time taken 12.50300, Log(Time Taken) 2.52597, Ratio(Time Taken) 1.60748, Ratio(Log(TimeTaken)) 1.23140
 * 8 ==> N = 48, Time taken 20.28200, Log(Time Taken) 3.00973, Ratio(Time Taken) 1.62217, Ratio(Log(TimeTaken)) 1.19152
 * 9 ==> N = 49, Time taken 33.06500, Log(Time Taken) 3.49848, Ratio(Time Taken) 1.63026, Ratio(Log(TimeTaken)) 1.16239
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

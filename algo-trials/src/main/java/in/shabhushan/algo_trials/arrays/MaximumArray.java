package in.shabhushan.algo_trials.arrays;

public class MaximumArray {
  public static int maximumArray(int[] arr) {
    return helper(arr, arr.length - 1).max;
  }

  private static Result helper(int[] arr, int currentIndex) {
    if (currentIndex == 0) {
      return new Result(arr[currentIndex], arr[currentIndex] * arr[currentIndex], Integer.MIN_VALUE, arr[currentIndex] * arr[currentIndex]);
    }

    Result previousResult = helper(arr, currentIndex - 1);

    Result current = new Result();

    // previous or 0, whichever is positive
    current.sumWithoutOperation = max(previousResult.sumWithoutOperation, 0) + arr[currentIndex];
    // still no operation, since i apply the operation here
    current.sumWithOperation = max(previousResult.sumWithoutOperation, 0) + arr[currentIndex] * arr[currentIndex];
    // this one is from kadane's algorithm, take only current element as soon as max(...) reaches 0
    current.sumSoFar = max(previousResult.sumWithoutOperation, previousResult.sumWithOperation, previousResult.sumSoFar, 0)
        + arr[currentIndex];

    // max of everything
    current.max = max(previousResult.max, current.sumWithoutOperation, current.sumWithOperation, current.sumSoFar);

    return current;
  }

  private static class Result {
    public int sumWithoutOperation;
    public int sumWithOperation;
    public int sumSoFar;
    public int max;

    public Result() {}

    public Result(int sumWithoutOperation, int sumWithOperation, int sumSoFar, int max) {
      this.sumWithoutOperation = sumWithoutOperation;
      this.sumWithOperation = sumWithOperation;
      this.sumSoFar = sumSoFar;
      this.max = max;
    }
  }

  private static int max(int... numbers) {
    int max = 0;

    for (int number : numbers) {
      max = Math.max(max, number);
    }

    return max;
  }
}

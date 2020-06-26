package in.shabhushan.cp_trials.array;

class UglyNumbersII {

  private static int[] nums = calc();

  private static int[] calc() {
    int len = 500;
    int[] n = new int[len];

    n[0] = 1;
    n[1] = 2;
    n[2] = 3;
    n[3] = 4;
    n[4] = 5;

    int i = 6;
    int idx = 5;
    while (true) {
      if (isUgly(i)) {
        n[idx++] = i;
      }

      i++;

      if (idx == len)
        break;
    }

    return n;
  }

  private static boolean isUgly(int n) {
    int i = 2;

    while (n != 1) {
      if (n % i == 0) {
        while(n % i == 0) {
          n = n / i;
        }

      }

      i++;

      if (i > 5) return false;
    }

    return true;
  }

  public static int nthUglyNumber(int n) {
    System.out.println(nums[nums.length - 1]);
    return nums[n - 1];
  }

  public int nthUglyNumber2(int n) {
    int[] dp = new int[n];

    dp[0] = 1;

    int multipleTwo = 0;
    int multipleThree = 0;
    int multipleFive = 0;

    for (int i = 1; i < n; i++) {
      dp[i] = Math.min(
          Math.min(dp[multipleTwo] * 2, dp[multipleThree] * 3),
          dp[multipleFive] * 5
      );

      if (dp[i] == dp[multipleTwo] * 2) { multipleTwo++; }
      if (dp[i] == dp[multipleThree] * 3) { multipleThree++; }
      if (dp[i] == dp[multipleFive] * 5) { multipleFive++; }
    }

    return dp[n - 1];
  }
}

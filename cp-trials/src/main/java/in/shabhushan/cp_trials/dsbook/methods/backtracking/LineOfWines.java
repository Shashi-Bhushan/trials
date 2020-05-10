package in.shabhushan.cp_trials.dsbook.methods.backtracking;

import java.util.Arrays;

public class LineOfWines {
  public static int lineOfWines(int[] wines) {
    return getMax(wines, 0, 0);
  }

  private static int getMax(int[] wines, int price, int year) {
    System.out.printf("Year %d Wines %d\n", year, wines.length);
    if (wines.length == 0)
      return price * year;
    else {
      int rightPrice = wines[0];
      int[] right = Arrays.copyOfRange(wines, 1, wines.length);

      int leftPrice = wines[wines.length - 1];
      int[] left = Arrays.copyOfRange(wines, 0, wines.length - 1);

      return (price * year) + Math.max(getMax(right, rightPrice, year + 1), getMax(left, leftPrice, year + 1));
    }
  }

  private static int lineOfWinesDp(int[] wines, int begin, int end, int n) {
    int[][] dp = new int[1000][1000];

    int year = n - (end - begin);



    return 0;
  }
}

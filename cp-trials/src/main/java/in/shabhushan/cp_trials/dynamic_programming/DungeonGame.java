package in.shabhushan.cp_trials.dynamic_programming;

/**
 * Leetcode solution for
 * https://leetcode.com/problems/dungeon-game/
 */
class DungeonGame {
  public int calculateMinimumHP(int[][] dungeon) {
    int m = dungeon.length;
    int n = dungeon[0].length;

    int[][] dp = new int[m][n];

    dp[m - 1][n - 1] = -Math.min(0, dungeon[m - 1][n - 1]) + 1;

    for (int i = m - 2; i >= 0; i--) {
      dp[i][n - 1] = Math.max(dp[i + 1][n - 1] - dungeon[i][n - 1], 1);
    }

    for (int j = n - 2; j >= 0; j--) {
      dp[m - 1][j] = Math.max(dp[m - 1][j + 1] - dungeon[m - 1][j], 1);
    }

    for (int i = m - 2; i >= 0; i--) {
      for (int j = n - 2; j >= 0; j--) {
        dp[i][j] = Math.max(
          Math.min(dp[i][j +1] - dungeon[i][j], dp[i + 1][j] - dungeon[i][j])
          , 1);
      }
    }

    return dp[0][0];
  }
}

package in.shabhushan.cp_trials.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChange {
  public static int coinChangeRecursiveWithMemoization(int[] coins, int x) {
    int[] memory = new int[x + 1];
    Arrays.fill(memory, -1);
    memory[0] = 0;

    return solve(coins, x, memory);
  }

  private static int solve(int[] coins, int x, int[] memory) {
    //System.out.println("Solve called for " + x);
    if (x < 0) {
      return 100_00_00; // prevents overflow
    } else if (x == 0) {
      return 0;
    } else if (memory[x] != -1) {
      return memory[x];
    }

    int best = Integer.MAX_VALUE;
    for (int coin: coins) {
      best = Math.min(best, solve(coins, x - coin, memory) + 1);
    }

    memory[x] = best;
    //System.out.println("Solving for x " + x + " best " + best);
    return best;
  }

  public static int coinChangeIterative(int[] coins, int x) {
    int[] memory = new int[x + 1];
    memory[0] = 0;

    for (int i = 1; i <= x; i++) {
      memory[i] = 100_00_00;

      // for each coin, check the min value required
      for (int coin: coins) {
        if (i - coin >= 0) {
          memory[i] = Math.min(memory[i], memory[i - coin] + 1);
        }
      }
    }

    return memory[x];
  }

  public static CoinChangeSolution coinChangeIterativeWithCounting(int[] coins, int target) {
    int[] memory = new int[target + 1];
    memory[0] = 0;

    int[] sequence = new int[target + 1];

    for (int i = 1; i <= target; i++) {
      memory[i] = 100_00_00;

      // for each coin, check the min value required
      for (int coin: coins) {
        if (i - coin >= 0 && memory[i - coin] + 1 < memory[i]) {
          memory[i] = memory[i - coin] + 1;
          sequence[i] = coin;
        }
      }
    }

    CoinChangeSolution solution = new CoinChangeSolution();
    solution.solution = memory[target];
    solution.sequence = sequence;
    return solution;
  }

  public static class CoinChangeSolution {
    public int solution;
    public int[] sequence;
  }

  /**
   * Total number of ways to form the target
   */
  public static int totalWaysCoinChange(int[] coins, int target) {
    int[] memory = new int[target + 1];
    memory[0] = 1;

    for (int i = 1; i <= target; i++) {
      for (int coin: coins) {
        if (i - coin >= 0) {
          memory[i] += memory[i - coin];
        }
      }
    }

    return memory[target];
  }
}

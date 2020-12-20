package in.shabhushan.algo_trials.dynamic_programming;

import java.util.*;

/**
 * Whis and Beerus are playing a new game today.
 * They form a tower of N coins and make a move in alternate turns. Beerus plays first.
 * In one step, the player can remove either 1, X, or Y coins from the tower.
 * <p>
 * The person to make the last move wins the game. Can you find out who wins the game?
 */
public class CoinTower {

  private static int[] candidates;
  // Map<Pair<Number of stones left, Player playing>, Winner in scenario>
  private static Map<Map.Entry<Integer, String>, String> map;

  public static String findWinnerDP(int n, int x, int y) {
    //Your code goes here

    candidates = new int[]{1, x, y};

    //map = new HashMap<>();

    //return helper(n, "Beerus");

    // if dp[i] is true, Beerus is going to win the game
    boolean[] dp = new boolean[n + 1];

    dp[0] = false;
    dp[1] = true;

    for (int i = 2; i <= n; i++) {
      for (int candidate : candidates) {
        if (i - candidate >= 0) {
          if (dp[i - candidate] == false) {
            dp[i] = true;
          }
        }
      }
    }

    return dp[n] ? "Beerus" : "Whis";
  }

  public static String findWinner(int n, int x, int y) {
    //Your code goes here

    candidates = new int[]{1, x, y};

    map = new HashMap<>();

    return helper(n, "Beerus");
  }

  private static String helper(int n, String player) {
    Map.Entry<Integer, String> entry = new AbstractMap.SimpleEntry<>(n, player);
    if (map.containsKey(entry)) return map.get(entry);

    String opponent = getOpponent(player);

    if (n == 0) return opponent;

    for (int x : candidates) {
      if (n - x >= 0 && helper(n - x, opponent).equals(player)) {
        map.put(entry, player);
        return player;
      }
    }

    map.put(entry, opponent);
    return opponent;
  }

  private static String getOpponent(String player) {
    return player.equals("Beerus") ? "Whis" : "Beerus";
  }

}

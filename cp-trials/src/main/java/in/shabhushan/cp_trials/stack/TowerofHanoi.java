package in.shabhushan.cp_trials.stack;

/**
 * check the problem here
 * https://www.hackerearth.com/blog/developers/tower-hanoi-recursion-game-algorithm-explained/#:~:text=Tower%20of%20Hanoi%20algorithm%20explained,these%20disks%20to%20peg%20B.&text=Now%20to%20solve%20the%20problem,peg%20A%20to%20peg%20B.
 */
public class TowerofHanoi {
  public static void towerOfHanoi(int pegs, String begin, String auxiliary, String end) {
    if (pegs == 1) {
      System.out.print(String.format(" %s -> %s ", begin, end));
    } else {
      towerOfHanoi(pegs - 1, begin, end, auxiliary);
      towerOfHanoi(1, begin, auxiliary, end);
      towerOfHanoi(pegs - 1, auxiliary, begin, end);
    }
  }
}

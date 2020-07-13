package in.shabhushan.cp_trials.stack;

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

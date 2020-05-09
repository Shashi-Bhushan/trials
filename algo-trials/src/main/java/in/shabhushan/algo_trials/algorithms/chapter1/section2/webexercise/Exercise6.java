package in.shabhushan.algo_trials.algorithms.chapter1.section2.webexercise;

public class Exercise6 {
  /**
   * A string s is a circular rotation of a string t if it matches when the characters are circularly shifted
   * by any number of positions; e.g., ACTGACG is a circular shift of TGACGAC, and vice versa.
   * Detecting this condition is important in the study of genomic sequences.
   *
   * Write a program that checks whether two given strings s and t are circular shifts of one another.
   */
  public static boolean isCircularShifted(String s, String t) {
    return s.length() == t.length() && (s.concat(s).contains(t));
  }
}

package in.shabhushan.algo_trials.algorithms.chapter1.section3.exercise;

import org.junit.Test;

import java.util.List;

import static in.shabhushan.algo_trials.algorithms.chapter1.section3.exercise.Exercise37.josepheusProblem;
import static org.junit.Assert.assertEquals;

public class Exercise37Test {
  @Test
  public void testJosepheusProblem() {
    assertEquals(List.of(1, 3, 5, 0, 4, 2, 6), josepheusProblem(2, 7));
    assertEquals(List.of(2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35, 38, 41, 44, 47, 50, 53, 56, 59, 62, 65, 68, 71, 74, 77, 80, 83, 86, 89, 92, 95, 98, 101, 104, 107, 110, 113, 116, 119, 122, 125, 128, 131, 134, 137, 140, 143, 146, 149, 152, 155, 158, 161, 164, 167, 170, 173, 176, 3, 7, 12, 16, 21, 25, 30, 34, 39, 43, 48, 52, 57, 61, 66, 70, 75, 79, 84, 88, 93, 97, 102, 106, 111, 115, 120, 124, 129, 133, 138, 142, 147, 151, 156, 160, 165, 169, 174, 1, 9, 15, 22, 28, 36, 42, 49, 55, 63, 69, 76, 82, 90, 96, 103, 109, 117, 123, 130, 136, 144, 150, 157, 163, 171, 0, 10, 19, 31, 40, 51, 60, 72, 81, 91, 100, 112, 121, 132, 141, 153, 162, 172, 6, 24, 37, 54, 67, 85, 99, 114, 127, 145, 159, 175, 18, 45, 64, 87, 108, 135, 154, 4, 33, 73, 105, 139, 168, 46, 94, 148, 27, 118, 13, 126, 78, 166, 58),
        josepheusProblem(3, 177));
  }
}

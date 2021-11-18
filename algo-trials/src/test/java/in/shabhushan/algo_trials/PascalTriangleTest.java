package in.shabhushan.algo_trials;

import org.junit.Test;

import java.util.List;

import static in.shabhushan.algo_trials.PascalTriangle.getPascalTriangle;
import static org.junit.Assert.assertEquals;

public class PascalTriangleTest {
  @Test
  public void getPascalTriangleTest() {
    assertEquals(List.of(
        List.of(1),
        List.of(1, 1),
        List.of(1, 2, 1),
        List.of(1, 3, 3, 1)
    ), getPascalTriangle(4));

    assertEquals(List.of(
        List.of(1),
        List.of(1, 1),
        List.of(1, 2, 1),
        List.of(1, 3, 3, 1),
        List.of(1, 4, 6, 4, 1)
    ), getPascalTriangle(5));

    getPascalTriangle(6);

    assertEquals(List.of(
        List.of(1),
        List.of(1, 1),
        List.of(1, 2, 1),
        List.of(1, 3, 3, 1),
        List.of(1, 4, 6, 4, 1),
        List.of(1, 5, 10, 10, 5, 1),
        List.of(1, 6, 15, 20, 15, 6, 1)
    ), getPascalTriangle(7));
  }
}

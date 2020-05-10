package in.shabhushan.cp_trials.string.logic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShortestKnightPathTest {
  @Test
  public void sampleTests() {
    assertEquals("Test for (b6, c5)", 2, ShortestKnightPath.knight("b6", "c5"));
    assertEquals("Test for (a1, c1)", 2, ShortestKnightPath.knight("a1", "c1"));
    assertEquals("Test for (a1, f1)", 3, ShortestKnightPath.knight("a1", "f1"));
    assertEquals("Test for (a1, f3)", 3, ShortestKnightPath.knight("a1", "f3"));
    assertEquals("Test for (a1, f4)", 4, ShortestKnightPath.knight("a1", "f4"));
    assertEquals("Test for (a1, f7)", 5, ShortestKnightPath.knight("a1", "f7"));
  }
}

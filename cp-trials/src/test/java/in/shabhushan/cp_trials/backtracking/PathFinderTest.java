package in.shabhushan.cp_trials.backtracking;

import in.shabhushan.cp_trials.backtracking.PathFinder;
import org.junit.Test;

import static in.shabhushan.cp_trials.backtracking.PathFinder.pathFinderThree;
import static in.shabhushan.cp_trials.backtracking.PathFinder.pathFinderTwo;
import static org.junit.Assert.assertEquals;

// TODO: Replace examples and use TDD development by writing your own tests

public class PathFinderTest {

  @Test
  public void testPathFinderOne() {

    String a = ".W.\n" +
        ".W.\n" +
        "...",

        b = ".W.\n" +
            ".W.\n" +
            "W..",

        c = "......\n" +
            "......\n" +
            "......\n" +
            "......\n" +
            "......\n" +
            "......",

        d = "......\n" +
            "......\n" +
            "......\n" +
            "......\n" +
            ".....W\n" +
            "....W.";

    assertEquals(true, PathFinder.pathFinderOne(a));
    assertEquals(false, PathFinder.pathFinderOne(b));
    assertEquals(true, PathFinder.pathFinderOne(c));
    assertEquals(false, PathFinder.pathFinderOne(d));
  }

  @Test
  public void testPathFinderTwo() {

    String a = ".W.\n" +
        ".W.\n" +
        "...",

        b = ".W.\n" +
            ".W.\n" +
            "W..",

        c = "......\n" +
            "......\n" +
            "......\n" +
            "......\n" +
            "......\n" +
            "......",

        d = "......\n" +
            "......\n" +
            "......\n" +
            "......\n" +
            ".....W\n" +
            "....W.";

    assertEquals(a, 4, pathFinderTwo(a));
    assertEquals(b, -1, pathFinderTwo(b));
    assertEquals(c, 10, pathFinderTwo(c));
    assertEquals(d, -1, pathFinderTwo(d));
  }

  @Test
  public void testPathFinderThree() {

    String a =
        "000\n"+
        "000\n"+
        "000",

        b = "010\n"+
            "010\n"+
            "010",

        c = "010\n"+
            "101\n"+
            "010",

        d = "0707\n"+
            "7070\n"+
            "0707\n"+
            "7070",

        e = "700000\n"+
            "077770\n"+
            "077770\n"+
            "077770\n"+
            "077770\n"+
            "000007",

        f = "777000\n"+
            "007000\n"+
            "007000\n"+
            "007000\n"+
            "007000\n"+
            "007777",

        g = "000000\n"+
            "000000\n"+
            "000000\n"+
            "000010\n"+
            "000109\n"+
            "001010";

    assertEquals(0,  pathFinderThree(a));
    assertEquals(2,  pathFinderThree(b));
    assertEquals(4,  pathFinderThree(c));
    assertEquals(42, pathFinderThree(d));
    assertEquals(14, pathFinderThree(e));
    assertEquals(0,  pathFinderThree(f));
    assertEquals(4,  pathFinderThree(g));
  }
}


package in.shabhushan.cp_trials.prefix_sum;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static in.shabhushan.cp_trials.prefix_sum.MaximumNumberVowels.maxVowels;
import static in.shabhushan.cp_trials.prefix_sum.MaximumNumberVowels.maxVowels2;
import static org.junit.Assert.assertEquals;

public class MaximumNumberVowelsTest {
  String longString = new String(Files.readAllBytes(Paths.get(MaximumNumberVowelsTest.class.getResource("/longString.txt").toURI())));;

  public MaximumNumberVowelsTest() throws IOException, URISyntaxException {
  }

  @Test
  public void test() {
    assertEquals(3, maxVowels("abciiidef", 3));
    assertEquals(2, maxVowels("aeiou", 2));
    assertEquals(2, maxVowels("leetcode", 3));
    assertEquals(0, maxVowels("rhythms", 4));
    assertEquals(1, maxVowels("tryhard", 4));
    assertEquals(84, maxVowels(longString, 316));
  }

  @Test
  public void test2() {
    assertEquals(3, maxVowels2("abciiidef", 3));
    assertEquals(2, maxVowels2("aeiou", 2));
    assertEquals(2, maxVowels2("leetcode", 3));
    assertEquals(0, maxVowels2("rhythms", 4));
    assertEquals(1, maxVowels2("tryhard", 4));
    assertEquals(84, maxVowels2(longString, 316));
  }
}

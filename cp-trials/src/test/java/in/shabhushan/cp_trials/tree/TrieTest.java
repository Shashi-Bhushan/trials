package in.shabhushan.cp_trials.tree;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TrieTest {
  private static Random random = new Random(System.nanoTime());
  private static String[] words;
  private static final int size = 1000;

  @BeforeClass
  public static void setup() {
    words = new String[size];
    int x = size;

    while (x > 0) {
      byte[] array = new byte[random.nextInt(size)];
      random.nextBytes(array);

      words[x - 1] = new String(array);
      x--;
    }
  }

  @Test
  public void testTrie() {
    Trie trie = new Trie();

    trie.insert("apple");
    assertTrue(trie.search("apple"));
    assertFalse(trie.search("app"));
    assertTrue(trie.startsWith("app"));
    trie.insert("app");
    assertTrue(trie.search("app"));
  }

  @Test
  public void performanceTest() {
    Trie trie = new Trie();

    for (String word: words) {
      trie.insert(word);
    }

    long startTime = System.nanoTime();

    for (int i = 0; i < 10; i++) {
      int index = random.nextInt(size);

      assertTrue(trie.search(words[index]));
    }

    System.out.println(String.format("Time taken :: %d", (System.nanoTime() - startTime)));
  }
}

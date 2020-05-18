package in.shabhushan.cp_trials.ds.tree;

import in.shabhushan.cp_trials.ds.tree.Trie;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Time taken For Iterative Search :: 713442
 * Time taken For Recursive Search :: 2194285
 */
public class TrieTest {
  private static Random random = new Random(System.nanoTime());
  private static String[] words;
  private static final int size = 2000;

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
  public void testTrieRecursive() {
    Trie.TrieRecursive trie = new Trie.TrieRecursive();

    trie.insert("apple");
    assertTrue(trie.search("apple"));
    assertFalse(trie.search("app"));
    assertTrue(trie.startsWith("app"));
    trie.insert("app");
    assertTrue(trie.search("app"));
  }

  @Test
  public void testTrieIterative() {
    Trie.TrieIterative trie = new Trie.TrieIterative();

    trie.insert("apple");
    assertTrue(trie.search("apple"));
    assertFalse(trie.search("app"));
    assertTrue(trie.startsWith("app"));
    trie.insert("app");
    assertTrue(trie.search("app"));
  }

  @Test
  public void performanceTestTrieRecursive() {
    Trie.TrieRecursive trie = new Trie.TrieRecursive();

    for (String word: words) {
      trie.insert(word);
    }

    long startTime = System.nanoTime();

    for (int i = 0; i < 10; i++) {
      int index = random.nextInt(size);

      assertTrue(trie.search(words[index]));
    }

    System.out.println(String.format("Time taken For Recursive Search :: %d", (System.nanoTime() - startTime)));
  }

  @Test
  public void performanceTestTrieIterative() {
    Trie.TrieIterative trie = new Trie.TrieIterative();

    for (String word: words) {
      trie.insert(word);
    }

    long startTime = System.nanoTime();

    for (int i = 0; i < 10; i++) {
      int index = random.nextInt(size);

      assertTrue(trie.search(words[index]));
    }

    System.out.println(String.format("Time taken For Iterative Search :: %d", (System.nanoTime() - startTime)));
  }
}

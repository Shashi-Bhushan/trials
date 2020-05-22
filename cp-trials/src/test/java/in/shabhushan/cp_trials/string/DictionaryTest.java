package in.shabhushan.cp_trials.string;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DictionaryTest {
  @Test
  public void testDictionary() {
    Dictionary dictionary = new Dictionary(new String[]{"apple", "banana", "orange"});

    assertTrue(dictionary.atMostOneTypo("banana"));
    assertTrue(dictionary.atMostOneTypo("banena"));
    assertFalse(dictionary.atMostOneTypo("banan"));
    assertFalse(dictionary.atMostOneTypo("banxnn"));
    assertTrue(dictionary.atMostOneTypo("canana"));
  }
}

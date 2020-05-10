package in.shabhushan.cp_trials.string.logic;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class PlayingCardsTest {
  PlayingCards playingCards = new PlayingCards();

  @Test
  public void testEncodeA() {
    String message = "A";
    String[] deck = new String[]{
        "AC", "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C", "TC", "JC", "QC", "KC",
        "AD", "2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D", "TD", "JD", "QD", "KD",
        "AH", "2H", "3H", "4H", "5H", "6H", "7H", "8H", "9H", "TH", "JH", "QH", "KH",
        "AS", "2S", "3S", "4S", "5S", "6S", "7S", "8S", "9S", "TS", "JS", "KS", "QS"
    };

    assertArrayEquals("The message \"A\" corresponds to the second permutation of the deck of cards (its numeric value is equal to 1)",
        deck, playingCards.encode(message));
  }

  @Test
  public void testEncodeSecretMessage() {
    String message = "ATTACK TONIGHT ON CODEWARS";
    String[] deck = new String[]{
        "AC", "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C", "TC", "JC", "QC", "KC",
        "AD", "2D", "3D", "4D", "5D", "6D", "JD", "9D", "7S", "9S", "QD", "5S", "TH",
        "7D", "TS", "QS", "2H", "JS", "6H", "3S", "6S", "TD", "8S", "2S", "8H", "7H",
        "4S", "4H", "3H", "5H", "AS", "KH", "QH", "9H", "KD", "KS", "JH", "8D", "AH"
    };

    assertArrayEquals(deck, playingCards.encode(message));
  }

  @Test
  public void testDecodeA() {
    String[] deck = new String[]{
        "AC", "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C", "TC", "JC", "QC", "KC",
        "AD", "2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D", "TD", "JD", "QD", "KD",
        "AH", "2H", "3H", "4H", "5H", "6H", "7H", "8H", "9H", "TH", "JH", "QH", "KH",
        "AS", "2S", "3S", "4S", "5S", "6S", "7S", "8S", "9S", "TS", "JS", "KS", "QS"
    };
    String message = "A";

    assertEquals("This deck represents the second permutation of its cards (its numeric value is equal to 1), so the returned message should have been \"A\"",
        message, playingCards.decode(deck));
  }

  @Test
  public void testDecodeSecretMessage() {
    String[] deck = new String[]{
        "AC", "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C", "TC", "JC", "QC", "KC",
        "AD", "2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D", "TD", "JD", "QD", "KD",
        "AH", "2H", "3H", "4H", "8H", "9S", "3S", "2S", "8S", "TS", "QS", "9H", "7H",
        "KH", "AS", "JH", "4S", "KS", "JS", "5S", "TH", "7S", "6S", "5H", "QH", "6H"
    };
    String message = "ATTACK APPROVED";

    assertEquals(message, playingCards.decode(deck));
  }
}

package in.shabhushan.cp_trials.string.logic;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PlayingCards {
  private static final String ALPHABETS = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private static final BigInteger BASE = new BigInteger("27");
  private static final String RANKS = "A23456789TJQK";
  private static final String SUITS = "CDHS";
  private static final String[] DECK = IntStream.range(0, 52).mapToObj(i ->
      String.valueOf(RANKS.charAt(i % 13)) + SUITS.charAt(i / 13)
  ).toArray(String[]::new);

  private static final Map<Integer, BigInteger> factMap = new HashMap<>();

  static {
    factMap.put(0, BigInteger.ONE);
    factMap.put(52, new BigInteger("80658175170943878571660636856403766975289505440883277824000000000000"));
  }

  private static BigInteger factorial(int n) {
    if (!factMap.containsKey(n)) {
      factMap.put(n, BigInteger.valueOf(n).multiply(factorial(n - 1)));
    }

    return factMap.get(n);
  }

  /**
   * Takes a String containing a message, and returns an array of Strings representing
   * a deck of playing cards ordered to hide the message, or null if the message is invalid.
   */
  public String[] encode(String message) {
    for (int i = 0; i < message.length(); i++) {
      if (!ALPHABETS.contains(String.valueOf(message.charAt(i))))
        return null;
    }

    BigInteger numericMessage = toNumericMessage(message);

    BigInteger fact = factorial(DECK.length);

    if (numericMessage.compareTo(fact) >= 0)
      return null;

    List<String> answer = new ArrayList<>(Arrays.asList(DECK));

    for (int i = DECK.length - 1; i >=0; i--) {
      fact = fact.divide(BigInteger.valueOf(i + 1L));
      int x = numericMessage.divide(fact).intValue();

      answer.add(answer.remove(x));

      numericMessage = numericMessage.mod(fact);
    }

    return answer.toArray(String[]::new);
  }

  private BigInteger toNumericMessage(String message) {
    char[] chars = message.toCharArray();

    BigInteger result = BigInteger.ZERO;

    for (char c : chars) {
      // result = result * 27 + index;
      result = result.multiply(BASE).add(BigInteger.valueOf(ALPHABETS.indexOf(c)));
    }

    return result;
  }

  /**
   * Takes an array of Strings representing a deck of playing cards, and returns
   * the message that is hidden inside, or null if the deck is invalid.
   */
  public String decode(String[] deck) {
    //PlayingCardsOutput.printDeck(deck, true);
    Set<String> cards = new HashSet<>(Arrays.asList(deck));
    if (cards.size() != DECK.length || !cards.containsAll(Arrays.asList(DECK)))
      return null;

    int[] nums = Arrays.stream(deck).mapToInt(card ->
        RANKS.indexOf(card.charAt(0)) + SUITS.indexOf(card.charAt(1)) * 13
    ).toArray();

    BigInteger num = BigInteger.ZERO;
    BigInteger fac = BigInteger.ONE;

    for (int i = 52 - 1; i >= 0; i--) {
      final int pos = i;
      long lesser = IntStream.range(i, 52).filter(index -> nums[index] < nums[pos]).count();

      num = fac.multiply(BigInteger.valueOf(lesser)).add(num);
      fac = fac.multiply(BigInteger.valueOf(52 - i));

    }


    return Stream.iterate(num, r -> r.compareTo(BigInteger.ZERO) > 0, r -> r.divide(BASE))
        .map(r -> r.mod(BASE).intValue()).map(ALPHABETS::charAt).collect(
        Collector.of(StringBuilder::new, StringBuilder::append, StringBuilder::append, sb -> "" + sb.reverse())
    );
  }
}

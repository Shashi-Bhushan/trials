# Section 1

## The Knuth Fisher-Yates Algorithm

#### Bad Shuffle
A randomized shuffle would seem to look like this. Let's take example of deck of 52 cards.
Intuition behind this code is I choose the first card in a deck, put it at a random place.
Then I choose the second card, put it again at a random place and so on.

```java
class BadShuffle {
  public static char[] badShuffle(char[] array) {
    for (int i = 0; i < array.length; i++) {
      int randomIndex = StdRandom.uniform(array.length);

      swap(array, i, randomIndex);
    }

    return array;
  }
}
```

It might look a good random distribution but it's not.

- Problem 1 (__Over shuffling__)
Since I'm considering all 52 cards in each iteration, I could end up shuffling one element multiple times.

- Problem 2 (__Non uniform Distribution__)
Because of overshuffling, there would be few combinations that would occur more frequently than others.
See the article [here](https://www.i-programmer.info/programming/theory/2744-how-not-to-shuffle-the-kunth-fisher-yates-algorithm.html) for the problem.
For 3 cards ABC, if I do this shuffling, for first element there would be 3 possible outcomes.
For second swap, these 3 would further result into 3 possible outcomes each.
Similar result for 3rd. There would be a total of 27 possible outcomes after the final swap.
But, choosing ABC at random one element at a time would have 6 possible outcomes. So the final answer should be multiple of 6.
Thus, it means there are few elements (27 - 24 = 3 in this case), that are occurring more than others. (27 is not multiple of 3!)

#### Empirical Shuffle

A good shuffle would be, if I choose a random card between [0, 52) and place at position 0.
Then, I choose a random card between [1, 52) and place at position 1. This would give me a uniform distribution since I'm not doing over shuffling here.
After placing a card at certain position, I don't consider that card again for re-shuffling.

#### Another Problem

How to generate a random deck of cards.
2^64 < 52!

Suppose a long l denotes a unique shuffled deck. Even if I consider Knuth shuffle, I would only be able to get 2^64 possible combinations.
52! is more than 2^64, infact it's close to 2^226. So, I won't be able to denote all shuffles using even a long.


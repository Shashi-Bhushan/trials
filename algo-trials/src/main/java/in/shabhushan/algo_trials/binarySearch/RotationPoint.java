package in.shabhushan.algo_trials.binarySearch;

public class RotationPoint {
    /**
     * Complexity
     * Each time we go through the while loop, we cut our range of indices in half, just like binary search. So we have O(\lg{n})O(lgn) loop iterations.
     *
     * In each loop iteration, we do some arithmetic and a string comparison. The arithmetic is constant time, but the string comparison requires looking at characters in both words—every character in the worst case. Here, we'll assume our word lengths are bounded by some constant so we'll say the string comparison takes constant time.
     *
     * The longest word in English is pneumonoultramicroscopicsilicovolcanoconiosis, a medical term. It's 45 letters long.
     *
     * Putting everything together, we do O(\lg{n})O(lgn) iterations, and each iteration is O(1)O(1) time. So our time complexity is O(\lg{n})O(lgn).
     *
     * Some languages—like German, Russian, and Dutch—can have arbitrarily long words, so we might want to factor the length of the words into our runtime. We could say the length of the words is \ellℓ, each string comparison takes O(\ell)O(ℓ) time, and the whole algorithm takes O(\ell*\lg{n})O(ℓ∗lgn) time.
     *
     * We use O(1)O(1) space to store the first word and the floor and ceiling indices.
     */
    public static int findRotationPoint(String[] words) {
        int start = 0;
        int end = words.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (isInAlphabeticOrder(words[start], words[mid]) && !isInAlphabeticOrder(words[mid], words[end])) {
                /*
                 * [start, mid] is in alphabetic order and [mid, end] is not
                 * assign start to mid (if start == mid, to avoid falling in infinite loop, set to mid + 1)
                 */
                start = (start != mid) ? mid : mid + 1;
            } else if (isInAlphabeticOrder(words[mid], words[end]) && !isInAlphabeticOrder(words[start], words[mid])) {
                /*
                 * [mid, end] is in alphabetic order and [start, mid] is not
                 * Note that, end == mid will never come since mid will always go to start index (because of `start + (end - start) / 2` calculation.
                 */
                end = mid;
            } else {
                /*
                 * [start, mid] and [mid, end] is in alphabetic order
                 * List is sorted, hence the rotation point is start of list. even `return start;` will be valid at this point.
                 */
                break;
            }
        }

        return start;
    }

    private static boolean isInAlphabeticOrder(String word, String nextWord) {
        return word.compareTo(nextWord) <= 0;
    }
}

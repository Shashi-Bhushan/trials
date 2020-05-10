package in.shabhushan.cp_trials.string;

import java.util.*;

public class FirstNonRepeatingCharacter {
    /**
     * Bit slow
     */
    public static int getFirstNonRepeatingCharacter(String string) {
        char[] chars = string.toCharArray();

        Set<Character> set = new HashSet<>();
        Map<Character, Integer> list = new LinkedHashMap<>();

        for (int index = 0; index < chars.length; index++) {
            if (set.contains(chars[index])) {
                list.remove(chars[index]);
            } else {
                set.add(chars[index]);
                list.put(chars[index], index);
            }
        }

        if (list.isEmpty())
            return -1;
        else
            return list.entrySet().iterator().next().getValue();
    }

    /**
     * Very Fast
     */
    public static int getFirstNonRepeatingCharacterWithArray(String string) {
        int[] frequency = new int[26];

        char[] chars = string.toCharArray();
        for (char c: chars) {
            frequency[c - 'a']++;
        }

        for (int index = 0; index < chars.length; index++) {
            if (frequency[chars[index] - 'a'] == 1) {
                return index;
            }
        }

        return -1;
    }

    public static int getFirstNonRepeatingCharacterWithIndexOf(String string) {
        char[] chars = string.toCharArray();

        for (int index = 0; index < chars.length; index++) {
            if (string.indexOf(chars[index]) == string.lastIndexOf(chars[index])) {
                return index;
            }
        }

        return -1;
    }
}

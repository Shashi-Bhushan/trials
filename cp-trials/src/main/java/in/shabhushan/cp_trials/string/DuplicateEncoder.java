package in.shabhushan.cp_trials.string;

import java.util.HashMap;
import java.util.Map;

public class DuplicateEncoder {
    public static String encode2(String word){
        word = word.toLowerCase();
        Map<Character, Integer> map = new HashMap<>();

        for (int index = 0; index < word.length(); index++) {
            Character character = word.charAt(index);

            new StringBuilder().replace(1, 2, ")");
            map.put(character, map.getOrDefault(character, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < word.length(); index++) {
            Character character = word.charAt(index);

            sb.append(map.get(character) == 1 ? "(" : ")");
        }

        return sb.toString();
    }

    public static String encode(String word) {
        word = word.toLowerCase();

        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int index = 0; index < word.length(); index++) {
            Character character = word.charAt(index);
            Integer charIndex = map.get(character);

            if (charIndex == null) {
                // Character not in map
                sb.append("(");
                map.put(character, index);
            } else if (charIndex >= 0) {
                // Character already found previously at charIndex location
                sb.replace(charIndex, charIndex + 1, ")");
                // for current position
                sb.append(")");

                // replace index with -1 for subsequent calls
                map.put(character, -1);
            } else {
                sb.append(")");
            }
        }

        return sb.toString();
    }
}

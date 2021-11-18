package in.shabhushan.algo_trials.dynamic_programming;// you can also use imports, for example:
import java.util.*;

/**
 * Make all integers equal with minimum changes
 *
 * In one go, you can increase or decrease a number by 1
 *
 * 1 2 4 4 1 1 1 1 3
 */
// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public String solution(int A, int B, int C) {
        // write your code in Java SE 8
        // Choice : choose A or B or C or any combination of 3 letters

        Map<Character, Integer> map = new HashMap<>();
        map.put('a', A);
        map.put('b', B);
        map.put('c', C);

        return helper(map, 'X', new StringBuilder());
    }

    private boolean isAllZeros(Map<Character, Integer> map) {
        return map.entrySet().stream().allMatch(val -> val.getValue() == 0);
    }

    private String getPerm(Map<Character, Integer> map, List<Character> startingList, List<Character> secondList, StringBuilder sb) {
        int maxLen = 0;
        String ans = "";

        for (char one: startingList) {
            for (char two: secondList) {
                if (map.get(one) != 0) {
                    sb.append(one);
                    map.put(one, map.get(one) - 1);

                    if (map.get(two) != 0) {
                        sb.append(two);
                        map.put(two, map.get(two) - 1);

                        String returnValue = helper(map, two, sb);

                        if (maxLen < returnValue.length()) {
                            maxLen = returnValue.length();
                            ans = returnValue;
                        }

                        sb.deleteCharAt(sb.length() - 1);
                        map.put(two, map.get(two) + 1);
                    } /*else {
                        String returnValue = helper(map, one, sb);

                        if (maxLen < returnValue.length()) {
                            maxLen = returnValue.length();
                            ans = returnValue;
                        }
                    }*/

                    sb.deleteCharAt(sb.length() - 1);
                    map.put(one, map.get(one) + 1);
                }
            }
        }

        return ans;
    }

    private String helper(Map<Character, Integer> map, char last, StringBuilder sb) {
        System.out.println(map + " " + sb.toString());

        if (isAllZeros(map)) {
            return sb.toString();
        } else {
            // if any two zeros
            if (map.get('a') == 0 && map.get('b') == 0 && last != 'c') {
                for (int i = 0; i < 2 && map.get('c') > 0; i++) {
                    sb.append('c');
                    map.put('c', map.get('c') - 1);
                }

                return sb.toString();
            }

            if (map.get('b') == 0 && map.get('c') == 0 && last != 'a') {
                for (int i = 0; i < 2 && map.get('a') > 0; i++) {
                    sb.append('a');
                    map.put('a', map.get('a') - 1);
                }

                return sb.toString();
            }

            if (map.get('a') == 0 && map.get('c') == 0 && last != 'b') {
                for (int i = 0; i < 2 && map.get('b') > 0; i++) {
                    sb.append('b');
                    map.put('b', map.get('b') - 1);
                }

                return sb.toString();
            }
        }


        String ans = sb.toString();
        int maxLen = ans.length();

        if (map.get('a') != 0) {
            sb.append('a');
            map.put('a', map.get('a') - 1);

            if (last != 'a') {
                // generate 2 char perm starting with A, B and C
                String returnValue = getPerm(map, List.of('a', 'b', 'c'), List.of('b', 'c'), sb);

                if (maxLen < returnValue.length()) {
                    maxLen = returnValue.length();
                    ans = returnValue;
                }
            } else {
                // generate 2 char perm starting with B and C
                String returnValue = getPerm(map, List.of('b', 'c'), List.of('a', 'b', 'c'), sb);

                if (maxLen < returnValue.length()) {
                    maxLen = returnValue.length();
                    ans = returnValue;
                }
            }

            map.put('a', map.get('a') + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (map.get('b') != 0) {
            sb.append('b');
            map.put('b', map.get('b') - 1);

            if (last != 'b') {
                // generate 2 char perm starting with A, B and C
                String returnValue = getPerm(map, List.of('a', 'b', 'c'), List.of('a', 'c'), sb);

                if (maxLen < returnValue.length()) {
                    maxLen = returnValue.length();
                    ans = returnValue;
                }
            } else {
                // generate 2 char perm starting with A and C
                String returnValue = getPerm(map, List.of('a', 'c'), List.of('a', 'b', 'c'), sb);

                if (maxLen < returnValue.length()) {
                    maxLen = returnValue.length();
                    ans = returnValue;
                }
            }

            map.put('b', map.get('b') + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (map.get('c') != 0) {
            sb.append('c');
            map.put('c', map.get('c') - 1);

            if (last != 'c') {
                // generate 2 char perm starting with A, B and C
                String returnValue = getPerm(map, List.of('a', 'b', 'c'), List.of('a', 'b'), sb);

                if (maxLen < returnValue.length()) {
                    maxLen = returnValue.length();
                    ans = returnValue;
                }
            } else {
                // generate 2 char perm starting with A and C
                String returnValue = getPerm(map, List.of('a', 'b'), List.of('a', 'b', 'c'), sb);

                if (maxLen < returnValue.length()) {
                    maxLen = returnValue.length();
                    ans = returnValue;
                }
            }

            map.put('c', map.get('c') + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

        return ans;
    }
}

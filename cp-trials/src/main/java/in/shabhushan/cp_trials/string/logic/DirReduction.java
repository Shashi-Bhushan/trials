package in.shabhushan.cp_trials.string.logic;

import java.util.*;

public class DirReduction {
    private static Map<String, String> complementMap = new HashMap<>();

    static {
        complementMap.put("NORTH", "SOUTH");
        complementMap.put("SOUTH", "NORTH");
        complementMap.put("EAST", "WEST");
        complementMap.put("WEST", "EAST");
    }

    public static String[] dirReduc(String[] arr) {
        Deque<String> stack = new ArrayDeque<>();

        stack.push(arr[0]);

        for (int index = 1; index < arr.length; index++) {
            String string = arr[index];

            if (!stack.isEmpty() && complementMap.get(stack.peek()).equals(string)) {
                stack.pop();
            } else {
                stack.push(string);
            }
        }

        // Your code here.
        return stack.toArray(new String[0]);
    }
}

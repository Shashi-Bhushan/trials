package in.shabhushan.cp_trials.math.logic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Consecutives {

    public static List<Integer> sumConsecutives(List<Integer> s) {
        List<Integer> list = new ArrayList<>();

        int prev = s.get(0);
        list.add(prev);

        for (int index = 1; index < s.size(); index++) {
            if (prev == s.get(index)) {
                // increment last element by prev
                list.set(list.size() - 1, list.get(list.size() - 1) + prev);
            } else {
                prev = s.get(index);
                list.add(prev);
            }
        }

        return list;
    }

    static List<Integer> sumConsecutives2(List<Integer> s) {
        var result = new LinkedList<>(List.of(0));

        int prev = s.get(0);

        for (int i : s) {
            result.addLast(prev == i ? result.removeLast() + i : (prev = i));
        }
        return result;
    }
}

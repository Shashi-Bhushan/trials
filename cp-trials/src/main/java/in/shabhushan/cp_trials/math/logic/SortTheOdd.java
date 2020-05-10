package in.shabhushan.cp_trials.math.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortTheOdd {
    private SortTheOdd() {
    }

    public static int[] sortArray(int[] array) {
        List<Integer> indexList = new ArrayList<>();
        List<Integer> valueList = new ArrayList<>();

        for (int index = 0; index < array.length; index++) {
            if (array[index] % 2 != 0) {
                indexList.add(index);
                valueList.add(array[index]);
            }
        }

        //list.sort((objectOne, objectTwo) -> objectOne.getSecond().compareTo(objectTwo.getSecond()));
        valueList.sort(Comparator.comparing(object -> object));

        for (int i = 0; i < valueList.size(); i++) {
            array[indexList.get(i)] = valueList.get(i);
        }

        return array;
    }

    public static int[] sortArray2(int[] array) {
        int[] sorted = Arrays.stream(array).filter(obj -> obj % 2 == 1).sorted().toArray();

        for (int i = 0, j = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                array[i] = sorted[j];
                j++;
            }
        }

        return array;
    }
}

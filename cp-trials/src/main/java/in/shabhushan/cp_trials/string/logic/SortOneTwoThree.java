package in.shabhushan.cp_trials.string.logic;

import java.util.Arrays;
import java.util.Comparator;

public class SortOneTwoThree {

    private static final String units[] = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static final String tens[] = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    public static int[] sort(final int array[]) {
        return Arrays.stream(array)
                .boxed()
                .sorted(Comparator.comparing(SortOneTwoThree::getString))
                .mapToInt(elem -> elem)
                .toArray();
    }

    private static String getString(int i) {
        if (i == 0)
            return "zero";
        else if (i < 20)
            return units[i];
        else if (i < 100)
            return tens[i / 10] + " " + units[i % 10];
        else if (i % 100 == 0)
            return units[i / 100] + " hundred";
        else if (i % 100 < 20)
            return units[i / 100] + " hundred " + units[i % 100];
        else
            return units[i / 100] + " hundred " + tens[(i % 100) / 10] + " " + units[i % 10];
    }

}

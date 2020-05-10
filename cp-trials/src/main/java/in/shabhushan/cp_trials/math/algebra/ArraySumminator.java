package in.shabhushan.cp_trials.math.algebra;

import java.util.Arrays;
import java.util.Map;

public class ArraySumminator {

    public static Map<String, Integer> map = Map.ofEntries(
            Map.entry("0", 0),
            Map.entry("1", 1),
            Map.entry("2", 2),
            Map.entry("3", 3),
            Map.entry("4", 4),
            Map.entry("5", 5),
            Map.entry("6", 6),
            Map.entry("7", 7),
            Map.entry("8", 8),
            Map.entry("9", 9),
            Map.entry("A", 10),
            Map.entry("B", 11),
            Map.entry("C", 12),
            Map.entry("D", 13),
            Map.entry("E", 14),
            Map.entry("F", 15),
            Map.entry("G", 16),
            Map.entry("H", 17),
            Map.entry("I", 18),
            Map.entry("J", 19),
            Map.entry("K", 20),
            Map.entry("L", 21),
            Map.entry("M", 22),
            Map.entry("N", 23),
            Map.entry("O", 24),
            Map.entry("P", 25),
            Map.entry("Q", 26),
            Map.entry("R", 27),
            Map.entry("S", 28),
            Map.entry("T", 29),
            Map.entry("U", 30),
            Map.entry("V", 31),
            Map.entry("W", 32),
            Map.entry("X", 33),
            Map.entry("Y", 34),
            Map.entry("Z", 35)
    );

    public static long sumItUp(BasedNumbers[] numbersWithBases) {
        Arrays.stream(numbersWithBases).forEach(System.out::println);
        return Arrays.stream(numbersWithBases).map(ArraySumminator::toDecimal).reduce(0L, Long::sum);
    }

    public static long toDecimal(BasedNumbers basedNumbers) {
        int[] ints = Arrays.stream(basedNumbers.number.split("")).map(String::toUpperCase).map(map::get).mapToInt(elem -> elem).toArray();

        int multiplier = 1;
        long num = 0;

        for (int index = ints.length - 1; index >= 0; index--) {
            num += (ints[index] * multiplier);

            multiplier *= basedNumbers.base;
        }

        return num;
    }
}

class BasedNumbers {
    String number;
    int base;

    public BasedNumbers(String number, int base) {
        this.number = number;
        this.base = base;
    }
}

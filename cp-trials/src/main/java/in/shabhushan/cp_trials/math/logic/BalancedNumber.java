package in.shabhushan.cp_trials.math.logic;

import java.util.function.IntUnaryOperator;

public class BalancedNumber {
    public static String balancedNum(long number) {
        String s = String.valueOf(number);
        if (s.length() == 0 || s.length() == 1 || s.length() == 2) return "Balanced";
        int half = s.length() / 2;

        char[] leftString = s.substring(0, half % 2 == 0 ? half - 1 : half).toCharArray();
        char[] rightString = s.substring(half + 1).toCharArray();

        long leftSum = 0;
        for (int i = 0; i < leftString.length; i++) {
            leftSum += leftString[i] - '0';
        }

        long rightSum = 0;
        for (int i = 0; i < rightString.length; i++) {
            rightSum += rightString[i] - '0';
        }

        return leftSum == rightSum ? "Balanced" : "Not Balanced";
    }

    /**
     * cool 8)
     * @param number
     * @return
     */
    public static String balancedNum2(final long number) {
        return new BalancedNumber(number).compute();
    }

    private final String str;

    private BalancedNumber(final long number) {
        str = String.valueOf(number);
    }

    private String compute() { return (isSmall() || leftSum() == rightSum()) ? "Balanced" : "Not Balanced"; }

    private boolean isSmall()  { return str.length() < 3; }
    private int     leftSum()  { return str.chars().limit((str.length() - 1) / 2    ).map(toDigit).sum(); }
    private int     rightSum() { return str.chars().skip ( str.length()      / 2 + 1).map(toDigit).sum(); }

    private static final IntUnaryOperator toDigit = c -> Character.digit(c, 10);
}

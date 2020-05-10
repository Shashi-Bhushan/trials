package in.shabhushan.cp_trials.math.algebra;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://www.geeksforgeeks.org/greedy-algorithm-egyptian-fraction/
 */
public class EgyptianFraction {
    /**
     * Wrapper function that converts String to BigDecimal and wrap answer in []
     */
    public static String decompose(String nrStr, String drStr) {
        // Convert to Big Decimal values (Note: even long would overflow very fast)
        BigDecimal numerator = new BigDecimal(nrStr);
        BigDecimal denominator = new BigDecimal(drStr);

        List<BigDecimal[]> decompose = decompose(numerator, denominator);

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        sb.append(decompose.stream().map(entry -> {
            if (entry.length == 1) {
                return entry[0].equals(BigDecimal.ZERO) ? "" : entry[0].toString();
            } else {
                return entry[1].equals(BigDecimal.ONE) ? entry[0].toString() : String.format("%s/%s", entry[0].toString(), entry[1].toString());
            }
        }).collect(Collectors.joining(", ")));

        sb.append("]");
        return sb.toString();
    }

    public static List<BigDecimal[]> decompose(BigDecimal numerator, BigDecimal denominator) {
        if (numerator.remainder(denominator).equals(BigDecimal.ZERO)) {
            // if denominator perfectly divides numerator (say 8/2) add 4 in List
            BigDecimal[] bigDecimals = new BigDecimal[]{numerator.divide(denominator, RoundingMode.DOWN)};

            return new ArrayList<>(Collections.singleton(bigDecimals));
        } else if (denominator.remainder(numerator).equals(BigDecimal.ZERO)) {
            // if denominator perfectly divides numerator (say 2/8) add 1/4 in List
            BigDecimal[] bigDecimals = {BigDecimal.ONE, denominator.divide(numerator, RoundingMode.DOWN)};

            return new ArrayList<>(Collections.singleton(bigDecimals));
        } else {
            // if numerator doesn't divide denominator perfectly
            // denominator/numerator + 1
            BigDecimal n = denominator.divide(numerator, RoundingMode.DOWN).add(BigDecimal.ONE);

            BigDecimal newNumerator = numerator.multiply(n).subtract(denominator);
            BigDecimal newDenominator = denominator.multiply(n);

            List<BigDecimal[]> list = new ArrayList<>();
            list.add(new BigDecimal[]{BigDecimal.ONE, n});

            list.addAll(decompose(newNumerator, newDenominator));

            return list;
        }
    }

    public static String decompose2(String nrStr, String drStr) {
        long numerator = Integer.parseInt(nrStr);
        long denominator = Integer.parseInt(drStr);

        long denum = 2;
        StringBuilder s;

        if (numerator > denominator) {
            s = new StringBuilder(", " + numerator / denominator);
            numerator %= denominator;
        } else
            s = new StringBuilder();

        while (numerator > 0) {
            if (numerator * denum >= denominator) {
                s.append(", 1/").append(denum);
                numerator = numerator * denum - denominator;
                denominator *= denum;
            }

            denum++;
        }
        return (s.length() == 0) ? "[]" : "[" + s.substring(2) + "]";
    }
}

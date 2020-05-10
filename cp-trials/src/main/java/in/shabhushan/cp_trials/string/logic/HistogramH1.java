package in.shabhushan.cp_trials.string.logic;

import java.util.stream.IntStream;

public class HistogramH1 {

    public static String histogram(final int results[]) {
        StringBuilder finalStringBuilder = new StringBuilder();

        for (int index = results.length; index > 0; index--) {
            if (results[index - 1] == 0) {
                finalStringBuilder.append(String.format("%d|\n", index));
            } else {
                final StringBuilder sb = new StringBuilder();

                IntStream.range(0, results[index - 1]).forEach(i -> sb.append("#"));

                finalStringBuilder.append(String.format("%d|%s %d\n", index, sb.toString(), results[index - 1]));
            }
        }

        return finalStringBuilder.toString();
    }

}

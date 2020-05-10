package in.shabhushan.cp_trials.string.logic;

public class HistogramV2 {

    public static String histogram(final int results[]) {
        int max = 0;

        // Find Max in results
        for (int a : results)
            if (max < a)
                max = a;

        StringBuilder finalSb = new StringBuilder();

        if (max > 0) {
            for (int index = max; index >= 0; index--) {
                // create a temporary stringbuilder to hold spaces
                StringBuilder spacesSb = new StringBuilder();

                for (int element : results) {
                    // if element is 0, append element
                    if (element != 0 && index == element) {
                        spacesSb.append(element);
                        if (element <= 9)
                            spacesSb.append(" ");

                        finalSb.append(spacesSb.toString());

                        spacesSb = new StringBuilder();
                    }
                    // found an element, append previously collected spaces and then a #
                    // not merging the two if-else for brevity reasons
                    else if (index < element) {
                        spacesSb.append("# ");
                        finalSb.append(spacesSb.toString());

                        spacesSb = new StringBuilder(0);
                    }
                    // add spaces for the next element
                    else {
                        spacesSb.append("  ");
                    }
                }

                removeLastCharacter(finalSb).append("\n");
            }
        }

        for (int index = 0; index < (results.length * 2) - 1; index++) {
            finalSb.append("-");
        }
        finalSb.append("\n");

        for (int index = 0; index < results.length; index++) {
            finalSb.append(index + 1).append(" ");
        }

        return removeLastCharacter(finalSb).append("\n").toString();
    }

    /**
     * Removes the last character in StringBuilder, in this case, last character is always a space
     */
    private static StringBuilder removeLastCharacter(StringBuilder finalSb) {
        if (finalSb.toString().endsWith(" ")) {
            int sbLength = finalSb.length();
            return finalSb.replace(sbLength - 1, sbLength, "");
        } else {
            return finalSb;
        }
    }

}

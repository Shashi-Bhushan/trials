package in.shabhushan.cp_trials.math.algebra;

public class FindSmallest {
    public static long[] smallest(long n) {
        String str = String.valueOf(n);

        // jisko replace krna hai
        int index = 0;
        int min = 0;

        for (int i = 0; i < str.length(); i++) {
            boolean allBig = true;
            int tempMin = i + 1;

            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) > str.charAt(j)) {
                    allBig = false;
                    index = i;
                }

                if (str.charAt(j) <= str.charAt(tempMin)) {
                    tempMin = j;
                }
            }

            if (!allBig) {
                min = tempMin;
                break;
            }
        }

        // index is position to replace
        // min is position that replaces

        String s = str.substring(0, index) + str.charAt(min) + str.substring(index, min) + str.substring(min + 1);

        if (min == 1 && index == 0 && s.startsWith("0")) {
            return new long[]{
                    Long.parseLong(s), index, min
            };
        } else {
            return new long[]{
                    Long.parseLong(s), min, index
            };
        }
    }
}

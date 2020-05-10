package in.shabhushan.cp_trials.string;

import java.util.Arrays;

public class ValidateCC {
    public static boolean validate(String n){
        boolean isDigit = false;
        int sum = 0;

        for (int index = n.length() - 1; index >= 0; index--) {
            int x = n.charAt(index) - '0';

            if (isDigit)
                x = x * 2;

            if (x > 9)
                x -= 9;

            isDigit = !isDigit;

            sum += x;
        }

        return sum % 10 == 0;
    }

    public static boolean validate2(String n) {
        final boolean[] flag = {n.length() % 2 == 0};

        return Arrays.stream(n.split(""))
                .mapToInt(Integer::parseInt)
                .map(integer -> (flag[0] = !flag[0]) ? (integer * 2) % 9 : integer).sum() % 10 == 0;
    }
}

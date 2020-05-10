package in.shabhushan.cp_trials.math.logic;

public class SumTriangularNumbers {
    public static int sumTriangularNumbers(int n) {
        int sum = 0;
        int num = 1;

        for (int i = 1; i <= n; i++) {
            sum += num;
            num += (1 + i);
        }

        return sum;
    }
}

package in.shabhushan.algo_trials.binarySearch;

public class SmallestGoodBase {
    public String solve(String A) {
        long a = Long.parseLong(A);

        for (int i = 63; i >= 2; i--) {
            if ((1L << i) < a) {
                long base = calculateGoodBase(a, i);

                if (base != -1) {
                    return String.valueOf(base);
                }
            }
        }

        return String.valueOf(a - 1);
    }

    private long calculateGoodBase(long a, int bits) {
        double pow = 1.0D / bits;
        long base = (long)Math.pow(a, pow);

        long sum = 1;
        long mult = 1;

        for (int i =1; i <= bits; i++) {
            mult *= base;
            sum += mult;
        }

        return (sum == a) ? base : -1L;
    }
}

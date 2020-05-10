package in.shabhushan.cp_trials.string.logic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HistogramH1Test {

    @Test
    public void basic() {
        final String expected =
                "6|##### 5\n" +
                        "5|\n" +
                        "4|# 1\n" +
                        "3|########## 10\n" +
                        "2|### 3\n" +
                        "1|####### 7\n";
        assertEquals(expected, HistogramH1.histogram(new int[]{7, 3, 10, 1, 0, 5}));
    }
}

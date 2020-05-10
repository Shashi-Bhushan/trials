package in.shabhushan.cp_trials.math.logic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumTriangularNumbersTest {
    @Test
    public void basicTests() {
        assertEquals(56, SumTriangularNumbers.sumTriangularNumbers(6));
        assertEquals(7140, SumTriangularNumbers.sumTriangularNumbers(34));
        assertEquals(0, SumTriangularNumbers.sumTriangularNumbers(-291));
        assertEquals(140205240, SumTriangularNumbers.sumTriangularNumbers(943));
        assertEquals(0, SumTriangularNumbers.sumTriangularNumbers(-971));
    }
}

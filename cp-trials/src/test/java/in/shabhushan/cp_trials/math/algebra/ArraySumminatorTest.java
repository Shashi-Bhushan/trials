package in.shabhushan.cp_trials.math.algebra;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArraySumminatorTest {
    @Test
    public void exampleTests() {
        System.out.println("Should return 4258");
        assertEquals(4258, ArraySumminator.sumItUp(new BasedNumbers[]{new BasedNumbers("101", 16), new BasedNumbers("7640", 8), new BasedNumbers("1", 9)}));
        System.out.println("Should return 13");
        assertEquals(13, ArraySumminator.sumItUp(new BasedNumbers[]{new BasedNumbers("101", 2), new BasedNumbers("10", 8)}));
        System.out.println("Should return 2751");
        assertEquals(2751, ArraySumminator.sumItUp(new BasedNumbers[]{new BasedNumbers("ABC", 16), new BasedNumbers("11", 2)}));
    }
}

package in.shabhushan.cp_trials.math.logic;

import org.junit.Test;

import static in.shabhushan.cp_trials.math.logic.LengthOfMissing.getLengthOfMissingArray;
import static org.junit.Assert.assertEquals;

public class LengthOfMissingTest {
    @Test
    public void BasicTests() {
        assertEquals(3, getLengthOfMissingArray(new Object[][]{new Object[]{1, 2}, new Object[]{4, 5, 1, 1}, new Object[]{1}, new Object[]{5, 6, 7, 8, 9}}));
        assertEquals(2, getLengthOfMissingArray(new Object[][]{new Object[]{5, 2, 9}, new Object[]{4, 5, 1, 1}, new Object[]{1}, new Object[]{5, 6, 7, 8, 9}}));
        assertEquals(2, getLengthOfMissingArray(new Object[][]{new Object[]{null}, new Object[]{null, null, null}}));
        assertEquals(5, getLengthOfMissingArray(new Object[][]{new Object[]{'a', 'a', 'a'}, new Object[]{'a', 'a'}, new Object[]{'a', 'a', 'a', 'a'}, new Object[]{'a'}, new Object[]{'a', 'a', 'a', 'a', 'a', 'a'}}));
        assertEquals(4, getLengthOfMissingArray(new Object[][]{new Object[]{4, 4, 4, 0, 1}, new Object[]{3, 0, 2}, new Object[]{}, new Object[]{1}, new Object[]{4, 4}}));

        assertEquals(0, getLengthOfMissingArray(new Object[][]{}));
    }
}

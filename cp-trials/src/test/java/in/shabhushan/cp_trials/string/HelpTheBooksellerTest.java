package in.shabhushan.cp_trials.string;

import static in.shabhushan.cp_trials.string.HelpTheBookseller.stockSummary;
import static org.junit.Assert.*;
import org.junit.Test;

public class HelpTheBooksellerTest {
    @Test
    public void test1() {
        String art[] = new String[]{"ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600"};
        String cd[] = new String[] {"A", "B"};
        assertEquals("(A : 200) - (B : 1140)",
                stockSummary(art, cd));
    }
}

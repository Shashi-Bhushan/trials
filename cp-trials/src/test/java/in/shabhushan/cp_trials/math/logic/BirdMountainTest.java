package in.shabhushan.cp_trials.math.logic;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BirdMountainTest {

    @Test
    public void ex() {
        char[][] mountain = {
                "^^^^^^        ".toCharArray(),
                " ^^^^^^^^     ".toCharArray(),
                "  ^^^^^^^     ".toCharArray(),
                "  ^^^^^       ".toCharArray(),
                "  ^^^^^^^^^^^ ".toCharArray(),
                "  ^^^^^^      ".toCharArray(),
                "  ^^^^        ".toCharArray()
        };
        assertEquals(3, BirdMountain.peakHeight(mountain));
    }

}

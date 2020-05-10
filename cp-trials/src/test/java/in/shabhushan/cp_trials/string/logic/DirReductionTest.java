package in.shabhushan.cp_trials.string.logic;

import org.junit.Test;

import static org.junit.Assert.*;

public class DirReductionTest {
    @Test
    public void testSimpleDirReduc() {
        assertArrayEquals(
                "\"NORTH\", \"SOUTH\", \"SOUTH\", \"EAST\", \"WEST\", \"NORTH\", \"WEST\"",
                new String[]{"WEST"},
                DirReduction.dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"})
        );
        assertArrayEquals(
                "\"NORTH\",\"SOUTH\",\"SOUTH\",\"EAST\",\"WEST\",\"NORTH\"",
                new String[]{},
                DirReduction.dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH"})
        );
    }
}

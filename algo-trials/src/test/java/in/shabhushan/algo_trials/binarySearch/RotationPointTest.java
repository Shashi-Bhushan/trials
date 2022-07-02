package in.shabhushan.algo_trials.binarySearch;

import org.junit.Test;

import static in.shabhushan.algo_trials.binarySearch.RotationPoint.findRotationPoint;
import static org.junit.Assert.assertEquals;

public class RotationPointTest {
    @Test
    public void testRotationPoint() {
        assertEquals(5, findRotationPoint(new String[]{
                "ptolemaic",
                "retrograde",
                "supplant",
                "undulate",
                "xenoepist",
                "asymptote",  // # <-- rotates here!
                "babka",
                "banoffee",
                "engender",
                "karpatka",
                "othellolagkage",
        }));

        assertEquals(9, findRotationPoint(new String[]{
                "banoffee",
                "engender",
                "karpatka",
                "othellolagkage",
                "ptolemaic",
                "retrograde",
                "supplant",
                "undulate",
                "xenoepist",
                "asymptote",  // # <-- rotates here!
                "babka",
        }));

        assertEquals(10, findRotationPoint(new String[]{
                "babka",
                "banoffee",
                "engender",
                "karpatka",
                "othellolagkage",
                "ptolemaic",
                "retrograde",
                "supplant",
                "undulate",
                "xenoepist",
                "asymptote",  // # <-- rotates here!
        }));

        assertEquals(0, findRotationPoint(new String[]{
                "asymptote",  // # <-- rotates here!
                "babka",
                "banoffee",
                "engender",
                "karpatka",
                "othellolagkage",
                "ptolemaic",
                "retrograde",
                "supplant",
                "undulate",
                "xenoepist",
        }));

        assertEquals(1, findRotationPoint(new String[]{
                "xenoepist",
                "asymptote",  // # <-- rotates here!
                "babka",
                "banoffee",
                "engender",
                "karpatka",
                "othellolagkage",
                "ptolemaic",
                "retrograde",
                "supplant",
                "undulate",
        }));

        assertEquals(1, findRotationPoint(new String[]{
                "xenoepist",
                "asymptote",  // # <-- rotates here!
                "asymptote",  // # <-- This is duplicate
                "babka",
                "banoffee",
                "engender",
                "karpatka",
                "othellolagkage",
                "ptolemaic",
                "retrograde",
                "supplant",
                "undulate",
        }));

        assertEquals(12, findRotationPoint(new String[]{
                "asymptote",  // # <-- This is duplicate
                "babka",
                "banoffee",
                "engender",
                "karpatka",
                "othellolagkage",
                "ptolemaic",
                "ptolemaic",
                "retrograde",
                "supplant",
                "undulate",
                "xenoepist",
                "asymptote",  // # <-- rotates here!
        }));

        assertEquals(0, findRotationPoint(new String[]{
                "asymptote",  // # <-- rotates here!
                "asymptote",  // # <-- rotates here!
                "asymptote",  // # <-- rotates here!
                "asymptote",  // # <-- rotates here!
                "asymptote",  // # <-- rotates here!
                "asymptote",  // # <-- rotates here!
                "asymptote",  // # <-- rotates here!
        }));
    }
}

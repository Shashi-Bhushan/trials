package in.shabhushan.cp_trials;

import org.junit.Assert;
import org.junit.Test;


public class DisemvowelTrollsTest {
    @Test
    public void test() {
        Assert.assertEquals("Ths wbst s fr lsrs LL!",
                DisemvowelTrolls.disemvowel("This website is for losers LOL!"));
        Assert.assertEquals("N ffns bt,\nYr wrtng s mng th wrst 'v vr rd",
                DisemvowelTrolls.disemvowel("No offense but,\nYour writing is among the worst I've ever read"));
        Assert.assertEquals("Wht r y,  cmmnst?",
                DisemvowelTrolls.disemvowel("What are you, a communist?"));
    }
}

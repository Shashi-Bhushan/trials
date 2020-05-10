package in.shabhushan.cp_trials.math.fundamental;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MysteryFunctionTest {
	@Test
	public void mystery() throws Exception {
		assertEquals( "mystery(6) ", 5, MysteryFunction.mystery( 6 ) );
		assertEquals( "mystery(9) ", 13, MysteryFunction.mystery( 9 ) );
		assertEquals( "mystery(19) ", 26, MysteryFunction.mystery( 19 ) );
	}

	@Test
	public void mysteryInv() throws Exception {
		assertEquals( "mysteryInv(5)", 6, MysteryFunction.mysteryInv( 5 ) );
		assertEquals( "mysteryInv(13)", 9, MysteryFunction.mysteryInv( 13 ) );
		assertEquals( "mysteryInv(26)", 19, MysteryFunction.mysteryInv( 26 ) );
	}

}

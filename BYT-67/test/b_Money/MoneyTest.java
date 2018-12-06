package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyTest {
	Currency SEK, DKK, NOK, EUR;
	Money SEK100, EUR10, SEK200, EUR20, SEK0, EUR0, SEKn100;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
		SEK100 = new Money(100, SEK);
		EUR10 = new Money(10, EUR);
		SEK200 = new Money(200, SEK);
		EUR20 = new Money(20, EUR);
		SEK0 = new Money(0, SEK);
		EUR0 = new Money(0, EUR);
		SEKn100 = new Money(-100, SEK);
	}

	/*
	 * Testing method getAmount()
	 */
	@Test
	public void testGetAmount() {
		assertEquals(20, EUR20.getAmount(), 0);
	}

	/*
	 * Testing method getCurrency()
	 */
	@Test
	public void testGetCurrency() {
		assertEquals(SEK, SEK100.getCurrency());
	}
	
	/*
	 *  Testing UniversalValue()
	 */
	@Test
	public void testGlobalValue() {
		
		assertEquals((int)(100 * 0.15), SEK100.universalValue(), 0);
	}
	/*
	 * resting equals() method
	 */
	@Test
	public void testEqualsMoney() {
		Money SEKS = new Money(100, SEK);
		assertTrue(SEKS.equals(SEK100));
		
	}
	/*
	 * testing add(Money) method
	 */
	@Test
	public void testAdd() {
		Money added = EUR10.add(SEK100);
		assertEquals(20, added.getAmount(), 0);
	}
	/*
	 * testing sub(Money) method
	 */
	@Test
	public void testSub() {
		Money subbed = SEK200.sub(SEK100);
		int res = (int) (200 - 100 * 0.15 / 0.15);
		assertEquals(res, subbed.getAmount(), 0);
	}
	/*
	 * testing isZero() method
	 */
	@Test
	public void testIsZero() {
		assertTrue(SEK0.isZero());
	}
	/*
	 * testing negate() method
	 */
	@Test
	public void testNegate() {
		assertEquals(-10, EUR10.negate().getAmount(), 0);
	}
	/*
	 * testing compareTo(Object) method of Money object
	 */
	@Test
	public void testCompareTo() {
		
		assertEquals(-1, SEK100.compareTo(SEK200));
	}
}

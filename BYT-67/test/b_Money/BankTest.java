package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BankTest {
	Currency SEK, DKK;
	Bank SweBank, Nordea, DanskeBank;
	
	@Before
	public void setUp() throws Exception {
		DKK = new Currency("DKK", 0.20);
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		Nordea = new Bank("Nordea", SEK);
		DanskeBank = new Bank("DanskeBank", DKK);
		SweBank.openAccount("name2");
		SweBank.openAccount("name1");
		Nordea.openAccount("name1");
		DanskeBank.openAccount("name3");
	}
	
	/*
	 * testing getName() method
	 */
	@Test
	public void testGetName() {
		assertEquals("SweBank", SweBank.getName());
	}

	/*
	 * testing getCurrency() method
	 */
	@Test
	public void testGetCurrency() {
		assertEquals(DKK, DanskeBank.getCurrency());
	}

	/*
	 * testing openAccount() method
	 */
	@Test
	public void testOpenAccount() throws AccountExistsException, AccountDoesNotExistException {
		SweBank.openAccount("testAccount");
		assertTrue(SweBank.existsAccount("testAccount"));
	}

	/*
	 * testing deposit() method
	 */
	@Test
	public void testDeposit() throws AccountDoesNotExistException {
		SweBank.deposit("name1", new Money(1000, SEK));
		assertEquals(1000, SweBank.getBalance("name1"), 0);
	}

	/*
	 * testing withdraw() method
	 */
	@Test
	public void testWithdraw() throws AccountDoesNotExistException {
		SweBank.withdraw("name1", new Money(1000, SEK));
		assertEquals(-1000, SweBank.getBalance("name1"), 0);
	}
	
	/*
	 * testing getBalance() method
	 */
	@Test
	public void testGetBalance() throws AccountDoesNotExistException {
		assertEquals(0, SweBank.getBalance("name1"), 0);
	}
	/*
	 * testing transfer() method inside same bank and with other bank
	 * testing inside bank and between banks
	 */
	@Test
	public void testTransfer() throws AccountDoesNotExistException {
		//inside one bank
		SweBank.deposit("name1", new Money(1000, SEK));
		SweBank.transfer("name1", "name2", new Money(500, SEK));		
		assertEquals(500, SweBank.getBalance("name1"), 0);
		assertEquals(500, SweBank.getBalance("name2"), 0);
		
		//between banks
		SweBank.transfer("name1", DanskeBank, "name3", new Money(500, SEK));	
		assertEquals(0, SweBank.getBalance("name1"), 0);
		assertEquals((int)(500 * 0.15 / 0.20), DanskeBank.getBalance("name3"), 0);
	}
	
	/*
	 * testing addTimedPayment() method
	 * add timed payment
	 * tick for payment to go through
	 */
	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		SweBank.deposit("name1", new Money(1000, SEK));
		SweBank.addTimedPayment("name1", "1", 2, 0, new Money(1000, SEK), SweBank, "name2"); 	
		SweBank.tick();																			
		
		assertEquals(0, SweBank.getBalance("name1"), 0);
		assertEquals(1000, SweBank.getBalance("name2"), 0);
		
		
	}
}

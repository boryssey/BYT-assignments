package b_Money;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class AccountTest {
	Currency SEK, DKK;
	Bank Nordea;
	Bank DanskeBank;
	Bank SweBank;
	Account testAccount;
	/*
	 * Setting up initial accounts
	 */
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		SweBank.openAccount("Andrew");
		testAccount = new Account("Hans", SEK);
		testAccount.deposit(new Money(10000000, SEK));

		SweBank.deposit("Andrew", new Money(1000000, SEK));
		
	}
	/*
	 * Testing adding and removing TimedPayment from HashTable
	 */
	@Test
	public void testAddRemoveTimedPayment() {
		testAccount.addTimedPayment("1", 5, 10, new Money(500, SEK), SweBank, "Anna");
		assertTrue(testAccount.timedPaymentExists("1"));
		testAccount.removeTimedPayment("1");
		assertFalse(testAccount.timedPaymentExists("1"));
	}
	/*
	 * Testing TimedPayment
	 */
	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		testAccount.addTimedPayment("1", 2, 1, new Money(1000, SEK), SweBank, "Andrew"); 
		testAccount.tick();
		testAccount.tick();
		testAccount.tick();
		
		assertEquals(new Integer(10000000 - 1000), testAccount.getBalance().getAmount());
	}

	/*
	 * Testing depositing and withdrawing money from account
	 */
	@Test
	public void testAddWithdraw() {
		testAccount.deposit(new Money(5000, SEK));
		assertEquals(10000000 + 5000, testAccount.getBalance().getAmount(), 0);  
		testAccount.withdraw(new Money(5000, SEK));
		assertEquals(10000000, testAccount.getBalance().getAmount(), 0);
		
	}
	/*
	 * Testing getBalance() method
	 */
	@Test
	public void testGetBalance() {
		assertTrue(new Money(10000000, SEK).equals(testAccount.getBalance()));
	}
}

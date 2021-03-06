package b_Money;

import java.util.Hashtable;

public class Bank {
	private Hashtable<String, Account> accountlist = new Hashtable<String, Account>();
	private String name;
	private Currency currency;

	/**
	 * creates new Bank
	 * 
	 * @param name
	 *            Name of this bank
	 * @param currency
	 *            Base currency of this bank (If this is a Swedish bank, this might
	 *            be a currency class representing SEK)
	 */
	Bank(String name, Currency currency) {
		this.name = name;
		this.currency = currency;
	}

	/**
	 * Get the name of this bank
	 * 
	 * @return Name of this bank
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get the Currency of this bank
	 * 
	 * @return The Currency of this bank
	 */
	public Currency getCurrency() {
		return currency;
	}

	/**
	 * Open an account in this bank.
	 * 
	 * @param accountid
	 *            The ID of the account
	 * @throws AccountExistsException
	 *             If the account already exists
	 */
	public void openAccount(String accountid) throws AccountExistsException {
		if (existsAccount(accountid)) {
			throw new AccountExistsException();
		} else {
			accountlist.put(accountid, new Account("accountid", getCurrency())); // creating account with currency of
																					// this bank
		}
	}

	/**
	 * Deposit money to an account
	 * 
	 * @param accountid
	 *            Account to deposit to
	 * @param money
	 *            Money to deposit.
	 * @throws AccountDoesNotExistException
	 *             If the account does not exist
	 */
	public void deposit(String accountid, Money money) throws AccountDoesNotExistException {
		if (!existsAccount(accountid)) { // There was no negation for boolean expression
			throw new AccountDoesNotExistException();
		} else {
			Account account = accountlist.get(accountid);
			account.deposit(money);
		}
	}

	/**
	 * Withdraw money from an account
	 * 
	 * @param accountid
	 *            Account to withdraw from
	 * @param money
	 *            Money to withdraw
	 * @throws AccountDoesNotExistException
	 *             If the account does not exist
	 */
	public void withdraw(String accountid, Money money) throws AccountDoesNotExistException {
		if (!accountlist.containsKey(accountid)) {
			throw new AccountDoesNotExistException();
		} else {
			Account account = accountlist.get(accountid);
			account.withdraw(money); // It was depositing instead of withdrawing
		}
	}

	/**
	 * Check if account exists in the list
	 * 
	 * @return true if it exists
	 */
	public boolean existsAccount(String accountid) {
		return accountlist.containsKey(accountid);
	}

	/**
	 * Get the balance of an account
	 * 
	 * @param accountid
	 *            Account to get balance from
	 * @return Balance of the account
	 * @throws AccountDoesNotExistException
	 *             If the account does not exist
	 */
	public Integer getBalance(String accountid) throws AccountDoesNotExistException {
		if (!existsAccount(accountid)) {
			throw new AccountDoesNotExistException();
		} else {
			return accountlist.get(accountid).getBalance().getAmount();
		}
	}

	/**
	 * Transfer money between two accounts
	 * 
	 * @param fromaccount
	 *            Id of account to deduct from in this Bank
	 * @param tobank
	 *            Bank where receiving account resides
	 * @param toaccount
	 *            Id of receiving account
	 * @param amount
	 *            Amount of Money to transfer
	 * @throws AccountDoesNotExistException
	 *             If one of the accounts do not exist
	 */
	public void transfer(String fromaccount, Bank tobank, String toaccount, Money amount)
			throws AccountDoesNotExistException {
		if (!existsAccount(fromaccount) || !tobank.existsAccount(toaccount)) {
			throw new AccountDoesNotExistException();
		} else {
			if (accountlist.get(fromaccount).getBalance().getAmount() >= amount.getAmount()) {
				accountlist.get(fromaccount).withdraw(amount);
				tobank.accountlist.get(toaccount).deposit(amount);
			} else {
				System.err.println("Not enought money on account to transfer");
			}
		}
	}

	/**
	 * Transfer money between two accounts on the same bank
	 * 
	 * @param fromaccount
	 *            Id of account to deduct from
	 * @param toaccount
	 *            Id of receiving account
	 * @param amount
	 *            Amount of Money to transfer
	 * @throws AccountDoesNotExistException
	 *             If one of the accounts do not exist
	 */
	public void transfer(String fromaccount, String toaccount, Money amount) throws AccountDoesNotExistException {
		transfer(fromaccount, this, toaccount, amount); // It was transfer(from, this, from, amount), so was transfering
														// between same account
	}

	/**
	 * Add a timed payment
	 * 
	 * @param accountid
	 *            Id of account to deduct from in this Bank
	 * @param payid
	 *            Id of timed payment
	 * @param interval
	 *            Number of ticks between payments
	 * @param next
	 *            Number of ticks till first payment
	 * @param amount
	 *            Amount of Money to transfer each payment
	 * @param tobank
	 *            Bank where receiving account resides
	 * @param toaccount
	 *            Id of receiving account
	 * @throws AccountDoesNotExistException
	 */
	public void addTimedPayment(String accountid, String payid, Integer interval, Integer next, Money amount,
			Bank tobank, String toaccount) throws AccountDoesNotExistException {
		Account acc = accountlist.get(accountid);
		if (acc != null) { // There was no check for account existence
			Account account = accountlist.get(accountid);
			account.addTimedPayment(payid, interval, next, amount, tobank, toaccount);
		} else {
			throw new AccountDoesNotExistException();
		}
	}

	/**
	 * Remove a timed payment
	 * 
	 * @param accountid
	 *            Id of account to remove timed payment from
	 * @param id
	 *            Id of timed payment
	 */
	public void removeTimedPayment(String accountid, String id) {
		Account account = accountlist.get(accountid);
		account.removeTimedPayment(id);
	}

	/**
	 * A time unit passes in the system
	 */
	public void tick() throws AccountDoesNotExistException {
		for (Account account : accountlist.values()) {
			account.tick();
		}
	}
}

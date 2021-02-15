package com.stackroute.exception;

public class Account {

	private int accountBalance;

	public Account() {
		this.accountBalance = 0;
	}

	public Account(int balance) {
		this.accountBalance = balance;
	}

	public int getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}

	public double withdraw(int amt) throws InsufficientFundException, NegativeIntegerException {
		double clearBalance = 0;
		if (amt < 0) {
			throw new NegativeIntegerException("Input Amount Is Negative Number");
		} else {
			if (accountBalance < amt) {
				throw new InsufficientFundException("Insufficient Fund In Account");
			} else
				clearBalance = accountBalance - amt;
		}
		return clearBalance;
	}

}

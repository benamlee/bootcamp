package com.javahongkong.bootcamp.exercise;

import java.util.LinkedHashMap;

public class Bank implements BankInterface{
	private LinkedHashMap<Long, Account> accounts; // object reference
	static Long accountNumber = Long.valueOf(0);

	public Bank() {
		// complete the function
		this.accounts = new LinkedHashMap<>();
	}

	public Account getAccount(Long accountNumber) {
		// complete the function
		return this.accounts.get(accountNumber);
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		// complete the function
		this.accounts.put(accountNumber, new CommercialAccount(company, accountNumber, pin, startingDeposit));
		return accountNumber++;
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		// complete the function
		this.accounts.put(accountNumber, new ConsumerAccount(person, accountNumber, pin, startingDeposit));
		return accountNumber++;
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		// complete the function
		return getAccount(accountNumber).validatePin(pin);
	}

	public double getBalance(Long accountNumber) {
		// complete the function
		return getAccount(accountNumber).getBalance();
	}

	public void credit(Long accountNumber, double amount) {
		// complete the function
		getAccount(accountNumber).creditAccount(amount);
	}

	public boolean debit(Long accountNumber, double amount) {
		// complete the function
		return getAccount(accountNumber).debitAccount(amount);
	}
}

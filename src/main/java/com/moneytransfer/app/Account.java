package com.moneytransfer.app;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accountdata")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "Name_Surname")
	private String name;

	@Column(name = "Account_Balance")
	private double balance;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getBalance() {
		return balance;
	}

	public Account() {

	}

	public Account(String name, double balance) {
		this.name = name;
		this.balance = balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void creditAccount(double addedAmount) {
		this.balance = balance + addedAmount;
	}

	public void debitAccount(double deductedAmount) {
		this.balance = balance - deductedAmount;
	}

	// Transfer the money between the accounts
	public void transfer(Account from, Account to, double transferAmount) {
		
			from.debitAccount(transferAmount);
			to.creditAccount(transferAmount);
	}

	@Override
	public String toString() {
		return String.format("Accounts[ID=%d, Name Surname='%s', Account Balance='%s']", id, name, balance);
	}
}

package com.moneytransfer.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//This class in the main controller

@RestController
@RequestMapping(value = "/moneytransfer")
public class Controller {

	@Autowired
	AccountRepository accountRepository;

	Account myAccount = new Account();

	@GetMapping(value = "/account/all")
	public List<Account> getall() {
		return accountRepository.findAll();
	}

	@GetMapping("/account/{id}")
	public Account getAccountById(@PathVariable(value = "id") int id) {
		return accountRepository.findById(id);
	}

	@RequestMapping(value = "/transferMoney", method = RequestMethod.POST)
	public String tranfer(@RequestParam("fromaccount") int FromAccountId, @RequestParam("toaccount") int ToAccountId,
			@RequestParam("amount") double amount) {

		if ((accountRepository.existsById(FromAccountId)) == true
				&& (accountRepository.existsById(ToAccountId)) == true) {

			// Load account entities from the database and then update only the balance
			Account fromAccount = accountRepository.findById(FromAccountId);
			Account toAccount = accountRepository.findById(ToAccountId);

			double oldBalanceFrom = fromAccount.getBalance();
			double oldBalanceTo = toAccount.getBalance();

			myAccount.transfer(fromAccount, toAccount, amount);

			accountRepository.save(fromAccount);
			accountRepository.save(toAccount);

			return "AccountId: " + FromAccountId + " had balance " + oldBalanceFrom + " and has now balance "
					+ fromAccount.getBalance() + ". AccountId: " + ToAccountId + " had balance: " + oldBalanceTo
					+ " and has now balance " + toAccount.getBalance();
		} else {
			if (accountRepository.existsById(FromAccountId) == false) {
				return "We could not find Id: " + FromAccountId + " in the database";
			} else {
				return "We could not find Id: " + ToAccountId + " in the database";
			}
		}

	}
}

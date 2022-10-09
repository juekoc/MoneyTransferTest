package com.moneytransfer.app;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import com.moneytransfer.app.Account;

//Interface
public interface AccountRepository extends JpaRepository<Account, Integer> {

	// Spring Data JPA generates a query automatically given the name of the method.
	Account findById(int id);
}

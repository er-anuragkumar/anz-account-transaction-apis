package com.anz.account.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anz.account.model.Account;
import com.anz.account.repository.AccountRepository;

/**
 * 
 * @author Kumar, Anurag
 *
 */
@RestController
public class AccountController {
	private Logger logger = LoggerFactory.getLogger(AccountController.class);

	@Autowired
	AccountRepository repository;

	/**
	 * This service retrieves all the accounts.
	 * 
	 * @return Account Objects List JSON.
	 */
	@GetMapping(path = "/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Account> getAllAccounts() {
		logger.info("START: getAllAccounts");
		return repository.findAll();

	}

	/**
	 * This service retrieves account details with Account Number.
	 * 
	 * @param userId
	 * @param accountNumber
	 * @return Account Object JSON
	 */
	@GetMapping(path = "/accounts/search/account", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> getAccountByAccountNumber(@RequestParam("accountNumber") Long accountNumber) {

		logger.info("START: getAccountByAccountNumber, accountNumber: " + accountNumber);
		Account account = repository.getAccountByAccountNumber(accountNumber);
		ResponseEntity<Account> response = null;
		if (account == null) {
			response = new ResponseEntity<Account>(HttpStatus.NO_CONTENT);
		} else {
			response = new ResponseEntity<>(account, HttpStatus.OK);
		}
		logger.info("EXIT: getAccountByAccountNumber");
		return response;
	}

	/**
	 * This service retrieves all accounts associated with User Id.
	 * 
	 * @param userId
	 * @return Account Objects List JSON.
	 */
	@GetMapping(path = "/accounts/search/allaccounts", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Account>> getAllAccountsByUserId(@RequestParam("userId") String userId) {
		logger.info("START: getAllAccountsByUserId, userId: " + userId);

		List<Account> accounts = repository.getAllAccountsByUserId(userId);
		ResponseEntity<List<Account>> response = new ResponseEntity<>(accounts, HttpStatus.OK);
		if (accounts == null || accounts.isEmpty()) {
			response = new ResponseEntity<List<Account>>(HttpStatus.NO_CONTENT);
		}
		logger.info("EXIT: getAllAccountsByUserId");
		return response;
	}

}

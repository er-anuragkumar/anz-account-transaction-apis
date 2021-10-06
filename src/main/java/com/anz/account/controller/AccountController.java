package com.anz.account.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anz.account.exception.AccountNotFoundException;
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
	public ResponseEntity<List<Account>> getAllAccounts(@RequestParam(defaultValue = "0") Integer pageNo, @RequestParam(defaultValue = "10") Integer pageSize,
			@RequestParam(defaultValue = "accountNumber") String sortBy) throws AccountNotFoundException, Exception {
		logger.info("START: getAllAccounts");
		List<Account> accountsList = new ArrayList<Account>();
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		try {
			Page<Account> pagedResult = repository.findAll(paging);
			accountsList = pagedResult.getContent();
		} catch (Exception ex) {
			logger.error("Exception Occurred while Fetching All Accounts, " + ex.getMessage());
			throw new Exception("Exception Occurred while Fetching All Accounts, " + ex.getMessage());
		}
		ResponseEntity<List<Account>> response = null;
		if (accountsList == null || accountsList.isEmpty()) {
			throw new AccountNotFoundException("No Accounts Found.");
		} else {
			response = new ResponseEntity<>(accountsList, HttpStatus.OK);
		}
		logger.info("EXIT: getAllAccounts.");

		return response;

	}

	/**
	 * This service retrieves account details with Account Number.
	 * 
	 * @param account
	 * 
	 * @return Account Object JSON
	 */
	@PostMapping(path = "/accounts/search/account", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> getAccountByAccountNumber(@Valid @RequestBody Account account) throws AccountNotFoundException, Exception {
		long accountNumber = account.getAccountNumber();
		logger.info("START: getAccountByAccountNumber, accountNumber: " + accountNumber);

		try {
			account = repository.getAccountByAccountNumber(accountNumber);
		} catch (Exception ex) {
			logger.error("Exception Occurred while Fetching account details with accountNumber: " + accountNumber + ", " + ex.getMessage());
			throw new Exception("Exception Occurred while Fetching account details for accountNumber: " + accountNumber + ", " + ex.getMessage());
		}
		ResponseEntity<Account> response = null;
		if (account == null) {
			throw new AccountNotFoundException("Account Not Found with accountNumber: " + accountNumber);
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
	@PostMapping(path = "/accounts/search/allaccounts", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Account>> getAllAccountsByUserId(@Valid @RequestBody Account account, @RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "accountNumber") String sortBy) throws AccountNotFoundException, Exception {
		String userId = account.getUserId();
		logger.info("START: getAllAccountsByUserId, userId: " + userId);
		List<Account> accounts = new ArrayList<Account>();
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		try {
			accounts = repository.getAllAccountsByUserId(userId, paging);

		} catch (Exception ex) {
			logger.error("Exception Occurred while Fetching account details with userId: " + userId + ", " + ex.getMessage());
			throw new Exception("Exception Occurred while Fetching account details for userId: " + userId + ", " + ex.getMessage());
		}
		ResponseEntity<List<Account>> response = null;
		if (accounts == null || accounts.isEmpty()) {
			throw new AccountNotFoundException("Account Not Found with userId: " + userId);
		} else {
			response = new ResponseEntity<>(accounts, HttpStatus.OK);
		}
		logger.info("EXIT: getAllAccountsByUserId");
		return response;
	}

}

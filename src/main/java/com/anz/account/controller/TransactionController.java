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

import com.anz.account.exception.TransactionNotFoundException;
import com.anz.account.model.Account;
import com.anz.account.model.Transaction;
import com.anz.account.repository.TransactionRepository;

/**
 * 
 * @author Kumar, Anurag
 *
 */
@RestController
public class TransactionController {
	private Logger logger = LoggerFactory.getLogger(TransactionController.class);

	@Autowired
	TransactionRepository repository;

	/**
	 * This service retrieves all the transactions.
	 * 
	 * @return Transaction Object List JSON.
	 */
	@GetMapping(path = "/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Transaction>> getAllTransactions(@RequestParam(defaultValue = "0") Integer pageNo, @RequestParam(defaultValue = "10") Integer pageSize,
			@RequestParam(defaultValue = "transactionId") String sortBy) throws TransactionNotFoundException, Exception {
		logger.info("START: getAllTransactions");
		List<Transaction> transactionList = new ArrayList<Transaction>();
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		try {
			Page<Transaction> pagedResult = repository.findAll(paging);
			transactionList = pagedResult.getContent();
		} catch (Exception ex) {
			logger.error("Exception Occurred while Fetching All Transactions" + ", " + ex.getMessage());
			throw new Exception("Exception Occurred while Fetching All Transactions, " + ex.getMessage());
		}
		ResponseEntity<List<Transaction>> response = null;
		if (transactionList == null || transactionList.isEmpty()) {
			throw new TransactionNotFoundException("No Transactions Found.");
		} else {
			response = new ResponseEntity<>(transactionList, HttpStatus.OK);
		}
		logger.info("EXIT: getAllTransactions.");

		return response;

	}

	/**
	 * This service retrieves transaction details with transactionId.
	 * 
	 * @param transaction
	 * @return Transaction Object JSON
	 */
	@PostMapping(path = "/transactions/search/transaction", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Transaction> getTransactionByTransactionId(@Valid @RequestBody Transaction transaction) throws TransactionNotFoundException, Exception {
		long transactionId = transaction.getTransactionId();
		logger.info("START: getTransactionByTransactionId, transactionId: " + transactionId);
		try {
			transaction = repository.getTransactionByTransactionId(transactionId);
		} catch (Exception ex) {
			logger.error("Exception Occurred while Fetching Transaction with transactionId: " + transactionId + ", " + ex.getMessage());
			throw new Exception("Exception Occurred while Fetching transaction details for transactionId: " + transactionId + ", " + ex.getMessage());

		}
		ResponseEntity<Transaction> response = null;
		if (transaction == null) {
			throw new TransactionNotFoundException("Transaction Not Found with transactionId: " + transactionId);
		} else {
			response = new ResponseEntity<>(transaction, HttpStatus.OK);
		}
		logger.info("EXIT: getTransactionByTransactionId");
		return response;
	}

	/**
	 * This service retrieves all transactions details associated with Account
	 * Number.
	 * 
	 * @param userId
	 * @param accountNumber
	 * @return Transaction Object List JSON.
	 */
	@PostMapping(path = "/transactions/search/alltransactions", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Transaction>> getAllTransactionByAccountNumber(@Valid @RequestBody Account account, @RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "transactionId") String sortBy) throws TransactionNotFoundException, Exception {
		long accountNumber = account.getAccountNumber();
		logger.info("START: getAllTransactionByAccountNumber, accountNumber: " + accountNumber);
		List<Transaction> transactions = new ArrayList<Transaction>();
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		try {
			transactions = repository.getTransactionByAccount(account, paging);
		} catch (Exception ex) {
			logger.error("Exception Occurred while Fetching All Transaction with accountNumber: " + accountNumber + ", " + ex.getMessage());
			throw new Exception("Exception Occurred while Fetching All transaction detail for accountNumber: " + accountNumber + ", " + ex.getMessage());

		}
		ResponseEntity<List<Transaction>> response = null;
		if (transactions == null || transactions.isEmpty()) {
			throw new TransactionNotFoundException("Transactions Not Found with accountNumber: " + accountNumber);
		} else {
			response = new ResponseEntity<>(transactions, HttpStatus.OK);
		}

		logger.info("EXIT: getAllTransactionByAccountNumber");
		return response;

	}

}

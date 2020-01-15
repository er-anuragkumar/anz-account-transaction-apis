package com.anz.account.controller;

import java.util.ArrayList;
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
	public List<Transaction> getAllTransactions() {
		logger.info("START: getAllAccounts");
		return repository.findAll();

	}

	/**
	 * This service retrieves transaction details with transactionId.
	 * 
	 * @param userId
	 * @param accountNumber
	 * @return Transaction Object JSON
	 */
	@GetMapping(path = "/transactions/search/transaction", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Transaction> getTransactionByTransactionId(@RequestParam("transactionId") Long transactionId) {

		logger.info("START: getTransactionByTransactionId, transactionId: " + transactionId);
		Transaction transaction = repository.getTransactionByTransactionId(transactionId);
		ResponseEntity<Transaction> response = null;
		if (transaction == null) {
			response = new ResponseEntity<Transaction>(HttpStatus.NO_CONTENT);
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
	@GetMapping(path = "/transactions/search/alltransactions", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Transaction>> getAllTransactionByAccountNumber(@RequestParam("accountNumber") Long accountNumber) {

		logger.info("START: getAllTransactionByAccountNumber, accountNumber: " + accountNumber);
		List<Transaction> transactionList = new ArrayList<Transaction>();
		List<Transaction> transactions = repository.findAll();
		for (Transaction transaction : transactions) {
			if (transaction.getAccount().getAccountNumber() == accountNumber) {
				transactionList.add(transaction);
			}
		}

		ResponseEntity<List<Transaction>> response = new ResponseEntity<>(transactionList, HttpStatus.OK);
		if (transactionList == null || transactionList.isEmpty()) {
			response = new ResponseEntity<List<Transaction>>(HttpStatus.NO_CONTENT);
		}
		logger.info("EXIT: getAllTransactionByAccountNumber");
		return response;

	}

}

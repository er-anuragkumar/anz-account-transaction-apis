package com.anz.account.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.anz.account.controller.TransactionController;
import com.anz.account.exception.TransactionNotFoundException;
import com.anz.account.model.Account;
import com.anz.account.model.Transaction;

import org.junit.runner.RunWith;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.*;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Kumar, Anurag
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(TransactionController.class)
@AutoConfigureMockMvc(addFilters = false)
public class AnzTransactionControllerMvcTest {

	private Logger logger = LoggerFactory.getLogger(AnzTransactionControllerMvcTest.class);
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private TransactionController transactionController;

	@Test
	public void getAllTransactions_200_Success() throws TransactionNotFoundException, Exception {
		logger.info("Inside getAllTransactions_200_Success() Test.");
		List<Transaction> transactionList = new ArrayList<Transaction>();

		Transaction transaction = Transaction.builder().accountName("SGSaving726").creditAmount(9540.98).currency("SGD").transactionId(1).type("credit").build();

		transactionList.add(transaction);
		ResponseEntity<List<Transaction>> response = new ResponseEntity<>(transactionList, HttpStatus.OK);

		Mockito.when(transactionController.getAllTransactions(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt(), ArgumentMatchers.anyString())).thenReturn(response);

		mockMvc.perform(get("/transactions")).andExpect(status().isOk());
	}

	@Test
	public void getTransactionByTransactionId_200_Success() throws TransactionNotFoundException, Exception {
		logger.info("Inside getTransactionByTransactionId_200_Success() Test.");
		Transaction transaction = Transaction.builder().accountName("SGSaving726").creditAmount(9540.98).currency("SGD").transactionId(1).type("credit").build();

		ResponseEntity<Transaction> response = new ResponseEntity<>(transaction, HttpStatus.OK);

		Mockito.when(transactionController.getTransactionByTransactionId(ArgumentMatchers.any(Transaction.class))).thenReturn(response);

		mockMvc.perform(post("/transactions/search/transaction").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(transaction))).andExpect(status().isOk());
	}

	@Test
	public void getTransactionByTransactionId_400_BadRequest() throws TransactionNotFoundException, Exception {
		logger.info("Inside getTransactionByTransactionId_400_BadRequest() Test.");
		Transaction transaction = Transaction.builder().accountName("SGSaving726").creditAmount(9540.98).currency("SGD").transactionId(1).type("credit").build();

		ResponseEntity<Transaction> response = new ResponseEntity<>(transaction, HttpStatus.BAD_REQUEST);

		Mockito.when(transactionController.getTransactionByTransactionId(ArgumentMatchers.isNull())).thenReturn(response);

		mockMvc.perform(post("/transactions/search/transaction")).andExpect(status().isBadRequest());
	}

	@Test
	public void getAllTransactionByAccountNumber_200_Success() throws TransactionNotFoundException, Exception {
		logger.info("Inside getAllTransactionByAccountNumber_200_Success() Test.");
		List<Transaction> transactionList = new ArrayList<Transaction>();
		Transaction transaction = Transaction.builder().accountName("SGSaving726").creditAmount(9540.98).currency("SGD").transactionId(1).type("credit").build();
		transactionList.add(transaction);
		Account account = Account.builder().accountName("SGSaving726").accountNumber(9467563420L).accountType("Savings").balance(84327.51).currency("SGD").userId("AU2344").build();
		ResponseEntity<List<Transaction>> response = new ResponseEntity<>(transactionList, HttpStatus.OK);

		Mockito.when(transactionController.getAllTransactionByAccountNumber(ArgumentMatchers.any(Account.class), ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt(), ArgumentMatchers.anyString()))
				.thenReturn(response);

		mockMvc.perform(post("/transactions/search/alltransactions").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(account))).andExpect(status().isOk());
	}

	@Test
	public void getAllTransactionByAccountNumber_400_BadRequest() throws TransactionNotFoundException, Exception {
		logger.info("Inside getAllTransactionByAccountNumber_400_BadRequest() Test.");
		List<Transaction> transactionList = new ArrayList<Transaction>();
		Transaction transaction = Transaction.builder().accountName("SGSaving726").creditAmount(9540.98).currency("SGD").transactionId(1).type("credit").build();
		transactionList.add(transaction);
		Account account = Account.builder().accountName("SGSaving726").accountNumber(9467563420L).accountType("Savings").balance(84327.51).currency("SGD").userId("AU2344").build();
		ResponseEntity<List<Transaction>> response = new ResponseEntity<>(transactionList, HttpStatus.BAD_REQUEST);

		Mockito.when(transactionController.getAllTransactionByAccountNumber(ArgumentMatchers.isNull(), ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt(), ArgumentMatchers.anyString()))
				.thenReturn(response);

		mockMvc.perform(post("/transactions/search/alltransactions")).andExpect(status().isBadRequest());
	}

}

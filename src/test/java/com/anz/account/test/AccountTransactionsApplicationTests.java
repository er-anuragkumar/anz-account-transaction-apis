package com.anz.account.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.anz.account.controller.AccountController;
import com.anz.account.controller.TransactionController;
import com.anz.account.model.Account;
import com.anz.account.model.Transaction;
import com.anz.account.repository.AccountRepository;
import com.anz.account.repository.TransactionRepository;

import org.mockito.junit.MockitoJUnitRunner;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * 
 * @author Kumar, Anurag
 *
 */

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class AccountTransactionsApplicationTests {

	private Logger logger = LoggerFactory.getLogger(AccountTransactionsApplicationTests.class);

	@Test
	public void contextLoads() {
		logger.info("START: contextLoads().");
	}

	@Mock
	private AccountRepository accountRepository;
	@InjectMocks
	private AccountController accountController;
	@Mock
	private TransactionRepository transactionRepository;
	@InjectMocks
	private TransactionController transactionController;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAccountByAccountNumber() throws ParseException {
		logger.info("Inside getAccountByAccountNumber() Test.");
		Account account = Account.builder().accountName("SGSaving726").accountNumber(9467563420L).accountType("Savings").balance(84327.51).currency("SGD").userId("AU2344").build();

		when(accountRepository.getAccountByAccountNumber(946756342)).thenReturn(account);

		Account testAccount = accountRepository.getAccountByAccountNumber(946756342);

		assertEquals(account, testAccount);
		verify(accountRepository, times(1)).getAccountByAccountNumber(946756342);

	}

	@Test
	public void getAllAccountsByUserId() throws ParseException {

		logger.info("Inside getAllAccountsByUserId Test");
		List<Account> accountList = new ArrayList<Account>();

		Account account = Account.builder().accountName("SGSaving726").accountNumber(9467563420L).accountType("Savings").balance(84327.51).currency("SGD").userId("AU2344").build();

		accountList.add(account);
		Pageable paging = PageRequest.of(0, 10, Sort.by("accountNumber"));

		when(accountRepository.getAllAccountsByUserId("AU2344", paging)).thenReturn(accountList);
		List<Account> accounts = accountRepository.getAllAccountsByUserId("AU2344", paging);

		assertEquals(1, accounts.size());
		verify(accountRepository, times(1)).getAllAccountsByUserId("AU2344", paging);

		logger.info("Inside getAllAccountsByUserId() :  accounts : " + accounts.size());

	}

	@Test
	public void getAllAccounts() throws ParseException {
		logger.info("Inside getAllAccounts Test");
		List<Account> accountList = new ArrayList<Account>();

		Account account = Account.builder().accountName("SGSaving726").accountNumber(9467563420L).accountType("Savings").balance(84327.51).currency("SGD").userId("AU2344").build();

		accountList.add(account);

		when(accountRepository.findAll()).thenReturn(accountList);
		List<Account> accounts = accountRepository.findAll();

		assertEquals(1, accounts.size());
		verify(accountRepository, times(1)).findAll();

		logger.info("getAllAccounts() : accounts: " + accounts.size());
	}

	@Test
	public void getTransactionByTransactionId() throws ParseException {

		logger.info("Inside getTransactionByTransactionId Test");
		Account account = Account.builder().accountName("SGSaving726").accountNumber(9467563420L).accountType("Savings").balance(84327.51).currency("SGD").userId("AU2344").build();

		Transaction transaction = Transaction.builder().account(account).accountName("SGSaving726").creditAmount(9540.98).currency("SGD").transactionId(1).type("credit").build();

		when(transactionRepository.getTransactionByTransactionId(1)).thenReturn(transaction);

		Transaction testTransaction = transactionRepository.getTransactionByTransactionId(1);

		assertEquals(transaction, testTransaction);
		verify(transactionRepository, times(1)).getTransactionByTransactionId(1);
		logger.info("Inside getTransactionByTransactionId() :  transaction : " + testTransaction.toString());

	}

	@Test
	public void getAllTransactions() throws ParseException {
		logger.info("Inside getAllTransactions Test");
		List<Transaction> transactionList = new ArrayList<Transaction>();

		Account account = Account.builder().accountName("SGSaving726").accountNumber(9467563420L).accountType("Savings").balance(84327.51).currency("SGD").userId("AU2344").build();

		Transaction transactionOne = Transaction.builder().account(account).accountName("SGSaving726").creditAmount(9540.98).currency("SGD").transactionId(1).type("credit").build();
		Transaction transactionTwo = Transaction.builder().account(account).accountName("SGSaving726").creditAmount(9540.98).currency("AUD").transactionId(2).type("credit").build();

		transactionList.add(transactionOne);
		transactionList.add(transactionTwo);
		account.setTransactions(transactionList);

		when(transactionRepository.findAll()).thenReturn(transactionList);
		List<Transaction> transactions = transactionRepository.findAll();

		assertEquals(2, transactions.size());
		verify(transactionRepository, times(1)).findAll();

		logger.info("getAllTransactions() : transactions: " + transactions.size());
	}

}

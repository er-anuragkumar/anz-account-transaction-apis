package com.anz.account.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
		List<Transaction> transactionList = new ArrayList<Transaction>();
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
		Account account = new Account();
		account.setAccountName("SGSaving726");
		account.setAccountNumber(9467563420L);
		account.setAccountType("Savings");
		account.setBalance(84327.51);
		account.setBalanceDate(format.parse("08/12/2012"));
		account.setCurrency("SGD");

		account.setUserId("AU2344");

		Transaction transaction_one = new Transaction();
		transaction_one.setAccount(account);
		transaction_one.setAccountName("SGSaving726");
		transaction_one.setCreditAmount(9540.98);
		transaction_one.setCurrency("SGD");
		transaction_one.setDebitAmount(0);
		transaction_one.setDescription("Interest Received");
		transaction_one.setTransactionDate("12/01/2012");
		transaction_one.setTransactionId(1);
		transaction_one.setType("credit");

		Transaction transaction_two = new Transaction();
		transaction_two.setAccount(account);
		transaction_two.setAccountName("SGSaving726");
		transaction_two.setCreditAmount(5000);
		transaction_two.setCurrency("SGD");
		transaction_two.setDebitAmount(0);
		transaction_two.setDescription("Interest Received");
		transaction_two.setTransactionDate("12/01/2012");
		transaction_two.setTransactionId(2);
		transaction_two.setType("credit");

		transactionList.add(transaction_one);
		transactionList.add(transaction_two);
		account.setTransactions(transactionList);

		when(accountRepository.getAccountByAccountNumber(946756342)).thenReturn(account);

		Account testAccount = accountRepository.getAccountByAccountNumber(946756342);

		assertEquals(account, testAccount);
		verify(accountRepository, times(1)).getAccountByAccountNumber(946756342);

	}

	@Test
	public void getAllAccountsByUserId() throws ParseException {

		logger.info("Inside getAllAccountsByUserId Test");
		List<Account> accountList = new ArrayList<Account>();
		List<Transaction> transactionList = new ArrayList<Transaction>();
		DateFormat format = new SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH);

		Account account = new Account();
		account.setAccountName("SGSaving726");
		account.setAccountNumber(946756342L);
		account.setAccountType("Savings");
		account.setBalance(84327.51);
		account.setBalanceDate(format.parse("08/12/2012"));
		account.setCurrency("SGD");

		account.setUserId("AU2344");

		Transaction transaction_one = new Transaction();
		transaction_one.setAccount(account);
		transaction_one.setAccountName("SGSaving726");
		transaction_one.setCreditAmount(9540.98);
		transaction_one.setCurrency("SGD");
		transaction_one.setDebitAmount(0);
		transaction_one.setDescription("Interest Received");
		transaction_one.setTransactionDate("12/01/2012");
		transaction_one.setTransactionId(1);
		transaction_one.setType("credit");

		Transaction transaction_two = new Transaction();
		transaction_two.setAccount(account);
		transaction_two.setAccountName("SGSaving726");
		transaction_two.setCreditAmount(5000);
		transaction_two.setCurrency("SGD");
		transaction_two.setDebitAmount(0);
		transaction_two.setDescription("Interest Received");
		transaction_two.setTransactionDate("12/01/2012");
		transaction_two.setTransactionId(2);
		transaction_two.setType("credit");

		transactionList.add(transaction_one);
		transactionList.add(transaction_two);
		account.setTransactions(transactionList);

		accountList.add(account);

		when(accountRepository.getAllAccountsByUserId("AU2344")).thenReturn(accountList);
		List<Account> accounts = accountRepository.getAllAccountsByUserId("AU2344");

		assertEquals(1, accounts.size());
		verify(accountRepository, times(1)).getAllAccountsByUserId("AU2344");

		logger.info("Inside getAllAccountsByUserId() :  accounts : " + accounts.size());

	}

	@Test
	public void getAllAccounts() throws ParseException {
		logger.info("Inside getAllAccounts Test");
		List<Account> accountList = new ArrayList<Account>();
		List<Transaction> transactionList = new ArrayList<Transaction>();
		DateFormat format = new SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH);

		Account account = new Account();
		account.setAccountName("SGSaving726");
		account.setAccountNumber(946756342L);
		account.setAccountType("Savings");
		account.setBalance(84327.51);
		account.setBalanceDate(format.parse("08/12/2012"));
		account.setCurrency("SGD");

		account.setUserId("AU2344");

		Transaction transaction_one = new Transaction();
		transaction_one.setAccount(account);
		transaction_one.setAccountName("SGSaving726");
		transaction_one.setCreditAmount(9540.98);
		transaction_one.setCurrency("SGD");
		transaction_one.setDebitAmount(0);
		transaction_one.setDescription("Interest Received");
		transaction_one.setTransactionDate("12/01/2012");
		transaction_one.setTransactionId(1);
		transaction_one.setType("credit");

		Transaction transaction_two = new Transaction();
		transaction_two.setAccount(account);
		transaction_two.setAccountName("SGSaving726");
		transaction_two.setCreditAmount(5000);
		transaction_two.setCurrency("SGD");
		transaction_two.setDebitAmount(0);
		transaction_two.setDescription("Interest Received");
		transaction_two.setTransactionDate("12/01/2012");
		transaction_two.setTransactionId(2);
		transaction_two.setType("credit");

		transactionList.add(transaction_one);
		transactionList.add(transaction_two);
		account.setTransactions(transactionList);

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
		DateFormat format = new SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH);
		Account account = new Account();
		account.setAccountName("SGSaving726");
		account.setAccountNumber(946756342L);
		account.setAccountType("Savings");
		account.setBalance(84327.51);
		account.setBalanceDate(format.parse("08/12/2012"));
		account.setCurrency("SGD");

		account.setUserId("AU2344");

		Transaction transaction = new Transaction();
		transaction.setAccount(account);
		transaction.setAccountName("SGSaving726");
		transaction.setCreditAmount(9540.98);
		transaction.setCurrency("SGD");
		transaction.setDebitAmount(0);
		transaction.setDescription("Interest Received");
		transaction.setTransactionDate("12/01/2012");
		transaction.setTransactionId(1);
		transaction.setType("credit");

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
		DateFormat format = new SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH);

		Account account = new Account();
		account.setAccountName("SGSaving726");
		account.setAccountNumber(946756342L);
		account.setAccountType("Savings");
		account.setBalance(84327.51);
		account.setBalanceDate(format.parse("08/12/2012"));
		account.setCurrency("SGD");

		account.setUserId("AU2344");

		Transaction transaction_one = new Transaction();
		transaction_one.setAccount(account);
		transaction_one.setAccountName("SGSaving726");
		transaction_one.setCreditAmount(9540.98);
		transaction_one.setCurrency("SGD");
		transaction_one.setDebitAmount(0);
		transaction_one.setDescription("Interest Received");
		transaction_one.setTransactionDate("12/01/2012");
		transaction_one.setTransactionId(1);
		transaction_one.setType("credit");

		Transaction transaction_two = new Transaction();
		transaction_two.setAccount(account);
		transaction_two.setAccountName("SGSaving726");
		transaction_two.setCreditAmount(5000);
		transaction_two.setCurrency("SGD");
		transaction_two.setDebitAmount(0);
		transaction_two.setDescription("Interest Received");
		transaction_two.setTransactionDate("12/01/2012");
		transaction_two.setTransactionId(2);
		transaction_two.setType("credit");

		transactionList.add(transaction_one);
		transactionList.add(transaction_two);
		account.setTransactions(transactionList);

		when(transactionRepository.findAll()).thenReturn(transactionList);
		List<Transaction> transactions = transactionRepository.findAll();

		assertEquals(2, transactions.size());
		verify(transactionRepository, times(1)).findAll();

		logger.info("getAllTransactions() : transactions: " + transactions.size());
	}

}

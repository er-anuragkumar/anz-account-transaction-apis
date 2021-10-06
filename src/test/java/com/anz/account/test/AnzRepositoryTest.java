package com.anz.account.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.anz.account.model.Account;
import com.anz.account.model.Transaction;
import com.anz.account.repository.AccountRepository;
import com.anz.account.repository.TransactionRepository;

import org.junit.runner.RunWith;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * 
 * @author Kumar, Anurag
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class AnzRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(AnzRepositoryTest.class);

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private TestEntityManager testEntityManager;

	@Test
	public void testAccountRepository() {
		logger.info("Inside testAccountRepository() Test.");
		Account account = Account.builder().accountName("SGSaving7261").accountNumber(9467563421L).accountType("Savings").balance(84327.51).currency("SGD").userId("AU23441").build();
		testEntityManager.persist(account);
		Account acc = accountRepository.getAccountByAccountNumber(9467563421L);

		assertThat(acc.getAccountNumber()).isEqualTo(account.getAccountNumber());
	}

	@Test
	public void testTransactionRepository() {
		logger.info("Inside testTransactionRepository() Test.");
		Transaction transaction = Transaction.builder().accountName("SGSaving7262").creditAmount(9540.98).currency("SGD").type("credit").build();
		testEntityManager.persist(transaction);
		Transaction tran = transactionRepository.getTransactionByTransactionId(transaction.getTransactionId());

		assertThat(tran.getTransactionId()).isEqualTo(transaction.getTransactionId());
	}

}

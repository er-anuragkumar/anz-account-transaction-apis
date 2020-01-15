package com.anz.account;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * 
 * @author Kumar, Anurag
 *
 */
@SpringBootTest
public class AccountTransactionsApplicationTests {
	
	private Logger logger = LoggerFactory.getLogger(AccountTransactionsApplicationTests.class);

	@Test
	public void contextLoads() {
		logger.info("START: contextLoads().");
	}

}

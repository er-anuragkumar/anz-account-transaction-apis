package com.anz.account.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.anz.account.controller.AccountController;
import com.anz.account.exception.AccountNotFoundException;
import com.anz.account.model.Account;
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
@WebMvcTest(AccountController.class)
@AutoConfigureMockMvc(addFilters = false)
public class AnzAccountControllerMvcTest {

	private Logger logger = LoggerFactory.getLogger(AnzAccountControllerMvcTest.class);
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private AccountController accountController;

	@Test
	public void getAllAccounts_200_Success() throws AccountNotFoundException, Exception {
		logger.info("Inside getAllAccounts_200_Success() Test.");
		Account account = Account.builder().accountName("SGSaving726").accountNumber(9467563420L).accountType("Savings").balance(84327.51).currency("SGD").userId("AU2344").build();
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(account);
		ResponseEntity<List<Account>> response = new ResponseEntity<>(accounts, HttpStatus.OK);

		Mockito.when(accountController.getAllAccounts(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt(), ArgumentMatchers.anyString())).thenReturn(response);

		mockMvc.perform(get("/accounts")).andExpect(status().isOk());
	}

	@Test
	public void getAccountByAccountNumber_200_Success() throws AccountNotFoundException, Exception {
		logger.info("Inside getAccountByAccountNumber_200_Success() Test.");
		Account account = Account.builder().accountName("SGSaving726").accountNumber(9467563420L).accountType("Savings").balance(84327.51).currency("SGD").userId("AU2344").build();
		ResponseEntity<Account> response = new ResponseEntity<>(account, HttpStatus.OK);

		Mockito.when(accountController.getAccountByAccountNumber(ArgumentMatchers.any(Account.class))).thenReturn(response);

		mockMvc.perform(post("/accounts/search/account").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(account))).andExpect(status().isOk());
	}

	@Test
	public void getAccountByAccountNumber_400_BadRequest() throws AccountNotFoundException, Exception {
		logger.info("Inside getAccountByAccountNumber_400_BadRequest() Test.");
		Account account = Account.builder().accountName("SGSaving726").accountNumber(9467563420L).accountType("Savings").balance(84327.51).currency("SGD").userId("AU2344").build();
		ResponseEntity<Account> response = new ResponseEntity<>(account, HttpStatus.BAD_REQUEST);

		Mockito.when(accountController.getAccountByAccountNumber(ArgumentMatchers.isNull())).thenReturn(response);

		mockMvc.perform(post("/accounts/search/account")).andExpect(status().isBadRequest());
	}

	@Test
	public void getAllAccountsByUserId_200_Success() throws AccountNotFoundException, Exception {
		logger.info("Inside getAllAccountsByUserId_200_Success() Test.");
		Account account = Account.builder().accountName("SGSaving726").accountNumber(9467563420L).accountType("Savings").balance(84327.51).currency("SGD").userId("AU2344").build();
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(account);
		ResponseEntity<List<Account>> response = new ResponseEntity<>(accounts, HttpStatus.OK);

		Mockito.when(accountController.getAllAccountsByUserId(ArgumentMatchers.any(Account.class), ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt(), ArgumentMatchers.anyString()))
				.thenReturn(response);

		mockMvc.perform(post("/accounts/search/allaccounts").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(account))).andExpect(status().isOk());
	}

	@Test
	public void getAllAccountsByUserId_400_BadRequest() throws AccountNotFoundException, Exception {
		logger.info("Inside getAllAccountsByUserId_400_BadRequest() Test.");
		Account account = Account.builder().accountName("SGSaving726").accountNumber(9467563420L).accountType("Savings").balance(84327.51).currency("SGD").userId("AU2344").build();
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(account);
		ResponseEntity<List<Account>> response = new ResponseEntity<>(accounts, HttpStatus.BAD_REQUEST);

		Mockito.when(accountController.getAllAccountsByUserId(ArgumentMatchers.isNull(), ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt(), ArgumentMatchers.anyString())).thenReturn(response);
		mockMvc.perform(post("/accounts/search/allaccounts")).andExpect(status().isBadRequest());
	}

}

package com.anz.account.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anz.account.model.Account;

/**
 * 
 * @author Kumar, Anurag
 *
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	List<Account> getAllAccountsByUserId(String userId, Pageable pageable);

	Account getAccountByAccountNumber(long accountNumber);

}

package com.anz.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anz.account.model.Transaction;

/**
 * 
 * @author Kumar, Anurag
 *
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	Transaction getTransactionByTransactionId(long transactionId);

}

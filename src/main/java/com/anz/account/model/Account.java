package com.anz.account.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * 
 * @author Kumar, Anurag
 *
 */
@Entity
@Data
public class Account {
	@Id
	private Long accountNumber;
	private String accountName;
	private String accountType;
	private Date balanceDate;
	private String currency;
	private Double balance;
	private String userId;

	@OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Transaction> transactions;

}

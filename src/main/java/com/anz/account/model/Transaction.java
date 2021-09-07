package com.anz.account.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * 
 * @author Kumar, Anurag
 *
 */
@Entity
@Data
public class Transaction extends ResourceSupport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long transactionId;
	private String transactionDate;
	private String currency;
	private double debitAmount;
	private double creditAmount;
	private String type;
	private String description;
	private String accountName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Account account;

}

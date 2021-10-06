package com.anz.account.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Kumar, Anurag
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Users {
	@Id
	private String user;
	private String pwd;
	private String token;
	private String expiration;

}

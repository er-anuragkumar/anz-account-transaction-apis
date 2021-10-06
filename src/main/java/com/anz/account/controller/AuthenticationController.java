package com.anz.account.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anz.account.model.Users;
import com.anz.account.repository.UserRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 
 * @author Kumar, Anurag
 *
 */
@RestController
public class AuthenticationController {
	private Logger logger = LoggerFactory.getLogger(AccountController.class);
	@Autowired
	UserRepository repository;

	/**
	 * This service validates username/password and generates JWT Bearer Token
	 * 
	 * @param user
	 * @return User Object with JWT Token
	 */
	@PostMapping("/auth")
	public Users login(@Valid @RequestBody Users user) throws UsernameNotFoundException, Exception {
		logger.info("START: login");
		/*
		 * TODO: For this demo application we are validating user against local
		 * H2 Database which can be changed to an external Identity Provider.
		 * 
		 */

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Users validUser = null;
		if (!StringUtils.isEmpty(user.getUser()) && !StringUtils.isEmpty(user.getPwd())) {
			Users authUser = repository.findByUser(user.getUser());
			if (authUser != null) {
				if (encoder.matches(user.getPwd().trim(), authUser.getPwd())) {
					String token = getJWTToken(authUser.getUser());
					validUser = new Users().builder().token(token).user(authUser.getUser()).pwd("").expiration("600").build();
				} else {
					throw new Exception("Password not valid.");
				}
			} else {
				throw new UsernameNotFoundException("User Not Found with UserName: " + user.getUser());
			}
		} else {
			throw new Exception("UserName & Password cannot be blank");
		}
		logger.info("EXIT: login");
		return validUser;
	}

	/**
	 * This Method Generates JWT Bearer Token for Authentication with username
	 * 
	 * @param username
	 * @return String JWT Token
	 */
	private String getJWTToken(String username) {
		String secretKey = "ANZTestSecretKey@123!";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

		String token = Jwts.builder().setId("softtekJWT").setSubject(username).claim("authorities", grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis() + 600000)).signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
}
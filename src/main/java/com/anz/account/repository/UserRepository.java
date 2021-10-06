package com.anz.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anz.account.model.Users;

/**
 * 
 * @author Kumar, Anurag
 *
 */
@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

	Users findByUser(String user);

}

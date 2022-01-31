package com.eteration.simplebanking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.model.DepositTransaction;
import com.eteration.simplebanking.model.WithdrawalTransaction;

@Repository
public interface IAccountRepository  extends JpaRepository<Account, Integer>{

	/*
	@Query(nativeQuery = true,value="select * from account a where a.account_number=?1")
    Account findAccount(String accountNumber);
    */
	Account findByAccountNumber(String accountNumber);
}

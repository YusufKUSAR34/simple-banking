package com.eteration.simplebanking.services;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.model.DepositTransaction;
import com.eteration.simplebanking.model.InsufficientBalanceException;
import com.eteration.simplebanking.model.Transaction;
import com.eteration.simplebanking.model.WithdrawalTransaction;
import com.eteration.simplebanking.repository.IAccountRepository;


@Service
//@Transactional
public class AccountService implements IAccountService {

	@Autowired
      private IAccountRepository accountRepository;
	 @Override
	    public Account findAccount(String accountNumber) {
	        return accountRepository.findByAccountNumber(accountNumber);
	    }

	    @Override
	    public void saveAccount(Account account) {
	        accountRepository.save(account);
	    }
	
	
}

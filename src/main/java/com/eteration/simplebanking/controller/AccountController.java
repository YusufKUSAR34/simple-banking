package com.eteration.simplebanking.controller;


import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.model.DepositTransaction;
import com.eteration.simplebanking.model.InsufficientBalanceException;
import com.eteration.simplebanking.model.Transaction;
import com.eteration.simplebanking.model.WithdrawalTransaction;
import com.eteration.simplebanking.services.IAccountService;
import com.eteration.simplebanking.util.ApprovalCode;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

// This class is a place holder you can change the complete implementation
@RestController
@RequestMapping("/account/v1")
public class AccountController {
	
	 @Autowired
	    private IAccountService accountService;

	    @GetMapping(value = "/{accountNumber}")
	    public ResponseEntity<Account> getAccount(@PathVariable("accountNumber") String accountNumber) throws JsonProcessingException {
	        Account account = accountService.findAccount(accountNumber);

	        HttpHeaders headers = new HttpHeaders();
	        headers.add("Content-Type", "application/json;");
	        ObjectMapper mapper = new ObjectMapper();
	        mapper.writeValueAsString(account);

	        return (new ResponseEntity<>(account, headers, HttpStatus.OK));
	    }

	    @PostMapping
	    public void saveAccount(@Validated @RequestBody Account account) {
	        accountService.saveAccount(account);
	    }

	    @PostMapping(value = "/credit/{accountNumber}")
	    public ResponseEntity<TransactionStatus> credit(@PathVariable("accountNumber") String accountNumber,
	                                                    @RequestBody DepositTransaction transaction)
	            throws InsufficientBalanceException {

	        Account account = accountService.findAccount(accountNumber);

	        HttpHeaders headers = new HttpHeaders();
	        headers.add("Content-Type", "application/json;");

	        String approvalCode = ApprovalCode.generateRandomStringByUUID();

	        DepositTransaction depositTransaction = new DepositTransaction(transaction.getAmount());

	        transaction.setAmount(transaction.getAmount());
	        transaction.setType("DepositTransaction");
	        transaction.setDate(depositTransaction.getDate());
	        transaction.setApprovalCode(approvalCode);
	        account.post(transaction);

	        accountService.saveAccount(account);
	        TransactionStatus transactionStatus = new TransactionStatus();
	        transactionStatus.setApprovalCode(approvalCode);

	        return new ResponseEntity<TransactionStatus>(transactionStatus, headers, HttpStatus.OK);
	    }

	    @PostMapping(value = "/debit/{accountNumber}")
	    public ResponseEntity<TransactionStatus> debit(@PathVariable("accountNumber") String accountNumber,
	                                                   @RequestBody WithdrawalTransaction transaction)
	            throws InsufficientBalanceException {

	        Account account = accountService.findAccount(accountNumber);

	        if (Optional.ofNullable(account).isPresent()) {

	            HttpHeaders headers = new HttpHeaders();
	            headers.add("Content-Type", "application/json;");

	            String approvalCode = ApprovalCode.generateRandomStringByUUID();

	            WithdrawalTransaction withdrawalTransaction = new WithdrawalTransaction(transaction.getAmount());
	            transaction.setAmount(transaction.getAmount());
	            transaction.setType("WithdrawalTransaction");
	            transaction.setDate(withdrawalTransaction.getDate());
	            transaction.setApprovalCode(approvalCode);
	            account.post(transaction);

	            accountService.saveAccount(account);

	            TransactionStatus transactionStatus = new TransactionStatus();
	            transactionStatus.setApprovalCode(approvalCode);

	            return new ResponseEntity<TransactionStatus>(transactionStatus, headers, HttpStatus.OK);
	        }

	        return new ResponseEntity(HttpStatus.NO_CONTENT);
	    }

 
}
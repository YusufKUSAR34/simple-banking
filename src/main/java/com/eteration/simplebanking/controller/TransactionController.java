package com.eteration.simplebanking.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eteration.simplebanking.model.DepositTransaction;
import com.eteration.simplebanking.services.ITransactionService;

@RestController
@RequestMapping("/transaction/v1/")
public class TransactionController {

	 @Autowired
	    private ITransactionService transactionService;

	    @PostMapping
	    public void createDepositTransaction(@Validated @RequestBody DepositTransaction depositTransaction) {
	        transactionService.createDepositTransaction(depositTransaction);
	    }
}

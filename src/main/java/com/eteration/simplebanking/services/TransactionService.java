package com.eteration.simplebanking.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eteration.simplebanking.model.DepositTransaction;
import com.eteration.simplebanking.repository.ITransactionRepository;

@Service
public class TransactionService  implements ITransactionService{

	  @Autowired
	    private ITransactionRepository transactionRepository;

	    @Override
	    public Optional<DepositTransaction> findById(int id) {
	        return transactionRepository.findById(id);
	    }

	    @Override
	    public void createDepositTransaction(DepositTransaction depositTransaction) {
	        transactionRepository.save(depositTransaction);
	    }
}

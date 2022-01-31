package com.eteration.simplebanking.services;

import java.util.Optional;

import com.eteration.simplebanking.model.DepositTransaction;

public interface ITransactionService {
	 Optional<DepositTransaction> findById(int id);

	    void createDepositTransaction(DepositTransaction depositTransaction);
}

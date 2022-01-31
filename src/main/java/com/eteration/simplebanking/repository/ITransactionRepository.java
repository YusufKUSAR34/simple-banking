package com.eteration.simplebanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eteration.simplebanking.model.DepositTransaction;

@Repository
public interface ITransactionRepository  extends JpaRepository<DepositTransaction, Integer> {

}

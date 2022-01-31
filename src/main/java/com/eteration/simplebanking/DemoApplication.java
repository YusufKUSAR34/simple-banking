package com.eteration.simplebanking;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.model.DepositTransaction;
import com.eteration.simplebanking.model.InsufficientBalanceException;
import com.eteration.simplebanking.model.PhoneBillPaymentTransaction;
import com.eteration.simplebanking.model.Transaction;
import com.eteration.simplebanking.model.WithdrawalTransaction;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws InsufficientBalanceException {
		SpringApplication.run(DemoApplication.class, args);
	       

		

		
		


}
}
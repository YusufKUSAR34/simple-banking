package com.eteration.simplebanking.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.eteration.simplebanking.controller.TransactionStatus;

// This class is a place holder you can change the complete implementation
@Entity
public class WithdrawalTransaction  extends Transaction{

	  public WithdrawalTransaction() {

	    }

	    public WithdrawalTransaction(double withdrawalTransaction) {
	        super(withdrawalTransaction);
	        this.setType("WithdrawalTransaction");
	    }
}



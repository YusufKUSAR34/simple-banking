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


@Entity
public class DepositTransaction extends Transaction  {

	public DepositTransaction() {

    }

    public DepositTransaction(double depositTransaction) {
        super(depositTransaction);
        this.setType("DepositTransaction");
    }
	
		
	}


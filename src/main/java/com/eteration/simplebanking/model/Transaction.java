package com.eteration.simplebanking.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//@Table(name="Transaction")
public abstract class Transaction {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int id;

	    @Column
	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z")
	    public Date date;

	    @Column
	    public double amount;

	    @Column
	    public String type;

	    @Column
	    public String approvalCode;

	    @ManyToOne(fetch = FetchType.LAZY)
	    private Account account;

	    public Transaction() {

	    }

	    public Transaction(double transaction) {

	        date = new Date();
	        this.date = date;
	        this.amount = transaction;

	    }

	    public String toString() {
	        return null;

	    }

	    public Date getDate() {
	        return date;
	    }

	    public void setDate(Date date) {
	        this.date = date;
	    }

	    public double getAmount() {
	        return amount;
	    }

	    public void setAmount(double amount) {
	        this.amount = amount;
	    }

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getType() {
	        return type;
	    }

	    public void setType(String type) {
	        this.type = type;
	    }

	    public Account getAccount() {
	        return account;
	    }

	    public void setAccount(Account account) {
	        this.account = account;
	    }

	    public String getApprovalCode() {
	        return approvalCode;
	    }

	    public void setApprovalCode(String approvalCode) {
	        this.approvalCode = approvalCode;
	    }
	
}

package com.eteration.simplebanking;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.model.DepositTransaction;
import com.eteration.simplebanking.model.PhoneBillPaymentTransaction;
import com.eteration.simplebanking.model.WithdrawalTransaction;

@SpringBootTest
@ContextConfiguration
@AutoConfigureMockMvc
public class PhoneBillPaymentTests {


    @Test
    public void testPhoneBillPayment()
    throws Exception {
        
        Account account = new Account("Jim", "12345");
        account.post(new DepositTransaction(1000));
        account.post(new WithdrawalTransaction(200));
        account.post(new PhoneBillPaymentTransaction("Vodafone", "5423345566", 96.50));
        assertEquals(account.getBalance(), 703.50, 0.0001);

    }
}

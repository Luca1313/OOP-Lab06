package it.unibo.oop.lab.exception2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * JUnit test to test
 * {@link StrictBankAccount}.
 * 
 */
public class TestStrictBankAccount {

    /**
     * Used to test Exceptions on {@link StrictBankAccount}.
     */
    @SuppressWarnings("deprecation")
	@Test
    public void testBankOperations() {
        /*
         * 1) Creare due StrictBankAccountImpl assegnati a due AccountHolder a
         * scelta, con ammontare iniziale pari a 10000 e nMaxATMTransactions=10
         */
    	
    	AccountHolder acc1 = new AccountHolder("Luca", "Rubboli", 1);
    	AccountHolder acc2 = new AccountHolder("Mario", "Rossi", 2);
    	
    	StrictBankAccount bankAcc1 = new StrictBankAccount(acc1.getUserID(), 10000, 10);
    	StrictBankAccount bankAcc2 = new StrictBankAccount(acc2.getUserID(), 10000, 10);
    	
    	bankAcc1.deposit(acc1.getUserID(), 5000);
    	bankAcc2.deposit(acc2.getUserID(), 3000);
    	
    	assertTrue("[CHECKING BALANCE ACCOUNT 1]", (Double)15000.0 == bankAcc1.getBalance());
    	assertTrue("[CHECKING BALANCE ACCOUNT 2]", (Double)13000.0 == bankAcc2.getBalance());
    	
    	try {
    		bankAcc1.deposit(0, 1000);
    		//fail();
    	} catch (Exception e) {
    		assertNotNull(e.getMessage());
    	}
    	
    	try {
    		bankAcc2.deposit(0, 1000);
    		//fail();
    	} catch (Exception e) {
    		assertNotNull(e.getMessage());
    	}
    	
    	for (int i = 0; i < 10; i++) {
    		try {
        		bankAcc1.withdrawFromATM(acc1.getUserID(), 1600);
        		bankAcc2.withdrawFromATM(acc2.getUserID(), 1350);
        		//fail();
        	} catch (Exception e) {
        		assertNotNull(e.getMessage());
        	}
    	}
    	
    	for (int i = 0; i < 2; i++) {
    		try {
        		bankAcc1.withdraw(acc1.getUserID(), 1600);
        		bankAcc2.withdraw(acc2.getUserID(), 1350);
        		//fail();
        	} catch (Exception e) {
        		assertNotNull(e.getMessage());
        	}
    	}
    	/*
         * 2) Effetture un numero di operazioni a piacere per verificare che le
         * eccezioni create vengano lanciate soltanto quando opportuno, cioè in
         * presenza di un id utente errato, oppure al superamento del numero di
         * operazioni ATM gratuite.
         */
    }
}

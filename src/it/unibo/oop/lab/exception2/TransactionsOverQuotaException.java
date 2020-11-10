package it.unibo.oop.lab.exception2;

public class TransactionsOverQuotaException extends Exception {

	public TransactionsOverQuotaException() {
		super("Invalid operation due to maximum ATM operation done.");
	}
}

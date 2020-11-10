package it.unibo.oop.lab.exception2;

public class WrongAccountHolderException extends Exception {
	
	public WrongAccountHolderException() {
		super("Invalid operation due to invalid account.");
	}
}

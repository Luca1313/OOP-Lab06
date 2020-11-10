package it.unibo.oop.lab.exception2;

public class NotEnoughFoundsException extends Exception {

	public NotEnoughFoundsException() {
		super("Invalid operation due to lower balance.");
	}
}

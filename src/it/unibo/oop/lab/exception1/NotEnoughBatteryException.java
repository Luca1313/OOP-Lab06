package it.unibo.oop.lab.exception1;

public class NotEnoughBatteryException extends Exception {
	
	public NotEnoughBatteryException() {
		super("Exception, not enough battery to reach the new position.");
	}
}

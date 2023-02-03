package org.lessons.java.eventi;

public class PastDate extends Exception{

	public PastDate() {
		super("La data è già passata");
	}
}

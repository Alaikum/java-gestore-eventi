package org.lessons.java.eventi;

public class SoldOut extends Exception {
	SoldOut() {
		super("Posti esauriti!");
	}
}

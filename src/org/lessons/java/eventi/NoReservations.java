package org.lessons.java.eventi;

public class NoReservations extends Exception {
NoReservations(){
	super("Non hai prenotazioni per questo eventi");
}
}

package org.lessons.java.eventi;

public class NoReservations extends Exception {
NoReservations(){
	super("Non ci sono altre prenotazioni per questo evento");
}
}

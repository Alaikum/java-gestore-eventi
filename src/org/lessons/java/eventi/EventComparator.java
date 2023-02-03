package org.lessons.java.eventi;


import java.util.Comparator;

public class EventComparator implements Comparator<Evento> {

	@Override
	public int compare(Evento o1, Evento o2) {
		return o1.getLd().compareTo(o2.getLd());

	}

}

package org.lessons.java.eventi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProgrammEventi {

	private String titolo;
	private List<Evento> eventi;

	public ProgrammEventi(String titolo) {
		super();
		this.titolo = titolo;
		this.eventi = new ArrayList<>();
	}

	public void addEvento(Evento x) {
		eventi.add(x);
	}

	public void getEventiSameDate(LocalDate x) {
		System.out.print("Eventi con data uguale : ");
		List<Evento> eventiStessaData = new ArrayList<>();
		for (Evento evento : eventi) {
			if (evento.getLd().equals(x)) {
				eventiStessaData.add(evento);
			}

		}
		System.out.println(eventiStessaData);

	}

	public int getNumEventi() {
		return eventi.size();
	}

//	● un metodo che restituisce una stringa che mostra il titolo del programma e tutti gli
//	eventi ordinati per data nella forma:

	public String getOrderList() {
		Collections.sort(eventi, new EventComparator());
		String eventiOrd = "-" + getTitolo().toUpperCase() + "-\n-";

		for (Evento evento : eventi) {
			eventiOrd+=evento+" -";
		}
		return eventiOrd;
	}

	public int compareTo(Evento o) { // ordinamento predefinito per nome
		return this.titolo.compareTo(o.getTitolo());
	}

	public void clearList() {
		eventi.clear();
	}

	public String getTitolo() {
		return titolo;
	}

	public List<Evento> getEventi() {
		return eventi;
	}

}

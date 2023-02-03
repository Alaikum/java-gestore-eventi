package org.lessons.java.eventi;

import java.time.LocalDate;
import java.util.ArrayList;
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
		List<Evento> eventiStessaData= new ArrayList<>();
		for (Evento evento : eventi) {
		if(evento.getLd().equals(x)) {
			eventiStessaData.add(evento);
		}
			
		}
	System.out.println(eventiStessaData);
		
	}

	public String getTitolo() {
		return titolo;
	}


	public List<Evento> getEventi() {
		return eventi;
	}


		
	


	
	
}

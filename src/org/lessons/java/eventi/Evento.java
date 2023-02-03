package org.lessons.java.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Evento {

	private String  titolo;
	private LocalDate ld,nowDate=LocalDate.now();
	private int postiTotale, postiPrenotati;
	private DateTimeFormatter df=DateTimeFormatter.ofPattern("dd/MM/yyyy").withLocale(Locale.ITALIAN);
	
	
	public Evento(String titolo, LocalDate ld, int postiTotale) throws PastDate, ExistingPlaces {
		super();
		this.titolo = titolo;
		validateDate(ld);
		this.ld = ld;
		validatePostiTotale(postiTotale);
		this.postiTotale = postiTotale;
		this.postiPrenotati = 0;
	}

	public void validateDate(LocalDate n) throws PastDate{
		if (n.isBefore(nowDate))		
			throw new PastDate();		
		
	}
	
	public void validatePostiTotale(int p) throws ExistingPlaces {
		if(p<1)
			throw new ExistingPlaces();
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getLd() {
		return ld;
	}

	public void setLd(LocalDate ld) throws PastDate {
		validateDate(ld);
		this.ld = ld;
	}

	public int getPostiTotale() {
		return postiTotale;
	}

	public int getPostiPrenotati() {
		return postiPrenotati;
	}
	
	public void prenota() throws SoldOut, PastDate {
		if(postiTotale==postiPrenotati) //controllo presenza posti liberi
			throw new SoldOut();
		validateDate(ld); //controllo data
		postiPrenotati++; //aumento posti prenotati
	}
	
	public void disdici() throws NoReservations,PastDate {
		if(postiPrenotati==0)
			throw new NoReservations(); //controllo prenotazioni
		validateDate(ld); //controllo data
		postiPrenotati--; //rimuovo il posto
	}

	@Override
	public String toString() {
		return "Data= " + ld.format(df) + " - Titolo= " + titolo;
	}
	
	
	
	
	
	
	

}

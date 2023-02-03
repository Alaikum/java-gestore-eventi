package org.lessons.java.eventi;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Concerto extends Evento {

	private LocalTime ora;
	private BigDecimal prezzo;
	private static DateTimeFormatter oraF = DateTimeFormatter.ofPattern("hh:mm a").withLocale(Locale.ITALY);
	private static DecimalFormat pf = new DecimalFormat("####.## €");

	public Concerto(String titolo, LocalDate ld, int postiTotale, LocalTime ora, BigDecimal prezzo)
			throws PastDate, ExistingPlaces {
		super(titolo, ld, postiTotale);
		this.ora = ora;
		;
		this.prezzo = prezzo;
	}

	public LocalTime getOra() {
		return ora;
	}

	public void setOra(LocalTime ora) {
		this.ora = ora;
	}

	public BigDecimal getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}

	public String formatBD() {
		return pf.format(getPrezzo());
	}

	public String formatOra() {
		return getOra().format(oraF);
	}

	@Override
	public String toString() {
		return "Data= " + formatData() + " Ora= " + formatOra() + " Titolo= " + getTitolo() + " Prezzo= " + formatBD();
	
	}

}

package org.lessons.java.eventi;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Evento eve;
		LocalDate lDate;
		boolean bonus=false;
		int postiTotale, giorno, mese, anno, prenotazioni, disdette;
		String titolo, disdire;
		Scanner s = new Scanner(System.in);
		
		System.out.println("Vuoi vedere anche la parte bonus?(s/n)");
		if(s.nextLine().trim().toLowerCase().equals("s")) {
			bonus=true;
		}

		System.out.println("Inserisci il TITOLO dell'evento: ");
		titolo = s.nextLine();
		System.out.println("Inserisci il numero di POSTI dell'evento: ");
		postiTotale = Integer.parseInt(s.nextLine());

		// INSERIRE LDATE
		System.out.println("Inserisci il GIORNO dell'evento(1-31): ");
		giorno = Integer.parseInt(s.nextLine());

		System.out.println("Inserisci il MESE dell'evento(1-12): ");
		mese = Integer.parseInt(s.nextLine());

		System.out.println("Inserisci il ANNO dell'evento(es 2023): ");
		anno = Integer.parseInt(s.nextLine());
		lDate = LocalDate.of(anno, mese, giorno);

		try {

			// controllo delle funzionalit√† della classe Concerto
			Concerto con = new Concerto(titolo, lDate, postiTotale, LocalTime.of(23, 50), new BigDecimal(".566"));
			System.out.println("Print di Concerto per test"+con.toString());

			eve = new Evento(titolo, lDate, postiTotale);
			System.out.println(eve.toString());

			// TEST BONUS
			if(bonus) {
				System.out.println("INIZIO BONUS");
				
			ProgrammEventi pE = new ProgrammEventi("raccolta-Eventi");
			Concerto con2 = new Concerto("con2", LocalDate.of(4443, 1, 1), postiTotale, LocalTime.of(23, 50), new BigDecimal(".566"));
			pE.addEvento(con);
			pE.addEvento(eve);
			pE.addEvento(con2);
			
			//trova eventi con data uguale a quella inserita dall'utente 
			pE.getEventiSameDate(LocalDate.of(4444, 1, 1));
			System.out.println(pE.getEventi());
			System.out.println("Il numero di eventi in lista √® : " + pE.getNumEventi());
			System.out.println("Stringa Eventi Ordinati + Titolo: ");
			System.out.println(	pE.getOrderList());
		
			pE.clearList();
	
			System.out.println(pE.getEventi());
			System.out.println("FINE BONUS");
			}

			// CHIEDERE QUANTE PRENOTAZIONI FARE
			System.out.println("Quanti posti vuoi prenotare per l'evento?");
			prenotazioni = Integer.parseInt(s.nextLine());
			// FARE PRENOTAZIONI
			for (int i = 0; i < prenotazioni; i++) {
				eve.prenota();
			}
			System.out.printf("Posti Prenotati: %d\nPosti ancora Disponibili: %d\n", eve.getPostiPrenotati(),
					eve.getPostiTotale() - eve.getPostiPrenotati());

			// Chiedere all‚Äôutente se e quanti posti vuole disdire
			System.out.println("Vuoi disdire qualche posto?\nS/N: ");
			disdire = s.nextLine();
			if (disdire.trim().toLowerCase().equals("s")) {
				System.out.println("Quanti posti vuoi disdire?");
				disdette = Integer.parseInt(s.nextLine());
				// FARE DISDETTE
				for (int i = 0; i < disdette; i++) {
					eve.disdici();
				}

			}

			System.out.printf("Posti Prenotati: %d\nPosti ancora Disponibili: %d\n", eve.getPostiPrenotati(),
					eve.getPostiTotale() - eve.getPostiPrenotati());

		} catch (Exception e) {
			System.out.println("ATTENZIONE : " + e.getMessage());
		}

		s.close();

		// Stiamo lavorando a un programma che deve gestire eventi (ad esempio concerti,
//				conferenze, spettacoli,...)
//				MILESTONE 1
//				La consegna √® di creare una classe Evento che abbia le seguenti propriet√†:
//				‚óŹ titolo
//				‚óŹ data
//				‚óŹ numero di posti in totale
//				‚óŹ numero di posti prenotati
//				Quando si istanzia un nuovo evento questi attributi devono essere tutti valorizzati nel
//				costruttore , tranne posti prenotati che va inizializzato a 0.
//				Inserire il controllo che la data non sia gi√† passata e che il numero 
		// di posti totali sia positivo.
//				In caso contrario sollevare opportune eccezioni.

//				Aggiungere metodi getter e setter in modo che:
//				‚óŹ titolo sia in lettura e in scrittura
//				‚óŹ data sia in lettura e scrittura
//				‚óŹ numero di posti totale sia solo in lettura
//				‚óŹ numero di posti prenotati sia solo in lettura
//				Vanno inoltre implementati dei metodi public che svolgono le seguenti funzioni:
//				1. prenota : aggiunge uno ai posti prenotati. Se l‚Äôevento √® gi√† passato o 
		// non ha posti
//				disponibili deve sollevare un‚Äôeccezione.

//				2. disdici : riduce di uno i posti prenotati. Se l‚Äôevento √® gi√† passato o non ci sono
//				prenotazioni deve sollevare un‚Äôeccezione.

//				3. l‚Äôoverride del metodo toString() in modo che venga restituita una stringa
//				contenente: data formattata - titolo
//				Aggiungete eventuali metodi (public e private) che vi aiutino a svolgere le funzioni richieste.
//			

		// MILESTONE 2
//				1. Creare una classe Main di test, in cui si chiede all‚Äôutente
		// di inserire un nuovo evento
//				con tutti i parametri.
//				2. Dopo che l‚Äôevento √® stato istanziato, chiedere all‚Äôutente se e quante prenotazioni
//				vuole fare e provare ad effettuarle, implementando opportuni controlli e gestendo
//				eventuali eccezioni.
//				3. Stampare a video il numero di posti prenotati e quelli disponibili
//				4. Chiedere all‚Äôutente se e quanti posti vuole disdire
//				5. Provare ad effettuare le disdette, implementando opportuni controlli e gestendo
//				eventuali eccezioni
//				6. Stampare a video il numero di posti prenotati e quelli disponibili

//				MILESTONE 3
//				Creare una classe Concerto che estende Evento, che ha anche gli attributi :
//				‚óŹ ora: LocalTime
//				‚óŹ prezzo: BigDecimal
//				Aggiungere questi attributi nel costruttore e implementarne getter e setter
//				Aggiungere i metodi per restituire data e ora formattata e prezzo formattato (##,##‚ā¨)
//				Fare l‚Äô override del metodo toString() in modo che venga restituita una stringa del tipo:
//				data e ora formattata - titolo - prezzo formattato

//				MILESTONE 4 (bonus)
//				Creare una classe ProgrammEventi con i seguenti attributi
//				‚óŹ titolo: String
//				‚óŹ eventi: List<Evento>
//				Nel costruttore valorizzare il titolo, passato come parametro, e inizializzare la lista di eventi
//				come una nuova ArrayList

//				Aggiungere i seguenti metodi :
//				‚óŹ un metodo che aggiunge alla lista un Evento, passato come parametro
//				‚óŹ un metodo che restituisce una lista con tutti gli eventi presenti in una certa data
//				‚óŹ un metodo che restituisce quanti eventi sono presenti nel programma
//				‚óŹ un metodo che svuota la lista di eventi
//				‚óŹ un metodo che restituisce una stringa che mostra il titolo del programma e tutti gli
//				eventi ordinati per data nella forma:
//				‚óč data1 - titolo1
//				‚óč data2 - titolo2
//				‚óč data3 - titolo3

	}

}

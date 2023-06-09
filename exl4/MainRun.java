package exl4;

import java.util.ArrayList;

public class MainRun {

	static ArrayList<Dipendente> dipendenti = new ArrayList<>();

	public static void main(String[] args) {
		System.out.println("\n\n *** STATO INIZIALE DIPENDENTI *** \n");
		dipendenti.add(new Dipendente(13533, Dipartimento.PRODUZIONE, Livello.OPERAIO));
		dipendenti.add(new Dipendente(12547, Dipartimento.PRODUZIONE, Livello.OPERAIO));
		dipendenti.add(new Dipendente(16161, Dipartimento.AMMINISTRAZIONE, Livello.IMPIEGATO));
		dipendenti.add(new Dipendente(11125, Dipartimento.VENDITE, Livello.DIRIGENTE));
		stampaDipendenti();
		System.out.println("\n *** PROMUOVO DUE DIPENDENTI *** \n");
		dipendenti.get(1).promuovi();
		dipendenti.get(2).promuovi();
		stampaDipendenti();
		stampaPaghe(5);

	}

	public static void stampaDipendenti() {
		for (int i = 0; i < dipendenti.size(); i++) {
			System.out.println(dipendenti.get(i));
		}
	}

	public static void stampaPaghe() {
		double totaleStipendi = 0;
		for (int i = 0; i < dipendenti.size(); i++) {
			totaleStipendi +=Dipendente.calcolaPaga(dipendenti.get(i));
		}
		System.out.println("\n L'azienda deve pagare " + totaleStipendi + "€ di stipendi ai dipendenti.");
	}
	
	public static void stampaPaghe(int ore) {
		//aggiungo le ore di straordinario
		double totaleStipendi = 0;
		for (int i = 0; i < dipendenti.size(); i++) {
			totaleStipendi += Dipendente.calcolaPaga(dipendenti.get(i), ore);
		}
		System.out.println("\n *** RILEVAZIONE STIPENDI ***");
		System.out.println("\n L'azienda deve pagare " + totaleStipendi + "€ di stipendi ai dipendenti\n conteggiando " + ore + " ore di straordinario");
	}

}

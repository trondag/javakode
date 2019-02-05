package hiof.trondag.oblig3;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

		/////////////////////////////////////////////////\
		////--------------------		                /\
		////       OBLIG 3                              /\
		////						-Oppgave 5			/\
		////--------------------                        /\
		/////////////////////////////////////////////////\

		Person stigBergqvist = new Person("Stig", "Bergqvist", LocalDate.of(1962, 4, 28), "Sverige");
		Film kapteinSabeltann = new Film("Kaptein Sabeltann", "Film om piraten Sabeltann", 100, LocalDate.of(2003, 11, 19), stigBergqvist);
		Person jonFavreau = new Person("Jon", "Favreau", LocalDate.of(1966, 10, 19), "USA");
		Film lovenesKonge = new Film("Løvenes Konge", "Film om dyr i Afrika", 90, LocalDate.of(1994, 8, 18), jonFavreau);

		System.out.println("\nOppgave 5:");
		System.out.println("Lagde filmene: " + kapteinSabeltann.getTittel() + " og " + lovenesKonge.getTittel());

		System.out.println("\nOppgave 7:");
		System.out.println("Regissør i Kaptein Sabeltann: " + kapteinSabeltann.getRegissor().getFulltNavn());
		System.out.println("Regissør i Løvenes Konge: " + lovenesKonge.getRegissor().getFulltNavn());
	}
	}

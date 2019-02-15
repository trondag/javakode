package hiof.trondag.oblig3;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

		///////////////////////////////////
		//-------------------------------//
		//--------Oblig 2----------------//         (Oblig 3 er lenger ned)
		//-------------------------------//
		//-------Lager sesong-objekt-----//
		///////////////////////////////////

		TVSerie friends = new TVSerie("Friends", "En sitkom med 6 venner", LocalDate.of(2004, 1, 7));

		//////////////////////////////////////
		//-------Lager episode-objekter-----//
		//////////////////////////////////////

		Episode friends_e01_s01 = new Episode("The one where Monica gets a new roommate", 1, 1, 25.0);
		friends.leggTilEpisode(friends_e01_s01);
		Episode friends_e02_s01 = new Episode("The one with the sonogram at the end", 2, 1, 23.0);
		friends.leggTilEpisode(friends_e02_s01);
		Episode friends_e03_s01 = new Episode("The one with the thumb", 3, 1, 22.5);
		friends.leggTilEpisode(friends_e03_s01);
		Episode friends_e04_s01 = new Episode("The One with George Stephanopoulos", 4, 1, 23.5);
		friends.leggTilEpisode(friends_e04_s01);

		///////////////////////////////////////////////////////////////
		//-------Tester override toString metodene--- (Oppgave 5)----//
		///////////////////////////////////////////////////////////////

		/*
		System.out.println("\nOppgave 5: ");
		System.out.println(friends.toString());
		System.out.println(friends_e02_s01.toString());
		*/

		/////////////////////////////////////////////////////////////
		//--------Lager 5 sesonger med 20 episoder (oppgave 6)-----//
		/////////////////////////////////////////////////////////////

		LocalDate bigbangDato = LocalDate.of(2009,1,1);
		TVSerie bigBang = new TVSerie("The Big Bang Theory", "Gjeng med nerder", bigbangDato);
		bigBang = bigBang.lagEpisoder(bigBang,5, 20);

		///////////////////////////////////////////////////////////////
		//-------Henter så ut sesong 4 av The Big Bang Theory--------//
		///////////////////////////////////////////////////////////////

		/*
		System.out.println("\nOppgave 6: ");
		System.out.println(bigBang.hentFraEnSesong(4));
		*/

		/////////////////////////////////////////////////////////////////////////////////////////////////////
		//-------Skriver ut den gjennomsnittlige spilletiden av The Big Bang Theory. (Oppgave 8 og 9)------//
		/////////////////////////////////////////////////////////////////////////////////////////////////////

		/*
		System.out.println("\nOppgave 8:");
		System.out.println("Gjennomsnittlig spilletid: " + bigBang.minutterOgSekunder(bigBang.getGjennomSnittligSpilletid()));

		System.out.println("\nOppgave 9:");
		System.out.println("antall sesonger: " + bigBang.getAntallSesonger() + "\n");
		*/

		///////////////////////////////////////////////////////////////////////////////////////////////
		//-------Tester om jeg kan legge inn en episode fra sesong 6, så sesong 8 (Oppgave 10)-------//
		///////////////////////////////////////////////////////////////////////////////////////////////

		System.out.println("\nOppgave 10: Prøver først å legge til for sesong 6, så prøver jeg fra sesong 8, som ikke skal gå");
		Episode e01s06 = new Episode("Episode 1", 1, 6, 22.5);
		bigBang.leggTilEpisode(e01s06);
		System.out.println(e01s06);

		Episode e01s08 = new Episode("Episode 1", 1, 8, 23.0);
		bigBang.leggTilEpisode(e01s08);

		/////////////////////////////////////////////////\
		////--------------------		                /\
		////       OBLIG 3                              /\
		////						-Oppgave 5			/\
		////--------------------                        /\
		/////////////////////////////////////////////////\

		System.out.println("\n*****************************");
		System.out.println("**  Oblig 3 starter her:   **");
		System.out.println("*****************************");

		Person stigBergqvist = new Person("Stig", "Bergqvist", LocalDate.of(1962, 4, 28), "Sverige");
		Film kapteinSabeltann = new Film("Kaptein Sabeltann", "Film om piraten Sabeltann", 100, LocalDate.of(2003, 11, 19), stigBergqvist);
		Person jonFavreau = new Person("Jon", "Favreau", LocalDate.of(1966, 10, 19), "USA");
		Film lovenesKonge = new Film("Løvenes Konge", "Film om dyr i Afrika", 90, LocalDate.of(1994, 8, 18), jonFavreau);
		Person jamesBurrows = new Person("James", "Burrows", LocalDate.of(1940, 12, 30), "USA");
		friends_e01_s01.setRegissor(jamesBurrows);


		System.out.println("\nOppgave 5:");
		System.out.println("Lagde filmene: " + kapteinSabeltann.getTittel() + " og " + lovenesKonge.getTittel());

		///////////////////////////////
		//---------Oppgave 7---------//
		///////////////////////////////

		System.out.println("\nOppgave 7:");
		System.out.println("Regissør i Kaptein Sabeltann: " + kapteinSabeltann.getRegissor().getFulltNavn());
		System.out.println("Regissør i Friends e01 s01: " + friends_e01_s01.getRegissor().getFulltNavn());

		///////////////////////////////
		//---------Oppgave 8---------//
		///////////////////////////////

		//Legger til skuespillere til serien Friends

		Person mattleBlanc = new Person("Matt", "LeBlanc", LocalDate.of(1967, 7, 25), "USA");
		Person matthewPerry = new Person("Matthew", "Perry", LocalDate.of(1969, 8, 19), "USA");
		Person davidSchwimmer = new Person("David", "Schwimmer", LocalDate.of(1966, 11, 2), "USA");
		Person courtneyCox = new Person("Courtney", "Cox", LocalDate.of(1964, 6, 15), "USA");
		Person jenniferAniston = new Person("Jennifer", "Aniston", LocalDate.of(1969, 2, 11), "USA");
		Person lisaKudrow = new Person("Lisa", "Kudrow", LocalDate.of(1963, 7, 30), "USA");

		Rolle joeyTribbiani = new Rolle("Joey", "Tribbiani", mattleBlanc);
		Rolle chandlerBing = new Rolle("Chandler", "Bing", matthewPerry);
		Rolle rossGeller = new Rolle("Ross", "Geller", davidSchwimmer);
		Rolle monicaGeller = new Rolle("Monica", "Geller", courtneyCox);
		Rolle rachelGreen = new Rolle("Rachel", "Green", jenniferAniston);
		Rolle phoebeBuffay = new Rolle("Phoebe", "Buffay", lisaKudrow);

		//Prøver ut metodene leggTilMangeRoller() og leggTilEnRolle() ved å legge roller til i en episode av friends(e01s01)

		ArrayList<Rolle> jentene = new ArrayList<>();
		jentene.add(monicaGeller);
		jentene.add(rachelGreen);
		jentene.add(phoebeBuffay);
		friends_e01_s01.leggTilMangeRoller(jentene);
		friends_e01_s01.leggTilEnRolle(rossGeller);
		friends_e01_s01.leggTilEnRolle(chandlerBing);
		friends_e01_s01.leggTilEnRolle(joeyTribbiani);

		System.out.println("\nOppgave 8:");
		friends_e01_s01.skrivUtRoller();

		// Gjør så det samme med en film

		Person jamesCameron = new Person("James", "Cameron", LocalDate.of(1954, 8, 16), "Canada");
		Person leonardoDiCaprio = new Person("Leonardo", "DiCaprio", LocalDate.of(1974, 11, 11), "USA");
		Person kateWinslet = new Person("Kate", "Winslet", LocalDate.of(1975, 10, 5), "Storbritannia");
		Rolle jackDawson = new Rolle("Jack", "Dawson", leonardoDiCaprio);
		Rolle roseBukater = new Rolle("Rose", "Dewitt Bukater", kateWinslet);
		Produksjon titanic = new Film("Titanic", "Film om en båt som treffer et isfjell", 194, LocalDate.of(1998, 2, 13), jamesCameron);
		titanic.leggTilEnRolle(jackDawson);
		titanic.leggTilEnRolle(roseBukater);

		System.out.println("\n");
		titanic.skrivUtRoller();

		//////////////////////////////////////////////////
		//  -------------Oppgave 10 og 11-------------  //
		//  -Legger til skuespillere i flere episoder-  //
		//////////////////////////////////////////////////

		ArrayList<Rolle> skuespillereIFriends = new ArrayList<>();
		skuespillereIFriends.add(monicaGeller);
		skuespillereIFriends.add(rachelGreen);
		skuespillereIFriends.add(phoebeBuffay);
		skuespillereIFriends.add(rossGeller);
		skuespillereIFriends.add(chandlerBing);
		skuespillereIFriends.add(joeyTribbiani);
		friends_e02_s01.leggTilMangeRoller(skuespillereIFriends);
		friends_e03_s01.leggTilMangeRoller(skuespillereIFriends);
		friends_e04_s01.leggTilMangeRoller(skuespillereIFriends);

		ArrayList<Rolle> rollerFriends = new ArrayList<>();
		rollerFriends.addAll(friends.hentRollebesetning());
		System.out.println("\nOppgave 10 og 11:");
		System.out.println(rollerFriends.get(0).toString());
		System.out.println(rollerFriends.get(5).toString());

		//////////////////////////////////////////////////
		//  ---------------Oppgave 12-----------------  //
		//////////////////////////////////////////////////

		System.out.println("\nOppgave 12:\n");
		System.out.println(friends.antallEpisoderSkuespiller(mattleBlanc));

		//////////////////////////////////////////////////
		//  ---------------Oppgave 13-----------------  //
		//////////////////////////////////////////////////

		System.out.println("\nOppgave 13:\n");
		TVSerie daysOfOurLives = new TVSerie("Days of our Lives", "En serie som handler om ting", LocalDate.of(1965, 11, 8));
		daysOfOurLives.lagSaape(13518, LocalDate.of(1965, 11, 8));

			//Kommenter ut linjen under for å se de andre oppgavene, JRE printer ut 260 episoder, siden det ble mange episoder per sesong.
		System.out.println(daysOfOurLives.hentFraEnSesong(42));

	}
	}

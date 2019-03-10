package hiof.trondag.oblig5_alt1;
import hiof.trondag.oblig5_alt1.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

		TVSerie friends = new TVSerie("Friends", "En sitkom med 6 venner", LocalDate.of(2004, 1, 7));
		Episode friends_e01_s01 = new Episode("The one where Monica gets a new roommate", 1, 1, 25.0);
		friends.leggTilEpisode(friends_e01_s01);
		Episode friends_e02_s01 = new Episode("The one with the sonogram at the end", 2, 1, 23.0);
		friends.leggTilEpisode(friends_e02_s01);
		Episode friends_e03_s01 = new Episode("The one with the thumb", 3, 1, 22.5);
		friends.leggTilEpisode(friends_e03_s01);
		Episode friends_e04_s01 = new Episode("The One with George Stephanopoulos", 4, 1, 23.5);
		friends.leggTilEpisode(friends_e04_s01);
		LocalDate bigbangDato = LocalDate.of(2009, 1, 1);
		TVSerie bigBang = new TVSerie("The Big Bang Theory", "Gjeng med nerder", bigbangDato);
		bigBang = bigBang.lagEpisoder(bigBang, 5, 20);
		Episode e01s06 = new Episode("The Date Night Variable", 1, 6, 22.5);
		bigBang.leggTilEpisode(e01s06);
		Person stigBergqvist = new Person("Stig", "Bergqvist", LocalDate.of(1962, 4, 28), "Sverige");
		Film kapteinSabeltann = new Film("Kaptein Sabeltann", "Film om piraten Sabeltann", 100, LocalDate.of(2003, 11, 19), stigBergqvist);
		Person jonFavreau = new Person("Jon", "Favreau", LocalDate.of(1966, 10, 19), "USA");
		Film lovenesKonge = new Film("Løvenes Konge", "Film om dyr i Afrika", 90, LocalDate.of(1994, 8, 18), jonFavreau);
		Person jamesBurrows = new Person("James", "Burrows", LocalDate.of(1940, 12, 30), "USA");
		friends_e01_s01.setRegissor(jamesBurrows);
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
		ArrayList<Rolle> jentene = new ArrayList<>();
		jentene.add(monicaGeller);
		jentene.add(rachelGreen);
		jentene.add(phoebeBuffay);
		friends_e01_s01.leggTilMangeRoller(jentene);
		friends_e01_s01.leggTilEnRolle(rossGeller);
		friends_e01_s01.leggTilEnRolle(chandlerBing);
		friends_e01_s01.leggTilEnRolle(joeyTribbiani);
		Person jamesCameron = new Person("James", "Cameron", LocalDate.of(1954, 8, 16), "Canada");
		Person leonardoDiCaprio = new Person("Leonardo", "DiCaprio", LocalDate.of(1974, 11, 11), "USA");
		Person kateWinslet = new Person("Kate", "Winslet", LocalDate.of(1975, 10, 5), "Storbritannia");
		Rolle jackDawson = new Rolle("Jack", "Dawson", leonardoDiCaprio);
		Rolle roseBukater = new Rolle("Rose", "Dewitt Bukater", kateWinslet);
		Film titanic = new Film("Titanic", "Film om en båt som treffer et isfjell", 194, LocalDate.of(1998, 2, 13), jamesCameron);
		titanic.leggTilEnRolle(jackDawson);
		titanic.leggTilEnRolle(roseBukater);
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
		TVSerie daysOfOurLives = new TVSerie("Days of our Lives", "En serie som handler om ting", LocalDate.of(1965, 11, 8));
		daysOfOurLives.lagSaape(13518, LocalDate.of(1965, 11, 8));

		/////////////////////////////////////////////////////
		//        OBLIG 4 -------------                    //
		//                  Oppgave 5                      //
		/////////////////////////////////////////////////////

		ArrayList<TVSerie> listeMedSerier = new ArrayList<>();

		listeMedSerier.add(bigBang);
		listeMedSerier.add(friends);
		listeMedSerier.add(daysOfOurLives);

		System.out.println("\nUsortert liste med serier:");
		printUtSerier(listeMedSerier);
		Collections.sort(listeMedSerier);
		System.out.println("\nSorert liste med serier: (alfabetisk)");
		printUtSerier(listeMedSerier);

		ArrayList<Episode> listeMedEpisoder = new ArrayList<>();
		listeMedEpisoder.add(friends_e04_s01);
		listeMedEpisoder.add(friends_e02_s01);
		listeMedEpisoder.add(e01s06);
		listeMedEpisoder.add(friends_e01_s01);
		listeMedEpisoder.add(friends_e03_s01);

		System.out.println("\nUsorert liste med episoder:");
		printUtEpisoder(listeMedEpisoder);
		Collections.sort(listeMedEpisoder);
		System.out.println("\nSortert liste med episoder:");
		printUtEpisoder(listeMedEpisoder);

		ArrayList<Film> listeMedFilmer = new ArrayList<>();
		listeMedFilmer.add(titanic);
		listeMedFilmer.add(kapteinSabeltann);
		listeMedFilmer.add(lovenesKonge);

		System.out.println("\nUsortert liste med filmer:");
		printUtFilmer(listeMedFilmer);
		Collections.sort(listeMedFilmer);
		System.out.println("\nSortert liste med filmer:");
		printUtFilmer(listeMedFilmer);


	}

		private static void printUtSerier(ArrayList<TVSerie> serieListe){
			for (TVSerie enSerie : serieListe){
				System.out.println(enSerie.getTittel() + " (" + enSerie.getPubliseringsDato().getYear() + ")");
			}
		}

		private static void printUtEpisoder(ArrayList<Episode> episodeListe){
    		for (Episode enEpisode : episodeListe){
				System.out.println(enEpisode.getTittel() + " | sesong: " + enEpisode.getSesongNummer() + " episode: " + enEpisode.getEpisodeNummer());
			}
		}

		private static void printUtFilmer(ArrayList<Film> filmListe){
    		for (Film enFilm : filmListe){
				System.out.println(enFilm.getTittel() + " (" + enFilm.getUtgivelsesdato().getYear() + ")");
			}
		}
	}

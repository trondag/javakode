package hiof.trondag.oblig2;

import java.time.LocalDate;
import java.time.Duration;

public class Main {

    public static void main(String[] args) {

		/************************
		 * -------Lager sesong-objekt-----
		 */
		LocalDate friendsDato = LocalDate.of(2004, 1, 7);
		TVSerie friends = new TVSerie("Friends", "En sitkom med 6 venner", friendsDato);
		Duration treKvarter = Duration.ofMinutes(45);

		/************************
		 * -------Lager episode-objekter-----
		 */

		Episode e01 = new Episode("The one where Monica gets a new roommate", 1, 1, treKvarter);
		friends.leggTilEpisode(e01);
		Episode e02 = new Episode("The one with the sonogram at the end", 2, 1, treKvarter);
		friends.leggTilEpisode(e02);
		Episode e03 = new Episode("The one with the thumb", 3, 1, treKvarter);
		friends.leggTilEpisode(e03);
		Episode e04 = new Episode("The One with George Stephanopoulos", 4, 1, treKvarter);
		friends.leggTilEpisode(e04);

		/************************
		 * -------Tester override toString metodene---
		 */

		System.out.println(friends.toString());
		System.out.println(e02.toString());

		/************************
		 * -------Lager 5 sesonger med 20 episoder (oppgave 6)
		 */
		LocalDate bigbangDato = LocalDate.of(2009,1,1);
		TVSerie bigBang = new TVSerie("The Big Bang Theory", "Gjeng med nerder", bigbangDato);
		bigBang = bigBang.lagEpisoder(bigBang,5, 20);

		EnSesong sesongFire = new EnSesong();
		sesongFire.hentEnSesong(bigBang, 4, sesongFire);
		System.out.println(sesongFire.toString());


		//System.out.println(bigBang.toString());
	}
	}

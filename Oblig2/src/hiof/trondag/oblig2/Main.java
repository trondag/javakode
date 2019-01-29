package hiof.trondag.oblig2;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

		///////////////////////////////////
		//-------Lager sesong-objekt-----//
		///////////////////////////////////

		TVSerie friends = new TVSerie("Friends", "En sitkom med 6 venner", LocalDate.of(2004, 1, 7));

		//////////////////////////////////////
		//-------Lager episode-objekter-----//
		//////////////////////////////////////

		Episode e01 = new Episode("The one where Monica gets a new roommate", 1, 1, 25.0);
		friends.leggTilEpisode(e01);
		Episode e02 = new Episode("The one with the sonogram at the end", 2, 1, 23.0);
		friends.leggTilEpisode(e02);
		Episode e03 = new Episode("The one with the thumb", 3, 1, 22.5);
		friends.leggTilEpisode(e03);
		Episode e04 = new Episode("The One with George Stephanopoulos", 4, 1, 23.5);
		friends.leggTilEpisode(e04);

		///////////////////////////////////////////////////////////////
		//-------Tester override toString metodene--- (Oppgave 5)----//
		///////////////////////////////////////////////////////////////

		System.out.println("\nOppgave 5: ");
		System.out.println(friends.toString());
		System.out.println(e02.toString());

		/////////////////////////////////////////////////////////////
		//--------Lager 5 sesonger med 20 episoder (oppgave 6)-----//
		/////////////////////////////////////////////////////////////

		LocalDate bigbangDato = LocalDate.of(2009,1,1);
		TVSerie bigBang = new TVSerie("The Big Bang Theory", "Gjeng med nerder", bigbangDato);
		bigBang = bigBang.lagEpisoder(bigBang,5, 20);

		///////////////////////////////////////////////////////////////
		//-------Henter så ut sesong 4 av The Big Bang Theory--------//
		///////////////////////////////////////////////////////////////

		System.out.println("\nOppgave 6: ");
		System.out.println(bigBang.hentFraEnSesong(bigBang, 4).toString());

		/////////////////////////////////////////////////////////////////////////////////////////////////////
		//-------Skriver ut den gjennomsnittlige spilletiden av The Big Bang Theory. (Oppgave 8 og 9)------//
		/////////////////////////////////////////////////////////////////////////////////////////////////////

		System.out.println("\nOppgave 8:");
		System.out.println("Gjennomsnittlig spilletid: " + bigBang.minutterOgSekunder(bigBang.getGjennomSnittligSpilletid()));

		System.out.println("\nOppgave 9:");
		System.out.println("antall sesonger: " + bigBang.getAntallSesonger() + "\n");
		Episode e01s06 = new Episode("Episode 1", 1, 6, 22.5);

		///////////////////////////////////////////////////////////////////////////////////////////////
		//-------Tester om jeg kan legge inn en episode fra sesong 6, så sesong 8 (Oppgave 10)-------//
		///////////////////////////////////////////////////////////////////////////////////////////////

		System.out.println("\nOppgave 10: Prøver først å legge til for sesong 6, så prøver jeg fra sesong 8, som ikke skal gå");
		bigBang.leggTilEpisode(e01s06);
		System.out.println(e01s06);

		Episode e01s08 = new Episode("Episode 1", 1, 8, 23.0);
		bigBang.leggTilEpisode(e01s08);
	}
	}

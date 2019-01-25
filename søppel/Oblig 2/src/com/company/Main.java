package com.company;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        LocalDate friendsSluppet = LocalDate.of(2004, 1, 7);

        //Ny serie
	    TVSerie friends = new TVSerie("Friends", "Sitkom om 6 venner", friendsSluppet);
        System.out.println("Serien " + friends.getTittel() + " som er en " + friends.getBeskrivelse());

        TVSerie breakingbad = new Episode()

        Episode e1 = new Episode()
    }
}

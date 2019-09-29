package no.hiof.trondag;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
	    Produksjon ringensBrorskap = new Film("Ringenes Herre: Ringens Brorskap", "Filmen om ringen", 120, LocalDate.of(2000, 12, 12));
        System.out.println(ringensBrorskap);

        TVSerie friends = new TVSerie("Friends", "6 venner", LocalDate.of(1994, 12, 12));
        TVSerie gameofthrones = new TVSerie("Game of Thrones", "Spillet om tronen", LocalDate.of(2010, 4, 1));
        TVSerie motibrøstet = new TVSerie("Mot i brøstet", "hei", LocalDate.of(1980, 7, 30));
        Produksjon hei = new Film("Hei", "Hade", 12, LocalDate.of(1994, 7, 13));

        ArrayList<TVSerie> liste = new ArrayList<>();

        liste.add(motibrøstet);
        liste.add(friends);
        liste.add(gameofthrones);

        Collections.sort(liste);
        System.out.println(liste);

        if (ringensBrorskap instanceof Episode){
            System.out.println("Der er en produksjon");
        } else {
            System.out.println("Ikke produksjon");
        }

        Object film = new Object();

        Object hei1 = (Object) friends;
        Object du = (Object) hei;

        var heisann = 0;
        var dooo = "heidann";

        


    }
}

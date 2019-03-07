package hiof.trondag.oblig4.data;

import hiof.trondag.oblig4.model.Film;
import hiof.trondag.oblig4.model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class DataHandler {

    private final static ObservableList<Film> filmListe = FXCollections.observableArrayList();

    public static ObservableList<Film> hentFilmData(){
        genererFilmData();
        return filmListe;
    }

    public static void slettFraListen(int index){
        filmListe.remove(index);
    }

    private static void genererFilmData() {
        Person jamesCameron = new Person("James", "Cameron", LocalDate.of(1954, 8, 16), "USA");
        filmListe.add(new Film("Titanic", "Romantisk film med isfjelltragedien i Atlanteren som kuliss.", 194, LocalDate.of(1998, 2, 13), jamesCameron));
        filmListe.add(new Film("Avatar", "Spenningsfilm med store blå raringer som lever på en planet.", 162, LocalDate.of(2009, 12, 18), jamesCameron));
    }
}


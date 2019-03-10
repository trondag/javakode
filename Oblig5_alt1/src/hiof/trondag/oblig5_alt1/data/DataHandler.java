package hiof.trondag.oblig5_alt1.data;

import hiof.trondag.oblig5_alt1.model.Film;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.time.LocalDate;

import static java.lang.Double.parseDouble;

public class DataHandler {

    private final static ObservableList<Film> filmListe = FXCollections.observableArrayList();

    public static ObservableList<Film> hentFilmData(){
        lesFilmData();
        return filmListe;
    }

    public static void slettFraListen(int index){
        filmListe.remove(index);
    }

    private static void lesFilmData() {

        try {
            BufferedReader br = new BufferedReader(new FileReader("filmer.csv"));
            String linje;
            while ((linje = br.readLine()) != null){

                String[] values = linje.split(";");
                Film enFilm = new Film(values[0], values[1], parseDouble(values[2]), LocalDate.parse(values[3]));
                filmListe.add(enFilm);
            }
        }
        catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}


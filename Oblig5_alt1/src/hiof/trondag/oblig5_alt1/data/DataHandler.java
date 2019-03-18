package hiof.trondag.oblig5_alt1.data;

import hiof.trondag.oblig5_alt1.controller.FilmController;
import hiof.trondag.oblig5_alt1.model.Film;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

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
        //Leser fra csv filen
        try {
            BufferedReader br = new BufferedReader(new FileReader("filmer.csv"));
            String linje;

            //Mens linja ikke er null, les av verdiene og putt de inn i lista med filmer!
            int filmIndex = 1;
            while ((linje = br.readLine()) != null){

                //Splitt på komma og legg i en midlertidig array med stringer
                String[] values = linje.split(";");
                //Lag film og legg i lista
                filmListe.add(new Film(values[0], values[1], parseDouble(values[2]), LocalDate.parse(values[3]), values[4]));
                filmIndex++;
            }
        }
        catch (FileNotFoundException fnfe){
            //Melding til bruker hvis filen ikke er funnet
            Alert fnfeAlert = new Alert(Alert.AlertType.ERROR);
            fnfeAlert.setHeaderText("Feil!");
            fnfeAlert.setContentText("Fil ikke funnet");
            fnfeAlert.showAndWait();

            fnfe.printStackTrace();

        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    //Skriver over alt det gamle og erstatter med nytt innhold
    public static void lagreFilmData(){
        try (BufferedWriter bufretWriter = new BufferedWriter(new FileWriter("filmer.csv"))) {

            for (Film enFilm : filmListe){
                bufretWriter.write(enFilm.getTittel() + ";"
                + enFilm.getBeskrivelse() + ";"
                + enFilm.getSpilletid() + ";"
                + enFilm.getUtgivelsesdato() + ";"
                + enFilm.getBildePath());

                bufretWriter.newLine();
            }


        } catch (Exception e){
            Alert eAlert = new Alert(Alert.AlertType.ERROR);
            eAlert.setHeaderText("Feil!");
            eAlert.setContentText("Noe gikk desverre galt");
            eAlert.showAndWait();

            e.printStackTrace();
        }
    }
}


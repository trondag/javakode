package hiof.trondag.oblig4.controller;

import hiof.trondag.oblig4.MainJavaFX;
import hiof.trondag.oblig4.data.DataHandler;
import hiof.trondag.oblig4.model.Film;
import javafx.collections.ObservableList;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.util.Collections;

public class FilmController {
    public static void setFilmIListe(Film film, int index) {
        FilmController.filmerIListe.set(index, film);

    }

    private static ObservableList<Film> filmerIListe;
    private static int antallFilmer = 0;
    private static int valgtFilmIndex = 0;

    public static ObservableList<Film> getFilmer(){
        return filmerIListe;
    }


    public static int getValgtFilmIndex() {
        return valgtFilmIndex;
    }

    @FXML
    private ListView idFilmListe;

    @FXML
    private Text idFilmTittel, idAntallFilmer;

    @FXML
    private TextArea idBeskrivelse, idUtgivelsesDato, idSpilletid;

    @FXML
    private Button idNyKnapp, idRedigerKnapp, idSlettKnapp;

    @FXML
    public void initialize() {

        //Henter all dataen fra listen i DataHandler.java
        filmerIListe = DataHandler.hentFilmData();
        Collections.sort(filmerIListe);
        fyllListe();
        oppdaterAntallFilmer();

        idNyKnapp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    RedigerFilmerController.skalDetLagesNyFilm = true;
                    MainJavaFX.getInstance().visRedigerVindu("Ny film");
                } catch (Exception e){
                    e.printStackTrace();
                }

            }
        });

        idRedigerKnapp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                try {
                    RedigerFilmerController.skalDetLagesNyFilm = false;
                    MainJavaFX.getInstance().visRedigerVindu("Rediger film");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        idSlettKnapp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DataHandler.slettFraListen(idFilmListe.getSelectionModel().getSelectedIndex());
            }
        });

        filmerIListe.addListener(new ListChangeListener<Film>() {
            @Override
            public void onChanged(Change<? extends Film> change) {

                //Oppdaterer ListView hvis observableList endrer seg
                idFilmListe.getItems().clear();
                fyllListe();
                oppdaterAntallFilmer();
            }
        });
    }

    public void fyllListe(){
        //Legger filmene inn i ListView
        for (Film enFilm: filmerIListe) {
            idFilmListe.getItems().add(enFilm.toString());
        }
    }

    @FXML
    public void idListeTrykketPaa(MouseEvent mouseEvent){
        int listeIndex = idFilmListe.getSelectionModel().getSelectedIndex();
        valgtFilmIndex = listeIndex;
        settEgenskaper(listeIndex);
    }

    private void settEgenskaper(int index){
        idFilmTittel.setText(filmerIListe.get(index).getTittel());
        idBeskrivelse.setText(filmerIListe.get(index).getBeskrivelse());
        idUtgivelsesDato.setText(filmerIListe.get(index).getUtgivelsesdato().toString());
        idSpilletid.setText(filmerIListe.get(index).getSpilletidTilMinOgSek());
    }

    public static void leggTilFilm(Film enFilm){
        filmerIListe.add(enFilm);
        Collections.sort(filmerIListe);
    }

    private void oppdaterAntallFilmer(){
        antallFilmer = filmerIListe.size();
        idAntallFilmer.setText("Antall filmer: " + antallFilmer);
    }
}
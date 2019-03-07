package hiof.trondag.oblig4.controller;

import hiof.trondag.oblig4.MainJavaFX;
import hiof.trondag.oblig4.data.DataHandler;
import hiof.trondag.oblig4.model.Film;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import java.util.Collections;


public class FilmController {

    private static ObservableList<Film> filmerIListe;
    private static int valgtFilmIndex;

    public static void setFilmIListe(Film film, int index) {
        FilmController.filmerIListe.set(index, film);

    }


    public static int getValgtFilmIndex() {
        return valgtFilmIndex;
    }

    //Alle FXML elementene
    @FXML
    private ListView<Film> filmListeListView;

    @FXML
    private Text filmTittelText, idAntallFilmer;

    @FXML
    private TextArea beskriveTextArea, utgivelseDatoTextArea, idSpilletid;


    @FXML
    private Button idNyKnapp, idRedigerKnapp, idSlettKnapp;

    @FXML
    private void initialize() {

        //Henter all dataen fra listen i DataHandler.java
        //filmerIListe = DataHandler.hentFilmData();


        //Fyller opp ListView med filmer fra listen
        filmListeListView.getItems().addAll( DataHandler.hentFilmData() );

        System.out.println(filmListeListView.getItems());
        //Sorterer listen
        Collections.sort(filmListeListView.getItems());

        System.out.println(filmListeListView.getItems());

        //Oppdaterer den statiske variabelen med antall filmer
        oppdaterAntallFilmer();

        idNyKnapp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    //En boolean som jeg sender med til RedigerFilmController.
                    RedigerFilmerController.skalDetLagesNyFilm = true;
                    //Metode i Main som lager vindu
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
                    //En boolean som jeg sender med til RedigerFilmController.
                    RedigerFilmerController.skalDetLagesNyFilm = false;
                    //Metode i Main som lager vindu
                    MainJavaFX.getInstance().visRedigerVindu("Rediger film");
                    valgtFilmIndex = filmListeListView.getSelectionModel().getSelectedIndex();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        idSlettKnapp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //Sletter fra listen, metoden er i DataHandler
                filmListeListView.getItems().remove(filmListeListView.getSelectionModel().getSelectedIndex());
            }
        });



    }

    @FXML
    private void idListeTrykketPaa(MouseEvent mouseEvent){
        settEgenskaper();
    }

    //Fyller opp hvert felt med informasjon
    private void settEgenskaper(){

        Film valgFilm = filmListeListView.getSelectionModel().getSelectedItem();

        filmTittelText.setText(valgFilm.getTittel());
        beskriveTextArea.setText(valgFilm.getBeskrivelse());
        utgivelseDatoTextArea.setText(valgFilm.getUtgivelsesdato().toString());
        idSpilletid.setText(valgFilm.getSpilletidTilMinOgSek());
    }

    //Legger til film i slutten av ObserveableList med filmer
    public void leggTilFilm(Film enFilm){
        filmListeListView.getItems().add(enFilm);
        Collections.sort(filmerIListe);
    }

    //Oppdater teksten som forteller antall filmer
    private void oppdaterAntallFilmer(){
        idAntallFilmer.setText("Antall filmer: " + filmListeListView.getItems().size());
    }

    public static void oppdaterListView(){

    }
}
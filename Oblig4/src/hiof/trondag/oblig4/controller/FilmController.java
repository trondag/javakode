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

    private static ObservableList<Film> filmerIListe;
    private static int antallFilmer = 0;
    private static int valgtFilmIndex = 0;

    public static void setFilmIListe(Film film, int index) {
        FilmController.filmerIListe.set(index, film);
    }

    public static ObservableList<Film> getFilmer(){
        return filmerIListe;
    }


    public static int getValgtFilmIndex() {
        return valgtFilmIndex;
    }


    //Alle FXML elementene
    @FXML
    private ListView idFilmListe;

    @FXML
    private Text idFilmTittel, idAntallFilmer;

    @FXML
    private TextArea idBeskrivelse, idUtgivelsesDato, idSpilletid;

    @FXML
    private Button idNyKnapp, idRedigerKnapp, idSlettKnapp;

    @FXML
    private void initialize() {

        //Henter all dataen fra listen i DataHandler.java
        filmerIListe = DataHandler.hentFilmData();
        //Sorterer listen
        Collections.sort(filmerIListe);
        //Fyller opp ListView med filmer fra listen
        fyllListe();
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
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        idSlettKnapp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //Sletter fra listen, metoden er i DataHandler
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

    private void fyllListe(){
        //Legger filmene inn i ListView
        for (Film enFilm: filmerIListe) {
            idFilmListe.getItems().add(enFilm.toString());
        }
    }

    @FXML
    private void idListeTrykketPaa(MouseEvent mouseEvent){
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
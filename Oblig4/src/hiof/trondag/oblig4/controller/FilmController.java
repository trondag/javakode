package hiof.trondag.oblig4.controller;

import hiof.trondag.oblig4.MainJavaFX;
import hiof.trondag.oblig4.data.DataHandler;
import hiof.trondag.oblig4.model.Film;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import java.lang.Double;
import javafx.scene.input.MouseEvent;

public class FilmController {
    private ObservableList<Film> filmerIListe;
    private static int antallFilmer = 0;

    @FXML
    private ListView idFilmListe;

    @FXML
    private Text idFilmTittel;

    @FXML
    private TextArea idBeskrivelse, idUtgivelsesDato, idSpilletid;

    @FXML
    private Button idNyKnapp, idRedigerKnapp, idSlettKnapp;

    @FXML
    public void initialize() {


        //Henter all dataen fra listen i DataHandler.java
        filmerIListe = DataHandler.hentFilmData();

        //Legger det jeg vil at denne dataen i en ArrayList
        for (int i = 0 ; i < filmerIListe.size() ; i++){
            idFilmListe.getItems().add(i, filmerIListe.get(i).getTittel() + " (" + filmerIListe.get(i).getUtgivelsesdato().getYear() + ")");
            antallFilmer++;
        }

        idRedigerKnapp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                try {
                    MainJavaFX.visRedigerVindu();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @FXML
    public void idListeTrykketPaa(MouseEvent mouseEvent){
        int listeIndex = idFilmListe.getSelectionModel().getSelectedIndex();
        settEgenskaper(listeIndex);
    }

    private void settEgenskaper(int index){
        idFilmTittel.setText(filmerIListe.get(index).getTittel());
        idBeskrivelse.setText(filmerIListe.get(index).getBeskrivelse());
        idUtgivelsesDato.setText(filmerIListe.get(index).getUtgivelsesdato().toString());
        idSpilletid.setText(filmerIListe.get(index).getSpilletidTilMinOgSek());
    }

}
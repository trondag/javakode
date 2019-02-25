package hiof.trondag.oblig4.controller;

import hiof.trondag.oblig4.data.DataHandler;
import hiof.trondag.oblig4.model.Film;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

public class FilmController {
    private ObservableList<Film> filmerIListe;

    @FXML
    private ListView idFilmListe;

    @FXML
    private Text idFilmTittel;

    private List<String> listeUtskrift = new ArrayList<>();

    @FXML
    public void initialize() {


        //Henter all dataen fra listen i DataHandler.java
        filmerIListe = DataHandler.hentFilmData();

        //Legger det jeg vil at denne dataen i en ArrayList
        for (int i = 0 ; i < filmerIListe.size() ; i++){
            listeUtskrift.add(i, filmerIListe.get(i).getTittel());
        }

        //Lager så en observableArrayList som jeg legger disse dataene inn i
        idFilmListe.setItems(FXCollections.observableArrayList(listeUtskrift));
    }

    @FXML
    public void idListeTrykketPaa(MouseEvent mouseEvent){
        //if (mouseEvent.getTarget().ge
        idFilmTittel.setText("tiss");
        System.out.println(mouseEvent.getTarget());
    }
}
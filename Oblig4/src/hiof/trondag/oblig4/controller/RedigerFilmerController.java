package hiof.trondag.oblig4.controller;

import hiof.trondag.oblig4.model.Film;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

import java.time.LocalDate;

public class RedigerFilmerController {


    @FXML
    private Button idLagreKnapp;

    @FXML
    private TextField idTittelInput, idSpilletidInput;

    @FXML
    private TextArea idBeskrivelseInput;

    @FXML
    private DatePicker idDatoInput;

    public void initialize(){
        idLagreKnapp.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                try{

                }
            }
        });
    }

    public Film lesInformasjon(){
        String tittel = idTittelInput.getText();
        String beskrivelse = idBeskrivelseInput.getText();
        Double spilletid = Double.parseDouble(idSpilletidInput.getText());
        LocalDate utgivelsesDato = idDatoInput.getValue();
        Film nyFilm = new Film(tittel, beskrivelse, spilletid, utgivelsesDato);
        return nyFilm;
    }
}

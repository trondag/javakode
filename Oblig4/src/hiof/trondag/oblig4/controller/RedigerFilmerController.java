package hiof.trondag.oblig4.controller;

import hiof.trondag.oblig4.MainJavaFX;
import hiof.trondag.oblig4.model.Film;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.util.StringConverter;

import java.io.IOException;
import java.time.LocalDate;

public class RedigerFilmerController {

    private Film valgtFilm;
    public static boolean skalDetLagesNyFilm = true;

    @FXML
    private Button idLagreKnapp;

    @FXML
    private Text idOverskrift;

    @FXML
    private TextField idTittelInput, idSpilletidInput;

    @FXML
    private TextArea idBeskrivelseInput;

    @FXML
    private DatePicker idDatoInput;

    public void initialize(){

        // Denne kontrolleren kontrollerer både rediger og ny film.
        // Har flere if-tester som spør om boolean "skalDetLagesNyFilm" er true eller false.
        // Synes dette var en grei måte å gjøre det på

        if (!skalDetLagesNyFilm) {
            valgtFilm = FilmController.getFilmer().get(FilmController.getValgtFilmIndex());

            idTittelInput.setText(valgtFilm.getTittel());
            idBeskrivelseInput.setText(valgtFilm.getBeskrivelse());
            idDatoInput.setValue(valgtFilm.getUtgivelsesdato());
            idSpilletidInput.setText(String.valueOf(valgtFilm.getSpilletid()));
        }

        else {
            idOverskrift.setText("Ny film");
        }

        idLagreKnapp.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                try {
                    if (!skalDetLagesNyFilm) {
                        //Henter informasjon fra valgt film
                        valgtFilm.setTittel(idTittelInput.getText());
                        valgtFilm.setBeskrivelse(idBeskrivelseInput.getText());
                        valgtFilm.setUtgivelsesdato(idDatoInput.getValue());
                        valgtFilm.setSpilletid(Double.parseDouble(idSpilletidInput.getText()));

                        FilmController.setFilmIListe(valgtFilm, FilmController.getValgtFilmIndex());

                        MainJavaFX.getInstance().lukkRedigerVindu();

                    } else {
                        try {
                            //Henter informasjon som brukeren har skrevet inn og lager et film-objekt som blir lagt til i listen
                            String tittel = idTittelInput.getText().toLowerCase();
                            //Setter første forbokstav til stor bokstav
                            tittel = tittel.substring(0, 1).toUpperCase() + tittel.substring(1).toLowerCase();
                            String beskrivelse = idBeskrivelseInput.getText();
                            Double spilletid = Double.parseDouble(idSpilletidInput.getText());
                            LocalDate utgivelsesDato = idDatoInput.getValue();

                            Film nyFilm = new Film(tittel, beskrivelse, spilletid, utgivelsesDato);
                            FilmController.leggTilFilm(nyFilm);

                            MainJavaFX.getInstance().lukkRedigerVindu();

                        } catch (StringIndexOutOfBoundsException sioe){
                            Alert ikkeFyltUtAlleFelter = new Alert(Alert.AlertType.ERROR);
                            ikkeFyltUtAlleFelter.setTitle("Feil!");
                            ikkeFyltUtAlleFelter.setHeaderText("Felter ikke fylt ut!");
                            ikkeFyltUtAlleFelter.setContentText("Vennligst fyll ut felter med korrekt informasjon");
                            ikkeFyltUtAlleFelter.showAndWait();
                            sioe.printStackTrace();

                        }
                    }
                }
                catch (Exception e){
                }
            }
        });
    }
}

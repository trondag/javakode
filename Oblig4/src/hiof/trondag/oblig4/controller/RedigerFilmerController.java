package hiof.trondag.oblig4.controller;

import hiof.trondag.oblig4.MainJavaFX;
import hiof.trondag.oblig4.data.DataHandler;
import hiof.trondag.oblig4.model.Film;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;

import static hiof.trondag.oblig4.controller.FilmController.getValgtFilmIndex;

public class RedigerFilmerController {

    private Film valgtFilm;
    public static boolean skalDetLagesNyFilm = true;

    @FXML
    private Button idLagreKnapp;

    private Stage stage;

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
            //Henter riktig film ved hjelp av index som finnes i Filmkontroller
            //valgtFilm = FilmController.getFilmer().get(FilmController.getValgtFilmIndex());
            valgtFilm = DataHandler.getFilmListe().get(getValgtFilmIndex());

            //Fyller ut feltene med informasjonen som finnes fra før
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
                        //Sett egenskaper til filmen
                        valgtFilm.settEgenskaper(idTittelInput.getText(), idBeskrivelseInput.getText(), Double.parseDouble(idSpilletidInput.getText()), idDatoInput.getValue());
                        //Sett så filmen "tilbake" i listen
                        FilmController.setFilmIListe(valgtFilm, 0);

                        //Lukk vindu
                        stage.close();

                    } else {
                        try {
                            //Lager tomt filmobjekt
                            Film nyFilm = new Film();
                            //Setter instansvariablene
                            nyFilm.settEgenskaper(idTittelInput.getText(), idBeskrivelseInput.getText(), Double.parseDouble(idSpilletidInput.getText()), idDatoInput.getValue());
                            //Legger til denne filmen i observeableList
                            DataHandler.getFilmListe().add(nyFilm);

                            System.out.println(DataHandler.getFilmListe());
                            FilmController.oppdaterListView();

                            //Lukk vindu
                            stage.close();

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
                    e.printStackTrace();
                }
            }
        });
    }
    public void setStage(Stage stage) {
        this.stage = stage;
    }
}

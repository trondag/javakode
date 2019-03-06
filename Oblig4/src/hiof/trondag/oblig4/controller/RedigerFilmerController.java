package hiof.trondag.oblig4.controller;

import hiof.trondag.oblig4.MainJavaFX;
import hiof.trondag.oblig4.data.DataHandler;
import hiof.trondag.oblig4.model.Film;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

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
            //Hvilken film skal redigeres
            valgtFilm = FilmController.getFilmer().get(FilmController.getValgtFilmIndex());

            //Fyller ut feltene med allerede "lagret" informasjon
            idTittelInput.setText(valgtFilm.getTittel());
            idBeskrivelseInput.setText(valgtFilm.getBeskrivelse());
            idDatoInput.setValue(valgtFilm.getUtgivelsesdato());
            idSpilletidInput.setText(String.valueOf(valgtFilm.getSpilletid()));
        }

        else {
            //Ny film i stedet
            idOverskrift.setText("Ny film");
        }

        idLagreKnapp.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                try {
                    if (!skalDetLagesNyFilm) {

                        inputKontroll();

                        valgtFilm.settEgenskaper(idTittelInput.getText(), idBeskrivelseInput.getText(), Double.parseDouble(idSpilletidInput.getText()), idDatoInput.getValue());

                        //Setter filmen inn i observeable list, der den sto
                        FilmController.setFilmIListe(valgtFilm, FilmController.getValgtFilmIndex());

                        //Lukk
                        MainJavaFX.getInstance().lukkRedigerVindu();

                    } else {
                            //Nytt tomt filmobjekt
                            Film nyFilm = new Film();
                        System.out.println("bø");
                        System.out.println(idSpilletidInput.getText());

                        //Input kontroll
                         if (!inputKontroll()){
                             return;
                         }


                        //Dette ser rart ut, men hvis jeg ikke legger denne snutten inn i en slik if-test så starter den likevel, og programmet tryner
                        //Sett instansvariabler ved hjelp av metode i film-klassen
                        nyFilm.settEgenskaper(idTittelInput.getText(), idBeskrivelseInput.getText(), Double.parseDouble(idSpilletidInput.getText()), idDatoInput.getValue());

                        //Legg til i slutten av lista
                        FilmController.leggTilFilm(nyFilm);

                        MainJavaFX.getInstance().lukkRedigerVindu();

                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    private boolean inputKontroll(){
        if(idTittelInput.getText().equals("")){
            feilMelding("Vennligst fyll ut et navn!");
            return false;
        } else if (idBeskrivelseInput.getText().equals("")){
            feilMelding("Vennligst fyll ut beskrivelse!");
            return false;
        } else if (idSpilletidInput.getText().equals("")){
            feilMelding("Vennligst fyll ut spilletid i minutter!");
            return false;
        } else if (idDatoInput.getValue() == null){
            feilMelding("Velg utgivelsesdato!");
            return false;
        } else return true;
    }

    private void feilMelding(String feilMelding){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("En feil har oppstått");
        alert.setHeaderText(feilMelding);

        alert.showAndWait();
    }
}

package hiof.trondag.oblig5_alt1.controller;

import hiof.trondag.oblig5_alt1.MainJavaFX;
import hiof.trondag.oblig5_alt1.data.DataHandler;
import hiof.trondag.oblig5_alt1.model.Film;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class RedigerFilmerController {

    private Film valgtFilm;
    public static boolean skalDetLagesNyFilm = true;

    @FXML
    private Button lagreButton;

    @FXML
    private Text overskriftText;

    @FXML
    private TextField tittelInputTextField, spilleTidInputTextField;

    @FXML
    private TextArea beskrivelseInputTextArea;

    @FXML
    private DatePicker datoInputDatePicker;

    public void initialize(){

        // Denne kontrolleren kontrollerer både rediger og ny film.
        // Har flere if-tester som spør om boolean "skalDetLagesNyFilm" er true eller false.
        // Synes dette var en grei måte å gjøre det på, selv om det sikkert finnes mye bedre løsninger

        if (!skalDetLagesNyFilm) {
            //Hvilken film skal redigeres
            valgtFilm = DataHandler.getFilmListe().get(FilmController.getValgtFilmIndex());

            //Fyller ut feltene med allerede "lagret" informasjon
            tittelInputTextField.setText(valgtFilm.getTittel());
            beskrivelseInputTextArea.setText(valgtFilm.getBeskrivelse());
            datoInputDatePicker.setValue(valgtFilm.getUtgivelsesdato());
            spilleTidInputTextField.setText(String.valueOf(valgtFilm.getSpilletid()));
        }

        else {
            //Ny film i stedet
            overskriftText.setText("Ny film");
        }

        lagreButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                try {
                    if (!skalDetLagesNyFilm) {

                        //Input kontroll
                        if (!inputKontroll())
                            return;

                        //Setter instansvariabler ved hjelp av metode i film-klassen
                        valgtFilm.setTittel(tittelInputTextField.getText());
                        valgtFilm.setBeskrivelse(beskrivelseInputTextArea.getText());
                        valgtFilm.setSpilletid(Double.parseDouble(spilleTidInputTextField.getText()));
                        valgtFilm.setUtgivelsesdato(datoInputDatePicker.getValue());

                        //Setter filmen inn i observeable list, der den sto
                        FilmController.setFilmIListe(valgtFilm, FilmController.getValgtFilmIndex());

                        //Lukk
                        MainJavaFX.getInstance().lukkRedigerVindu();

                    } else {
                        //Nytt tomt filmobjekt
                        Film nyFilm = new Film();

                        //Input kontroll
                         if (!inputKontroll())
                             return;

                        //Setter instansvariabler ved hjelp av metode i film-klassen
                        nyFilm.settEgenskaper(tittelInputTextField.getText(),
                                beskrivelseInputTextArea.getText(),
                                Double.parseDouble(spilleTidInputTextField.getText()),
                                datoInputDatePicker.getValue());

                        //Legg til i slutten av lista
                        FilmController.leggTilFilm(nyFilm);

                        //Lukk vindu
                        MainJavaFX.getInstance().lukkRedigerVindu();

                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    //Input kontroll som returnerer false hvis feil input og true hvis riktig
    private boolean inputKontroll(){
        if(tittelInputTextField.getText().equals("")){
            feilMelding("Vennligst fyll ut et navn!");
            return false;
        } else if (beskrivelseInputTextArea.getText().equals("")){
            feilMelding("Vennligst fyll ut beskrivelse!");
            return false;
        } else if (spilleTidInputTextField.getText().equals("")){
            feilMelding("Vennligst fyll ut spilletid i minutter!");
            return false;
        } else if (datoInputDatePicker.getValue() == null){
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

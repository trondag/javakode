package hiof.trondag.Oblig5Alt2.controller;

import hiof.trondag.Oblig5Alt2.Data.DataHandler;
import hiof.trondag.Oblig5Alt2.model.Valuta;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ValutaController {

    @FXML
    private ComboBox<Valuta> valuta1ComboBox, valuta2ComboBox;

    @FXML
    private TextField valuta1TextField, valuta2TextField;

    @FXML
    private Button beregnButton;

    @FXML
    private ImageView valuta1ImageView, valuta2ImageView;

    @FXML
    private void initialize(){
        valuta1ComboBox.getItems().addAll(DataHandler.hentValutaData());
        valuta2ComboBox.getItems().addAll(DataHandler.getKurser());

        beregnButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                double valutaKurs1 = valuta1ComboBox.getSelectionModel().getSelectedItem().getValue();
                double valutaKurs2 = valuta2ComboBox.getSelectionModel().getSelectedItem().getValue();
                double verdi1 = Double.parseDouble(valuta1TextField.getText());
                valuta2TextField.setText(Double.toString(verdi1*valutaKurs1/valutaKurs2));


            }
        });

        valuta1ComboBox.valueProperty().addListener(new ChangeListener<Valuta>() {
            @Override
            public void changed(ObservableValue<? extends Valuta> observableValue, Valuta valuta, Valuta t1) {
                settBilde(1, valuta1ComboBox.getSelectionModel().getSelectedItem().getCountrycode());
            }
        });

        valuta2ComboBox.valueProperty().addListener(new ChangeListener<Valuta>() {
            @Override
            public void changed(ObservableValue<? extends Valuta> obserableValue, Valuta valuta, Valuta t1) {
                settBilde(2, valuta2ComboBox.getSelectionModel().getSelectedItem().getCountrycode());
            }
        });
    }

    private void settBilde(int hvilkenBox, String landsKode) {
        String path = "https://www.countryflags.io/" + landsKode.toLowerCase() + "/shiny/64.png";
        Image flagg = new Image(path);

        switch (hvilkenBox){
            case 1:
                valuta1ImageView.setImage(flagg);
                break;
            case 2:
                valuta2ImageView.setImage(flagg);
                break;
            default:
                break;
        }

    }
}

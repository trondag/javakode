package hiof.trondag.Oblig5Alt2.controller;

import hiof.trondag.Oblig5Alt2.Data.DataHandler;
import hiof.trondag.Oblig5Alt2.model.Valuta;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class ValutaController {

    @FXML
    private ComboBox<Valuta> valuta1ComboBox, valuta2ComboBox;

    @FXML
    private void initialize(){
        valuta1ComboBox.getItems().addAll(DataHandler.hentValutaData());
        valuta2ComboBox.getItems().addAll(DataHandler.getKurser());


    }
}

package hiof.trondag.oblig5_alt1;

import hiof.trondag.oblig5_alt1.controller.RedigerFilmerController;
import hiof.trondag.oblig5_alt1.data.DataHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MainJavaFX extends Application {

    private Stage primaryStage;
    private Stage redigerRigg;
    private static MainJavaFX instance;

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Starter hovedvinduet og setter programmet som en statisk variabel slik at den kan nås fra andre klasser
        this.primaryStage = primaryStage;
        instance = this;

        visFilmVindu();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void visFilmVindu() throws IOException {
        //Viser hovedvinduet
        FXMLLoader fxmlInnlaster = new FXMLLoader();
        fxmlInnlaster.setLocation(getClass().getResource("view/Filmer.fxml"));

        Parent hovedLayout = fxmlInnlaster.load();

        Scene hovedScene = new Scene(hovedLayout);

        primaryStage.setScene(hovedScene);
        primaryStage.setTitle("Filmer");
        primaryStage.show();
    }

    //Viser redigervinduet
    public void visRedigerVindu(String vinduNavn) throws Exception {
        FXMLLoader fxmlInnlasterRediger = new FXMLLoader();
        fxmlInnlasterRediger.setLocation(MainJavaFX.class.getResource("view/RedigerFilmer.fxml"));

        Parent hovedLayoutRediger = fxmlInnlasterRediger.load();

        Scene redigerScene = new Scene(hovedLayoutRediger);

        this.redigerRigg = new Stage();

        //initModality så man ikke kan trykke på bakgrunnsvinduet mens man redigerer
        redigerRigg.initModality(Modality.APPLICATION_MODAL);
        redigerRigg.initOwner(primaryStage);
        redigerRigg.setScene(redigerScene);
        redigerRigg.setTitle(vinduNavn);
        redigerRigg.show();
    }

    public void lukkRedigerVindu() throws Exception {
        redigerRigg.close();
    }

    public static MainJavaFX getInstance() {
        return instance;
    }

    @Override
    public void stop(){
        //Skriver over alt det gamle med det nye
        DataHandler.lagreFilmData();
    }
}

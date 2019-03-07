package hiof.trondag.oblig4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.IOException;

public class MainJavaFX extends Application {

    private Stage primaryStage;
    private Stage redigerRigg;
    private static MainJavaFX instance;

    @Override
    public void start(Stage primaryStage) {

        //Starter hovedvinduet og setter programmet som en statisk variabel slik at den kan nås fra andre klasser
        this.primaryStage = primaryStage;
        instance = this;

        try {
            visFilmVindu();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        RedigerFilmerController controller = fxmlInnlasterRediger.getController();

        Scene redigerScene = new Scene(hovedLayoutRediger);

        this.redigerRigg = new Stage();
        controller.setStage(redigerRigg);

        //initModality så man ikke kan trykke på bakgrunnsvinduet mens man redigerer
        redigerRigg.initModality(Modality.APPLICATION_MODAL);
        redigerRigg.initOwner(primaryStage);
        redigerRigg.setScene(redigerScene);
        redigerRigg.setTitle(vinduNavn);
        redigerRigg.show();
    }

    public void lukkRedigerVindu(){
        try{
            redigerRigg.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static MainJavaFX getInstance() {
        return instance;
    }
}

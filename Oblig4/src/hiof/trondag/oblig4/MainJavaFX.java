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
    private static MainJavaFX instance;

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage;
        instance = this;

        visFilmVindu();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void visFilmVindu() throws IOException {
        FXMLLoader fxmlInnlaster = new FXMLLoader();
        fxmlInnlaster.setLocation(getClass().getResource("view/Filmer.fxml"));

        Parent hovedLayout = fxmlInnlaster.load();

        Scene hovedScene = new Scene(hovedLayout);

        primaryStage.setScene(hovedScene);
        primaryStage.setTitle("Filmer");
        primaryStage.show();
    }

    public void visRedigerVindu() throws Exception {
        FXMLLoader fxmlInnlasterRediger = new FXMLLoader();
        fxmlInnlasterRediger.setLocation(MainJavaFX.class.getResource("view/RedigerFilmer.fxml"));

        Parent hovedLayoutRediger = fxmlInnlasterRediger.load();

        Scene redigerScene = new Scene(hovedLayoutRediger);

        Stage redigerRigg = new Stage();
        redigerRigg.initModality(Modality.APPLICATION_MODAL);
        redigerRigg.setScene(redigerScene);
        redigerRigg.setTitle("Rediger Film");
        redigerRigg.show();


    }

    public static MainJavaFX getInstance() {
        return instance;
    }
}

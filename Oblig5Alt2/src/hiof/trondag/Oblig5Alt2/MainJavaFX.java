package hiof.trondag.Oblig5Alt2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainJavaFX extends Application {
    private Stage primaryStage;
    private static MainJavaFX instance;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;
        instance = this;

        visVindu();
    }

    public static MainJavaFX getInstance() {
        return instance;
    }

    public void visVindu(){
        try {

            FXMLLoader fxmlInnlaster = new FXMLLoader();

            fxmlInnlaster.setLocation(getClass().getResource("view/valutakalkulator.fxml"));

            Parent hovedLayout = fxmlInnlaster.load();

            Scene hovedScene = new Scene(hovedLayout);

            primaryStage.setScene(hovedScene);

            primaryStage.setTitle("ValutaController-kalkulator");

            primaryStage.show();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

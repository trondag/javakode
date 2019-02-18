package hiof.trondag.oblig4;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class MainJavaFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        Label hei = new Label();
        hei.setText("Hællæ JavaFX");
    }
}

package hiof.trondag.oblig4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;

public class MainJavaFX extends Application {
    private int teller = 0;



    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlInnlaster = new FXMLLoader();
        fxmlInnlaster.setLocation(getClass().getResource("view/Filmer.fxml"));

        Parent hovedLayout = fxmlInnlaster.load();

        Scene hovedScene = new Scene(hovedLayout);

        primaryStage.setScene(hovedScene);
        primaryStage.setTitle("Filmer");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

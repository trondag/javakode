package hiof.trondag.oblig4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
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

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label etTekstFelt = new Label();
        etTekstFelt.setText("Hællæ JavaFX");
        etTekstFelt.setFont(Font.font("Calibri", 24));

        Button enKnapp = new Button("Trykk på meg!");

        enKnapp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                teller++;

                etTekstFelt.setText("Du har trykket på knappen " + teller + " ganger");

                if (teller == 10) {
                    visAlert();
                    teller = 0;
                }
            }
        });

        enKnapp.setOnMouseEntered(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("Mus over knapp!");

                enKnapp.setFont(Font.font("Calibri", 50));
            }
        });

        enKnapp.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                enKnapp.setFont(Font.font("Times", 20));
            }
        });

        VBox hovedLayout = new VBox();
        hovedLayout.setAlignment(Pos.CENTER);
        hovedLayout.getChildren().add(etTekstFelt);
        hovedLayout.getChildren().add(enKnapp);

        Scene hovedScenen = new Scene(hovedLayout, 600, 400);

        primaryStage.setScene(hovedScenen);
        primaryStage.setTitle("Min første JavaFX applikasjon");
        primaryStage.show();
    }

    private void visAlert() {
        Alert minAlert = new Alert(Alert.AlertType.INFORMATION);

        minAlert.setTitle("Du vant!");
        minAlert.setHeaderText(null);
        minAlert.setContentText("Gratulerer! Du klarte på trykke på knappen 10 ganger!");

        minAlert.showAndWait();
    }
}

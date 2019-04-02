package hiof.trondag.oblig5_alt1.controller;

import hiof.trondag.oblig5_alt1.MainJavaFX;
import hiof.trondag.oblig5_alt1.data.DataHandler;
import hiof.trondag.oblig5_alt1.model.Film;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ListChangeListener;
import javafx.collections.transformation.FilteredList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import java.util.Collections;


public class FilmController {

    private static ObservableList<Film> filmerIListe;
    private static int valgtFilmIndex = 0;

    public static int getValgtFilmIndex() {
        return valgtFilmIndex;
    }


    //Alle FXML elementene
    @FXML
    private ListView<Film> filmListeListView;

    @FXML
    private Text filmTittelText, antallFilmerText;

    @FXML
    private TextArea beskrivelseTextArea, utgivelsesdatoTextArea, spilletidTextArea;

    @FXML
    private TextField sokTextField;

    @FXML
    private Button nyFilmButton, redigerFilmButton, slettFilmButton;

    @FXML
    private ChoiceBox<String> sorteringChoiceBox;

    @FXML
    private ImageView posterImageView;

    @FXML
    private void initialize() {


        //Henter all dataen fra listen i DataHandler.java
        filmerIListe = DataHandler.hentFilmData();

        FilteredList<Film> filmerIListeFilteredList = new FilteredList<>(filmerIListe,  s -> true);


        //Sorterer listen
        Collections.sort(DataHandler.getFilmListe());
        //Fyller opp ListView med filmer fra listen
        filmListeListView.setItems(filmerIListeFilteredList);

        //ChoiceBox fylles med sorteringskriterier
        sorteringChoiceBox.setItems(FXCollections.observableArrayList("Tittel, stigende", "Tittel, synkende", "År, stigende", "År, synkende"));

        filmListeListView.setCellFactory(new Callback<ListView<Film>, ListCell<Film>>() {
            @Override
            public ListCell<Film> call(ListView<Film> filmListView) {
                return new FilmListCell();
            }
        });

        //Oppdaterer den statiske variabelen med antall filmer
        oppdaterAntallFilmer();

        nyFilmButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    //En boolean som jeg sender med til RedigerFilmController.
                    RedigerFilmerController.skalDetLagesNyFilm = true;
                    //Metode i Main som lager vindu
                    MainJavaFX.getInstance().visRedigerVindu("Ny film");
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        redigerFilmButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                try {
                    //En boolean som jeg sender med til RedigerFilmController.
                    RedigerFilmerController.skalDetLagesNyFilm = false;
                    valgtFilmIndex = filmListeListView.getSelectionModel().getSelectedIndex();

                    //Metode i Main som lager vindu
                    MainJavaFX.getInstance().visRedigerVindu("Rediger film");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        slettFilmButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //Sletter fra listen, metoden er i DataHandler
                DataHandler.getFilmListe().remove(filmListeListView.getSelectionModel().getSelectedIndex());
            }
        });

        filmerIListe.addListener(new ListChangeListener<Film>() {
            @Override
            public void onChanged(Change<? extends Film> change) {

                //Oppdaterer ListView hvis observableList endrer seg
                filmListeListView.setItems(filmerIListe);
                oppdaterAntallFilmer();
            }
        });

        sorteringChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            public void changed(ObservableValue ov, Number value, Number newValue) {
                int valgtSortering = (int) newValue;
                nySortering(valgtSortering);
            }
        });

        sokTextField.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {

                String filtertekst = sokTextField.getText();
                if (filtertekst == null || filtertekst.length() == 0) {
                    filmerIListeFilteredList.setPredicate(s -> true);
                } else {
                    filmerIListeFilteredList.setPredicate(s -> s.getTittel().contains(filtertekst));

                    //filmListeListView.setItems(filmerIListeFilteredList);
                }
            }
        });


    }

    private static class FilmListCell extends ListCell<Film> {
        @Override
        protected void updateItem(Film enFilm, boolean empty){
            super.updateItem(enFilm, empty);

            if (enFilm != null){
                setText(enFilm.getTittel() + " (" + enFilm.getUtgivelsesdato().getYear() + ")");
            }
        }
    }

    // setter en redigert film tilbake på samme plass i listen
    public static void setFilmIListe(Film film, int index) {
        DataHandler.getFilmListe().set(index, film);
    }


    @FXML
    private void idListeTrykketPaa(MouseEvent mouseEvent){
        Film enFilm = filmListeListView.getSelectionModel().getSelectedItem();
        filmTittelText.setText(enFilm.getTittel());
        beskrivelseTextArea.setText(enFilm.getBeskrivelse());
        utgivelsesdatoTextArea.setText(enFilm.getUtgivelsesdato().toString());
        spilletidTextArea.setText(enFilm.getSpilletidTilMinOgSek());
        Thread bildeLoader = new Thread(hentBilde);
        bildeLoader.setDaemon(false);
        bildeLoader.start();
        valgtFilmIndex = filmListeListView.getSelectionModel().getSelectedIndex();
    }
    /*
    private Image hentBilde(String path){
        path = "https://image.tmdb.org/t/p/w500" + path;
        Image poster = new Image(path);
        return poster;
    }*/

    public Task<Void> hentBilde = new Task<>() {
        @Override
        protected Void call(){
            try {
                Image poster = new Image("https://image.tmdb.org/t/p/w500" + filmListeListView.getSelectionModel().getSelectedItem().getBildePath());
                posterImageView.setImage(poster);
            } catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }
    };

    public static void leggTilFilm(Film enFilm){
        //Legger til film i lista
        DataHandler.getFilmListe().add(enFilm);
        Collections.sort(DataHandler.getFilmListe());
    }

    private void oppdaterAntallFilmer(){
        //Oppdatere en liten tekst som viser antall filmer
        antallFilmerText.setText("Antall filmer: " + DataHandler.getFilmListe().size());
    }

    private void nySortering(int index) {

        if (index == 0)
            DataHandler.getFilmListe().sort(Film.PAA_TITTEL_STIGENDE);

        if (index == 1)
            DataHandler.getFilmListe().sort(Film.PAA_TITTEL_SYNKENDE);

        if (index == 2)
            DataHandler.getFilmListe().sort(Film.PAA_DATO_STIGENDE);

        if (index == 3)
            DataHandler.getFilmListe().sort(Film.PAA_DATO_SYNKENDE);
    }
}
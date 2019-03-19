package hiof.trondag.oblig5_alt1.controller;

import com.sun.javafx.scene.ImageViewHelper;
import hiof.trondag.oblig5_alt1.MainJavaFX;
import hiof.trondag.oblig5_alt1.data.DataHandler;
import hiof.trondag.oblig5_alt1.model.Film;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

import java.util.Collections;
import java.util.Comparator;


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
        //Sorterer listen
        Collections.sort(DataHandler.getFilmListe());
        //Fyller opp ListView med filmer fra listen
        fyllListe();

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
                filmListeListView.getItems().clear();
                fyllListe();
                oppdaterAntallFilmer();
            }
        });

        sorteringChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            public void changed(ObservableValue ov, Number value, Number newValue) {
                int valgtSortering = (int) newValue;
                nySortering(valgtSortering);
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

    private void fyllListe(){
        //Legger filmene inn i ListView
        for (Film enFilm: DataHandler.getFilmListe()) {
            filmListeListView.getItems().add(enFilm);
        }
    }

    @FXML
    private void idListeTrykketPaa(MouseEvent mouseEvent){
        //Reagerer hvis listen blir trykket på, og oppdaterer egenskapene til høyre i grensesnittet
        valgtFilmIndex = filmListeListView.getSelectionModel().getSelectedIndex();
        settEgenskaper(valgtFilmIndex);
    }


    private void settEgenskaper(int index){
        //Oppdaterer egenskaper til høyre i grensesnitt hvis man trykker på en film
        filmTittelText.setText(DataHandler.getFilmListe().get(index).getTittel());
        beskrivelseTextArea.setText(DataHandler.getFilmListe().get(index).getBeskrivelse());
        utgivelsesdatoTextArea.setText(DataHandler.getFilmListe().get(index).getUtgivelsesdato().toString());
        spilletidTextArea.setText(DataHandler.getFilmListe().get(index).getSpilletidTilMinOgSek());
        posterImageView.setImage(hentBilde(DataHandler.getFilmListe().get(index).getBildePath()));
    }

    private Image hentBilde(String path){
        path = "https://image.tmdb.org/t/p/w500" + path;
        Image poster = new Image(path);
        return poster;
    }

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
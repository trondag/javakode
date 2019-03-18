package hiof.trondag.oblig5_alt1.controller;

import com.sun.javafx.scene.ImageViewHelper;
import hiof.trondag.oblig5_alt1.MainJavaFX;
import hiof.trondag.oblig5_alt1.data.DataHandler;
import hiof.trondag.oblig5_alt1.model.Film;
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


public class FilmController {

    private static ObservableList<Film> filmerIListe;
    private static int valgtFilmIndex = 0;


    public static ObservableList<Film> getFilmer(){
        return filmerIListe;
    }

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
    private Button nyFilmButton, redigerFilmButton, slettFilmButton;

    @FXML
    private ImageView posterImageView;

    @FXML
    private void initialize() {

        //Henter all dataen fra listen i DataHandler.java
        filmerIListe = DataHandler.hentFilmData();
        //Sorterer listen
        Collections.sort(filmerIListe);
        //Fyller opp ListView med filmer fra listen
        fyllListe();

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
                DataHandler.slettFraListen(filmListeListView.getSelectionModel().getSelectedIndex());
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
        FilmController.filmerIListe.set(index, film);
    }

    private void fyllListe(){
        //Legger filmene inn i ListView
        for (Film enFilm: filmerIListe) {
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
        filmTittelText.setText(filmerIListe.get(index).getTittel());
        beskrivelseTextArea.setText(filmerIListe.get(index).getBeskrivelse());
        utgivelsesdatoTextArea.setText(filmerIListe.get(index).getUtgivelsesdato().toString());
        spilletidTextArea.setText(filmerIListe.get(index).getSpilletidTilMinOgSek());
        posterImageView.setImage(hentBilde(filmerIListe.get(index).getBildePath()));
    }

    private Image hentBilde(String path){
        path = "https://image.tmdb.org/t/p/w500" + path;
        Image poster = new Image(path);
        return poster;
    }

    public static void leggTilFilm(Film enFilm){
        //Legger til film i lista
        filmerIListe.add(enFilm);
        Collections.sort(filmerIListe);
    }

    private void oppdaterAntallFilmer(){
        //Oppdatere en liten tekst som viser antall filmer
        antallFilmerText.setText("Antall filmer: " + filmerIListe.size());
    }
}
package hiof.trondag.oblig5_alt1.data;

import hiof.trondag.oblig5_alt1.model.Film;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class FilmMapper {

    private Connection connection;

    private final static ObservableList<Film> filmListe = FXCollections.observableArrayList();

    public FilmMapper(Connection connection) {
        this.connection = connection;
    }





    public static ObservableList<Film> hentFilmer() {

        String url = "jdbc:mysql://localhost:3306/filmdata?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";

        String bruker = "root";
        String passord = "";

        try (Connection connection = DriverManager.getConnection(url, bruker, passord)){

            FilmMapper filmMapper = new FilmMapper(connection);

            Statement statement = connection.createStatement();

            String sporring = "SELECT * FROM filmer;";

            ResultSet resultSet = statement.executeQuery(sporring);

            while (resultSet.next()) {
                int filmId = resultSet.getInt(1);
                String tittel = resultSet.getString(2);
                LocalDate utgivelsesdato = resultSet.getDate(5).toLocalDate();
                Film film = new Film(filmId, tittel, utgivelsesdato);
                filmListe.add(film);
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        return filmListe;
    }
}

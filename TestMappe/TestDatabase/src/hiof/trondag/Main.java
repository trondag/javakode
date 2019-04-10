package hiof.trondag;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.util.ArrayList;

import static java.lang.Double.parseDouble;
import static java.nio.charset.StandardCharsets.UTF_8;

import java.sql.*;

public class Main {

    public static ArrayList<Film> filmListe = new ArrayList<>();



    public static void main(String[] args) {
        String path = "filmer.csv";
        try (BufferedReader leser = new BufferedReader(new InputStreamReader(new FileInputStream(path), "utf8")))
        {
            String linje;

            while ((linje = leser.readLine()) != null){
                String[] verdier = linje.split(";");
                filmListe.add(new Film(verdier[0], verdier[1], parseDouble(verdier[2]), LocalDate.parse(verdier[3]), verdier[4]));
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/filmdata?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";

        String bruker = "root";
        String passord = "";

        try (Connection connection = DriverManager.getConnection(url, bruker, passord)){

            FilmMapper filmMapper = new FilmMapper(connection);

            System.out.println(filmListe.get(0).getTittel());
            System.out.println(filmListe.get(0).getBeskrivelse());

            for (Film film : filmListe){
                filmMapper.leggTilFilm(film);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

package hiof.trondag;

import java.sql.*;

public class FilmMapper {

    private Connection connection;

    public FilmMapper(Connection connection) {
        this.connection = connection;
    }

    public void leggTilFilm(Film enFilm){
        String sql = String.format("INSERT INTO filmer (tittel, beskrivelse, spilletid, utgivelsesdato, bildepath)" +
                "values ('%s', '%s', '%s', '%s', '%s');", enFilm.getTittel(),
                enFilm.getBeskrivelse(), enFilm.getSpilletid(), enFilm.getUtgivelsesDato(), enFilm.getBildePath());

        String sql1 = "INSERT INTO filmer (tittel, beskrivelse, spilletid, utgivelsesdato, bildepath) VALUES(?, ?, ?, ?, ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql1)){
            preparedStatement.setString(1, enFilm.getTittel());
            preparedStatement.setString(2, enFilm.getBeskrivelse());
            preparedStatement.setDouble(3, enFilm.getSpilletid());
            preparedStatement.setDate(4, Date.valueOf(enFilm.getUtgivelsesDato()));
            preparedStatement.setString(5, enFilm.getBildePath());

            preparedStatement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
/*
        try (
                Statement statement = connection.createStatement()){
            //statement.execute(, Statement.RETURN_GENERATED_KEYS);

            ResultSet resultSet = statement.getGeneratedKeys();

            if (resultSet.next())
                enFilm.setId((int) resultSet.getLong("film_id"));
        } catch (SQLException sqle){
            System.err.println("Feil: " + sqle);
        }*/
    }
}

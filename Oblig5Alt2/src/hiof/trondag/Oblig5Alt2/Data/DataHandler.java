package hiof.trondag.Oblig5Alt2.Data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import hiof.trondag.Oblig5Alt2.model.Valuta;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class DataHandler {
    private  static ArrayList<Valuta> kurser;

    public  static ArrayList<Valuta> getKurser() {
        return kurser;
    }

    public static ArrayList<Valuta> hentValutaData(){
        GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();

        Gson gson = gsonBuilder.create();

        String linje = "";

        StringBuilder jsonFraTekstFil = new StringBuilder();

        ArrayList<Valuta> kursListe = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("valutakurser.json"))){
            while ((linje = bufferedReader.readLine()) != null) {
                jsonFraTekstFil.append(linje);

                System.out.println(linje);
            }

            Valuta[] valutaArray = gson.fromJson(jsonFraTekstFil.toString(), Valuta[].class);

            kursListe.addAll(Arrays.asList(valutaArray));

        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Valuta valuta: kursListe) {
            System.out.println(valuta);
        }
        kurser = kursListe;
        return kursListe;
    }
}

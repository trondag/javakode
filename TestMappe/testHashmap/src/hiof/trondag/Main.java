package hiof.trondag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Main {

    private static ArrayList<String> fargeListe = new ArrayList<>();
    private static ArrayList<String> fargeliste2 = new ArrayList<>();

    public static ArrayList<String> getFargeListe() {
        return fargeListe;
    }

    private enum bokNavn {
        HARRY_POTTER,
        MAREKORS,
        GAME_OF_THRONES,
        SECRETS_AND_LIES,
        DATABASER
    }

    public static void main(String[] args) {



        String blå = "blå";
        String gul = "gul";
        String rød = "rød";

        fargeListe.add(blå);
        fargeListe.add(gul);
        fargeListe.add(rød);

        String lilla = "lilla";

        fargeListe.add(0, lilla);

        updateFarge(0, "lillagrønn");

        fargeListe.remove(2);


        Collections.sort(fargeListe);

        String oransj = "oransj";
        String turkis = "turkis";


        fargeliste2.add(oransj);
        fargeliste2.add(turkis);

        fargeListe.addAll(fargeliste2);

        System.out.println(fargeListe);

        int[] tall = new int[5];

        int i = 0;
        int tallet;
        while (i < 5) {
            tallet = (int) Math.ceil(Math.random()*5);
            if (!contains(tall, tallet)){
                tall[i] = tallet;
                i++;
            }
        }

        ArrayList<String> omrokkertListe = new ArrayList<>(5);
        for (int etTall : tall
                ) {
            omrokkertListe.add(fargeListe.get(etTall-1));
        }
        fargeListe = omrokkertListe;
        System.out.println(fargeListe);

        // -----HASHMAP------  //


        HashMap<bokNavn, Bok> bokListe = new HashMap();

        Bok harryPotter = new Bok("Harry Potter", 1994, 295);
        Bok marekors = new Bok("Marekors", 1998, 365);
        Bok goT = new Bok("Game of Thrones", 2001, 679);
        Bok secretsAndLies = new Bok("Secrets & Lies", 2005, 398);
        Bok databaser = new Bok("Databaser", 2006, 431);

        bokListe.put(bokNavn.HARRY_POTTER, harryPotter);
        bokListe.put(bokNavn.MAREKORS, marekors);
        bokListe.put(bokNavn.GAME_OF_THRONES, goT);
        bokListe.put(bokNavn.SECRETS_AND_LIES, secretsAndLies);
        bokListe.put(bokNavn.DATABASER, databaser);

        System.out.println(bokListe.get(bokNavn.SECRETS_AND_LIES));

        System.out.println(bokListe.containsValue(goT));

        System.out.println(bokListe.keySet());
        System.out.println(bokListe);




    }

    private static String getFarge(int index) {
        return fargeListe.get(index);
    }

    private static void updateFarge(int index, String farge) {
        fargeListe.set(index, farge);
    }

    private static boolean contains(int[] array, int nokkel){
        for (int i = 0; i < array.length ; i++){
            if (nokkel == array[i])
                return true;
        }
        return false;
    }


}
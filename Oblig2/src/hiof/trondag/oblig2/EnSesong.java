package hiof.trondag.oblig2;

import java.util.ArrayList;

public class EnSesong {
    public String sesongTittel;
    public ArrayList<Episode> episoder;

    /*************
     * ----KONSTRUKTØR, DENNE ER BARE FOR Å HENTE EPISODENE FRA EN SESONG, TRENGER DERFOR IKKE TITTEL OSV
     */

    public EnSesong() {
        episoder = new ArrayList<>();
        sesongTittel = "";
    }

    public EnSesong hentEnSesong(TVSerie serie, int sesong, EnSesong enSesong){


        for(int i = 0; i < serie.episoder.size() ; i++){
            if (serie.episoder.get(i).getSesongNummer() == sesong) {
                enSesong.episoder.add(serie.episoder.get(i));
            }
        }
        sesongTittel = serie.getTittel() + ", sesong " + sesong;
        return enSesong;

    }

    @Override
    public String toString(){
        return sesongTittel + "\nInneholder episodene :\n" + TVSerie.iterEpisoder();
    }
}

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

    /*****
     * ----------Fryktelig stygg dublisert kode, men jeg fikk ikke til å gjenbruke iterEpisoder fra klasse: TVSerie
     * @return
     */

    @Override
    public String toString(){
        return sesongTittel + "\n**********************\nInneholder episodene:\n" + iterEpisoderSesong();
    }
    public String iterEpisoderSesong(){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i<episoder.size() ; i++){
            stringBuilder.append(episoder.get(i).getEpisodeNummer() + ". " + episoder.get(i).getEpisodeTittel() + "\n");
        }
        return stringBuilder.toString();
    }
}

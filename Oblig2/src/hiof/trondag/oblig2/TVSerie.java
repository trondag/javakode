package hiof.trondag.oblig2;
import java.time.LocalDate;
import java.util.ArrayList;

/************************'
 * Klassen TVSerie, som inneholder konstruktør, get-metoder og en leggTilEpisode-metode.
 */

public class TVSerie {
    private String tittel;
    private String beskrivelse;
    private LocalDate publiseringsDato;
    public ArrayList<Episode> episoder;

    public TVSerie(String tittel, String beskrivelse, LocalDate publiseringsDato) {
        this.tittel = tittel;
        this.beskrivelse = beskrivelse;
        this.publiseringsDato = publiseringsDato;
        episoder = new ArrayList<>();
    }

    /*******
     *        GET-METODER
     * @return
     */

    public String getTittel() {
        return tittel;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public LocalDate getPubliseringsDato() {
        return publiseringsDato;
    }

    public ArrayList<Episode> getEpisoder() {
        return episoder;
    }

    /****
     *      METODE SOM LEGGER TIL EPISODER
     * @param episode
     */

    public void leggTilEpisode(Episode episode){
        episoder.add(episode);
    }

    //-------------------------------//
    // OVERRIDE TOSTRING() oppgave 5 //
    //-------------------------------//

    public String iterEpisoder(){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i<episoder.size() ; i++){
            stringBuilder.append(episoder.get(i).getEpisodeNummer() + ". " + episoder.get(i).getEpisodeTittel() + "\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString(){
        return "Tittel: " + tittel + "\nBeskrivelse: " + beskrivelse + "\nPubliseringsdato: " + publiseringsDato
                + "\nInneholder episodene: \n" + iterEpisoder();
    }

    /************************
     * -----------Metode som lager episoder
     */


    public TVSerie lagEpisoder(TVSerie serie, int antallSesonger, int antallEpisoder){
        for(int i = 1 ; i <=antallSesonger ; i++){
            for(int j = 1 ; j <= antallEpisoder ; j++){
                Episode episode = new Episode("Episode " + j, j, i);
                serie.leggTilEpisode(episode);
            }
        }
        return serie;
    }
/*
    public TVSerie hentEnSesong(TVSerie serie, int sesong){
        for(int i = 0; i < serie.episoder.size() ; i++){
            if (serie.episoder.get(i).getSesongNummer() == sesong){
                serie.leggTilEpisode(serie.episoder.get(i));
            }
        }
        return serie;
    }
*/

}


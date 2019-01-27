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
    public Double gjennomSnittligSpilletid;
    private int antallSesonger;

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

    public Double getGjennomSnittligSpilletid() {
        return gjennomSnittligSpilletid;
    }

    public int getAntallSesonger() {
        return antallSesonger;
    }

    /******************************************
     *      METODE SOM LEGGER TIL EPISODER (oppgave 9)
     * @param episode
     */

    public void leggTilEpisode(Episode episode){
        if(episode.getSesongNummer() > (getAntallSesonger())+1){
            System.out.println("Error: Episoden tilhører for høy sesong.");
            return;
        } else {
            episoder.add(episode);
            if(episode.getSesongNummer() == (getAntallSesonger()+1)){
                antallSesonger++;
            }
        }
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
                Double minutter = Math.random()*10+20;
                Episode episode = new Episode("Episode " + j, j, i, minutter);
                serie.leggTilEpisode(episode);
                oppdaterGjennomsnittligSpilletid(serie);
            }
        }
        return serie;
    }

    /****
     * ------------Metode som regner ut gjennomsnittlig spilletid
     */

    private void oppdaterGjennomsnittligSpilletid(TVSerie serie) {
        Double snittSpilleTid = 0.0;
        int k;
        for (k = 0; k < serie.episoder.size(); k++) {
            Double episodensSpilletid = serie.episoder.get(k).getSpilletid();
            snittSpilleTid += episodensSpilletid;
        }
        serie.gjennomSnittligSpilletid = snittSpilleTid / (k + 1);
        return;
    }

    /**************
     * ----------------Metode som lager en penere utskrift, og regner ut sekunder.
     * @param minTall
     * @return
     */

    public String minutterOgSekunder(Double minTall){
        int minutter = (int) Math.floor(minTall);
        Double raaSekunder = (minTall % minutter)*60;
        int sekunder = (int) Math.floor(raaSekunder);
        return minutter + "." + sekunder + "(min.sek)";
    }
}


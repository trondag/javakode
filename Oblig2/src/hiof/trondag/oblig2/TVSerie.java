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
    private ArrayList<Episode> episoder;
    private double gjennomSnittligSpilletid;
    private int antallSesonger;


    TVSerie(String tittel, String beskrivelse, LocalDate publiseringsDato) {
        this.tittel = tittel;
        this.beskrivelse = beskrivelse;
        this.publiseringsDato = publiseringsDato;
        episoder = new ArrayList<>();
    }

    /*******
     *        GET-METODER
     * @return tittel
     *
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

    public double getGjennomSnittligSpilletid() {
        return gjennomSnittligSpilletid;
    }

    public int getAntallSesonger() {
        return antallSesonger;
    }

    /******************************************
     *      METODE SOM LEGGER TIL EPISODER (oppgave 3, 4 og 9)
     * @param episode
     */

    public void leggTilEpisode(Episode episode){
        if(episode.getSesongNummer() > (this.getAntallSesonger())+1){
            System.out.println("Error: Episoden tilhører for høy sesong.");
        } else {
            episoder.add(episode);
            if(episode.getSesongNummer() == (getAntallSesonger()+1)){
                antallSesonger++;
            }
        }
    }

    /****************************
     * -------------Override av toString (Oppgave 5)
     * @return
     */
    private String iterEpisoder(){
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

    /********************************
     * -------------Henter alle episodene fra en sesong og legger disse i et TVSerie-objekt (Oppgave 6)
     */
    
    public ArrayList<Episode> hentFraEnSesong(int sesong){
        ArrayList<Episode> enSesong = new ArrayList<>();
        for(int i = 0; i < this.serie.episoder.size() ; i++){
            if (this.serie.episoder.get(i).getSesongNummer() == sesong) {
                enSesong.add(this.serie.episoder.get(i));
            }
        }
        return enSesong;
    }

    /************************
     * -----------Metode som lager episoder (Oppgave 6)
     */


    public TVSerie lagEpisoder(TVSerie serie, int antallSesonger, int antallEpisoder){
        for(int i = 1 ; i <=antallSesonger ; i++){
            for(int j = 1 ; j <= antallEpisoder ; j++){
                double minutter = Math.random()*10+20;
                Episode episode = new Episode("Episode " + j, j, i, minutter);
                serie.leggTilEpisode(episode);
                oppdaterGjennomsnittligSpilletid();
            }
        }
        return serie;
    }

    /****
     * ------------Metode som regner ut gjennomsnittlig spilletid (Oppgave 7 og 8)
     */

    private void oppdaterGjennomsnittligSpilletid() {
        double snittSpilleTid = 0.0;
        int k;
        for (k = 0; k < this.episoder.size(); k++) {
            double episodensSpilletid = this.episoder.get(k).getSpilletid();
            snittSpilleTid += episodensSpilletid;
        }
<<<<<<< HEAD
        this.gjennomSnittligSpilletid = snittSpilleTid / (k + 1);
=======
        serie.gjennomSnittligSpilletid = snittSpilleTid / (k + 1);
>>>>>>> c09244bf8b01107f816b0e4f9eea27a91f45e98a
    }

    /**************
     * ----------------Metode som lager en penere utskrift, og regner ut sekunder.
     * @param minTall
     * @return
     */

    public String minutterOgSekunder(double minTall){
        int minutter = (int) Math.floor(minTall);
        double raaSekunder = (minTall % minutter)*60;
        int sekunder = (int) Math.floor(raaSekunder);
        return minutter + "." + sekunder + "(min.sek)";
    }
}


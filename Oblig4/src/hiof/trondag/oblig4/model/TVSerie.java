package hiof.trondag.oblig4.model;

import java.time.LocalDate;
import java.util.ArrayList;

/************************'
 * Klassen TVSerie, som inneholder konstruktør, get-metoder og en leggTilEpisode-metode.
 */

public class TVSerie implements Comparable<TVSerie>{
    private String tittel;
    private String beskrivelse;
    private LocalDate publiseringsDato;
    private ArrayList<Episode> episoder;
    private double gjennomSnittligSpilletid;
    private int antallSesonger;


    public TVSerie(String tittel, String beskrivelse, LocalDate publiseringsDato) {
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

    public void leggTilEpisode(Episode episode) {
        if (episode.getSesongNummer() > (getAntallSesonger()) + 1) {
            System.out.println("Error: Episoden tilhører for høy sesong.");
        } else {
            episoder.add(episode);
            if (episode.getSesongNummer() == (getAntallSesonger() + 1)) {
                antallSesonger++;
            }
        }
    }

    /****************************
     * -------------Override av toString (Oppgave 5)
     * @return
     */
    private String iterEpisoder() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < episoder.size(); i++) {
            stringBuilder.append(episoder.get(i).getEpisodeNummer() + ". " + episoder.get(i).getTittel() + "\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "Tittel: " + tittel + "\nBeskrivelse: " + beskrivelse + "\nPubliseringsdato: " + publiseringsDato
                + "\nInneholder episodene: \n" + iterEpisoder();
    }

    /********************************
     * -------------Henter alle episodene fra en sesong og legger disse i et TVSerie-objekt (Oppgave 6)
     */

    public ArrayList<Episode> hentFraEnSesong(int sesong) {
        ArrayList<Episode> enSesong = new ArrayList<>();
        for (int i = 0; i < this.episoder.size(); i++) {
            if (this.episoder.get(i).getSesongNummer() == sesong) {
                enSesong.add(this.episoder.get(i));
            }
        }
        return enSesong;
    }

    /************************
     * -----------Metode som lager episoder (Oppgave 6)
     */


    public TVSerie lagEpisoder(TVSerie serie, int antallSesonger, int antallEpisoder) {
        for (int i = 1; i <= antallSesonger; i++) {
            for (int j = 1; j <= antallEpisoder; j++) {
                double minutter = Math.random() * 10 + 20;
                Episode episode = new Episode("Episode " + j, j, i, minutter);
                serie.leggTilEpisode(episode);
                oppdaterGjennomsnittligSpilletid(serie);
            }
        }
        return serie;
    }

    /****
     * ------------Metode som regner ut gjennomsnittlig spilletid (Oppgave 7 og 8)
     */

    private void oppdaterGjennomsnittligSpilletid(TVSerie serie) {
        double snittSpilleTid = 0.0;
        int k;
        for (k = 0; k < serie.episoder.size(); k++) {
            double episodensSpilletid = serie.episoder.get(k).getSpilletid();
            snittSpilleTid += episodensSpilletid;
        }
        serie.gjennomSnittligSpilletid = snittSpilleTid / (k + 1);
    }

    /**************
     * ----------------Metode som lager en penere utskrift, og regner ut sekunder.
     * @param minTall
     * @return
     */

    public String minutterOgSekunder(double minTall) {
        int minutter = (int) Math.floor(minTall);
        double raaSekunder = (minTall % minutter) * 60;
        int sekunder = (int) Math.floor(raaSekunder);
        return minutter + "." + sekunder + "(min.sek)";
    }

    /***************
     * ---------------- (Oblig 3) oppgave 10 og 11
     * @return
     */

    public ArrayList<Rolle> hentRollebesetning() {
        //Listen som skal fylles og returneres
        ArrayList<Rolle> rolleBesetning = new ArrayList<>();
        //Går gjennom hver episode
        for (int i = 0; i < this.episoder.size(); i++) {
            //Går gjennom hver rolle
            for (int j = 0; j < this.episoder.get(i).getRoller().size(); j++) {
                // går senere gjennom rollebesetning
                // Hvis rollebesetning er 0, går det galt med løkka
                if(rolleBesetning.size() == 0){
                    rolleBesetning.add(this.episoder.get(i).getRoller().get(j));
                }
                //Boolean som skal settes til true hvis løkka finner en duplikat rolle
                boolean duplikatRolle = false;
                for (int k = 0; k < rolleBesetning.size() ; k++){
                    if(this.episoder.get(i).getRoller().get(j) == rolleBesetning.get(k)){
                        duplikatRolle = true;
                    }
                }
                if (!duplikatRolle){
                    rolleBesetning.add(this.episoder.get(i).getRoller().get(j));
                }
            }
        }
        return rolleBesetning;
    }

    /*****************
     * -------------------- (Oblig 3) oppgave 12
     * @param skuespiller
     * @return
     */

    public String antallEpisoderSkuespiller(Person skuespiller){
         int antallEpisoder = 0;
        for (Episode episode:this.episoder
             ) {
            for (int i = 0 ; i < episode.getRoller().size() ; i++){
                if (episode.getRoller().get(i).getSkuespiller().equals(skuespiller)){
                    antallEpisoder++;
                }
            }
        }
        return "Skuespilleren " + skuespiller.getFulltNavn() + " har spilt i " + antallEpisoder + " episoder i serien" + this.tittel + ".";
    }

    /****************
     * ------------------------(Oblig 3) oppgave 13
     * @param antallEpisoder
     * @param startDato
     */

    public void lagSaape(int antallEpisoder, LocalDate startDato){
        ArrayList<Episode> episodene = new ArrayList<>();
        int episodenummer = 1;
        int sesongNummer = 1;
        LocalDate dato = startDato;
        int aar = dato.getYear();
        int episodeTeller = 1;
        while (episodeTeller < antallEpisoder){
            if (dato.getDayOfWeek().getValue() == 6 || dato.getDayOfWeek().getValue() == 7){
                dato = dato.plusDays(1);
                continue;
            }
            if (dato.getYear() > aar){
                aar++;
                sesongNummer++;
                episodenummer = 1;
            }
            Episode episode = new Episode("DooL_episode" + episodenummer, episodenummer, sesongNummer, dato);
            episodene.add(episode);
            dato = dato.plusDays(1);
            episodeTeller++;
            episodenummer++;
        }
        this.episoder = episodene;
    }

    @Override
    public int compareTo(TVSerie annenTVSerie) {
        return this.tittel.compareTo(annenTVSerie.getTittel());
    }


}


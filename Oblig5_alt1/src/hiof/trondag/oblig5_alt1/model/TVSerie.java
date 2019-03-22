package hiof.trondag.oblig5_alt1.model;

import java.time.LocalDate;
import java.util.ArrayList;

/************************'
 * Klassen TVSerie, som holder på tittel, beskrivelse, publiseringsdato, episodene i serien, gjennomsnittlig spille tid samt antall sesonger.
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

    /**
     * Legger til en episode i en tv-serie.
     * Hvis episoden er i en sesong to sesonger høyere enn de episodene som allerede er der vil ikke det gå
     * @param episode Episoden som skal legges til
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
    /**
     * Går gjennom alle episodene i serien ved hjelp av en for løkke og lager en pen utskrift av hver episode i serien
     * @return String Returnerer String med informasjon om episoden
     */
    private String iterEpisoder() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Episode episode : episoder) {
            stringBuilder.append(episode.getEpisodeNummer() + ". " + episode.getTittel() + "\n");
        }
        return stringBuilder.toString();
    }

    /**
     * Returnerer en pen utskrift av serien og alle episodene
     * @return String med serie og episoder
     */

    @Override
    public String toString() {
        return "Tittel: " + tittel + "\nBeskrivelse: " + beskrivelse + "\nPubliseringsdato: " + publiseringsDato
                + "\nInneholder episodene: \n" + iterEpisoder();
    }

    /**
     * Metode som returnerer alle episodene ved å gå gjennom med en for løkke
     * @return ArrayList med alle episodene fra en sesong
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

    /**
     *
     * Denne metoden lager et antall sesonger og episoder, og returnerer en hel TVSerie
     *
     * @param serie Serien som skal fylles opp
     * @param antallSesonger Antall sesonger som serien skal inneholde
     * @param antallEpisoder Antall episoder som hver sesong skal ha
     * @return Returnerer et helt TVSerie-objekt
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

    /**
     * Denne metoden går gjennom alle episodene i en hel TVSerie og regner ut gjennomsnittlig spilletid
     *
     * @param serie Serien der gjennomsnittlig spilletid skal oppdateres
     *
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

    /**
     * Metode som lager en penere utskrift, og regner ut sekunder og minutter
     *
     * @param minTall Tar inn et antall minutter som parameter
     * @return Returnerer en String med antall minutter og sekunder
     */

    public String minutterOgSekunder(double minTall) {
        int minutter = (int) Math.floor(minTall);
        double raaSekunder = (minTall % minutter) * 60;
        int sekunder = (int) Math.floor(raaSekunder);
        return minutter + "." + sekunder + "(min.sek)";
    }

    /**
     * Metode som henter alle de forskjellige rollene som har deltatt i en TVSerie. Den hindrer at duplikate roller blir tatt med
     * @return Returnerer en liste med alle rollene
     */

    public ArrayList<Rolle> hentRollebesetning() {
        //Listen som skal fylles og returneres
        ArrayList<Rolle> rolleBesetning = new ArrayList<>();
        //Går gjennom hver episode i objektet som kaller metoden
        for (Episode episode : this.episoder) {
            //Går gjennom hver rolle i episoden i objektet som kaller metoden
            for (int j = 0; j < episode.getRoller().size(); j++) {
                // går senere gjennom rollebesetning
                // Hvis rollebesetning er 0, går det galt med løkka
                if (rolleBesetning.size() == 0) {
                    rolleBesetning.add(episode.getRoller().get(j));
                }
                //Boolean som skal settes til true hvis løkka finner en duplikat rolle
                boolean duplikatRolle = false;
                for (int k = 0; k < rolleBesetning.size(); k++) {
                    if (episode.getRoller().get(j) == rolleBesetning.get(k)) {
                        duplikatRolle = true;
                    }
                }
                if (!duplikatRolle) {
                    rolleBesetning.add(episode.getRoller().get(j));
                }
            }
        }
        return rolleBesetning;
    }

    /**
     * Sjekker hvor mange episoder hver skuespiller har deltatt i Dette gjøres ved å sjekke hver episode med for løkke
     * @param skuespiller Tar inn en skuespiller
     * @return String med informasjon om hvor mange episoder skuespilleren har spilt i
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

    /**
     * Lager en såpeserie med et gitt antall episoder. Mens antallepisoder ikke er nådd lager den en episode hver dag i uka.
     * @param antallEpisoder Antall episoder som skal lages
     * @param startDato Hvilken dato den første episoden skal sendes
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

    /**
     * Sammenligner en tvserie med en annen basert på tittel
     * @param annenTVSerie Serien som skal sammenlignes
     * @return Hvilken TVSerie som kommer først i sorteringen
     */

    @Override
    public int compareTo(TVSerie annenTVSerie) {
        return this.tittel.compareTo(annenTVSerie.getTittel());
    }


}


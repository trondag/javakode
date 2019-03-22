package hiof.trondag.oblig5_alt1.model;

import java.time.LocalDate;

/**
 * Representer en episode, og arver fra Produksjon
 *
 * Inneholder episodenummer og sesongnummer
 */

public class Episode extends Produksjon implements Comparable<Episode>{
        //Instansvariabler
    private int episodeNummer;
    private int sesongNummer;


    public Episode(String tittel, int episodeNummer, int sesongNummer, double spilletid){
        super(tittel, spilletid);
        this.episodeNummer = episodeNummer;
        this.sesongNummer = sesongNummer;
    }

    public Episode(String tittel, int episodeNummer, int sesongNummer, LocalDate utgivelsesdato){
        super(tittel, utgivelsesdato);
        this.episodeNummer = episodeNummer;
        this.sesongNummer = sesongNummer;
    }

    public Episode(String tittel, String beskrivelse, int episodeNummer, int sesongNummer, double spilletid, LocalDate utgivelsesdato, Person regissor) {
        super(tittel, beskrivelse, spilletid, utgivelsesdato, regissor);
        this.episodeNummer = episodeNummer;
        this.sesongNummer = sesongNummer;
    }
    public int getEpisodeNummer() {
        return episodeNummer;
    }

    public int getSesongNummer() {
        return sesongNummer;
    }

    /**
     * Lager en pen utskrift av en episode
     *
     * @return String med penere utskrift
     */

    @Override
    public String toString(){
        return "Tittel: " + getTittel() + "\nNummer: E:" + episodeNummer + " S:" + sesongNummer + "\nSpilletid: " + getSpilletid();
    }

    /**
     * Overrider Comparable interfacet til å sammenlige episodene på sesong- /episodenummer
     *
     * @param annenEpisode Episoden som this skal sammenlignes med
     * @return Riktige episoder i riktig rekkefølge
     */

    @Override
    public int compareTo(Episode annenEpisode){
        if (this.sesongNummer == annenEpisode.getSesongNummer())
            return Integer.compare(this.episodeNummer, annenEpisode.episodeNummer);
        else
            return Integer.compare(this.sesongNummer, annenEpisode.sesongNummer);
    }
}

package hiof.trondag.oblig4.model;

import java.time.LocalDate;

public class Episode extends Produksjon implements Comparable<Episode>{
        //Instansvariabler
    private int episodeNummer;
    private int sesongNummer;


        //--------------------------//
        //Konstruktør uten spilletid//
        //--------------------------//
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

        //-------------------------//
        //Konstruktør med spilletid//
        //-------------------------//
    public Episode(String tittel, String beskrivelse, int episodeNummer, int sesongNummer, double spilletid, LocalDate utgivelsesdato, Person regissor) {
        super(tittel, beskrivelse, spilletid, utgivelsesdato, regissor);
        this.episodeNummer = episodeNummer;
        this.sesongNummer = sesongNummer;
    }
        //----------------------//
        //-----GETTERS----------//
        //----------------------//


    public int getEpisodeNummer() {
        return episodeNummer;
    }

    public int getSesongNummer() {
        return sesongNummer;
    }

    //-------------------------------//
    // OVERRIDE TOSTRING() oppgave 5 //
    //-------------------------------//

    @Override
    public String toString(){
        return "Tittel: " + getTittel() + "\nNummer: E:" + episodeNummer + " S:" + sesongNummer + "\nSpilletid: " + getSpilletid();
    }

    @Override
    public int compareTo(Episode annenEpisode){
        if (this.sesongNummer == annenEpisode.getSesongNummer())
            return Integer.compare(this.episodeNummer, annenEpisode.episodeNummer);
        else
            return Integer.compare(this.sesongNummer, annenEpisode.sesongNummer);
    }
}

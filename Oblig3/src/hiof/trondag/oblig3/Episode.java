package hiof.trondag.oblig3;

import java.time.LocalDate;

public class Episode extends Produksjon{
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
}

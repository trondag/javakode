package com.company;

import java.time.LocalDate;
import java.util.ArrayList;

public class Episode extends TVSerie{
    //Instansvariabler
    private int episodeNummer;
    private int sesongNummer;

    public Episode(String tittel, String beskrivelse, LocalDate utgivelsesdato, ArrayList episoder, int episodeNummer, int sesongNummer, String episodeTittel, String spilletid) {
        super(tittel, beskrivelse, utgivelsesdato);
        this.episodeNummer = episodeNummer;
        this.sesongNummer = sesongNummer;
        this.tittel = episodeTittel;
        this.spilletid = spilletid;
    }

    private String tittel;
    private String spilletid;

    public int getEpisodeNummer() {
        return episodeNummer;
    }

    public int getSesongNummer() {
        return sesongNummer;
    }

    public String getTittel() {
        return tittel;
    }

    public String getSpilletid() {
        return spilletid;
    }

    public leggTilEnEpisode(){

    }


}


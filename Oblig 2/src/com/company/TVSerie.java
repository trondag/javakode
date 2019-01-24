package com.company;
import java.time.LocalDate;
import java.util.ArrayList;

public class TVSerie{
    private String tittel;

    public TVSerie(String tittel, String beskrivelse, LocalDate utgivelsesdato, ArrayList[] episoder) {
        this.tittel = tittel;
        this.beskrivelse = beskrivelse;
        this.utgivelsesdato = utgivelsesdato;
        this.episoder = episoder;
    }

    public TVSerie(String tittel, String beskrivelse, LocalDate utgivelsesdato) {
        this.tittel = tittel;
        this.beskrivelse = beskrivelse;
        this.utgivelsesdato = utgivelsesdato;
    }

    private String beskrivelse;
    private LocalDate utgivelsesdato;
    private String[] episoder;

    public leggTilEnEpisode(Episode episode){
        //int listeNummer = episode.getEpisodeNummer();
        String episodeTittel = episode.getTittel();
        return episodeTittel;
    }
}
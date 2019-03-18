package hiof.trondag.oblig5_alt1.model;

import java.time.LocalDate;

public class Film extends Produksjon implements Comparable<Film>{

    private String bildePath;

    public Film(String tittel, String beskrivelse, double spilletid, LocalDate utgivelsesdato, Person regissor){
        super(tittel, beskrivelse, spilletid, utgivelsesdato, regissor);
    }

    public Film(String tittel, String beskrivelse, double spilletid, LocalDate utgivelsesdato, String bildePath){
        super(tittel, beskrivelse, spilletid, utgivelsesdato);
        this.bildePath = bildePath;
    }

    public Film(){}


    public String getBildePath() { return bildePath; }

    public void setBildePath(String bildePath) { this.bildePath = bildePath; }

    //Metode som setter egenskaper på en film
    public void settEgenskaper(String tittel, String beskrivelse, Double spilletid, LocalDate utgivelsesDato){
        //Stor forbokstav på tittel
        tittel = tittel.toLowerCase();
        tittel = tittel.substring(0,1).toUpperCase() + tittel.substring(1).toLowerCase();

        this.setTittel(tittel);
        this.setBeskrivelse(beskrivelse);
        this.setSpilletid(spilletid);
        this.setUtgivelsesdato(utgivelsesDato);
    }

    @Override
    public String toString(){
        return getTittel() + " (" + getUtgivelsesdato().getYear() + ")";
    }

    @Override
    public int compareTo(Film enFilm){
        return this.getTittel().compareTo(enFilm.getTittel());
    }
}

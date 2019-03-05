package hiof.trondag.oblig4.model;

import java.time.LocalDate;

public class Film extends Produksjon implements Comparable<Film>{


    public Film(String tittel, String beskrivelse, double spilletid, LocalDate utgivelsesdato, Person regissor){
        super(tittel, beskrivelse, spilletid, utgivelsesdato, regissor);
    }

    public Film(String tittel, String beskrivelse, double spilletid, LocalDate utgivelsesdato){
        super(tittel, beskrivelse, spilletid, utgivelsesdato);
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

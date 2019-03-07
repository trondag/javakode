package hiof.trondag.oblig4.model;

import java.time.LocalDate;

public class Film extends Produksjon implements Comparable<Film>{


    public Film(String tittel, String beskrivelse, double spilletid, LocalDate utgivelsesdato, Person regissor){
        super(tittel, beskrivelse, spilletid, utgivelsesdato, regissor);
    }

    public Film(String tittel, String beskrivelse, double spilletid, LocalDate utgivelsesdato){
        super(tittel, beskrivelse, spilletid, utgivelsesdato);
    }


    public Film(){}

    public void settEgenskaper(String tittel, String beskrivelse, Double spilletid, LocalDate utgivelsesdatp){
        tittel = tittel.substring(0,1).toUpperCase() + tittel.substring(1).toLowerCase();
        this.setTittel(tittel);
        this.setBeskrivelse(beskrivelse);
        this.setSpilletid(spilletid);
        this.setUtgivelsesdato(utgivelsesdatp);
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

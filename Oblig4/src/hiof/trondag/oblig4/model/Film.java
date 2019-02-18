package hiof.trondag.oblig4.model;

import java.time.LocalDate;

public class Film extends Produksjon implements Comparable<Film>{


    public Film(String tittel, String beskrivelse, double spilletid, LocalDate utgivelsesdato, Person regissor){
        super(tittel, beskrivelse, spilletid, utgivelsesdato, regissor);
    }

    @Override
    public String toString(){
        return "Filmen " + getTittel() + " er utgitt " + getUtgivelsesdato() + ", og er regissert av " + getRegissor()
                + ".\nBeskrivelse: " + getBeskrivelse() + "\nSpilletid: " + getSpilletid() + " minutter.";
    }

    @Override
    public int compareTo(Film enFilm){
        return this.getTittel().compareTo(enFilm.getTittel());
    }
}
